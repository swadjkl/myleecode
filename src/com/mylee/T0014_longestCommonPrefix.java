package com.mylee;

public class T0014_longestCommonPrefix {

    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        String str = longestCommonPrefix(strs);
        System.out.println(str);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
            return "";
        for(int i=1;i<strs.length;i++){//������ȡÿ��Ԫ�صĹ���ǰ׺������һ��Ԫ����Ϊ���գ�ѭ������һ��Ԫ�س��ȴӺ�����һ���ж�
            while(strs[i].indexOf(strs[0])!=0){
                strs[0]=strs[0].substring(0, strs[0].length()-1);
                if(strs[0].isEmpty())
                    return "";
            }
        }
        return strs[0];
    }
}
