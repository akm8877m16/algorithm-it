package others;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OtherTests {

    //评测题目: 面试题,不要慌，搞明白意思
    /**
     (30分钟内完成)有一个字符串它的构成是词+空格的组合，如“北京 杭州 杭州 北京”， 要求输入一个匹配模式（简单的以字符来写），
     * 比如 aabb, 来判断该字符串是否符合该模式， 举个例子：
     pattern = "abba", str="北京 杭州 杭州 北京" 返回 true ab 北京杭州
     pattern = "aabb", str="北京 杭州 杭州 北京" 返回 false
     pattern = "baab", str="北京 杭州 杭州 北京" 返回 true
     */

    public boolean regex(String pattern , String target){
        // 参数合法性校验
        if(target == null){
            throw  new RuntimeException("target is null");
        }

        if(pattern == null){
            throw new RuntimeException("pattern is null");
        }

        // 使用空格分割
        String space = " ";
        String[] objs = target.split(space);
        // 将排重后数组转成list结构操作
        List<String> targetList = Arrays.stream(objs).distinct().collect(Collectors.toList());
        // 使用pattern进行匹配
        char[] patternChars = pattern.toCharArray();
        // 将pattern切成单独的字符
        String[] strs = new String[patternChars.length];
        int i=0;
        for(char pc : patternChars){
            strs[i] = String.valueOf(patternChars[i]);
            i++;
        }

        // 顺序匹配
        List<String> patternList = Arrays.stream(strs).distinct().collect(Collectors.toList());
        // 如上先去重,判断长度是否一致
        if(targetList.size() != patternList.size()){
            return false;
        }

        // 变量替换
        int size = patternList.size();
        for(int x = 0;x < size ; x++){
            // 使用pattern中的变量替换实际元素，如a替换北京
            target = target.replace(targetList.get(x),patternList.get(x));
        }

        // 将target中的“ ”
        if(!pattern.equals(target.replaceAll(space,""))){
            return false;
        }

        return true;
    }

    public static void main(String[] args){

        String pattern = "aabb";
        String target = "北京 杭州 杭州 北京";
        System.out.println(new OtherTests().regex(pattern,target));


    }
}
