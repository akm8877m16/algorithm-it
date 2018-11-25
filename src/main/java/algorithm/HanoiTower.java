package algorithm;

import java.util.Stack;

/**
 * 汉诺塔问题， 计算最少移动步数，条件限制是左中右三个搭，左右不能直接跳，必须经过中间塔
 *
 *
 */
public class HanoiTower {

    /**
     * 用三个栈来作为三个塔，假设初始位置所有块在left
     * @param left
     * @param mid
     * @param right
     */
    public  void hanoiTowerOperationLeastMove(Stack<Integer> left,Stack<Integer> mid, Stack<Integer> right){



    }

    public boolean checkIfSuccess(Stack<Integer> left,Stack<Integer> mid, Stack<Integer> right){
        return (left.empty() && mid.empty());
    }

    public Boolean leftToMid(Stack<Integer> left,Stack<Integer> mid){
        Boolean isSuccess = false;
        if(left.peek() < mid.peek()){
            System.out.println("left to mid");
            isSuccess = true;
        }
        return isSuccess;
    }

    public Boolean midToLeft(Stack<Integer> mid,Stack<Integer> left){
        Boolean isSuccess = false;
        if(mid.peek() < left.peek()){
            System.out.println("mid to left");
            isSuccess = true;
        }
        return isSuccess;
    }

    

}
