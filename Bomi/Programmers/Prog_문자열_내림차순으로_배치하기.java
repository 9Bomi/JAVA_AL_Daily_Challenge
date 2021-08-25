import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        char[] ans = s.toCharArray();
        
        Arrays.sort(ans);
        
        String answer = "";
        for(int i=ans.length-1;i>=0;i--)
            answer += ans[i];
        
        return answer;
    }
}