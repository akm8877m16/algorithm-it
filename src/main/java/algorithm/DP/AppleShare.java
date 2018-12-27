/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.DP;

/**
 * 苹果分享问题
 * 先考虑m个苹果分给n个小孩 ， m>=n, 每个小孩至少可以获取一个苹果
 * 计算有几种解法
 *
 * 如果考虑小孩可以没有苹果呢？这样也包括了m<n的情况吧
 *
 * 穷举就不放在这里
 * @author wb-ywh474663
 * @version $Id: AppleShare.java, v 0.1 2018年12月24日 9:57 wb-ywh474663 Exp $
 */
public class AppleShare {

    public static int getAppleShareNumber(int appleNumber,int children){
        //先不考虑这种情况
        if(appleNumber < children){
            return 0;
        }
        if(appleNumber >= children && children ==1){
            return 1;
        }

        int maxPerChildren = appleNumber-children+1;
        int shareCal=0;
        for(int i = 1;i<=maxPerChildren;i++){
            shareCal += getAppleShareNumber(appleNumber-i,children-1);
        }
        return shareCal;
    }



    public static void main(String[] arg){
        int share = getAppleShareNumber(13,12);
        System.out.println(share);
    }

}