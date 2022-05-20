package ru.kpfu.itis.gnt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TimeTests implements Runnable{
    private File results;
    private Sort sort;
    private int i;

    public TimeTests(File mainFold, int i) {
        this.mainFold = mainFold;
        this.mainFold.mkdir();
        this.i = i;
    }
    @Override
    public void run() {
        try {
            timeTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File mainFold;
    private static final int countOfTests = 10;
    private static final int k1 = 2; //коэффециент1 увеличения кол-ва элементов
    private static final int k2 = 5; //коэффециент2 увеличения кол-ва элементов
    private static final int countOfDataSets = 10;
    private static final int dataSetSize = (int) 5e5;


    public void createDataSets(String operation) throws IOException {
        File foldForOperation = new File(mainFold.toPath().resolve(operation).toString());
        foldForOperation.mkdir();
        for (int i = 0; i < countOfDataSets; i++) {
            this.createDataSet(new File(foldForOperation.toPath().resolve("dataSet" + i + ".txt").toString()));
        }
    }

    private void createDataSet(File data) throws IOException {
        data.createNewFile();
        FileWriter out = new FileWriter(data);
        for (int i = 0; i < dataSetSize; i++) {
            out.write((int) (Math.random() * 1000000000) + " ");
        }
        out.flush();
        out.close();
    }



    public void timeTest() throws IOException {
        int dataSetSizeCopy = dataSetSize;
        int size = -2;
        while (dataSetSizeCopy > 0) {
            size += 2;
            dataSetSizeCopy /= k1 * k2;
        }
        int[] times = new int[size];
        int[] timesSizes = new int[size];
        int ij = 0;
        boolean bool = true;
        for (int curDataSetSize = k2; curDataSetSize <= dataSetSize; curDataSetSize = bool ? curDataSetSize * k1 : curDataSetSize * k2, bool = !bool) {
            timesSizes[ij] = curDataSetSize;
            System.out.println(curDataSetSize + " dataSetSize " + Thread.currentThread().getName());
            for (int i = 0; i < countOfDataSets; i++) {
                System.out.print("\tdataSetNumber: " + i + "; Test number: ");
                for (int j = 0; j < countOfTests; j++) {
                    System.out.print(j + " ");
                    Scanner data = new Scanner(new File(mainFold.toPath().resolve("sort").resolve("dataSet" + i + ".txt").toString()));
                    int[] arr = new int[curDataSetSize];
                    for (int l = 0; l < curDataSetSize; l++) {
                        arr[l] = data.nextInt();
                    }
                    data.close();

                    long t1 = System.currentTimeMillis();
                    sort.sort(arr, 0, arr.length - this.i);
                    long t2 = System.currentTimeMillis();
                    times[ij] += t2 - t1;

                }
                System.out.println();
            }
            ij++;
        }


        FileWriter out = new FileWriter(results);
        for (int j = 0; j < size; j++) {
            times[j] = times[j] / (countOfDataSets * countOfTests);
            out.write((timesSizes[j] + "\t" + times[j] + "\n").replace('.', ','));
        }
        out.flush();
        out.close();
    }


    public void setResults(File results) {
        this.results = results;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
