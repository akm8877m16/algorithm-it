/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.StackRelated;

import java.util.Stack;

/**
 * ��ָOffer 30 ����ջ�����ݽṹ��ʵ��һ�����л�ȡ��Сֵ���ܵ�ջ��������ܾͽ� getMin
 * Ҫ�󣺵���min,push,pop��ʱ�临�Ӷȶ���O(1)
 * @author wb-ywh474663
 * @version $Id: GetMinStack.java, v 0.1 2018��12��04�� 17:25 wb-ywh474663 Exp $
 */
public class GetMinStack {
    /**
     * ʵ���߼���ʹ��һ������ջ����Сֵ
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public GetMinStack(){
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void add(Integer data){
        //��һ��
        if(stack.isEmpty()){
            minStack.add(data);
        }else{
          if(data < minStack.peek()){
              minStack.add(data);
          }
        }
        stack.add(data);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public Integer getMin(){
        if(minStack.isEmpty()){
            return null;
        }
        return minStack.peek();
    }

    /**
     * С��Ϊ�յ����
     * @return
     */
    public Integer pop(){
        if(stack.isEmpty()){
            return null;
        }
        if(stack.peek() == minStack.peek()){
            minStack.pop();
        }
        return stack.pop();
    }

    public static void main(String[] args){
        GetMinStack getMinStack = new GetMinStack();
        getMinStack.add(1);
        getMinStack.add(4);
        getMinStack.add(9);
        getMinStack.add(2);
        getMinStack.add(12);
        getMinStack.add(-1);
        getMinStack.add(-9);

        System.out.println(getMinStack.getMin());
        getMinStack.pop();
        System.out.println(getMinStack.getMin());
        getMinStack.pop();
        System.out.println(getMinStack.getMin());
        getMinStack.pop();
        System.out.println(getMinStack.getMin());
        getMinStack.pop();
        System.out.println(getMinStack.getMin());
        getMinStack.pop();
        System.out.println(getMinStack.getMin());
        getMinStack.pop();
        System.out.println(getMinStack.getMin());
        getMinStack.pop();
        System.out.println(getMinStack.getMin());
        getMinStack.pop();
        System.out.println(getMinStack.getMin());
        getMinStack.pop();
        System.out.println(getMinStack.getMin());
    }
}