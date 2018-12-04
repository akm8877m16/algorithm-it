/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package ThreadOperation;

import java.util.HashMap;
import java.util.UUID;

/**
 *  ��ʾһ��Ϊʲô˵hashmap ���̲߳���ȫ��
 *  HashMap ���ݵ�ʱ������ resize() ��������������Ĳ�������������һ��Ͱ���γɻ�������
 *  ��������ȡһ�������ڵ� key ʱ��������� index �����ǻ���������±�ͻ������ѭ����
 * @author wb-ywh474663
 * @version $Id: HashMapThreadProblem.java, v 0.1 2018��12��04�� 21:06 wb-ywh474663 Exp $
 */
public class HashMapThreadProblem {

    public static void main(String[] args){
        final HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run(){
                    map.put(UUID.randomUUID().toString(), "");
                }
            }).start();
        }
    }

}