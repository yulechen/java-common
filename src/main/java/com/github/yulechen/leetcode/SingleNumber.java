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
     * 是第一题的变种，一些出现两次，有两个数字a，b不同且各出现一次。先做一趟xor假设结果为x，
     * 那么x是a，b亦或的结果，因为二者不同那么x中必然有一位是1，我们使用方法4得到这个1，
     * 是一个只包含一位1的掩码。然后做第二趟xor，这次使用掩码分组操作。就可以区分a和b。
     * 其余额元素也会分组，不过不影响结果，因为肯定是在某一组中出现两次
     *
     * 相同为0，不同为1
     * 0 ^0 = 0
     * 1^0  = 1
     * 1^1  =  0
     *
     *
     * 4.如何得到一个int的最右侧的第一个1？方法是与其相反数做&。因为相反数是取反加一，
     * 取反以后，第一个1右侧的0变为1，加一以后这些1变为0，相应的第一个1变回为1，
     * 比这个1高的位全是0，因为取反。最终就得到了一个只包含最右侧1的掩码，
     * 其余是0。这个方法是O1的。
     *
     */
    public int[] singleNumber2(int[] nums) {
        int[] res = new int[2];
        int n = 0;
        for(int i = 0 ; i < nums.length; i++){
            n ^= nums[i];
        }
        // n 0001000: 只有一个1位，其余位全是0
        n = n & ~(n - 1);
        for(int i = 0 ; i < nums.length; i++){
            // 这一位是1的分一组
            if((nums[i] & n) == n){ // & 掩码运算
                res[0] ^= nums[i];
            } else {
                // 不是1的分一组
                res[1] ^= nums[i];
            }
        }
        return res;

    }


    public int[] singleNumber3(int[] nums) {
        int[] res = new int[2];
        int n = 0;
        for(int i = 0 ; i < nums.length; i++){
            n ^= nums[i];
        }

        int k=1;
        while(n!=1){
            k=k<<1;
            n=n>>1;
        }
        for(int i = 0 ; i < nums.length; i++){
            // 这一位是1的分一组
            if((nums[i] & k) == k){ // & 掩码运算
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
        int[] ints = sn.singleNumber3(a);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
