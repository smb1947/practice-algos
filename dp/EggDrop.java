import java.util.*;
class Solution {
//	   https://leetcode.com/problems/super-egg-drop/
//     https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
//     https://www.youtube.com/watch?v=3hcaVyX00_4&ab_channel=TusharRoy-CodingMadeSimple
    public int superEggDrop(int K, int N) {
        int minval=Integer.MAX_VALUE;
        int[][] ar = new int[K+1][N+1];
        
        // zero eggs require zero tests
        // zero floors require zero tests
        // one egg requires k tests
        for(int j=1;j<=N;j++)
            ar[1][j]=j;
        
        // one floor requires one test
        for(int i=1;i<=K;i++)
            ar[i][1]=1;
        
        // System.out.println(Arrays.toString(ar));
        for(int i=2;i<=K;i++){
            // start from 2 ?
            for(int j=2;j<=N;j++){
                minval=Integer.MAX_VALUE;
                for(int x=1;x<=j;x++){
                    //  not => ar[i-1][x-1], ar[i][N-x]
                    int p=1+Math.max(ar[i-1][x-1], ar[i][j-x]);
                    
                    if(p<minval)
                        minval=p;
                }
                ar[i][j]=minval;
            }
            // System.out.println(Arrays.toString(ar[i]));
        }
        return ar[K][N];
    }
}