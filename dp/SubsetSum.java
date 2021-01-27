// https://practice.geeksforgeeks.org/problems/subset-sum-problem/0
public class SubsetSum {
    public int solve(ArrayList<Integer> ar, int sum) {
        int n= ar.size();
        boolean[][] dp= new boolean[n+1][sum+1];
        
        // cosidering zero elements can't get any sum
        Arrays.fill(dp[0], false);
		// but you can get zero from zero subset..
		// when sum = 1 and first element is also one
		dp[0][0]= true;
        // System.out.println(Arrays.toString(dp[0]));
        for(int i=1;i<=n;i++){
            // can get sum of zero from any subset.
            dp[i][0]=true;
            for(int j=1;j<=sum;j++){
                boolean x,y;
                x=false;
                y=false;
                int ari=ar.get(i-1);
                // with ar[i]
                if(ari<=j)
                    x=dp[i-1][j-ari];
                // without ar[i]
                y=dp[i-1][j];
                
                dp[i][j]=( x || y);
            }
            // System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][sum]?1:0;
    }
}


