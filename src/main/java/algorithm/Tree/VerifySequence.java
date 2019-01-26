package algorithm.Tree;


/**
 * 剑指Offer 面试题 33  二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果
 * 假设输入数组的任意两个数字都互不相同
 */
public class VerifySequence {

    /** 后序遍历 另外别忘了是二叉搜索书，其实之前做二叉树重构的一个问题知道，如果不是搜索树，光知道后序或者
     *  前序是没法恢复二叉树结构的
     */
    public static boolean verifySequenceOfBSTPostOrder(int[] sequence){

        if(sequence == null || sequence.length == 0){
            return false;
        }

        /**  后序遍历，root是数组最后一个值
         *   对于搜索树结构，左半部分比根小，右半部分比根大，以此为标准拆分左右子树 如果拆不出来，那就失败了
         *   所以实现上还是递归，即依次看左右子树是不是符合要求
         *   只有有一个递归不符合，递归就可以终止了，因为结果就是不符合
         */

        return verifySequenceOfBSTPostOrder(sequence,0,sequence.length-1);

    }

    private static boolean verifySequenceOfBSTPostOrder(int[] sequence,int start,int end) {
        /**  注意区分边界条件  可以先看最小情况，找出规律，比如{7，10，9}   */
        if(start == end){
            return true;
        }
        int root = sequence[end];
        int i,j;
        /** 找左半部分 */
        for(i = start;i<end; i++){
            /** 后序遍历，左右根，先找左子树  */
            if(sequence[i] > root){
               break;
            }
        }
        /** 找右半部分 */
        for(j=i;j<end;j++){
            if(sequence[j] < root){
                break;
            }
        }
        /** 如果一切正常  j == end-1  递归要区分只有左子树或者右子树的情况*/
        if(j == end){
            if(i-1 < start){
                return verifySequenceOfBSTPostOrder(sequence,start,end-1);
            }else if(i>end-1){
                return verifySequenceOfBSTPostOrder(sequence,start,i-1);
            }else{
                return verifySequenceOfBSTPostOrder(sequence,start,i-1)&&verifySequenceOfBSTPostOrder(sequence,i,end-1);
            }
        }else{
            return false;
        }

    }
    /**
     * 扩展: 如果给的是前序遍历序列呢？
     * @param sequence
     * @return
     */
    public static boolean verifySequencyOfBSTPreOrder(int[] sequence){
        /**
         * 思路类似，但是root在头，后面部分区分左右子树，根左右
         */
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return verifySequencyOfBSTPreOrder(sequence, 0, sequence.length-1);
    }

    private static boolean verifySequencyOfBSTPreOrder(int[] sequence, int start,int end){
        /**  注意区分边界条件  可以先看最小情况，找出规律，比如{10,8,16}   */
        if(start == end){
            return true;
        }
        int root = sequence[start];
        int i,j;
        for(i=start+1;i<=end;i++){
            if(sequence[i] > root){
                break;
            }
        }
        for(j=i;j<=end;j++){
            if(sequence[j] < root){
                break;
            }
        }
        if(j == end+1){
            if(i-1<(start+1)){
                return verifySequencyOfBSTPreOrder(sequence,i,end);
            }else if(i > end){
                return verifySequencyOfBSTPreOrder(sequence,start+1,i-1);
            }else{
                return verifySequencyOfBSTPreOrder(sequence,start+1,i-1)&&verifySequencyOfBSTPreOrder(sequence,i,end);
            }
        }else{
            return false;
        }

    }

    public static void main(String[] args){
        int[] testSequence = {1,3,2,9,8,5,18,14,15,10};
        boolean result = verifySequenceOfBSTPostOrder(testSequence);
        System.out.println(result);

        /**  这种情况差点漏掉 */
        int[] testSequence2 = {8,10};
        result = verifySequenceOfBSTPostOrder(testSequence2);
        System.out.println(result);

        /** 测试一下 verifySequencyOfBSTPreOrder*/
        int[] testSequencePreOrder1 = {10,18,16};
        int[] testSequencePreOrder2 = {10,8};
        int[] testSequencePreOrder3 = {10,16};
        int[] testSequencePreOrder4 = {10,18,4,5,9,16};
        result = verifySequencyOfBSTPreOrder(testSequencePreOrder1);
        System.out.println(result);
        result = verifySequencyOfBSTPreOrder(testSequencePreOrder2);
        System.out.println(result);
        result = verifySequencyOfBSTPreOrder(testSequencePreOrder3);
        System.out.println(result);
        result = verifySequencyOfBSTPreOrder(testSequencePreOrder4);
        System.out.println(result);

    }

}
