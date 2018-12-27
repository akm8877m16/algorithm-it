/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.DP;

/**
 * ����Ӵ�����
 * �ҵ�һ��һά���������У�������֮�͵����ֵ
 * @author wb-ywh474663
 * @version $Id: FindMaxSubArraySum.java, v 0.1 2018��12��10�� 11:59 wb-ywh474663 Exp $
 */
public class FindMaxSubArraySum {

    /**
     * ����͵�˼·����٣���ȷ�������һ������һʱ���뵽�ľ�����٣�Ȼ��������ö�̬�滮��˼·
     * ������������β��������
     * �ο����ӣ�
     * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
     * ������⣬DP��˼·���������
     * ����DP���ܻ����ȸ㲻�����ȷ�һ��
     *
     * ��ٷ��������n^3 �� n^2����ʱ�临�Ӷ�
     */
    public static int findMaxSubArraySumBF(int[] array){
        //max=0�����������ֵ����ʹ����,���Ը�һ��
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
     * DP��˼· O(nlgn)
     * ���ֵ�������������������һ��
     * 1 [0,array.length/2] �е����ֵ
     * 2 [length/2��length-1] �е����ֵ
     * 3 ��length/2��ʼ��������ɢ���ҳ������ֵ:������ֵ���Ǵ�length/2��ʼ�������ҵ������ֵ + �����Ҵ�����ֵ
     * @param array
     * @return
     */
    public static int findMaxSubArraySumDP(int[] array,int start,int end){
        //��ֹ����
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