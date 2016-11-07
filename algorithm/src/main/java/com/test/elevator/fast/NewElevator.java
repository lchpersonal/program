package com.test.elevator.fast;

/**
 * 优化电梯算法的效率
 * <p>
 * Created by chengli on 2016/11/7.
 */
public class NewElevator {
    private static int[] a = {0, 1, 2, 3, 4};
    //private static int[] a = {4, 0, 0, 0, 0, 1, 0, 0, 0, 0, 8};

    public static void main(String[] args) {
        a[0] = 0;//第一层的人不需要坐电梯
        int maxRotateNum = a.length;
        int[] result = new int[maxRotateNum];
        for (int i = 0; i < maxRotateNum; i++) {
            int leftW = leftWeight(i + 1);
            int rightW = rightWeight(i + 1);
            result[i] = Math.abs(leftW - rightW);
        }
        //TODO 找出result数组中值最小的元素，下标i+1即为最佳停止楼层数，注意最佳楼层可能不止一个。
        //以下只做简单输出
        for (int i = 0; i < result.length; i++) {
            System.out.println(String.format("楼层: %s , 权重差: %s", i + 1, result[i]));
        }
    }

    /**
     * @param rootIndex 电梯停止层数
     * @return 子树权重
     */
    private static int leftWeight(int rootIndex) {
        int weight = 0;
        for (int i = 0; i < rootIndex - 1; i++) {
            weight += a[i] * (rootIndex - i - 1);
        }
        return weight;
    }

    private static int rightWeight(int rootIndex) {
        int weight = 0;
        for (int i = rootIndex; i < a.length; i++) {
            weight += a[i] * (i - rootIndex + 1);
        }
        return weight;
    }
}
