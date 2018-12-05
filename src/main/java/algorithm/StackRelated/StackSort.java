/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.StackRelated;

import java.util.Stack;

/**
 * ջ�������ƣ�ֻ��ʹ��һ�������ջ���������ݽṹ������
 * @author wb-ywh474663
 * @version $Id: StackSort.java, v 0.1 2018��12��04�� 19:41 wb-ywh474663 Exp $
 */
public class StackSort {


    public static void sort(Stack<Integer> stack){
            Stack<Integer> tempStack = new Stack<Integer>();
            while(!stack.isEmpty()){
                //Ϊ��ʱ��һ��Ԫ��ֱ����ջ
                if(tempStack.isEmpty()){
                    tempStack.add(stack.pop());
                }else{
                    /**
                     *  ˼·�� Ŀ��ջҪ��С������ô��ʱջ��Ҫ�Ӵ�С���������
                     *  �Ϳ�������ѹ�ص�ʱ��ջ��Ϊ��С����
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