package org.jacklin.datastructure.stack;

/**
 * 数组模拟栈
 * 
 * @author linsir
 *
 */
public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(5);
		for (int i = 1; i <= 5; i++) {
			arrayStack.addStack(i);
		}

		System.out.println("出栈元素：" + arrayStack.pop());
		arrayStack.show();
	}
}

class ArrayStack {

	public int maxSize; // 栈最大容量
	public int[] arr; // 数组模拟栈容器
	public int top = -1;// 默认栈顶-1

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new int[this.maxSize];

	}

	// 判断栈是否已经满了
	public boolean isFull() {
		// top已经到了栈顶了
		return top == maxSize - 1;
	}

	// 判断栈是否为空
	public boolean isEmpty() {
		// 栈顶等于-1 意味着就在栈低
		return top == -1;
	}

	// 像栈中添加元素
	public void addStack(int value) {
		// 判断栈是否已经满来了
		if (isFull()) {
			System.out.println("栈已经满了");
			return;
		}
		// 添加
		top++; // 后移top指针
		arr[top] = value;
	}

	// 出栈操作
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈为空！");
		}
		int value = arr[top];
		top--; // 后减
		return value;
	}

	// 查看栈中所有元素
	public void show() {
		if (isEmpty()) {
			System.out.println("栈为空");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]= %d \n", i, arr[i]);
		}
	}

}
