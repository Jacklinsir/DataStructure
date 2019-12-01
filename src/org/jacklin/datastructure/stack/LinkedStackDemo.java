package org.jacklin.datastructure.stack;

/**
 * 单链表实现栈
 * 
 * @author linsir
 *
 */
public class LinkedStackDemo {

	public static void main(String[] args) {
		/*LinkedStack<String> stack = new LinkedStack<>();
		stack.push("张三");
		stack.push("李四");
		stack.push("王五");
		stack.list();
		System.out.println("========出栈======");
		System.out.println(stack.pop());
		stack.list();
		System.out.println("========查看栈顶======");
		System.out.println(stack.peek());
		stack.list();*/
		
	}

}

class LinkedStack<T> implements Stack<T> {

	// 定一个头节点
	private StackNode<T> head;

	// 构造方法初始化链栈
	public LinkedStack() {
		this.head = new StackNode<>();
	}

	@Override
	public boolean isEmpty() {
		return head.next == null;
	}

	@Override
	public boolean isFull() {
		return false;// 链表没有容量限制
	}

	@Override
	public void push(T value) {
		// 初始化对象相当于第三方temp变量
		StackNode<T> stackNode = new StackNode<>(value);
		// 入栈 添加操作
		stackNode.next = head.next;
		head.next = stackNode;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("链表为空");
		}
		// 使用第三方变量
		StackNode<T> temp = head.next;
		head.next = head.next.next;
		return temp.value;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new RuntimeException("链表为空");
		}
		return head.next.value;
	}

	@Override
	public void list() {
		// 使用第三方变量
		StackNode<T> temp = head.next;
		while (temp != null) {
			System.out.println(temp);
			// 后移
			temp = temp.next;
		}

	}

}

class StackNode<T> {
	public T value; // id
	public StackNode<T> next; // 链表的下一个节点

	public StackNode() {
	}

	public StackNode(T no) {
		this.value = no;
	}

	@Override
	public String toString() {
		return "StackNode [value=" + value + "]";
	}

}
