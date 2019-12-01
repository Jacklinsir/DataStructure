package org.jacklin.datastructure.linkedlist;

import java.util.Stack;

/**
 * 单链表
 * 
 * @author linsir
 *
 */
public class SingletonLinkedListDemo {
	public static void main(String[] args) {

		SingletonLinkedList singletonLinkedList = new SingletonLinkedList();
		SingletonLinkedList singletonLinkedList2 = new SingletonLinkedList();
//		singletonLinkedList.addLinked(new HeroNode(1, "张三", "组长"));
//		singletonLinkedList.addLinked(new HeroNode(2, "李四", "组员"));
//		singletonLinkedList.addLinked(new HeroNode(3, "王五", "组员"));

		singletonLinkedList.addLinkedByOrder(new HeroNode(1, "张三", "组长"));
		singletonLinkedList.addLinkedByOrder(new HeroNode(5, "孙七", "组员"));
		singletonLinkedList.addLinkedByOrder(new HeroNode(2, "李四", "组员"));
		singletonLinkedList2.addLinkedByOrder(new HeroNode(4, "赵六", "组员"));
		singletonLinkedList2.addLinkedByOrder(new HeroNode(3, "王五", "组员"));
		SingletonLinkedList.mergeTwoLists(singletonLinkedList2.getHead(), singletonLinkedList.getHead());
		// singletonLinkedList.updateLinked(new HeroNode(4, "xiaoliuliu", "daolao"));
		// singletonLinkedList.deleteLinked(4);
		// System.out.println("反转链表");
		// SingletonLinkedList.reversetList(singletonLinkedList.getHead());
		// 链表逆序打印
		// System.out.println("链表逆序打印");
		// SingletonLinkedList.reversePrint(singletonLinkedList.getHead());
		// singletonLinkedList.linkedList();

		// System.out.println("有效个数：" +
		// SingletonLinkedList.length(singletonLinkedList.getHead()));
		// System.out.println("查找到的节点=" +
		// SingletonLinkedList.findLastIndexNode(singletonLinkedList.getHead(), 1));

	}

}

