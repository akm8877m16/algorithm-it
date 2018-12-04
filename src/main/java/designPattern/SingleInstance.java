/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package designPattern;

/**
 * 单例的几种写法
 * 饥饿模式最简单，也最方便
 *
 * 第二种  双重null 检查
 * volatile要加的，其实不加也不一定不能使用，但有潜在隐患，因为new 操作并非原子操作，存在jvm不顺序执行的
 * 可能
 *
 * @author wb-ywh474663
 * @version $Id: SingleInstance.java, v 0.1 2018年12月01日 10:34 wb-ywh474663 Exp $
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
     * 饿汉模式
     * @return
     */
    public static SingleInstance singleInstance2 = new SingleInstance();
    public SingleInstance getSingleInstaneceHungry(){
        return singleInstance2;
    }


}