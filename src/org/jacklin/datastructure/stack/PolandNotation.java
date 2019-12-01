package org.jacklin.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Class class file creation author：jakclinsir
 * @DATE 2019/11/29 14:14
 * 逆波兰表达式实现计算器
 */
public class PolandNotation {

    public static void main(String[] args) {
        // (3+4)*5-6 ==> 3 4 + 5 * 6 -

        String suffixExpression = "30 4 + 5 * 6 -";


        List<String> list = getListStr(suffixExpression);
        System.out.println(list);

        int result = claculate(list);
        System.out.println("计算结果:" + result);
    }

    private static int claculate(List<String> list) {
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历 ls
        for (String item : list) {
            //使用正则表达式取数字 匹配多位数
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                //否则就是遇到符号了，取出两个数字进行计算最后将结果push进栈中
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if (item.equals("+")) {
                    result = num1 + num2;
                } else if (item.equals("-")) {
                    result = num1 - num2;
                } else if (item.equals("*")) {
                    result = num1 * num2;
                } else if (item.equals("/")) {
                    result = num1 / num2;
                } else {
                    throw new RuntimeException("运算符符号错误！");
                }
                //将结果入栈
                stack.push("" + result);
            }
        }

        //将栈中的最后一个结果去取出返回
        return Integer.parseInt(stack.pop());
    }

    //将一个逆波兰表达式，依次将数据和运算符放入一个ArrayList集合中
    private static List<String> getListStr(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        //定一个集合装数据和运算符
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }
}