class SingletonLinkedList {
	// 创建一个空的头节点并初始化
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return head;
	}

	// 判断链表是否为空
	public boolean isEmpty() {
		return head.next == null;
	}

	// 向单链表添加元素
	// 1:找到当前链表最后一个节点
	// 2:将最后一个节点指向新的节点
	public void addLinked(HeroNode heroNode) {
		// 头节点不能动，使用第三方变量接受
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) { // 找到最后一个尾节点
				break;
			}

			// 没有找到最后一个则后移
			temp = temp.next;

		}
		// 当循环退出时候temp就指向新的节点了。
		// 将最后这个节点next指向新的节点
		temp.next = heroNode;
	}

	// 顺序添加到链表中
	public void addLinkedByOrder(HeroNode heroNode) {
		// 用第三方变量接受头节点，因为头节点不能动
		HeroNode temp = head;
		// 定义状态
		boolean flag = false;
		while (true) {
			if (temp.next == null) { // 表示链表已经到了最后面，跳出循环
				break;
			}
			// 位置找到，就在temp插入指定元素
			if (temp.next.id > heroNode.id) {
				break;
			} else if (temp.next.id == heroNode.id) { // 表示当前id值的节点已经存在了
				flag = true;
				break;
			}
			// 位置没有找到则后移节点
			temp = temp.next;
		}
		if (flag) {
			System.out.printf("id=%d 已经存在了！\n", heroNode.id);
		} else {
			// 添加元素,将链表插入到temp后面,，就是在插入之前找到temp.next.id > heroNode.id前面，和temp的后面
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	// 修改链表
	public void updateLinked(HeroNode newHeroNode) {
		if (isEmpty()) {
			System.out.println("修改失败！链表为空！");
			return;
		}
		// 使用第三方变量接受第一个初始化为null对象
		HeroNode temp = head;
		// 用于接收遍历状态
		boolean flag = false;
		while (true) {
			// 判断链表是否为最后一个节点
			if (temp.next == null) {
				break;
			}
			// 判断是否该对象
			if (temp.id == newHeroNode.id) {
				flag = true;
				// 修改操作，将临时节点指向新节点的值
				temp.name = newHeroNode.name;
				temp.nickName = newHeroNode.nickName;
				break;
			}
			// 移动节点
			temp = temp.next;
		}

		// 根据游标状态判断是否已经修改成功
		if (flag) {
			System.out.println("修改节点成功！");
		} else {
			System.out.printf("修改失败！节点id=%d 不存在！\n", newHeroNode.id);
		}
	}

	// 删除节点
	public void deleteLinked(Integer id) {
		// 判断链表是否为空
		if (isEmpty()) {
			System.out.println("删除失败！链表为空");
			return;
		}
		// 使用第三方变量接受head头节点
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			// 判断需要删除的节点上一个节点的下一个节点是否和当前参数的id相等，则进行删除操作。
			if (temp.next.id == id) {
				// 找到需要删除的节点给游标设置成true
				flag = true;
				break;
			}
			// 后移temp.next节点
			temp = temp.next;
		}
		if (flag) {
			// 删除操作
			temp.next = temp.next.next;
			System.out.println("删除成功！");
		} else {
			System.out.printf("删除节点失败！id=%d 不存在！", id);
		}
	}

	// 遍历链表
	public void linkedList() {
		if (isEmpty()) {
			System.out.println("链表为空！");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			// 表示最后一个节点
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			// temp后移
			temp = temp.next;
		}
	}

	// ===================合并两个 有序的单链表，合并之后的链表依然有序=============================
	public static HeroNode mergeTwoLists(HeroNode l1, HeroNode l2) {
		if (l1 == null) return l2;
        if (l2 == null) return l1;
 
        HeroNode head = null;
        if (l1.id <= l2.id){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        System.out.println(head);
        return head;

	}

	// ===================单链表逆序打印=============================
	/**
	 * 
	 * @param head 头节点
	 */
	public static void reversePrint(HeroNode head) {

		// 链表为空
		if (head.next == null) {
			System.out.println("链表为空!");
			return;
		}
		// 用第三方变量接受头节点下一个节点
		HeroNode cur = head.next;
		Stack<HeroNode> stack = new Stack<>();
		while (cur != null) {
			// 把节点加入栈中
			stack.push(cur);
			// 后移cur节点
			cur = cur.next;
		}
		// 打印栈中元素
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

	// ===================单链表反转=============================

	public static void reversetList(HeroNode head) {
		// 判断当前列表是否为空,为空直接返回
		if (head.next == null || head.next.next == null) {
			return;
		}
		// 定义辅助变量
		HeroNode cur = head.next;
		// 指向当前节点【cur】的下一个节点
		HeroNode next = null;
		// 定义反转的新节点
		HeroNode reverseHead = new HeroNode(0, "", "");
		// 遍历原来的链表，每遍历一个节点，就将其取出，并放在新的reversetHead的最前面节点
		while (cur != null) {
			// 先暂时保存当前节点的下一个节点
			next = cur.next;
			// 将cur的下一个节点指向新的链表的最前端
			cur.next = reverseHead.next;
			// 将cur节点连接到新的节点
			reverseHead.next = cur;
			// 移动cur节点
			cur = next;
		}
		// 最后将head.next节点指向reverseHead.next，实现链表的反转
		head.next = reverseHead.next;
	}

	// ==================查找链表倒数第k个节点元素====================
	// 1.判断链表是否为空
	// 2.通过第三方变量的接收HeroNode 头节点的下一个节点，
	// 3.遍历获取链表的总长度 getLength
	// 4.得到总长度size长度后，遍历（size-index）
	// 5.找到返回节点，没有找到返回null
	/**
	 * 
	 * @param head  传入头节点
	 * @param index 倒数的index元素
	 * @return
	 */
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if (head.next == null) {
			System.out.println("链表为空！");
			return null;
		}
		// 获取链表有效size个数
		int size = SingletonLinkedList.length(head);
		// 判断index有效范围
		if (index < 0 || index > size) {
			return null;
		}
		// 接收头节点的下一个节点
		HeroNode cur = head.next;
		// 遍历查找倒数的k节点的元素
		for (int i = 0; i < size - index; i++) { // 4-1=3
			// 后移cur节点
			cur = cur.next;
		}
		// 返回第k个节点
		return cur;
	}

	// ==================获取链表有效节点个数(不统计头节点)====================
	/**
	 * 
	 * @param head 链表的头节点
	 * @return
	 */
	public static int length(HeroNode head) {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空！");
			return 0;
		}
		// 定义个length
		int length = 0;
		// 定一个第三方变量接收头节点的下一个节点
		HeroNode cur = head.next;
		while (cur != null) {
			// 记录有效节点个数
			length++;
			// 后移下一个节点
			cur = cur.next;
		}
		// 返回节点个数
		return length;
	}

}

class HeroNode {
	public int id; //
	public String name; //
	public String nickName; //

	public HeroNode next;// 指向下一个节点

	public HeroNode(int id, String name, String nickName) {
		this.id = id;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode [id=" + id + ", name=" + name + ", nickName=" + nickName + "]";
	}

}
