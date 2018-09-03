package sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {
    public static void sort(Integer[] arr) {
        //找到最大值和最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num :
                arr) {
            max = Integer.max(max, num);
            min = Integer.min(min, num);
        }

        //设置偏移量
        int offset = 0;
        if (min < 0) {
            offset = Math.abs(min);
        }

        //初始化计数数组,+1防止长度溢出
        int[] countArr = new int[max + offset + 1];

        //计数
        for (int num :
                arr) {
            countArr[num + offset] += 1;
        }

        //将计数数组每个下标的值加上之前所有元素的值
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }

        //定义暂存数组
        Integer[] tempArr = new Integer[arr.length];

        //倒序插入暂存数组中,保证数据插入时的顺序（为基数排序考虑）
        for (int i = arr.length - 1; i >= 0; i--) {
            tempArr[countArr[arr[i]] - offset - 1] = arr[i];
            countArr[arr[i]]--;
        }

        System.arraycopy(tempArr, 0, arr, 0, arr.length);
    }
}
