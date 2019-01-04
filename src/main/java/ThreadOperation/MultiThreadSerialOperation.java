/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package ThreadOperation;

/**
 * ����� A�̵߳ȴ�B�߳�ִ����ϣ�C�̵߳ȴ�A�߳�ִ����ϣ�
 * Ҳ����ִ��˳��   B  ->  A -> C
 *                  t2 -> t1 ->t3
 * @author wb-ywh474663
 * @version $Id: MultiThreadSerialOperation.java, v 0.1 2018��12��01�� 11:37 wb-ywh474663 Exp $
 */
public class MultiThreadSerialOperation {

    public static void main(String[] args){

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("I am thread B");
                    Thread.sleep(5000);
                }catch (InterruptedException exp){
                    exp.printStackTrace();
                }
            }
        },"B");

        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                    System.out.println("I am thread A");
                    Thread.sleep(5000);
                }catch (InterruptedException exp){
                    exp.printStackTrace();
                }
            }
        },"A");

        final Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                    System.out.println("I am thread C");
                    Thread.sleep(5000);
                }catch (InterruptedException exp){
                    exp.printStackTrace();
                }
            }
        },"C");

        t1.start();
        t2.start();
        t3.start();

    }

}