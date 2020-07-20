package com.mylee.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���������� nums ��
 *
 * ���һ������ (i,j) ���� nums[i] == nums[j] �� i < j ���Ϳ�����Ϊ����һ�� ������ ��
 *
 * ���غ����Ե���Ŀ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-good-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class T1512_numIdenticalPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        int count = numIdenticalPairs2(nums);
        System.out.println(count);
    }
    //����һ������ͳ��
    //ʱ�临�Ӷȣ�O(n^2)
    //�ռ临�Ӷȣ�O(1)
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

    //����������ϼ���
    //˼·���㷨
    //
    //�ù�ϣ��ͳ��ÿ�����������г��ֵĴ������������� kk �������г��ֵĴ���Ϊ vv��
    // ��ô������Ŀ����˵��
    // {\rm nums}[i] = {\rm nums}[j] = k(i < j)nums[i]=nums[j]=k(i<j) �� (i, j)(i,j) ���������� \frac{v(v - 1)}{2}
    // ���� kk �����ֵ�Դ𰸵Ĺ����� \frac{v(v - 1)}{2}
    // ������ֻ��Ҫ��������ֵ�Ĺ�����ӣ����ɵõ��𰸡�

    //ʱ�临�Ӷȣ�O(n)
    //�ռ临�Ӷȣ�O(n)����ϣ��ʹ�õ��ĸ����ռ�Ŀռ���ۡ�
    public static int numIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        //ͨ��map����
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        //ͨ��map����ظ�ֵȷ�����ٸ���������
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int v = entry.getValue();
            ans += v * (v - 1) / 2;
        }
        return ans;
    }
}
