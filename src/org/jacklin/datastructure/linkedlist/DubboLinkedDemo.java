package org.jacklin.datastructure.linkedlist;

/**
 * 双向链表
 * 
 * @author linsir
 *
 */
public class DubboLinkedDemo {
	public static void main(String[] args) {
		// 创建链表
		DubboLinked linked = new DubboLinked();
		linked.dubboOrdeByAdd(new DubboNode(6, "张三", "Java开发"));
		linked.dubboOrdeByAdd(new DubboNode(2, "王五", "Python开发"));
		linked.dubboOrdeByAdd(new DubboNode(4, "赵六", "Go语言开发"));
		linked.dubboOrdeByAdd(new DubboNode(5, "李四", "PHP开发"));
		linked.dubboOrdeByAdd(new DubboNode(7, "孙琦", "C++开发"));

		linked.dubboList();
//		System.out.println("修改双向链表");
//		linked.dubboUpdate(new DubboNode(40, "孙琦", "系统架构师"));
//		linked.dubboList();
//		System.out.println("删除指定ID链表");
//		linked.dubboDel(10);
//		linked.dubboList();
	}
}

class DubboLinked {
	// 先初始化一个头节点，头节点不可动。
	private DubboNode head = new DubboNode(0, "", "");

	public DubboNode getHead() {
		return head;
	}

	// ============链表按顺序添加=================

	public void dubboOrdeByAdd(DubboNode newNode) {
		// 获取头节点约束辅助变量
		DubboNode temp = head;
		// 定一个状态
		boolean flag = false;
		while (temp.next != null) {
			// 比较链表id序号的大小
			if (temp.next.id > newNode.id) {
				break;
			} else if (temp.next.id == newNode.id) {
				// 添加的元素id已经存在
				// 把状态改为true
				flag = true;
				break;
			}
			// 后移链表
			temp = temp.next;
		}
		if (!flag) {
			// 添加节点关联前一个节点
			newNode.pre = temp;
			// 判断是否在尾节点添加元素
			if (temp.next != null) {
				// 添加节点的下一个节点和新节点关联pre --->
				temp.next.pre = newNode;
			}
			// 关联添加节点和前一个节点连接
			newNode.next = temp.next;// 尾部时temp.next就是null
			// 后一个节点和添加节点关联
			temp.next = newNode;

		} else {
			System.out.printf("添加变量元素id【%d】已经存在！", newNode.id);
		}
	}

	// 链表添加
	public void dubboAdd(DubboNode newNode) {
		// 获取头节点，便于操作链表
		DubboNode temp = head;
		while (true) {
			// 查找最后一个节点
			if (temp.next == null) {
				break;
			}
			// 后移节点
			temp = temp.next;
		}
		// 追加到最后节点
		temp.next = newNode;
		// 构建成双向链表
		newNode.pre = temp;
	}

	// 链表更新
	public void dubboUpdate(DubboNode updateNode) {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空！");
			return;
		}
		// 定义头节点作为辅助变量,真实节点
		DubboNode temp = head.next;
		// 定一个状态值
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			// 找到这个需要更新节点
			if (temp.id == updateNode.id) {
				flag = true;
				break;
			}
			// 没找到就后移节点
			temp = temp.next;
		}
		if (flag) {
			// 更新操作
			temp.name = updateNode.name;
			temp.nickName = updateNode.nickName;
		} else {
			System.out.println("需要修改的链表不存在！id = " + updateNode.id);
		}
	}

	// 链表删除
	public void dubboDel(int id) {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空！");
			return;
		}
		// 接受头节点变量
		DubboNode temp = head.next;
		// 定一个状态记住遍历查找状态
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;// 链表为空
			}
			// 执行查找操作
			if (temp.id == id) {
				flag = true;
				break;
			}
			// 后移动节点
			temp = temp.next;
		}
		if (flag) {
			// 执行删除，只需要在删除的节点进行操作就行了
			temp.pre.next = temp.next;
			if (temp.next != null) { // 说明查找的是最后一个节点
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.printf("删除失败！需要删除id=【%d】不存在！\n", id);
		}
	}

	// 链表查询列表
	public void dubboList() {
		// 判断链表为空
		if (head.next == null) {
			System.out.println("链表为空！");
			return;
		}
		// 辅助变量
		DubboNode temp = head.next;
		while (true) {
			if (temp == null) { // 链表为空
				break;
			}
			System.out.println(temp);
			// 后移节点
			temp = temp.next;
		}
	}
}

class DubboNode {
	public int id;
	public String name;
	public String nickName;
	public DubboNode next;// 指向下一个节点
	public DubboNode pre;// 指向下一个节点

	public DubboNode(int id, String name, String nickName) {
		this.id = id;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "DubboNode [id=" + id + ", name=" + name + ", nickName=" + nickName + "]";
	}

}
