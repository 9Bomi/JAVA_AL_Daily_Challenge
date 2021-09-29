import java.util.*;
import java.io.*;

public class BOJ_17298{
    static class Pair {
        int idx, n;
        Pair(int idx, int n) {
            this.idx = idx;
            this.n = n;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[N];
        int[] ret = new int[N];
        Arrays.fill(ret, -1);
        StringTokenizer st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = new Pair(i + 1, Integer.parseInt(st.nextToken()));
        ArrayDeque<Pair> stk = new ArrayDeque<>();
        for(Pair p : arr) {
            while (!stk.isEmpty() && stk.peekLast().n < p.n)
                ret[stk.pollLast().idx - 1] = p.n;
            stk.addLast(p);
        }
        for(int n : ret)
            sb.append(n).append(" ");
        System.out.println(sb);
    }
}