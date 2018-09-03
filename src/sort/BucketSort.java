package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 */
public class BucketSort {
    public static void sort(Integer[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找到最大和最小值
        for (int a :
                arr) {
            max = Integer.max(max, a);
            min = Integer.min(min, a);
        }

        //定义桶
        ArrayList[] buckets = new ArrayList[arr.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList();
        }

        //计算下标，放入桶中
        for (int a :
                arr) {
            int index = (a - min + 1) / arr.length;
            buckets[index].add(a);
        }

        //桶内排序
        for (ArrayList bucket :
                buckets) {
            Collections.sort(bucket);
        }

        //合并
        int index = 0;

        for (ArrayList bucket :
                buckets) {
            for (int i = 0; i < bucket.size(); i++) {
                arr[index++] = (int) bucket.get(i);
            }
        }
    }
}
