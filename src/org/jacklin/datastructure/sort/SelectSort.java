package org.jacklin.datastructure.sort;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @Class class file creation author：jakclinsir
 * @DATE 2019/12/1 13:47
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        //假设需要把 101，34，119，1
        //从小到大排序
        //第次排序把最大的数放在最后面
        //1，34，119，101
        //int arr[] = {101, 34, 119, 1};
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println("排序前");
        System.out.println(LocalTime.now());
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(LocalTime.now());

        /*System.out.println("排序前 = " + Arrays.toString(arr));
        int minIndex = 0;// 找到最小值的索引位置
        int min = arr[0]; //找到最小值
        for (int j = 0 + 1; j < arr.length; j++) {
            if (min > arr[j]) { //找到最小值
                min = arr[j];//重置min，直到找到最小值位置
                minIndex = j; //重置 minIndex
            }
        }
        //把最小值放在arr[0]
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("排序后 = " + Arrays.toString(arr));

        minIndex = 1;//
        min = arr[1]; //第一个数
        for (int j = 1 + 1; j < arr.length; j++) {
            if (min > arr[j]) { //找到最小值
                min = arr[j];//重置min，直到找到最小值位置
                minIndex = j; //重置 minIndex
            }
        }
        //把最小值放在arr[0]
        if (minIndex != 0) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("排序后 = " + Arrays.toString(arr));*/
    }

    private static void selectSort(int arr[]) {
        //遍历数组大小容量减一
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;// 找到最小值的索引位置
            int min = arr[i]; //找到最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j]; //重置min为数组的最小值
                    minIndex = j;//记录最小值的位置
                }
            }
            //判读minIndex的最小值索引位置大于0,然后把最小值的位置value放到arr[i]前面
            if (minIndex != 0) {
                arr[minIndex] = arr[i];
                arr[i] = min; //进行赋值
            }
        }
    }
}
