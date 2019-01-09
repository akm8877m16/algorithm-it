package algorithm.Tree;


import sun.reflect.generics.tree.Tree;

public class TreeOperations {

    /**
     * 剑指Offer 面试题 26: 输入两颗二叉数A和B， 判断B是不是A的子结构
     *
     * 解决思路是:递归,而且这里要用两个递归，理解为什么
     * 终止条件是任意一个数判断到叶子节点
     *
     * 此外注意一个细节，这个用的TreeNode存的值是int类型，如果是double呢？不能直接做值比较的
     *
     * @param pRoot1
     * @param pRoot2
     * @return
     */
    public static boolean hasSubtree(TreeNode pRoot1, TreeNode pRoot2){

        if(pRoot1 == null && pRoot2 != null){
            return false;
        }
        if(pRoot1 != null && pRoot2 == null){
            return true;
        }
        if(pRoot1 == null && pRoot2 == null){
            return true;
        }
        boolean result = false;
        if(pRoot1.val == pRoot2.val){
            /** 根节点相同，要比较左右子树 */
            result = checkIfHasSubtree(pRoot1,pRoot2);
        }
        if(!result){
            result = hasSubtree(pRoot1.left,pRoot2);
        }
        if(!result){
            result = hasSubtree(pRoot1.right,pRoot2);
        }

        return result;
    }

    private static boolean checkIfHasSubtree(TreeNode pRoot1,TreeNode pRoot2){
        if(pRoot1 == null && pRoot2 != null){
            return false;
        }
        if(pRoot1 != null && pRoot2 == null){
            return true;
        }
        if(pRoot1 == null && pRoot2 == null){
            return true;
        }
        if(pRoot1.val != pRoot2.val){
            return false;
        }
        return checkIfHasSubtree(pRoot1.left,pRoot2.left)&&checkIfHasSubtree(pRoot1.right,pRoot2.right);
    }

    public static void main(String[] args){

        TreeNode pHead = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        TreeNode p8 = new TreeNode(8);
        TreeNode p9 = new TreeNode(9);
        TreeNode p7 = new TreeNode(7);

        pHead.left = p2;
        pHead.right = p3;
        p2.left = p5;
        p2.right = p6;
        p3.left = p8;
        p3.right = p9;
        p5.left = p7;

        TreeNode subTreeHead1 = new TreeNode(3);
        TreeNode subTree8 = new TreeNode(85);
        TreeNode subTree9 = new TreeNode(9);
        subTreeHead1.left = subTree8;
        subTreeHead1.right = subTree9;

        TreeNode subTreeHead2 = new TreeNode(3);

        TreeNode subTreeHead3 = new TreeNode(2);
        TreeNode subTree35 = new TreeNode(5);
        TreeNode subTree37 = new TreeNode(17);
        subTreeHead3.left = subTree35;
        subTree35.left = subTree37;


        boolean result = hasSubtree(pHead,p2);
        System.out.println(result);

        boolean result2 = hasSubtree(pHead,subTreeHead1);
        System.out.println(result2);

        boolean result3 = hasSubtree(pHead,subTreeHead2);
        System.out.println(result3);

        boolean result4 = hasSubtree(pHead,subTreeHead3);
        System.out.println(result4);

    }


}
