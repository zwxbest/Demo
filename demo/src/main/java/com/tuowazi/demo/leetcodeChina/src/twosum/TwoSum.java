package com.tuowazi.demo.leetcodeChina.src.twosum;

import java.util.Arrays;

/**
 * Created by zwxbest on 2018/3/5.
 */
public class TwoSum {


    public  void main(String[] args) {
        Solution solution=new Solution();
        Arrays.stream(solution.twoSum(new int[]{2, 7, 11, 15}, 9)).forEach(System.out::print);
    }

}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    return new int[]{i,j};
                }
            }
        }
        return null;

    }
}
