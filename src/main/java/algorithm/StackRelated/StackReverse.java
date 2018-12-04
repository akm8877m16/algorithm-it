/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.StackRelated;

import java.util.Stack;

/**
 * ��һ��ջ����  ��������������ֻ��ʹ�õݹ��ջ����
 * @author wb-ywh474663
 * @version $Id: StackReverse.java, v 0.1 2018��12��04�� 17:27 wb-ywh474663 Exp $
 */
public class StackReverse {

    /**
     * �����ϵݹ�Ҳ����ջ��ԭ��
     * ���ú���ջ�������ݣ�����˵����
     * ������Ҫ�������ݹ飬�����ѵ����� so
     * @param stack
     */
    public Stack<Integer> reverseStack(Stack<Integer> stack){
        if(stack.size() == 1){
            return stack;
        }
        Integer last = findLast(stack);
        reverseStack(stack);
        stack.push(last);
        return  stack;
    }

    private Integer findLast(Stack<Integer> stack){
        if(stack.size() == 1){
            return stack.pop();
        }
        int head = stack.pop();
        int last =  findLast(stack);
        stack.push(head);
        return last;
    }


    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        StackReverse stackReverse = new StackReverse();
        stack = stackReverse.reverseStack(stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
            System.out.print(" ");
        }
        System.out.println();
    }
}