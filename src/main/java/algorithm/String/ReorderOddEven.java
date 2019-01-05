package algorithm.String;


/**
 *  剑指Offer 面试题21：
 *  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于位于数组的后半
 *  部分
 *
 *  此外，想想该功能是否可以扩展:
 *  比如分组标准可以变为: 数组分成两部分，负数在前半部分，整数在后半部分
 *  数组分成两部分，能被3整除的在前半部分，不能被3整除的在后半部分
 *
 */
public class ReorderOddEven {

    /**
     * 最简单的先写出来
     * 奇在前，偶在后，那么从数组两端开始搜，从前往后搜偶，从后往前搜奇，两者交换
     * 终止条件： 直到两个位置标志的位置前后顺序互换
     * @param array
     */
    public static void reorderOddEven(int[] array){
        if(array == null || array.length ==0 || array.length == 1){
            return;
        }
        int start = 0;
        int end = array.length-1;
        int temp = 0;
        while(start < end){
            /** 找到第一个偶数,或者极端情况下找不到 */
            while(start < (array.length-1) && array[start]%2 == 1){
                start++;
            }
            while(end > 0 && array[end] %2 == 0){
                end--;
            }
            if(start < end){
                temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    /**
     * 思路是交换，这样时间复杂度就是数组长度O(n)
     * 可扩展性利用接口
     */
    interface ExchangeCondition{

        boolean canExchange(int a);

    }

    public static class oddEvenCondition implements ExchangeCondition{

        public boolean canExchange(int a) {
            return a%2 == 0;
        }
    }

    public static class tripleCondition implements ExchangeCondition{

        public boolean canExchange(int a) {
            return a%3 != 0;
        }
    }


    public static void reorderExtendable(int[] array, ExchangeCondition condition){

        if(array == null || array.length ==0 || array.length == 1){
            return;
        }
        int start = 0;
        int end = array.length-1;
        int temp = 0;
        while(start < end){
            /** 找到第一个偶数,或者极端情况下找不到 */
            while(start < (array.length-1) && !condition.canExchange(array[start])){
                start++;
            }
            while(end > 0 && condition.canExchange(array[end])){
                end--;
            }
            if(start < end){
                temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }


    public static void main(String[] args){
        int[] testArray = {2,5,7,6,8,9,12,34,33,51,9,2};
        //int[] testArray = {1,3,9,11,33};
        /*
        reorderOddEven(testArray);
        for(int i = 0;i< testArray.length;i++){
            System.out.print(testArray[i]);
            System.out.print(" ");
        }
        System.out.println();
        */
        reorderExtendable(testArray, new oddEvenCondition());
        for(int i = 0;i< testArray.length;i++){
            System.out.print(testArray[i]);
            System.out.print(" ");
        }
        System.out.println();


        reorderExtendable(testArray, new tripleCondition());
        for(int i = 0;i< testArray.length;i++){
            System.out.print(testArray[i]);
            System.out.print(" ");
        }
        System.out.println();

    }

}
