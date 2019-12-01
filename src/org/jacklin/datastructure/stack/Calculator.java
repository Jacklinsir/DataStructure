package org.jacklin.datastructure.stack;

/**
 * 使用栈实现总和计算器(中缀表达式)
 *
 * @author linsir
 */
public class Calculator {

    public static void main(String[] args) {
        // 表达式
        String expression = "13+6*2-4/2";
        // 创建两个栈分别装数子和计算符号
        ArrayExpresStack expresStackNum = new ArrayExpresStack(10);
        ArrayExpresStack expresStackOper = new ArrayExpresStack(10);

        //扫描索引
        int index = 0;
        //截取计算数字
        int num1 = 0;
        int num2 = 0;
        //计算符号
        int oper = 0;
        //计算结果
        int result = 0;
        //将每次扫描得到的char保存到ch中
        char ch;

        //用户拼接
        String keepNum = "";

        //计算
        while (true) {
            //依次得到表达式中的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是
            if (expresStackOper.isOper(ch)) { //操作符
                //判断当前符号栈是否为空
                if (!expresStackOper.isEmpty()) {
                    //如果当前符号栈为空，直接存入符号栈，如果有符号则比较，如果当前的符号栈的优先级小于或者等于栈中的符号，需要pop两个数进行计算
                    //在从符号栈中pop一个符号，进行运算，将得到的结果入数值栈，入数值栈，然后将当前的操作符号入栈
                    if (expresStackOper.priority(ch) <= expresStackOper.priority(expresStackOper.peek())) {
                        //pop数和符号进行计算
                        num1 = expresStackNum.pop();
                        num2 = expresStackNum.pop();
                        oper = expresStackOper.pop();
                        //计算结果
                        result = expresStackNum.cal(num1, num2, oper);
                        //把运算结果入栈
                        expresStackNum.push(result);
                        //把当前操作符号入栈
                        expresStackOper.push(ch);
                    } else {
                        //如果当前操作符号大于栈顶的操作符直接入栈
                        expresStackOper.push(ch);
                    }
                } else {
                    //如果为空直接如符号栈 1+2
                    expresStackOper.push(ch);
                }
            } else {
                //如果是数值直接入数栈
                //expresStackNum.push(ch - 48);

                //=======================
                keepNum += ch; //处理多位数
                //如果ch已经是表达式最后一位
                if (index == expression.length() - 1) {
                    expresStackNum.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个数字是否为数字，如果为数字则继续扫描，如果是运算符，则入栈
                    //看最后一位 index++
                    if (expresStackOper.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果最后一位是运算符号，则入栈 keepNum="1" 或者"123"
                        expresStackNum.push(Integer.parseInt(keepNum));
                        //则清空keepNum
                        keepNum = "";
                    }
                }

            }
            //index++ 判断用户是否扫描到最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //扫描完成，就顺序从数栈和符号栈pop相应的数字和符号进行计算
        while (true) {
            //如果符号栈为空，则计算到最后面，直到数栈最后一个数字为止则未结果
            if (expresStackOper.isEmpty()) {
                break;
            }
            num1 = expresStackNum.pop();
            num2 = expresStackNum.pop();
            oper = expresStackOper.pop();
            result = expresStackNum.cal(num1, num2, oper);
            //结果入栈
            expresStackNum.push(result);

        }
        //将数栈最后一个数字pop出
        int resultNum = expresStackNum.pop();
        System.out.printf("计算结果：%d ", resultNum);

    }


}

class ArrayExpresStack {
    private int maxSize;// 栈最大容量
    private int[] stack;// 模拟栈
    private int top = -1;// 表示栈顶 位-1

    public ArrayExpresStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 判断栈是否已经满了
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈操作
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已经满了");
            return;
        }
        // 添加
        top++;
        stack[top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 查看栈顶元素
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return stack[top];
    }

    // 查看栈中所有元素
    public void show() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \n", i, stack[i]);
        }
    }

    // 判断运算符的优先级，使用数字表示
    // 数字越大，则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;// 表示乘除
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            System.out.println("运算符号错误！");
            return -1;
        }
    }

    // 判断是否为云算符号
    public boolean isOper(char oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    /**
     * 实行计算
     *
     * @param num1 计算数1
     * @param num2 计算数2
     * @param oper 计算符号
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;

            default:
                break;
        }

        // 返回计算结果
        return result;
    }

}
