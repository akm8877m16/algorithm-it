/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.DP;

/**
 * 最大子串问题
 * 找到一个一维整数数组中，子数组之和的最大值
 * @author wb-ywh474663
 * @version $Id: FindMaxSubArraySum.java, v 0.1 2018年12月10日 11:59 wb-ywh474663 Exp $
 */
public class FindMaxSubArraySum {

    /**
     * 最典型的思路是穷举，的确，这个题一上来第一时间想到的就是穷举，然后，如果想用动态规划的思路
     * 那问题在于如何拆分子问题
     * 参考链接：
     * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
     * 但这道题，DP的思路体现在哪里？
     * 这里DP可能还是先搞不懂，先放一放
     *
     * 穷举分两种情况n^3 和 n^2两种时间复杂度
     */
    public static int findMaxSubArraySumBF(int[] array){
        //max=0的问题是最大值不能使负数,所以改一下
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int length = array.length;
        for(i=0;i<length;i++){
            for(j=i;j<length;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum += array[k];
                }
                if(max < sum){
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * DP的思路 O(nlgn)
     * 最大值是下面三种情况中最大的一个
     * 1 [0,array.length/2] 中的最大值
     * 2 [length/2，length-1] 中的最大值
     * 3 从length/2开始往两边扩散，找出的最大值:这个最大值就是从length/2开始，往左找到的最大值 + 往右找打的最大值
     * @param array
     * @return
     */
    public static int findMaxSubArraySumDP(int[] array,int start,int end){
        //终止条件
        if(start == end){
            return array[start];
        }

        int mid = (start+end)/2;
        int sum = 0;
        int maxLeftFromMid= Integer.MIN_VALUE;
        int maxRightFromMid = Integer.MIN_VALUE;
        for(int i = mid;i >=start;i--){
            sum += array[i];
            if(sum > maxLeftFromMid){
                maxLeftFromMid = sum;
            }
        }
        sum = 0;
        for (int i = mid+1;i<= end;i++){
            sum += array[i];
            if(sum > maxRightFromMid){
                maxRightFromMid = sum;
            }
        }
        int maxOption = maxLeftFromMid+maxRightFromMid;
        int maxLeft = findMaxSubArraySumDP(array,start,mid);
        int maxRight = findMaxSubArraySumDP(array,mid+1,end);
        return Math.max(Math.max(maxLeft,maxRight),maxOption);
    }

    public static void main(String[] args){
        int[] array = {10,11,12,-3,-89,78};
        int result = findMaxSubArraySumBF(array);
        System.out.println(result);
        result = findMaxSubArraySumDP(array,0,array.length-1);
        System.out.println(result);

        int[] array2 = {-10, -11, -12, -3, -89, -78};
        result = findMaxSubArraySumBF(array2);
        System.out.println(result);
        result = findMaxSubArraySumDP(array2,0,array.length-1);
        System.out.println(result);

        int[] array3 = {-10, -11, 45, -12, -3,22, -89, -78,1};
        result = findMaxSubArraySumBF(array3);
        System.out.println(result);
        result = findMaxSubArraySumDP(array3,0,array.length-1);
        System.out.println(result);

    }

}