/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package designPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者消费者
 * 看似简单，自己不写一遍，估计还要完
 * 两种写法
 * 1 利用阻塞队列
 *
 * 2 利用线程操作
 * wait notify 操作，必须先获取到需要等待的对象的锁，而且必须在synchronized 块内
 * @author wb-ywh474663
 * @version $Id: ProduceAndConsume.java, v 0.1 2018年12月01日 11:31 wb-ywh474663 Exp $
 */
public class ProduceAndConsume {

    private ArrayList<String> list = new ArrayList<String>();
    private volatile boolean producerStopFlag = false;
    private volatile boolean consumerStopFlag = false;

    /**
     * Getter method for property <tt>list</tt>.
     *
     * @return property value of list
     */
    public ArrayList<String> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     *
     * @param list value to be assigned to property list
     */
    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    /**
     * Getter method for property <tt>producerStopFlag</tt>.
     *
     * @return property value of producerStopFlag
     */
    public boolean isProducerStopFlag() {
        return producerStopFlag;
    }

    /**
     * Setter method for property <tt>producerStopFlag</tt>.
     *
     * @param producerStopFlag value to be assigned to property producerStopFlag
     */
    public void setProducerStopFlag(boolean producerStopFlag) {
        this.producerStopFlag = producerStopFlag;
    }

    /**
     * Getter method for property <tt>consumerStopFlag</tt>.
     *
     * @return property value of consumerStopFlag
     */
    public boolean isConsumerStopFlag() {
        return consumerStopFlag;
    }

    /**
     * Setter method for property <tt>consumerStopFlag</tt>.
     *
     * @param consumerStopFlag value to be assigned to property consumerStopFlag
     */
    public void setConsumerStopFlag(boolean consumerStopFlag) {
        this.consumerStopFlag = consumerStopFlag;
    }

    public static class producer implements Runnable{

            ProduceAndConsume source;
            int product;
            String name;
            public producer(ProduceAndConsume source,String name) {
                    this.source = source;
                    this.name = name;
            }

            @Override
            public void run() {
                while(!source.isProducerStopFlag()){
                    synchronized (source) {
                        if(source.getList().isEmpty()){
                            product++;
                            source.getList().add(String.valueOf(product));
                            System.out.println(this.name + " : " + "produce value " + String.valueOf(product));
                            source.notifyAll();
                        }
                        else{
                            try{
                                source.wait();
                            }catch (InterruptedException exp){
                                System.out.println(this.name + " : interrupted");
                                exp.printStackTrace();
                            }
                        }
                    }
                }
            }
    }

    public static class consumer implements Runnable{
        ProduceAndConsume source;
        String name;

        public consumer(ProduceAndConsume source,String name){
            this.source = source;
            this.name = name;
        }

        @Override
        public void run(){
            while(!source.isConsumerStopFlag()){
                synchronized (source) {
                    if(source.getList().isEmpty()){
                        try{
                            source.wait();
                        }catch (InterruptedException exp) {
                            System.out.println(this.name + " : interrupted");
                            exp.printStackTrace();
                        }
                    }else{
                        System.out.println(source.getList().remove(source.getList().size()-1) + "  : " + this.name);
                        source.notifyAll();
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        ProduceAndConsume source = new ProduceAndConsume();
        Thread producerThread1 = new Thread(new producer(source,"producer1"),"producer1");
        Thread producerThread2 = new Thread(new producer(source,"producer2"),"producer2");
        Thread consumerThread1 = new Thread(new consumer(source,"consuer1"),"consuer1");
        Thread consumerThread2 = new Thread(new consumer(source,"consuer2"),"consuer2");
        producerThread1.start();
        producerThread2.start();
        consumerThread1.start();
        consumerThread2.start();
        try {

            //有个小问题，如何终止代码？
            Thread.sleep(10000);
            source.setConsumerStopFlag(true);
            Thread.sleep(1000);
            source.setProducerStopFlag(true);
            Thread.sleep(1000);
            source.wait();
            source.notifyAll();
            System.out.println("Down");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}



