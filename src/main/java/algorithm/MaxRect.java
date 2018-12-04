/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm;

/**
 * 在二值矩阵(0,1),尺寸N*M 求最大的值都是1的子矩阵面积，时间复杂度实现O(N*M)
 * 比如：  1 0 1 1 1
 *         1 1 1 1 1
 *         1 1 1 1 0
 *         返回最大的1所在方形区域面积： 8
 * @author wb-ywh474663
 * @version $Id: MaxRect.java, v 0.1 2018年11月27日 11:33 wb-ywh474663 Exp $
 */
public class MaxRect {

    public static int findMaxRect(int[][] rect){
        //先横切，统计1开始的连续个数
        return 0;


    }

    /**
     * 获取柱状图数据
     * 比如输入： 0 1 1 1 1 1
     *            1 1 1 1 0 1
     *        ————————————
     *  得到      1 2 2 2 0 2
     *
     * @param data
     * @return
     */
    //private static int[] getHistogram(int[][]data){
    //    return {1};
    //}


    public static void main(String[] args){

        int[][] rect = {{1,0,1,1,1},{1,1,1,1,1},{1,1,1,1,0}};


    }

}