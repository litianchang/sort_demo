package sort;

/**
 * @author 李天长
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/7/18
 */
public class QuickSort {
    public static void sort(Integer[] arr){
        sort(arr,0,arr.length-1);
    }

    public static Integer[] sort(Integer[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }

        int tmp = arr[left];

        int i = left;
        int j = right;

        while (i < j) {
            //右侧哨兵移动
            while (arr[j] >= tmp && i < j) {
                j--;
            }
            //左侧哨兵移动
            while (arr[i] <= tmp && i < j) {
                i++;
            }
            //满足条件，换位
            if (i < j) {
                SortUtils.swap(arr, i, j);
            }
        }

        //哨兵位置相同，重新置位
        SortUtils.swap(arr, left, i);
        //左边的数组排序
        sort(arr, left, i - 1);
        //右边的数组排序
        sort(arr, i + 1, right);
        return arr;
    }
}
