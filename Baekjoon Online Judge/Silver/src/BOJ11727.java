import java.io.*;

public class BOJ11727 {
    static int N;
    static int[] dp;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            dp = new int[N+1];

            if(N==1) bw.write(1+"\n");
            else {
                dp[1] = 1;
                dp[2] = 3;

                for(int i=3; i<=N; i++) {
                    dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
                }

                bw.write(dp[N]+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
