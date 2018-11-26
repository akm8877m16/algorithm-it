package algorithm;

import java.util.LinkedList;
import java.util.List;
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
     * @return List<HanoiTowerStackOperationEnum> 最简所有操作
     */

    public List<HanoiTowerStackOperationEnum> hanoiTowerOperationLeastMove(Stack<Integer> left, Stack<Integer> mid, Stack<Integer> right){
        LinkedList<HanoiTowerStackOperationEnum> step = new LinkedList<HanoiTowerStackOperationEnum>();
        //这肯定是第一步
        step.add(HanoiTowerStackOperationEnum.LEFT_TO_MIDDLE);
        mid.add(left.pop());

        while(!checkIfSuccess(left,mid)){
            doOperation(left,mid,right,step);
        }
        for(HanoiTowerStackOperationEnum singleStep: step){
            System.out.println(singleStep.getOperationDesc());
        }
        return step;
    }

    private boolean checkIfSuccess(Stack<Integer> left,Stack<Integer> mid){
        return (left.empty() && mid.empty());
    }

    public void doOperation (Stack<Integer> left,Stack<Integer> mid,Stack<Integer> right, LinkedList<HanoiTowerStackOperationEnum> list){
        HanoiTowerStackOperationEnum prevOperation = list.getLast();
        switch (prevOperation.getCode()){
            case 1:
            case 2:
                // left to middle 不能使用2
                int midTop = mid.empty() ? Integer.MAX_VALUE:mid.peek();
                int rightTop = right.empty()? Integer.MAX_VALUE:right.peek();
                //注意特殊情况


                if(midTop < rightTop){
                    //do 4 注意汉诺塔问题没有相等的考虑
                    right.add(mid.pop());
                    list.add(HanoiTowerStackOperationEnum.MIDDLE_TO_RIGHT);
                }else {
                    //do 3
                    mid.add(right.pop());
                    list.add(HanoiTowerStackOperationEnum.RIGHT_TO_MIDDLE);
                }
                break;

            case 3:
            case 4:
                // left to middle 不能使用2
                midTop = mid.empty() ? Integer.MAX_VALUE:mid.peek();
                int leftTop = left.empty() ? Integer.MAX_VALUE:left.peek();
                if(midTop < leftTop){
                    //do 2 注意汉诺塔问题没有相等的考虑
                    left.add(mid.pop());
                    list.add(HanoiTowerStackOperationEnum.MIDDLE_TO_LEFT);
                }else {
                    //do 3
                    mid.add(left.pop());
                    list.add(HanoiTowerStackOperationEnum.LEFT_TO_MIDDLE);
                }
                break;
        }
    }



    public static void main(String[] args){
        int n = 2;
        Stack<Integer> stackLeft = new Stack<Integer>();
        for (;n>0;n--){
            stackLeft.add(n);
        }
        HanoiTower hanoiTower = new HanoiTower();
        hanoiTower.hanoiTowerOperationLeastMove(stackLeft,new Stack<Integer>(), new Stack<Integer>());


    }
    

}
