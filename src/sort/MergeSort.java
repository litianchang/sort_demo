package sort;

import java.util.Arrays;

/**
 * @author 李天长
 * @version V1.0
 * @summary 归并排序
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/7/18
 */
public class MergeSort {

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        T[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, temp, 0, arr.length);
    }

    /**
     * 排序，留头不留尾
     */

    private static <T extends Comparable<? super T>> void sort(T[] arr, T[] temp, int left, int right) {
        int size = right - left;
        if (size == 1) {
            return;
        } else if (size == 2) {
            merge(arr, temp, left, left + 1, left + 1, right);
        } else {
            int middle = (right + left) / 2;
            sort(arr, temp, left, middle);
            sort(arr, temp, middle, right);
            merge(arr, temp, left, middle, middle, right);
        }
    }

    /**
     * 合并，需传入两个合并数组的左右下标
     */

    private static <T extends Comparable<? super T>> void merge(T[] arr, T[] temp
            , int left1, int right1, int left2, int right2) {
        //定义两个指针
        int index1 = left1;
        int index2 = left2;

        for (int i = left1; i < right2; i++) {
            //某一个数组已经合并完了
            if (index1 >= right1) {
                temp[i] = arr[index2];
                index2++;
                continue;
            } else if (index2 >= right2) {
                temp[i] = arr[index1];
                index1++;
                continue;
            } else {
                if (arr[index1].compareTo(arr[index2]) < 0) {
                    temp[i] = arr[index1];
                    index1++;
                } else {
                    temp[i] = arr[index2];
                    index2++;
                }
            }
        }

        //从临时数组写入原数组
        for (int i = left1; i < right2; i++) {
            arr[i] = temp[i];
        }
    }
}
