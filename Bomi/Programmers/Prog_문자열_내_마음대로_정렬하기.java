import java.util.Arrays;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings,(String s1,String s2)->{
                int diff = s1.charAt(n)-s2.charAt(n);
                if(diff==0)
                    return s1.compareTo(s2);
                return diff;
            });
        return strings;
    }
    
}