package ru.kpfu.itis.gnt;

public class InsertionSort {
    // left и right используются для задания границ сортировки
    public static <T extends Comparable> void sort(T[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int insert_index = binary_search(array, i);
            if (insert_index != i) {
                T element_to_insert = array[i];
                int j = i - 1;
                while (j >= left && array[j].compareTo(element_to_insert) > 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = element_to_insert;
            }
        }
    }

    private static <T extends Comparable> int binary_search(T[] array, int index) {
        int start = 0;
        int stop = index;
        int middle = middleOf(start, stop);

        while (start <= stop) {
            if (array[index].compareTo(array[middle]) == 0) {
                return middle;
            }
            if (array[index].compareTo(array[middle]) > 0) {
                start = middle + 1;
            } else {
                stop = middle - 1;
            }
            middle = middleOf(start, stop);
        }
        return start;
    }

    private static int middleOf(int start, int stop) {
        return start + (stop - start) / 2;
    }
}
