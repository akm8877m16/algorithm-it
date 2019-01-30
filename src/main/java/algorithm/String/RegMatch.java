/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.String;

import java.util.Arrays;

/**
 * 正则表达式匹配
 * 实现一个函数用来匹配包含“.”和"*"的正则表达式，“.”表示任意一个字符，“*”表示它
 * 前面的字符可以出现任意次(含0次)，此外，匹配是整个字符串，不考虑匹配局部
 *
 * 这个问题解决思路上没有特别之处，关键是对比是能够把各种情况都考虑全
 *
 *
 * 1227 这个问题编了两天，似乎想复杂了，正则匹配肯定比这个还复杂，不也一样
 *
 * 思路上的一个漏洞：其实多种情况，利用递归穷举就可以了，不符合就返回false而已，不用
 * 每种情况都if else判断情况，只会把自己搞乱
 *
 * 2019/01/30 思路复盘
 * 正则表达式，体现的思路是回溯的思想
 * @author wb-ywh474663
 * @version $Id: RegMatch.java, v 0.1 2018年12月25日 10:20 wb-ywh474663 Exp $
 */
public class RegMatch {
        //考虑性能，应该用char[],String有点过
        public static boolean regMatch(String[] target,int targetIndex, String[] matcher,int matcherIndex){
            if(target == null || matcher == null){
                return false;
            }
            /**
             * 正则表达式先到头，那么匹配失败
             */
            if(targetIndex < target.length && matcherIndex == matcher.length){
                return false;
            }
            /**
             * 全都匹配到头，那么匹配成功
             */
            if(targetIndex == target.length && matcherIndex == matcher.length){
                return true;
            }
            if((matcherIndex+1)<matcher.length &&matcher[matcherIndex+1].equals("*")){
                /**
                 * 分三种情况, "."的情况也要考虑到
                 * 忽略
                 * 移动一个
                 * matcher 不用，target移动一格
                 * 同时判断，有一个是true就是匹配的
                 */
                if(targetIndex<target.length&&(target[targetIndex].equals(matcher[matcherIndex]) || matcher[matcherIndex].equals("."))){
                    return regMatch(target,targetIndex+1, matcher,matcherIndex+2)||
                            regMatch(target,targetIndex+1, matcher,matcherIndex);
                }else {
                    return regMatch(target,targetIndex, matcher,matcherIndex+2);
                }
            }else{
                if(targetIndex<target.length&& target[targetIndex].equals(matcher[matcherIndex])){
                    return regMatch(target,targetIndex+1, matcher,matcherIndex+1);
                }else {
                    return false;
                }
            }



        }

        public static void main(String[] args){
                String match1 = "ab*93";
                String target1 = "a93";
                boolean result1 = regMatch(target1.split(""),0,match1.split(""),0);
                System.out.println(result1);
        }

}