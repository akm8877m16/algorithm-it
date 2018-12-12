/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.Tree;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

import static algorithm.Tree.TreeTraversal.preOrder;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树，假设输入的前序遍历和中序遍历的结构中
 * 都不含重复的数字
 *
 * 例子： 前序遍历序列：{1,2,4,7,3,5,6,8}
 *        中序遍历序列: {4,7,2,1,5,3,8,6}
 * @author wb-ywh474663
 * @version $Id: TreeRebuild.java, v 0.1 2018年12月11日 10:39 wb-ywh474663 Exp $
 */
public class TreeRebuild {

    /**
     * 重建思路： 动态规划，或者说递归，
     * 光靠前序或者中序是没有办法唯一确定一个树的，一定要知道两者
     * @param preOrderList
     * @return
     */
    public static TreeNode treeRebuildPreOrder(int[] preOrderList, int[] inOrderList){

            if(preOrderList == null && inOrderList == null){
                return null;
            }

            TreeNode head = new TreeNode(preOrderList[0]);
            //确认左右子树的遍历序列
            int i;
            int[] inOrderLeft = null;
            int[] inOrderRight = null;
            int[] preOrderLeft = null;
            int[] preOrderRight = null;
            for(i =0;i<inOrderList.length;i++){
                //如果含有重复数字，那更麻烦，至少中序的head判断就要出错
                if(inOrderList[i] == head.val){
                    int leftTreeLength = i;
                    int rightTreeLength = inOrderList.length-i-1;
                    if(leftTreeLength != 0){
                        inOrderLeft = new int[leftTreeLength];
                        preOrderLeft = new int[leftTreeLength];
                        System.arraycopy(inOrderList,0,inOrderLeft,0,leftTreeLength);
                        System.arraycopy(preOrderList,1,preOrderLeft,0,leftTreeLength);
                    }
                    if(rightTreeLength != 0){
                        inOrderRight = new int[rightTreeLength];
                        preOrderRight = new int[rightTreeLength];
                        System.arraycopy(inOrderList,i+1,inOrderRight,0,rightTreeLength);
                        System.arraycopy(preOrderList,i+1,preOrderRight,0,rightTreeLength);
                    }
                    break;
                }
            }
            head.left = treeRebuildPreOrder(preOrderLeft,inOrderLeft);
            head.right = treeRebuildPreOrder(preOrderRight,inOrderRight);
            return head;
    }

    public static void main(String[] args){

        int[] preOrderTest = {1,2,4,7,3,5,6,8};
        int[] inOrderTest = {4,7,2,1,5,3,8,6};

        TreeNode head = treeRebuildPreOrder(preOrderTest,inOrderTest);

        //System.out.println(head.val);
        preOrder(head);

    }

}