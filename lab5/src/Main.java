public class Main {
    double [][] dp;

    public double maximalLength(int[] height, int w)
    {
        int N = height.length;
        dp = new double[height.length][101];
        for(int i = N-2; i >= 0; i--) {
            for(int j = 1; j <= height[i]; j++)
                for(int k = 1; k <= height[i+1]; k++) {
                    double dist = Math.sqrt(w*w+Math.pow(j-k,2)) + dp[i+1][k];
                    if(dist > dp[i][j])
                        dp[i][j] = dist;
                }
        }
        double best = 0;
        for(int i = 1; i <= height[0]; i++)
            best = Math.max(best,dp[0][i]);
        return best;
    }
    public static void main(String[] args) {
        int[] heights = {100, 2, 100, 2, 100};
        Main main = new Main();
        double result = main.maximalLength(heights, 4);
        System.out.println(result);
    }
}