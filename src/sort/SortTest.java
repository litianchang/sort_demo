package sort;

import java.util.Arrays;

/**
 * @author 李天长
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/7/17
 */
public class SortTest {

    public static void main(String[] args) {
        Integer[] arr = SortUtils.initArr(1000);

        long startTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        //排序
        RadixSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间为："+(endTime-startTime)+"毫秒");
    }
}
