package org.jacklin.datastructure.stack;

/**
 * 统一抽取Stack接口通用方法
 * 
 * @author linsir
 *
 */
public interface Stack<T> {

	boolean isEmpty();

	boolean isFull();

	void push(T value);

	T pop();

	T peek();

	void list();

}
