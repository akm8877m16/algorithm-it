/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package basicDataStructure.List.sort;

/**
 * 快速排序
 * @author wb-ywh474663
 * @version $Id: SortOperation.java, v 0.1 2018年11月27日 23:35 wb-ywh474663 Exp $
 */
public class SortOperation {

    public static void quickSort(int[] num, int left, int right){
            if(num == null || num.length == 0){
                return;
            }
            if(left >= right){
                return;
            }
            int i = left;
            int j = right;
            int temp = num[i];
            while(i<j) {

                while(i<j && num[j] > temp){
                    j--;
                }
                num[i] = num[j];
                while(i<j && num[i]<= temp){
                    i++;
                }
                num[j] = num[i];
                num[i] = temp;
            }

            quickSort(num,left,i-1);
            quickSort(num,i+1,right);


    }

    public static void main(String[] args){
        int[] num = {10,2,3,1,67,49,38,65,97,76,13,27,0};

        for(int i=0;i<num.length;i++){
            System.out.print(num[i]);
            System.out.print(" ");
        }
        System.out.println("");
        quickSort(num,0,num.length-1);
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]);
            System.out.print(" ");
        }

    }

}