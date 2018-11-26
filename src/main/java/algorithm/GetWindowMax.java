/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ��ȡ�����������ֵ���Ż��ⷨ��ʱ�临�Ӷ�O(n)
 * ������鳤��Ϊn, ���ڴ�СΪw,��һ������n-w+1���������ֵ
 *  ��4 3 5�� 4 3 3 6 7
 *
 * @author wb-ywh474663
 * @version $Id: GetWindowMax.java, v 0.1 2018��11��26�� 10:30 wb-ywh474663 Exp $
 */
public class GetWindowMax {

    /**
     * ����˫�˶���
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
            //deque ���ܴ��±꣬������ô�ж��Ƿ����ݹ��ڣ�
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
                //�Ѿ�������β�ͣ���Ҫȷ����ǰ�������ֵ���жϹ���
                maxData.add(data[deque.getFirst()]);
                //�ƶ�����
                if(currentWindowEndPosition < data.length-1){
                    currentWindowStartPosition++;
                    currentWindowEndPosition++;
                    if(deque.peek() < currentWindowStartPosition){
                        //���ڴ���
                        deque.pop();
                    }
                }else{
                    //�����Ѿ��ƶ�����
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