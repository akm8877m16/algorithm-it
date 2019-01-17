package algorithm.DP;

/**
 * 寻找一个二维点集合中，距离最近的点（可以有多个）
 *
 * 思路是分治，但怎么实现呢？
 *
 * 拆分的难点在于，分成两块以后，如何考虑跨区域的两个点距离最小的情况
 * 这个优化的点比较烧脑，但的确是可以分析出来的，注意
 *
 */
public class NearestPoints {

    public static void findNearestPoints(Point[] arrays){

        return;

    }


    public static class Point{

        int x = 0;
        int y = 0;

        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args){


    }

}
