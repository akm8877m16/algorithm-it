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
     * ǰ����� һ��linkedList(ͬ��ȱ���) + ����ջ,����ô���븴����
     * ��ʵһ��ջ�͹��ˣ�
     * @param head
     */
    public static void preOrder(TreeNode head){
        if(head == null){
            return;
        }
       Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(head);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }
            System.out.print(node.val);
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * �������ǰ�����������ʵ�����������˳���Ǹ�����
     * @param head
     */
    public static void preOrderRight(TreeNode head){
        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(head);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
            System.out.print(node.val);
            System.out.print(" ");
        }
        System.out.println();


    }

    /** �ȱ���left���ף�Ȼ���right
     * �������
     * @param head
     */
    public static void inOrder(TreeNode head){
        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(head);
        TreeNode cur = head;
        while(!stack.isEmpty()){

            while(cur.left != null){
                stack.add(cur.left);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val);
            System.out.print(" ");
            if(cur.right != null){
                cur = cur.right;
                stack.add(cur);
            }
        }
        System.out.println();
    }

    /**
     * ������� �����׺�������
     * @param head
     */
    public static void postOrder(TreeNode head){
        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> inputStack = new Stack<TreeNode>();
        stack.add(head);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
            inputStack.add(node);
        }
        while(!inputStack.isEmpty()){
            System.out.print(inputStack.pop().val);
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * ��ָOffer 32 ���ϵ��´�ӡ������
     * ���ǹ�����ȱ���
     *
     * ���˼·�������ö��� ʵ�ֲַ�
     *
     * ��չ˼���� ��ι�����ȱ�������ͼ�����Ƶ�˼·
     * @param head
     */
    public static void printFromTopToBottom(TreeNode head){

        return;
    }


    /**
     * ��Ϊ�����һ��С���Σ�Ҫ����д�ӡ��ȱ���������
     *
     * ˼·��һ���ģ�����Ҫ��������ж�һ�н���
     * @param head
     */
    public static void printFromTopToBottomInLines(TreeNode head){

        return;
    }

    /**
     * ������һ��Ļ�������һЩ�ı䣬Ҫ����д�ӡ��ȱ��������������ң�Ҫ��ʵ��֮���δ�ӡ����������
     * ��һ������Ҵ�ӡ���ڶ�����ҵ����ӡ������������Ҵ�ӡ���Դ�����
     * @param head
     */
    public static void printFromTopToBottomInLines2(TreeNode head){

        return;
    }


    public static void main(String[] args){
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        head.left = node1;
        head.right = node2;

        node1.left = node3;
        node1.right = node4;

        preOrder(head);
        inOrder(head);
        postOrder(head);

    }


}