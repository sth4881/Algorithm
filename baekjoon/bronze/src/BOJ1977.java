import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 백준 1977번 완전제곱수 (Bronze) */
public class BOJ1977 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int m = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            int sum = 0;
            for(int i=1; i<101; i++) {
                if(i*i>=m && i*i<=n) {
                    list.add(i*i);
                    sum += i*i;
                }
            }

            if(list.size()>0) bw.write(sum+" "+list.get(0)+"\n");
            else bw.write(-1+"\n");
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}