/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.String;

import java.util.Arrays;

/**
 * ������ʽƥ��
 * ʵ��һ����������ƥ�������.����"*"��������ʽ����.����ʾ����һ���ַ�����*����ʾ��
 * ǰ����ַ����Գ��������(��0��)�����⣬ƥ���������ַ�����������ƥ��ֲ�
 *
 * ���������˼·��û���ر�֮�����ؼ��ǶԱ����ܹ��Ѹ������������ȫ
 *
 *
 * 1227 �������������죬�ƺ��븴���ˣ�����ƥ��϶�����������ӣ���Ҳһ��
 *
 * ˼·�ϵ�һ��©������ʵ������������õݹ���پͿ����ˣ������Ͼͷ���false���ѣ�����
 * ÿ�������if else�ж������ֻ����Լ�����
 *
 * 2019/01/30 ˼·����
 * ������ʽ�����ֵ�˼·�ǻ��ݵ�˼��
 * @author wb-ywh474663
 * @version $Id: RegMatch.java, v 0.1 2018��12��25�� 10:20 wb-ywh474663 Exp $
 */
public class RegMatch {
        //�������ܣ�Ӧ����char[],String�е��
        public static boolean regMatch(String[] target,int targetIndex, String[] matcher,int matcherIndex){
            if(target == null || matcher == null){
                return false;
            }
            /**
             * ������ʽ�ȵ�ͷ����ôƥ��ʧ��
             */
            if(targetIndex < target.length && matcherIndex == matcher.length){
                return false;
            }
            /**
             * ȫ��ƥ�䵽ͷ����ôƥ��ɹ�
             */
            if(targetIndex == target.length && matcherIndex == matcher.length){
                return true;
            }
            if((matcherIndex+1)<matcher.length &&matcher[matcherIndex+1].equals("*")){
                /**
                 * ���������, "."�����ҲҪ���ǵ�
                 * ����
                 * �ƶ�һ��
                 * matcher ���ã�target�ƶ�һ��
                 * ͬʱ�жϣ���һ����true����ƥ���
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