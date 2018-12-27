/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.String;

/**
 * 正则表达式匹配
 * 实现一个函数用来匹配包含“.”和"*"的正则表达式，“.”表示任意一个字符，“*”表示它
 * 前面的字符可以出现任意次(含0次)，此外，匹配是整个字符串，不考虑匹配局部
 *
 * 这个问题解决思路上没有特别之处，关键是对比是能够把各种情况都考虑全
 * @author wb-ywh474663
 * @version $Id: RegMatch.java, v 0.1 2018年12月25日 10:20 wb-ywh474663 Exp $
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
                            /**这里的逻辑会相对复杂一点,要判断什么时候可以matcherRegStart
                             * 位置
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