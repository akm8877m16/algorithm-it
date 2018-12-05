/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.StackRelated;

import java.util.Stack;

/**
 * 栈排序，限制：只能使用一个额外的栈，其他数据结构不能用
 * @author wb-ywh474663
 * @version $Id: StackSort.java, v 0.1 2018年12月04日 19:41 wb-ywh474663 Exp $
 */
public class StackSort {


    public static void sort(Stack<Integer> stack){
            Stack<Integer> tempStack = new Stack<Integer>();
            while(!stack.isEmpty()){
                //为空时第一个元素直接入栈
                if(tempStack.isEmpty()){
                    tempStack.add(stack.pop());
                }else{
                    /**
                     *  思路： 目标栈要从小到大那么临时栈就要从大到小，这样最后
                     *  就可以重新压回的时候栈变为从小到大
                     */
                    if(tempStack.peek() >= stack.peek()){
                        tempStack.add(stack.pop());
                    }else{
                        Integer temp = stack.pop();
                        while((!tempStack.isEmpty()) && tempStack.peek() < temp){
                            stack.push(tempStack.pop());
                        }
                        tempStack.push(temp);
                    }
                }
            }
            while(!tempStack.isEmpty()){
                stack.push(tempStack.pop());
            }
    }

    public static void printStack(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Stack<Integer> test = new Stack<Integer>();
        test.add(1);
        test.add(9);
        test.add(6);
        test.add(7);
        test.add(11);
        test.add(10);
        test.add(9);
        test.add(2);
        printStack(test);
        test.add(1);
        test.add(9);
        test.add(6);
        test.add(7);
        test.add(11);
        test.add(10);
        test.add(9);
        test.add(2);
        sort(test);
        printStack(test);

    }

}