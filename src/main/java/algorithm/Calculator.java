/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm;

import java.util.HashMap;
import java.util.Optional;
import java.util.Stack;

/**
 * 支持4则运算带括号的计算器，2018/11/28蚂蚁上线测试做的
 * 看似简单，30分钟内却没有完整实现，所以，只能说加油，要多练
 * 当时的问题，只写了前序遍历怎么做，而且还写错了，尴尬了
 * 重新做一下，代码上还有一个问题，就是怎么截取数字和运算符
 * 碰到其他字符需要抛出异常，有时间也可以写自定义异常
 * 字符串转数字也要考虑异常处理
 *
 * 算法参考
 * http://www.cnblogs.com/chensongxian/p/7059802.html
 *
 * 另外 精度如何保证
 * 负数怎么算
 *
 * 2018/12/04 其实这么搞是复杂了，难怪之前30分钟写不出来
 *
 * 负数运算时可以的，怎么做？
 * 无非是考虑“-”开头的情况，内部的“-”都可以当做减号
 * 这样也不对，还有（-， ((-的情况，那怎么办，后面考虑
 * 还有4*(-8)这种情况怎么办？
 * @author wb-ywh474663
 * @version $Id: Calculator.java, v 0.1 2018年11月28日 14:18 wb-ywh474663 Exp $
 */
public class Calculator {

    /**
     * 字符串表达式(中序)转后序表示，怎么说呢，我比较喜欢后序，不过前序似乎计算更方便
     * @param expression
     * @return 表达式非法返回null
     */
    private static final HashMap<String, Integer> OPERATION_MAP = new HashMap<String, Integer>();

    static{
        OPERATION_MAP.put("-",1);
        OPERATION_MAP.put("+",1);
        OPERATION_MAP.put("*",2);
        OPERATION_MAP.put("/",2);
        OPERATION_MAP.put("(",3);
        OPERATION_MAP.put(")",4);
    }


    public Stack<String> changeMidToBack(String expression){
        Stack<String> backStack = new Stack<String>();
        Stack<String> temp = new Stack<String>();
        String[] array = expression.split("");
        Calculator calculator = new Calculator();
        for(int i = 0;i<array.length;){
            if(array[i].matches("^[0-9]")){
                String number = calculator.getNumber(i,array);
                backStack.add(number);
                i =i+number.length();
            }else{
                if(OPERATION_MAP.get(array[i]) == null){
                    return null;
                }
                //"("
                if(OPERATION_MAP.get(array[i]) == 3){
                    temp.push(array[i]);
                }else if(OPERATION_MAP.get(array[i]) == 4){
                    while(!temp.isEmpty() && OPERATION_MAP.get(temp.peek()) != 3){
                        backStack.push(temp.pop());
                    }
                    temp.pop();
                }else{
                    if(temp.isEmpty()){
                        temp.push(array[i]);
                    }else{
                        int tempTop = OPERATION_MAP.get(temp.peek());
                        if(tempTop == 3){
                            temp.push(array[i]);
                        }else{
                            int currentOperation = OPERATION_MAP.get(array[i]);
                            if(tempTop < currentOperation){
                                temp.push(array[i]);
                            }else{
                                while(!temp.isEmpty()&&OPERATION_MAP.get(temp.peek())!=3 && OPERATION_MAP.get(temp.peek())>=OPERATION_MAP.get(array[i])){
                                    backStack.add(temp.pop());
                                }
                                temp.push(array[i]);
                            }
                        }

                    }


                }
                i++;
            }
        }
        while(!temp.isEmpty()){
            backStack.push(temp.pop());
        }
        return backStack;
    }

    /**
     *
     * @param startIndex 搜索起点
     * @param array 搜索源字符串数组
     * @return
     */
    public String getNumber(int startIndex, String[] array){
            StringBuilder builder = new StringBuilder();
            while((startIndex < array.length)&&array[startIndex].matches("^[0-9]")){
                builder.append(array[startIndex]);
                startIndex++;
            }
            return builder.toString();
    }

    public Float calculate(String expression){
        Stack<String> backStack = changeMidToBack(expression);
        if(backStack != null){
            Stack<String> temp = new Stack<String>();
            while (backStack.size() > 1){
                //这是运算符
                if(OPERATION_MAP.get(backStack.peek()) != null){
                    temp.push(backStack.pop());
                }else{
                    //这是数字
                    String num1 = backStack.pop();
                    if(OPERATION_MAP.get(backStack.peek()) != null){
                        //这是运算符
                        temp.push(num1);
                    }else{
                        String num2 = backStack.pop();
                        String result = doOperation(num1,num2,temp.pop());
                        if(result != null){
                            backStack.push(result);
                            //temp有个回栈的过程
                            while(!temp.isEmpty()&&OPERATION_MAP.get(temp.peek()) == null){
                                backStack.push(temp.pop());
                            }
                        }else{
                            return null;
                        }
                    }
                }
            }
            return Float.valueOf(backStack.pop());
        }else {
            return null;
        }
    }

    private String doOperation(String num1,String num2, String operation){
        if(operation.equals("-")){
            return String.valueOf(Float.valueOf(num2) - Float.valueOf(num1));
        }else if(operation.equals("+")){
            return String.valueOf(Float.valueOf(num2) + Float.valueOf(num1));
        }else if(operation.equals("/")){
            return String.valueOf(Float.valueOf(num2) / Float.valueOf(num1));
        }else if(operation.equals("*")){
            return String.valueOf(Float.valueOf(num2) * Float.valueOf(num1));
        }else{
            return null;
        }
    }



    public static void main(String[] args){
            String test = "45-23+(9008/63+3)*12*(12+23)";
            Calculator calculator = new Calculator();
            Stack<String> result = calculator.changeMidToBack(test);
            while(!result.isEmpty()){
                System.out.print(result.pop());
            }
            System.out.println();
            Float calResult = calculator.calculate(test);
            System.out.println(calResult);

            test = "(56*(12-90)-200)*12";
            result = calculator.changeMidToBack(test);
            while(!result.isEmpty()){
                System.out.print(result.pop());
            }
            System.out.println();
            calResult = calculator.calculate(test);
            System.out.println(calResult);

        test = "500/(34*(99-23)+((12-23)*45)*(33+12*3))";
        result = calculator.changeMidToBack(test);
        while(!result.isEmpty()){
            System.out.print(result.pop());
        }
        System.out.println();
        calResult = calculator.calculate(test);
        System.out.println(calResult);
    }
}