package org.jacklin.datastructure.sort;

import java.util.Arrays;

/**
 * @Class class file creation author：jakclinsir
 * @DATE 2019/12/1 15:14
 * <p>
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {101, 34, 119, 1};
        System.out.println("排序前：" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));


        /*
        //拿到待插入的元素
        int  insertVal = arr[1];
        int  insertIndex = 1-1; //第一轮：1-1 第二轮：2-1 ，第三轮：3-1
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex]; //经过这个操作后 ｛101，101，119，1｝
            insertIndex--; // -1
        }
        arr[insertIndex + 1] = insertVal; // 34 插入到 arr[-1+1]中
        System.out.println("第一轮 " + Arrays.toString(arr));

        //执行第二轮
        int insertVal = arr[2];
        int insertIndex = 2-1; //第一轮：1-1 第二轮：2-1 ，第三轮：3-1
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex]; //经过这个操作后 ｛101，101，119，1｝
            insertIndex--; // -1
        }
        arr[insertIndex + 1] = insertVal; // 34 插入到 arr[-1+1]中
        System.out.println("第二轮 " + Arrays.toString(arr));

        //执行第三轮
        int  insertVal = arr[3];
        int  insertIndex = 3-1; //第一轮：1-1 第二轮：2-1 ，第三轮：3-1
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex]; //经过这个操作后 ｛101，101，119，1｝
            insertIndex--; // -1
        }
        arr[insertIndex + 1] = insertVal; // 34 插入到 arr[-1+1]中
        System.out.println("第三轮 " + Arrays.toString(arr));
         */
    }

    private static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];//拿到待插入元素
            insertIndex = i - 1;//待插入元素的前一个元素索引
            //第一个条件防止越界，第二个条件判断插入元素是否比前一个元素小
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //｛34.34，119，1｝
                arr[insertIndex + 1] = arr[insertIndex];
                //索引-1操作
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                //将第一次保存的数据放在
                arr[insertIndex + 1] = insertVal;
            }
        }

    }

}
