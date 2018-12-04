/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm;

import java.util.HashMap;
import java.util.Optional;
import java.util.Stack;

/**
 * ֧��4����������ŵļ�������2018/11/28�������߲�������
 * ���Ƽ򵥣�30������ȴû������ʵ�֣����ԣ�ֻ��˵���ͣ�Ҫ����
 * ��ʱ�����⣬ֻд��ǰ�������ô�������һ�д���ˣ�������
 * ������һ�£������ϻ���һ�����⣬������ô��ȡ���ֺ������
 * ���������ַ���Ҫ�׳��쳣����ʱ��Ҳ����д�Զ����쳣
 * �ַ���ת����ҲҪ�����쳣����
 *
 * �㷨�ο�
 * http://www.cnblogs.com/chensongxian/p/7059802.html
 *
 * ���� ������α�֤
 * ������ô��
 *
 * 2018/12/04 ��ʵ��ô���Ǹ����ˣ��ѹ�֮ǰ30����д������
 *
 * ��������ʱ���Եģ���ô����
 * �޷��ǿ��ǡ�-����ͷ��������ڲ��ġ�-�������Ե�������
 * ����Ҳ���ԣ����У�-�� ((-�����������ô�죬���濼��
 * ����4*(-8)���������ô�죿
 * @author wb-ywh474663
 * @version $Id: Calculator.java, v 0.1 2018��11��28�� 14:18 wb-ywh474663 Exp $
 */
public class Calculator {

    /**
     * �ַ������ʽ(����)ת�����ʾ����ô˵�أ��ұȽ�ϲ�����򣬲���ǰ���ƺ����������
     * @param expression
     * @return ���ʽ�Ƿ�����null
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
     * @param startIndex �������
     * @param array ����Դ�ַ�������
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
                //���������
                if(OPERATION_MAP.get(backStack.peek()) != null){
                    temp.push(backStack.pop());
                }else{
                    //��������
                    String num1 = backStack.pop();
                    if(OPERATION_MAP.get(backStack.peek()) != null){
                        //���������
                        temp.push(num1);
                    }else{
                        String num2 = backStack.pop();
                        String result = doOperation(num1,num2,temp.pop());
                        if(result != null){
                            backStack.push(result);
                            //temp�и���ջ�Ĺ���
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