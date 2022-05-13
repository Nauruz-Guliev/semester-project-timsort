package ru.kpfu.itis.gnt;

public class Merging {
    public static void merge (int[] arr, int start, int middle, int stop) {
        int[] buf = new int[arr.length];
        int left_offset = start;
        int right_offset = middle + 1;
        int buf_offset = start;
        while (left_offset <= middle && right_offset <= stop) {
            if (arr[left_offset] <= arr[right_offset]) {
                buf[buf_offset] = arr[left_offset];
                left_offset++;
            } else {
                buf[buf_offset] = arr[right_offset];
                right_offset++;
            }
            buf_offset += 1;
        }
        for (int i = left_offset; i <= middle; i++) {
            buf[buf_offset] = arr[i];
            buf_offset += 1;
        }
        for (int i = right_offset; i < arr.length; i++) {
            buf[buf_offset] = arr[i];
            buf_offset += 1;
        }

        if (buf_offset - start >= 0) System.arraycopy(buf, start, arr, start, buf_offset - start);
    }
}
