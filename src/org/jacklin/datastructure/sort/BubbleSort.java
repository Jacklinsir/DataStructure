package org.jacklin.datastructure.sort;

import java.time.LocalTime;
import java.util.Arrays;

/**
 * @Class class file creation author：jakclinsir
 * @DATE 2019/11/29 21:35
 * <p>
 * 冒泡排序法
 */
public class BubbleSort {

    public static void main(String[] args) {
        //定义一个无序数组
        //int[] arr = {-2, 1, 2, 3, 10};
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println("排序前");
        System.out.println(LocalTime.now());
        arrSort(arr);
        System.out.println("排序后");
        System.out.println(LocalTime.now());

//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));
        //经过下面四次循环排序发现已经把数组排序完成
       /* int temp = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第一次排序");
        System.out.println(Arrays.toString(arr));

        for (int j = 0; j < arr.length - 1 - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第二次排序");
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < arr.length - 1 - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第三次排序");
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < arr.length - 1 - 3; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四次排序");
        System.out.println(Arrays.toString(arr));*/
    }

    private static void arrSort(int[] arr) {
        //代码优化
        //定义一个第三方变量
        int temp = 0;
        //用于判断冒泡排序状态
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //进入交换数据
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //下面代码用户维护减少排序代码
            if (!flag) { //表示排序没有进行交换数据
                break;
            } else {
                flag = false;
            }
        }
    }
}
