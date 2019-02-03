package algorithm.String;

/**
 * 剑指Offer 全排列问题，不止字符串，数字也一样适用，很多问题都可以用全排列去解决
 * 比如如果是要求按照一定的要求摆放若干数字
 *
 * 例如八皇后
 */

public class FullPermutation {

    /**
     * 字符串全排列
     * 比如abc, 全排列为 abc,acb,bac,bca,cab,cba
     *
     * 这里暂时只考虑字符都不同的情况，
     *
     * 想一想如果字符可以相同的话，如何去重
     *
     * @param source
     */
    public static void fullPermutationString(String source){



    }

    /**
     * 扩展问题: 字符串所有组合
     * 比如abc ,所有组合为 a, b, c, ab, ac, bc, abc
     *
     * 注意ab ba 是同一种组合
     *
     * 也是暂时只考虑字符都不同的情况
     * @param source
     */
    public static void fullCombinationString(String source){


    }

    /**
     * 输入8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和都相等
     *
     * 也就是输入 数字 a1,a2,a3,a4,a5,a6,a7,a8  要求调整后的数字排列满足: a1+a2+a3+a4 == a5+a6+a7+a8,
     * a1+a3+a5+a7 == a2+a4+a6+a8 并且 a1+a2+a5+a6 == a3+a4+a7+a8
     *
     * 最为扩展是这个排列的要求其实是可以抽象出来的
     * @param source
     * @return
     */
    public static boolean findNumberCombinationWithRule(int[] source){

        return false;

    }

    /**
     * 八皇后问题， 经典问题，回溯，dp，放这里是因为这个思路有点不同，和上题类似
     * @return
     */
    public static int eightQueens(){
        return 0;
    }

}
