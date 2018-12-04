/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.StackRelated;

import java.util.Queue;
import java.util.Stack;

/**
 *  用两个栈来模拟一个队列
 *  顺便熟悉一下泛型编程，其实差不多，就这题来说没有什么特殊限制
 * @author wb-ywh474663
 * @version $Id: TwoStackQueue.java, v 0.1 2018年12月04日 17:23 wb-ywh474663 Exp $
 */
public class TwoStackQueue<T> {
    /**
     * 队列的话，就要实现数据头部出，尾部进
     * 注意特殊情况
     * 另外，目前是线程不安全的
     * @param args
     */
    private Stack<T>  stackA;
    private Stack<T>  stackB;

    public TwoStackQueue(){
        stackA = new Stack<T>();
        stackB = new Stack<T>();
    }

    public void add(T data){
        stackA.add(data);
    }

    public T remove(){
        if(stackB.isEmpty()){
           transfer();
        }
        if(!stackB.isEmpty()){
            return stackB.pop();
        }else{
            return null;
        }
    }

    public boolean isEmpty(){
        return stackA.isEmpty()&&stackB.isEmpty();
    }

    /**
     *  将栈A中元素转到栈B中
     */
    private void transfer(){
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }



    public static void main(String[] args){
        TwoStackQueue queue = new TwoStackQueue();
        queue.add("test1");
        queue.add("test2");
        queue.add("test3");
        queue.add("test4");
        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }


}