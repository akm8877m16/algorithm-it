/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package designPattern;

/**
 * �����ļ���д��
 * ����ģʽ��򵥣�Ҳ���
 *
 * �ڶ���  ˫��null ���
 * volatileҪ�ӵģ���ʵ����Ҳ��һ������ʹ�ã�����Ǳ����������Ϊnew ��������ԭ�Ӳ���������jvm��˳��ִ�е�
 * ����
 *
 * @author wb-ywh474663
 * @version $Id: SingleInstance.java, v 0.1 2018��12��01�� 10:34 wb-ywh474663 Exp $
 */
public class SingleInstance {

    public static volatile SingleInstance singleInstance;

    public SingleInstance getSingleInstance(){

        if(singleInstance == null){
            synchronized (SingleInstance.class){
                if(singleInstance == null){
                    singleInstance = new SingleInstance();
                }
            }
        }
        return singleInstance;
    }

    /**
     * ����ģʽ
     * @return
     */
    public static SingleInstance singleInstance2 = new SingleInstance();
    public SingleInstance getSingleInstaneceHungry(){
        return singleInstance2;
    }


}