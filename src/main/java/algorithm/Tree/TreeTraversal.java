/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * ���������ֱ������ݹ�Ͳ����ˣ�̫��
 * ����һ��ǰ������ �������ֱ���
 * ��ΪĿǰ��Ҫ������������Ŀ������ӱ����ṹ��
 * @author wb-ywh474663
 * @version $Id: TreeTraversal.java, v 0.1 2018��12��11�� 10:54 wb-ywh474663 Exp $
 */
public class TreeTraversal {

    /**
     * ǰ����� һ��linkedList(ͬ��ȱ���) + ����ջ
     * @param head
     */
    public static void preOrder(TreeNode head){
        if(head == null){
            return;
        }
        LinkedList<TreeNode> leftList = new LinkedList<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        leftList.add(head);
        while(!leftList.isEmpty()){
            TreeNode temp = leftList.pop();
            System.out.println(temp.val);
            if(temp.left != null){
                leftList.add(temp.left);
            }
            if(temp.right != null){
                rightStack.add((temp.right));
            }
            if(leftList.isEmpty()){
                while(!rightStack.isEmpty()){
                    leftList.add(rightStack.pop());
                }
            }
        }
    }

    /**
     * �������
     * @param head
     */
    public static void inOrder(TreeNode head){


    }

    /**
     * �������
     * @param head
     */
    public static void postOrder(TreeNode head){


    }


}