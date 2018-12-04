/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package ThreadOperation;

import java.util.HashMap;
import java.util.UUID;

/**
 *  演示一下为什么说hashmap 是线程不安全的
 *  HashMap 扩容的时候会调用 resize() 方法，就是这里的并发操作容易在一个桶上形成环形链表；
 *  这样当获取一个不存在的 key 时，计算出的 index 正好是环形链表的下标就会出现死循环。
 * @author wb-ywh474663
 * @version $Id: HashMapThreadProblem.java, v 0.1 2018年12月04日 21:06 wb-ywh474663 Exp $
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