import java.util.*;

class Solution {
    public long solution(long n) {
        
        String num = n+"";
        Integer arr[] = new Integer[num.length()];
        
        for(int i=0;i<arr.length;i++)
            arr[i] = num.charAt(i)-'0';
        
        Arrays.sort(arr,Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<arr.length;i++)
            sb.append(arr[i]);
        
        long answer = Long.parseLong(sb.toString());
        return answer;
    }
}