package JavaLanguage;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class TestRetry {

    public static void testRetry() {
        int i = 0;
        //retry:  //①
        while (true) {
            i++;
            System.out.println("i=" + i);
            int j = 0;
            retry:   //②
            for (; ; ) {
                j++;
                System.out.println("j=" + j);
                if (j == 2) {
                    break retry;
                }
            }
        }
    }





    public static void main(String[] args){

        //testRetry();
        //ThreadPoolExecutor   //  2019-02-25 到 2019-03-01 读
        //AbstractQueuedSynchronizer
        //Semaphore

        /**
        try{
            System.out.println("test1" );
            throw new RuntimeException("aaaaa");
        }catch (RuntimeException x){
            System.out.println("3333");
            throw x;
        }finally {
            System.out.println("6666"); //这个点很容易搞错，先做finally，然后才抛异常
        }
        */
        for(int i=0;i<1;i++){
            System.out.println(i);
        }

    }

}
