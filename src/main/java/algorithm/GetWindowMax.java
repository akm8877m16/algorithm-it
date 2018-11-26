/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 获取滑动窗口最大值，优化解法，时间复杂度O(n)
 * 如果数组长度为n, 窗口大小为w,则一共产生n-w+1个窗口最大值
 *  【4 3 5】 4 3 3 6 7
 *
 * @author wb-ywh474663
 * @version $Id: GetWindowMax.java, v 0.1 2018年11月26日 10:30 wb-ywh474663 Exp $
 */
public class GetWindowMax {

    /**
     * 利用双端队列
     * @param data
     * @param windowSize
     * @return
     */
    public static Integer[] getWindowMax(int[] data, int windowSize){
        Deque<Integer> deque = new LinkedList<Integer>();
        List<Integer> maxData = new ArrayList<Integer>();
        if(data == null || data.length == 0){
            return null;
        }
        int currentWindowStartPosition = 0;
        int currentWindowEndPosition = windowSize-1;
        for(int i = 0;i < data.length; i++){
            //deque 这能存下标，否则怎么判断是否数据过期？
            if(deque.isEmpty()){
                ((LinkedList<Integer>) deque).add(i);
            }else if( data[deque.peekLast()] > data[i]){
                ((LinkedList<Integer>) deque).add(i);
            }else{
                while ( !deque.isEmpty() && data[deque.peekLast()] <= data[i]){
                    deque.removeLast();
                }
                ((LinkedList<Integer>) deque).add(i);
            }
            if(i == currentWindowEndPosition){
                //已经到窗口尾巴，需要确定当前窗口最大值，判断过期
                maxData.add(data[deque.getFirst()]);
                //移动窗口
                if(currentWindowEndPosition < data.length-1){
                    currentWindowStartPosition++;
                    currentWindowEndPosition++;
                    if(deque.peek() < currentWindowStartPosition){
                        //过期处理
                        deque.pop();
                    }
                }else{
                    //窗口已经移动到底
                    Integer[] result = new Integer[maxData.size()];
                    return maxData.toArray(result);
                }
            }
        }
        return null;
    }

    public static void main(String[] arg){
        int[] data = {4,3,5,4,3,3,6,7};
        Integer[] result = getWindowMax(data,3);
        for(int i = 0; i< result.length;i++){
            System.out.print(result[i]);
            System.out.print(" ");
        }

    }

}