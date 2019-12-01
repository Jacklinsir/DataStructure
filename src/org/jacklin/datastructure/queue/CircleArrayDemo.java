package org.jacklin.datastructure.queue;

import java.util.Scanner;

public class CircleArrayDemo {

	public static void main(String[] args) {

        // 创建一个环形队列
        CircleArrayQueue queue = new CircleArrayQueue (4); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner (System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println ("s(show): 显示队列");
            System.out.println ("e(exit): 退出程序");
            System.out.println ("a(add): 添加数据到队列");
            System.out.println ("g(get): 从队列取出数据");
            System.out.println ("h(head): 查看队列头的数据");
            System.out.println ("c(size): 查看队列头的数据");
            key = scanner.next ().charAt (0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueueValue ();
                    break;
                case 'c':
                    int size = queue.size();
                    System.out.println("队列有效个数："+size);
                    break;
                case 'a':
                    System.out.println ("输出一个数");
                    int value = scanner.nextInt ();
                    queue.addQueueValue (value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueueValue();
                        System.out.printf ("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println (e.getMessage ());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueueVaule();
                        System.out.printf ("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println (e.getMessage ());
                    }
                    break;
                case 'e': // 退出
                    scanner.close ();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println ("程序退出~~");
    }
}

/**
 * 实现环形队列
 * 
 * @author linsir
 *
 */
class CircleArrayQueue {

	private int maxSize; // 队列最大容量
	private int front;// 队列头部: 指向队列的第一个元素 --> arr[front]
	private int rear;// 队列尾部: 指向队列元素的最后一个元素的后一个位置 rear+1
	private int arr[];// 模拟队列数组

	public CircleArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];// 初始化队列数组
	}

	// 判断队列是否满了
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 像队列添加元素
	public void addQueueValue(int num) {
		if (isFull()) {
			System.out.println("队列满了！");
			return;
		}
		// 添加操作
		arr[rear] = num;
		// 后移rear
		rear = (rear + 1) % maxSize;
	}

	// 向队列获取元素
	public int getQueueValue() {
		if (isEmpty()) {
			throw new RuntimeException("队列不能为空！");
		}
		// 获取元素
		int value = arr[front];
		// 后移front
		/**
		 * 算法解析： front = 0 maxSize=6 (front + 1) % maxSize=====> (0+1)%6=1
		 * 													====>(1+1)%6=2
		 * 														 ......
		 * 									 ====>(5+1)%6=0 //到达了队尾，回到对头，形成环形队列
		 */
		front = (front + 1) % maxSize;
		return value;
	}

	// 显示队列头元素
	public int headQueueVaule() {
		if (isEmpty()) {
			throw new RuntimeException("队列不能为空！");
		}
		// 现实队列头部元素，也就是第一个元素
		return arr[rear];
	}

	// 现实队列所有元素
	public void showQueueValue() {
		if (isEmpty()) {
			System.out.println("队列为空！");
			return;
		}
		// 遍历队列数组
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}

	}

	//计算队列中有效个数
	/**
	 * 算法解析：
	 * (rear + maxSize - front) % maxSize;
	 * rear=0, maxSize=6 ,front = 0 ====> 6%6=0 //有效个数为0个
	 * rear=2, maxSize=6 ,front = 1 ====> 7%6=1 //有效个数为1个
	 * 
	 */
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
}
