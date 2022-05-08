package ru.kpfu.itis.gnt;



public class TimSort {

    public static int RUN = 32;
    public static <T extends Comparable> void sort(T[] arr) {
        int n = arr.length;
        for (int start = 0; start < n; start +=RUN) {
            int end = Math.min(start + RUN-1, n-1);
            InsertionSort.sort(arr, start, end);
        }
        int curr_size = RUN;
        while (curr_size < n) {
            for (int start = 0; start < n; start += curr_size*2) {
                int mid = Math.min(n-1, start + curr_size-1);
                int end = Math.min(n-1,mid+curr_size);
                Merging.merge(arr, start,mid,end);
            }
            curr_size*=2;
        }
    }
}
