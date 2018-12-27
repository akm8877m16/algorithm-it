/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.DP;

/**
 * ƻ����������
 * �ȿ���m��ƻ���ָ�n��С�� �� m>=n, ÿ��С�����ٿ��Ի�ȡһ��ƻ��
 * �����м��ֽⷨ
 *
 * �������С������û��ƻ���أ�����Ҳ������m<n�������
 *
 * ��پͲ���������
 * @author wb-ywh474663
 * @version $Id: AppleShare.java, v 0.1 2018��12��24�� 9:57 wb-ywh474663 Exp $
 */
public class AppleShare {

    public static int getAppleShareNumber(int appleNumber,int children){
        //�Ȳ������������
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