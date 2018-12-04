/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.StackRelated;

import java.util.Queue;
import java.util.Stack;

/**
 *  ������ջ��ģ��һ������
 *  ˳����Ϥһ�·��ͱ�̣���ʵ��࣬��������˵û��ʲô��������
 * @author wb-ywh474663
 * @version $Id: TwoStackQueue.java, v 0.1 2018��12��04�� 17:23 wb-ywh474663 Exp $
 */
public class TwoStackQueue<T> {
    /**
     * ���еĻ�����Ҫʵ������ͷ������β����
     * ע���������
     * ���⣬Ŀǰ���̲߳���ȫ��
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
     *  ��ջA��Ԫ��ת��ջB��
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