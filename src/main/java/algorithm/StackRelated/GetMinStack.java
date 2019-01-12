/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.StackRelated;

import java.util.Stack;

/**
 * 剑指Offer 30 定义栈的数据结构，实现一个具有获取最小值功能的栈，这个功能就叫 getMin
 * 要求：调用min,push,pop的时间复杂度都是O(1)
 * @author wb-ywh474663
 * @version $Id: GetMinStack.java, v 0.1 2018年12月04日 17:25 wb-ywh474663 Exp $
 */
public class GetMinStack {
    /**
     * 实现逻辑是使用一个辅助栈存最小值
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public GetMinStack(){
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void add(Integer data){
        //第一个
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
     * 小心为空的情况
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