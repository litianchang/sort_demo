package sort;

import java.util.Random;

/**
 * @author 李天长
 * @version V1.0
 * @summary 排序的工具类
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/7/18
 */
public class SortUtils {
    private static final Random RANDOM = new Random();

    public static void swap(Integer[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    public static Integer[] initArr(int size){
        Integer[] arr = new Integer[size];
        for (int i=0;i<size;i++){
            arr[i] = RANDOM.nextInt(size);
        }
        return arr;
    }
}
