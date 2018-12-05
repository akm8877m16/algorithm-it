/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.StackRelated;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 猫狗队列的实现
 * 要求：可以直接查猫
 * 也可以直接查狗
 * 也可以按照插入顺序依次输出猫或者狗
 * @author wb-ywh474663
 * @version $Id: DogAndCat.java, v 0.1 2018年12月04日 19:40 wb-ywh474663 Exp $
 */
public class DogAndCat {
    /**
     * 设计思路，还是猫，狗队列两个，但是需要保存时间戳，用于顺序输出
     * 时间戳其实有点问题，因为可能连续add 时间戳是一样的，那就尴尬了
     *
     * 所以我觉得另外一个思路可以维护一个链表结构，缺点是维护成本高一点
     * cat或者 dog remove 的时候该链表结构也要维护
     */

    public abstract static class Base{

        long timeStamp;

        public Base(){
            timeStamp = System.currentTimeMillis();
            try{
                Thread.sleep(1);
            }catch (InterruptedException exp){

            }

        }

    }

    public static class Cat extends Base{
        String type = "Cat";
        String name;
        public Cat(String name){
            super();
            this.name = name;
        }
    }

    public static class Dog extends Base{
        String type = "Dog";
        String name;
        public Dog(String name){
            super();
            this.name = name;
        }
    }

    private LinkedList<Cat> catQueue;
    private LinkedList<Dog> dogQueue;

    public DogAndCat(){
        catQueue = new LinkedList<Cat>();
        dogQueue = new LinkedList<Dog>();
    }

    public void add(Cat cat){
        catQueue.add(cat);
    }
    public void add(Dog dog){
        dogQueue.add(dog);
    }

    public void pullCat(){
        while(!catQueue.isEmpty()){
            System.out.println(catQueue.remove().name);
        }
    }

    public void pullDog(){
        while(!dogQueue.isEmpty()){
            System.out.println(dogQueue.remove().name);
        }
    }

    public boolean isEmpty(){
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return catQueue.isEmpty();
    }

    public boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    //按照先后顺序来依次弹出
    public void pullAll(){
        while(!isEmpty()){
            if(catQueue.isEmpty()){
                if(dogQueue.isEmpty()){
                    return;
                }else{
                    while(!dogQueue.isEmpty()){
                        System.out.println(dogQueue.remove().name);
                    }
                }
            }else{
                if(dogQueue.isEmpty()){
                    while(!catQueue.isEmpty()){
                        System.out.println(catQueue.remove().name);
                    }
                }else{
                    if(catQueue.getFirst().timeStamp <= dogQueue.getFirst().timeStamp){
                        System.out.println(catQueue.remove().name);
                    }else{
                        System.out.println(dogQueue.remove().name);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        DogAndCat dogAndCatQueue = new DogAndCat();

        dogAndCatQueue.add(new Cat("cat1"));
        dogAndCatQueue.add(new Cat("cat2"));
        dogAndCatQueue.add(new Dog("dog1"));
        dogAndCatQueue.add(new Cat("cat3"));
        dogAndCatQueue.add(new Dog("dog2"));

        dogAndCatQueue.pullAll();
    }

}