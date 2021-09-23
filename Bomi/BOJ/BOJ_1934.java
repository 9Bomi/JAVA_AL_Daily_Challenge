import java.io.*;
import java.util.*;

public class Main {

    public static int GCD(int a, int b){
        if(b==0)
            return a;
        
        return GCD(b, a%b);
    }

    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(LCM(a,b)+"\n");
        }
        bw.close();
    }
}