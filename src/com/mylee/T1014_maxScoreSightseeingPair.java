package com.mylee;

public class T1014_maxScoreSightseeingPair {

    public static void main(String[] args){
        int[] A = {8,1,5,3,6};
        System.out.println(maxScoreSightseeingPair(A));
    }

    public static int maxScoreSightseeingPair(int[] A) {
        int ans = 0, mx = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);
            // ±ß±éÀú±ßÎ¬»¤
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }

}
