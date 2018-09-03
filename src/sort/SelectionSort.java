package sort;

/**
 * @author 李天长
 * @version V1.0
 * @summary 选择排序
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/7/18
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //最小值的下标
            int k = i;
            for (int j = k + 1; j < arr.length; j++) {
                //若下个元素小于当前元素，记录下标
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            //存在比arr[i]小的元素，交换元素
            if (k > i) {
                int tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
            }
        }
    }
}
