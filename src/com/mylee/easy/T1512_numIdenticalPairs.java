package com.mylee.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 。
 *
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 *
 * 返回好数对的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T1512_numIdenticalPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        int count = numIdenticalPairs2(nums);
        System.out.println(count);
    }
    //方法一：暴力统计
    //时间复杂度：O(n^2)
    //空间复杂度：O(1)
    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    System.out.println(nums[i]+"  "+nums[j]);
                    count++;
                }
            }
        }
        return count;
    }

    //方法二：组合计数
    //思路与算法
    //
    //用哈希表统计每个数在序列中出现的次数，假设数字 kk 在序列中出现的次数为 vv，
    // 那么满足题目中所说的
    // {\rm nums}[i] = {\rm nums}[j] = k(i < j)nums[i]=nums[j]=k(i<j) 的 (i, j)(i,j) 的数量就是 \frac{v(v - 1)}{2}
    // ，即 kk 这个数值对答案的贡献是 \frac{v(v - 1)}{2}
    // 。我们只需要把所有数值的贡献相加，即可得到答案。

    //时间复杂度：O(n)
    //空间复杂度：O(n)即哈希表使用到的辅助空间的空间代价。
    public static int numIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        //通过map计数
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        //通过map里的重复值确定多少个两两相配
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int v = entry.getValue();
            ans += v * (v - 1) / 2;
        }
        return ans;
    }
}
