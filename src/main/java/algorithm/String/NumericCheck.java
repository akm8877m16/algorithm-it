package algorithm.String;


/**
 * 判断一个字符串是否是数字，包括如下情况：
 * 0.123
 * .123
 * 123.2e123
 * 45E12
 * 45E-90
 * -45E-9
 * 其他诸如:
 * 1a.23
 * 2ok2
 * .12d4
 * 45.3e-5.6
 * 都是非法的,也就是 "." 和 "e/E"最多出现一次
 *
 * 所以扫数字，最后扫完了应该到字符串尾了。
 *
 * 目前的写法可以，但不优雅啊，远没有答案的C版本优雅
 */
public class NumericCheck {

    public static boolean isNumeric(String str){
        /**
         * 简化思路：模块化判断过程
         * 需要两个子函数：
         * scanInterger
         * scanUnsignedInteger
         */
        int scanResult = scanInteger(str,0);
        if(scanResult != str.length()){
            if(str.charAt(scanResult) == '.'){
                scanResult++;
                if(scanResult != str.length()){
                    scanResult = scanUnsignedInteger(str,scanResult);
                    if(scanResult != str.length()){
                        if(str.charAt(scanResult) == 'e'||str.charAt(scanResult) == 'E'){
                            scanResult++;
                            if(scanResult != str.length()){
                                scanResult = scanInteger(str,scanResult);
                                if(scanResult != str.length()){
                                    return false;
                                }
                                return true;
                            }
                            return false;
                        }else{
                            if(scanResult != str.length()){
                                return false;
                            }
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            }else if(str.charAt(scanResult) == 'e'||str.charAt(scanResult) == 'E'){
                scanResult++;
                if(scanResult != str.length()){
                    scanResult = scanInteger(str,scanResult);
                    if(scanResult != str.length()){
                        return false;
                    }
                    return true;

                }
                return false;

            }
            return false;
        }
        return true;
    }

    /**
     * 思路是：如果是正数或者负数，返回的值对应的
     * 应该是"."或者"e"或者"E"
     * @param str
     * @return
     */
    private static int scanInteger(String str,int startIndex){
        int i = startIndex;
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            i++;
            return scanUnsignedInteger(str,i);
        }else{
            return scanUnsignedInteger(str,i);
        }
    }

    /**
     *
     */
    private static int scanUnsignedInteger(String str,int startIndex){
        int i = startIndex;
        for(;i<str.length();i++){
            if(str.charAt(i)>='0' && str.charAt(i) <='9'){
                continue;
            }else{
                break;
            }
        }
        return i;
    }

    public static void main(String[] args){
        String testStr1 = "12e9";
        String testStr2 = "1.2e9";
        String testStr3 = "-11.32e-9";
        String testStr4 = "1.22e-90";
        String testStr5 = "1.2e2e+90";
        String testStr6 = "1.2e";
        String testStr7 = "1.2.4";
        String testStr8 = "-+1.24";
        String testStr9 = "1.24E3.4";
        String testStr10 = "01.24";
        boolean result1 = isNumeric(testStr1);
        boolean result2 = isNumeric(testStr2);
        boolean result3 = isNumeric(testStr3);
        boolean result4 = isNumeric(testStr4);
        boolean result5 = isNumeric(testStr5);
        boolean result6 = isNumeric(testStr6);
        boolean result7 = isNumeric(testStr7);
        boolean result8 = isNumeric(testStr8);
        boolean result9 = isNumeric(testStr9);
        boolean result10 = isNumeric(testStr10);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);
        System.out.println(result10);
    }

}
