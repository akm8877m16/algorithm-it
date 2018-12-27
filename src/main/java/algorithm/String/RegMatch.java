/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.String;

/**
 * ������ʽƥ��
 * ʵ��һ����������ƥ�������.����"*"��������ʽ����.����ʾ����һ���ַ�����*����ʾ��
 * ǰ����ַ����Գ��������(��0��)�����⣬ƥ���������ַ�����������ƥ��ֲ�
 *
 * ���������˼·��û���ر�֮�����ؼ��ǶԱ����ܹ��Ѹ������������ȫ
 * @author wb-ywh474663
 * @version $Id: RegMatch.java, v 0.1 2018��12��25�� 10:20 wb-ywh474663 Exp $
 */
public class RegMatch {

        public static boolean regMatch(String string ,String matcher){
            if(string == null || matcher == null){
                return false;
            }
            if(string.length() == 0 || matcher.length() == 0){
                return false;
            }
            String[] target = string.split("");
            String[] matcherReg = string.split("");
            int targetLength = target.length;
            int matcherRegLength = matcherReg.length;
            int targetStart = 0;
            int matcherRegStart = 0;
            int preMatcherPosition = 0;

            while(targetStart <=targetLength-1 && matcherRegStart<=matcherRegLength-1 ){
                if(target[targetStart].equals(matcherReg[matcherRegStart])){
                     targetStart++;
                     matcherRegStart++;
                }else{
                    if(matcherReg[matcherRegStart].equals(".")){
                        targetStart++;
                        matcherRegStart++;
                    }else if(matcherReg[matcherRegStart].equals("*")){
                        preMatcherPosition = targetStart-1;
                        if(preMatcherPosition<0) {
                            return false;
                        }else{
                            /**������߼�����Ը���һ��,Ҫ�ж�ʲôʱ�����matcherRegStart
                             * λ��
                             * */


                        }
                    }
                }


            }


        }

        public static void main(String[] args){
            int target = 2;
            int pre = 0;
            pre = --target;
            System.out.println(pre);
            System.out.println(target);
        }

}