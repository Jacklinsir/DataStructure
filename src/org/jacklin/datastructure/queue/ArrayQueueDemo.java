package org.jacklin.datastructure.queue;

public class ArrayQueueDemo {

	public static void main(String[] args) {

		ArrayQueue queue = new ArrayQueue(3);
		// 添加数据
		queue.addQueue(10);
		queue.addQueue(20);
		queue.addQueue(30);
		queue.showQueueValue();
		System.out.println(queue.showHeadValue());
	}
}

/**
 * 实现队列
 * 
 * @author linsir
 *
 */
class ArrayQueue {
	private int maxSize;// 记录元素最大容量
	private int rear;// 记录元素头部
	private int front;// 记录元素尾部
	private int[] arr;// 记录队列容量

	public ArrayQueue() {
		super();
		this.maxSize = 10;
		this.arr = new int[10]; // 初始化队列容器位10
		this.rear = -1;
		this.front = -1;
	}

	public ArrayQueue(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.arr = new int[maxSize]; // 初始化队列容器
		this.rear = -1; // 指向队尾，指向队尾的数据（即就是队列最后一个元素）
		this.front = -1;// 指向对头，front是指向队列头的前一个位置
	}

	// 当rear值等于容器最大值则队列已经满了
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 给队列添加元素
	public boolean addQueue(int num) {
		if (isFull()) {
			throw new RuntimeException("队列已满"+num);
		}
		// 移动rear
		// rear++;
		arr[++rear] = num;
		if (arr[rear] == num) {
			return true;
		} else {
			return false;
		}
	}

	// 像队列中取出数据
	public int getQueueVaule() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		// 像队列取出数据移动 front
		// front++
		return arr[++front];
	}

	// 显示队列中所有数据
	public void showQueueValue() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	// 显示队列头部数据
	public int showHeadValue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		// 显示头部数据
		return arr[front + 1];

	}
}