package com.mylee;

/*
*
* �����ÿ�� ���� �б���������һ���б���Ӧλ�õ����Ϊ��Ҫ��۲⵽���ߵ����£�������Ҫ�ȴ��������������������֮�󶼲������ߣ����ڸ�λ����?0 �����档

    ���磬����һ���б�?temperatures = [73, 74, 75, 71, 69, 72, 76, 73]��������Ӧ����?[1, 1, 4, 2, 1, 1, 0, 0]��

    ��ʾ������ �б��ȵķ�Χ��?[1, 30000]��ÿ�����µ�ֵ�ľ�Ϊ���϶ȣ�������?[30, 100]?��Χ�ڵ�������

    ��Դ�����ۣ�LeetCode��
    ���ӣ�https://leetcode-cn.com/problems/daily-temperatures
    ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
* */

import java.util.Stack;

public class T0739_dailyTemperatures {
    public static void main(String [] Args){

        int[] T = {75,78,43,46,50,44,60,80,100};//����һ���¶�����

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
     * ��������
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {

        // �洢������
        int [] result =new int[T.length];

        for(int i=0;i<T.length;i++){
            int temp = T[i];     // �����¶�
            int days =0;        // �洢��Ҫ����Żᳬ�������¶�
            int j;
            for(j=i+1;j<T.length;j++){
                int tempJ = T[j];   // ������� �� j �������
                if(temp>=tempJ){
                    days++;
                }else{
                    days++;
                    break;
                }
            }

            if(j==T.length){     // ��������ǵ�����¶ȣ��ǽ�������������
                result[i]=0;
            }else{
                result[i]=days;
            }
        }
        return result;

    }

    /**
     * //�ҳ������д��ڵ�ǰԪ�صĵ�һ��Ԫ�أ�����ǰԪ�صľ���
     * //�ݼ�ջ����ǰԪ����ջ��Ԫ�رȽϣ�С����ջ�������ջ��������֮����±��ֵΪ��ջԪ�صĽ��ֵ���������Ƚ���һ��ջ��Ԫ��
     * //���ջΪ�գ�ֱ����ջ(��ʾǰ��Ԫ�ض��ҵ��˱��Լ����ֵ)
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
