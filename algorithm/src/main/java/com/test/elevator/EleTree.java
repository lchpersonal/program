package com.test.elevator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengli on 2016/11/7.
 */
public class EleTree {

    private EleTreeNode root;
    private int rotateCount = 0;
    private int nodeCount;

    public EleTree(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("参数为空");
        }
        nodeCount = arr.length;
        //第一层的人不需要坐电梯，全部直接设置为0
        root = new EleTreeNode(0, 0);
        EleTreeNode pre_left = root;
        for (int i = 1; i < arr.length; i++) {
            EleTreeNode temp = new EleTreeNode(i, arr[i]);
            pre_left.setLeft(temp);
            temp.setRight(pre_left);
            pre_left = pre_left.getLeft();
        }
    }


    private int preWeight = Integer.MAX_VALUE;

    public int getAvgPoint() {
        this.calAll();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) < preWeight) {
                preWeight = result.get(i);
            } else {
                return i;
            }
        }
        return 0;
    }


    private List<Integer> result = new ArrayList(nodeCount);

    private void calAll() {
        int diff = getLeftRightDiff();
        result.add(diff);
        for (int i = 1; i < nodeCount; i++) {
            this.rotateR();
            result.add(getLeftRightDiff());
        }
    }

    //旋转
    private void rotateR() {
        this.rotateCount++;
        root = root.getLeft();
    }

    private int getLeftWeigth() {
        int leftWeigth = 0;
        EleTreeNode node = root;
        while ((node = node.getLeft()) != null) {
            leftWeigth += (node.getDeep() - this.rotateCount) * node.getPeople();
        }
        return leftWeigth;
    }

    private int getRightWeight() {
        int rightWeight = 0;
        EleTreeNode node = root;
        while ((node = node.getRight()) != null) {
            rightWeight += Math.abs(node.getDeep() - this.rotateCount) * node.getPeople();
        }
        return rightWeight;
    }

    private int getLeftRightDiff() {
        int leftWeight = this.getLeftWeigth();
        int rightWeight = this.getRightWeight();
        int weightDiff = Math.abs(leftWeight - rightWeight);
        System.out.println(String.format("leftWeight:%s , rightWeight:%s , diff:%s", leftWeight, rightWeight, weightDiff));
        return weightDiff;
    }
}
