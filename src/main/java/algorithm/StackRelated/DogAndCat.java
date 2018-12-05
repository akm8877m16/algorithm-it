/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.StackRelated;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * è�����е�ʵ��
 * Ҫ�󣺿���ֱ�Ӳ�è
 * Ҳ����ֱ�Ӳ鹷
 * Ҳ���԰��ղ���˳���������è���߹�
 * @author wb-ywh474663
 * @version $Id: DogAndCat.java, v 0.1 2018��12��04�� 19:40 wb-ywh474663 Exp $
 */
public class DogAndCat {
    /**
     * ���˼·������è��������������������Ҫ����ʱ���������˳�����
     * ʱ�����ʵ�е����⣬��Ϊ��������add ʱ�����һ���ģ��Ǿ�������
     *
     * �����Ҿ�������һ��˼·����ά��һ������ṹ��ȱ����ά���ɱ���һ��
     * cat���� dog remove ��ʱ�������ṹҲҪά��
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

    //�����Ⱥ�˳�������ε���
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