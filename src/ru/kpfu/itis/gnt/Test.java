package ru.kpfu.itis.gnt;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class Test {
    private static File mainFold;
    public static void main(String[] args) throws IOException {
        TimeTests test1 = new TimeTests(new File("src/testFiles"),0);
        TimeTests test2 = new TimeTests(new File("src/testFiles"),1);
        File results = new File("src/testFiles/Results/");
        results.mkdirs();

        test1.createDataSets("sort");
        //timsort
        test1.setResults(new File(results.toPath().resolve("timsort.txt").toString()));
        test1.setSort(new TimSort());

        //mergesort
        test2.setResults(new File(results.toPath().resolve("mergesort.txt").toString()));
        test2.setSort(new MergeSort());
        new Thread(test1).start();
        new Thread(test2).start();
        test2.timeTest();
        test1.timeTest();
    }
}
