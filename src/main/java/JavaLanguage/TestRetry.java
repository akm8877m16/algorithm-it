package JavaLanguage;

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

        testRetry();

    }

}
