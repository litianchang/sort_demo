package sort;

/**
 * @author 李天长
 * @version V1.0
 * @summary 希尔排序
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/7/18
 */
public class ShellSort {

    public static void sort(Integer[] arr) {
        //设置初始增量
        for (int gap = arr.length / 2;gap > 0;gap /= 2){
            for (int i = gap ;i<arr.length;i++){
                //根据增量进行插入排序
                int temp = arr[i];
                int j;
                for (j=i;j>=gap && temp<arr[j] ;j-=gap){
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
            }
        }
    }
}
