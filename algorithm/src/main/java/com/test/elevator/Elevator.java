package com.test.elevator;

/**
 * 高志大厦因等电梯人数太多，现规定电梯上升只能停一层，大家下电梯再各个步行到自己楼层，求停哪一层所有人步行层数总和最少。
 * input:
 * int[] floorPersonCount = [ 0, 0, 2, 5, 3, 0 ];    //各楼层工作的人数统计数组
 * ouput:
 * int bestFloor;                                      //求出停留在哪一层，大家走楼梯总数最少
 * <p>
 * <p>
 * Created by chengli on 2016/11/7.
 */
public class Elevator {

    public static void main(String[] args) {
        //int[] a = {0, 1, 2, 3, 4};
        int[] a = {4, 0, 0, 0, 0, 1, 0, 0, 0, 0, 8};
        EleTree eleTree = new EleTree(a);
        System.out.println(eleTree.getAvgPoint());
    }

}
