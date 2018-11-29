package com.github.yulechen.leetcode;

import java.util.*;

public class SingleNumber {
    /**
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
     * 找出只出现一次的那两个元素
     * #你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现#
     *  输入: [1,2,1,3,2,5]
     *  输出: [3,5]
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {

        HashMap<Integer,Integer> map =new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if(count==null)
                map.put(nums[i],1);
            else
                map.remove(nums[i]);

        }
        Iterator<Integer> iterator = map.keySet().iterator();
        int[] a =new int[map.size()];
        for (int i = 0; i < a.length; i++) {
            a[i]=iterator.next();
        }
        return a;
    }


    public void singleNumber1(int[] nums) {
        //其中恰好有只有一个个元素只出现一次，其他都出现两次
        // [1,2,1,3,2,5],[3]
        int res= nums[0];
        for (int i = 1; i < nums.length; i++) {
            res^=nums[i];
            System.out.println(res);
        }
      //  System.out.println(res);

    }

    /**
     *
     * 异或+分组
     * 相同为0，不同为1
     * 0 ^0 = 0
     * 1^0  = 1
     * 1^1  =  0
     */
    public int[] singleNumber2(int[] nums) {
        int[] res = new int[2];
        int n = 0;
        for(int i = 0 ; i < nums.length; i++){
            n ^= nums[i];
        }
        // 找出最右边第一个1
        n = n & ~(n - 1);
        for(int i = 0 ; i < nums.length; i++){
            // 这一位是1的分一组
            if((nums[i] & n) == n){
                res[0] ^= nums[i];
            } else {
                // 不是1的分一组
                res[1] ^= nums[i];
            }
        }
        return res;

    }



    public static void main(String[] args) {
        SingleNumber sn =new SingleNumber();
        int[] a ={1,2,3,1,5,2};
        int[] ints = sn.singleNumber2(a);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
