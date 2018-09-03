package sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void sort(Integer[] arr) {
        //计算最大值的长度
        int length = 0;

        for (int num :
                arr) {
            length = Math.max(length, length(num));
        }

        //定义计数数组
        int[] bucket = new int[10];
        //定义临时数组
        Integer[] temp = new Integer[arr.length];

        //从低位到高位排序
        for (int i = 0; i < length; i++) {
            //重置计数数组
            resetBucket(bucket);
            //计算计算每一位需要除以的值
            int calNum = (int) Math.pow(10, i);
            for (int num :
                    arr) {
                bucket[(num / calNum) % 10]++;
            }
            //将计数数组每个下标的值加上之前所有元素的值
            for (int j = 1; j < bucket.length; j++) {
                bucket[j] += bucket[j - 1];
            }
            //倒序插入临时数组
            for (int j = arr.length - 1; j >= 0; j--) {
                temp[--bucket[(arr[j] / calNum) % 10]] = arr[j];
            }
            System.arraycopy(temp,0,arr,0,arr.length);
        }
    }

    private static int length(int number) {
        return String.valueOf(number).length();
    }

    private static void resetBucket(int[] bucket) {
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }
    }

}
