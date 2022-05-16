package ru.kpfu.itis.gnt;



public class TimSort extends Sort {

    public static int RUN = 32;
    public void sort(int[] arr, int st, int stop) {
        int n = stop;
        for (int start = st; start < n; start +=RUN) {
            int end = Math.min(start + RUN-1, n-1);
            InsertionSort.sort(arr, start, end);
        }
        int curr_size = RUN;
        while (curr_size < n) {
            for (int start = st; start < n; start += curr_size*2) {
                int mid = Math.min(n-1, start + curr_size-1);
                int end = Math.min(n-1,mid+curr_size);
                Merging.merge(arr, start,mid,end);
            }
            curr_size*=2;
        }
    }
}
