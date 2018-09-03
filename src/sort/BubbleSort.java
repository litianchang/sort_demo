package sort;

/**
 * @author 李天长
 * @version V1.0
 * @summary 冒泡排序
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/7/18
 */
public class BubbleSort {

    public static void sort(Integer[] arr) {
        //控制冒泡次数
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                //交换元素
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
