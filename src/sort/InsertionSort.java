package sort;

/**
 * @author 李天长
 * @version V1.0
 * @summary 插入排序
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/7/18
 */
public class InsertionSort {

    public static void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //记录当前位置的值
            int tmp = arr[i];
            int j;
            //前一个元素比自身大时，将前一个元素进行后移操作
            for (j = i; j > 0 && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }
}
