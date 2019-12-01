package org.jacklin.datastructure.linkedlist;

public class Josepfu {

	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);
		// circleSingleLinkedList.show();

		circleSingleLinkedList.countBoy(1, 2, 5);
	}

}

class CircleSingleLinkedList {
	// 创建一个first节点相当于Head
	private Boy first = null;

	// 添加Boy节点
	public void addBoy(int nums) {
		// 判断传入的nums是否合法
		if (nums < 1) {
			System.out.println("nums数值不正确！");
			return;
		}
		// 定义一个辅助变量，构建环形链表
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			// 根据编号创建boy节点
			Boy boy = new Boy(i);
			// 判断是否是第一个boy
			if (i == 1) {
				first = boy;
				first.setNext(boy);// 构建成环形first.next=body
				curBoy = first; // curBoy指向第一个boy
			} else {
				curBoy.setNext(boy);//
				boy.setNext(first);// 构成环形指向第一个元素
				curBoy = boy;// 指向下一个几点
			}
		}

	}

	// 显示环形单链表
	public void show() {
		// 判断链表是否为空
		if (first == null) {
			System.out.println("链表为空！");
			return;
		}
		// 因为first节点不能动，所以我们定一个辅助节点
		Boy curBoy = first;
		while (true) {
			System.out.printf("节点的序号：%d \n", curBoy.getNo());
			// 判断节点是否是最后一个节点
			if (curBoy.getNext() == first) {
				break;
			}
			// 后移节点
			curBoy = curBoy.getNext();
		}
	}

	// 根据用户输入，计算出boy编号出链表的顺序
	/**
	 * 
	 * @param startNo  表示从那个编号开始 1
	 * @param countNum //表示要执行几下2
	 * @param nums     //表示最初链表的有多少个数据10
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		// 对参数进行校验
		if (startNo < 1 || first == null || startNo > nums) {
			System.out.println("参数有问题！");
			return;
		}

		// 定一个辅助boy变量
		Boy helper = first;
		// 创建一个辅助变量helper，让他指向最后一个节点
		while (true) {
			// 表示helper最后一个节点
			if (helper.getNext() == first) {
				break;
			}
			// 后移节点
			helper = helper.getNext();
		}
		// 执行前，先让first和helper同时移动k-1
		for (int i = 0; i < startNo - 1; i++) {
			first = first.getNext(); //找到需要出链表的no
			helper = helper.getNext(); //然后helper连接上出链表的no的前一个节点，依次类推直到最后一个no为止
		}
		//依次找出出链表的no
		while (true) {
			//判断helper节点和first节点相等表示已经到最后一个节点了
			if (helper == first) {
				break;
			}
			//遍历执行次数countNum-1
			for (int j = 0; j < countNum - 1; j++) {
				first = first.getNext();//找到需要出链表的no
				helper = helper.getNext();//重新指向新的节点
			}
			System.out.println("出链表的序列号：" + first.getNo());
			//first指向的元素出去
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.println("最后链表的序列号：" + first.getNo());
	}
}

class Boy {

	private int no; // id
	private Boy next;// 指向下一个节点，，默认null

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Boy [no=" + no + ", next=" + next + "]";
	}

}