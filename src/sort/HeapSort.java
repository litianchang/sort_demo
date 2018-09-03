package sort;

/**
 * @author 李天长
 * @version V1.0
 * @summary 堆排序
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/7/19
 */
public class HeapSort {
    public static void sort(Integer[] arr) {
        //将数组变成大顶堆结构的二叉树
        //从第一个非叶子节点开始遍历
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i,arr.length);
        }

        for (int i = arr.length-1;i>0;i--){
            SortUtils.swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
    }

    //调整大顶堆（仅建立在子节点大顶堆已构建的基础上）
    private static void adjustHeap(Integer[] arr, int i,int length) {
        int temp = arr[i];

        for (int j = i * 2 + 1;j<length ; j = j*2+1) {
            if(j<length-1 && arr[j]<arr[j+1]){
                j++;
            }
            if(temp<arr[j]){
                //进行移位
                arr[i] = arr[j];
                i = j;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
