package com.ltc;

import java.util.ArrayList;
import java.util.Arrays;

public class BitGroup {
    public static void main(String[] args) {
        String[] source = {"aa","bb","cc","abc"};
        String[][] group = group(source, new ArrayList<>());

        System.out.println(Arrays.deepToString(group));
    }

    public static String[][] group(String[] source,ArrayList<String[]> result){
        if(source== null || source.length == 0){
            return new String[0][];
        }

        int tempArrLength = 0;
        String[] tempArr = new String[source.length];

        //分组集合
        ArrayList<String> group = new ArrayList();
        group.add(source[0]);

        String nowStr = source[0];
        //计数数组
        int[] count = new int[256];

        for (int i = 0; i < nowStr.length(); i++) {
            count[nowStr.charAt(i)]++;
        }

        for (int i = 1; i < source.length; i++) {
            if(nowStr.length() != source[i].length()){
                tempArr[tempArrLength++] = source[i];
                continue;
            }
            //重置用于比较的计数数组
            int[] tempCount = Arrays.copyOf(count, 256);

            for (int j = 0; j < source[i].length(); j++) {
                if(--tempCount[source[i].charAt(j)] < 0){
                    tempArr[tempArrLength++] = source[i];
                    continue;
                }
            }

            group.add(source[i]);
        }

        //将分组后的数组放入result中

        result.add(group.toArray(new String[group.size()]));
        if(tempArrLength > 0){
            group(Arrays.copyOf(tempArr,tempArrLength),result);
        }

        return result.toArray(new String[result.size()][]);

    }
}
