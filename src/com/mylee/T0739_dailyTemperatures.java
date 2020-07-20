package com.mylee;

/*
*
* 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用?0 来代替。

    例如，给定一个列表?temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是?[1, 1, 4, 2, 1, 1, 0, 0]。

    提示：气温 列表长度的范围是?[1, 30000]。每个气温的值的均为华氏度，都是在?[30, 100]?范围内的整数。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/daily-temperatures
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

import java.util.Stack;

public class T0739_dailyTemperatures {
    public static void main(String [] Args){

        int[] T = {75,78,43,46,50,44,60,80,100};//定义一个温度数组

        int[] result = dailyTemperatures(T);
        for(int i:result){
            System.out.print(i+ " ");
        }
        System.out.println();
        int[] result2 = dailyTemperatures2(T);
        for(int i:result2){
            System.out.print(i+ " ");
        }
    }

    /**
     * 常规正序
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {

        // 存储计算结果
        int [] result =new int[T.length];

        for(int i=0;i<T.length;i++){
            int temp = T[i];     // 当天温度
            int days =0;        // 存储需要几天才会超过当天温度
            int j;
            for(j=i+1;j<T.length;j++){
                int tempJ = T[j];   // 当天过后 第 j 天的气温
                if(temp>=tempJ){
                    days++;
                }else{
                    days++;
                    break;
                }
            }

            if(j==T.length){     // 这种情况是当天的温度，是近几天的最高气温
                result[i]=0;
            }else{
                result[i]=days;
            }
        }
        return result;

    }

    /**
     * //找出数组中大于当前元素的第一个元素，到当前元素的距离
     * //递减栈，当前元素与栈中元素比较，小则入栈，大则出栈并将二者之间的下标差值为出栈元素的结果值，并继续比较下一个栈顶元素
     * //如果栈为空，直接入栈(表示前面元素都找到了比自己大的值)
     * @param T
     * @return
     */
    public static int[] dailyTemperatures2(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i = 0; i < T.length; ++i){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }
}
