class Solution {
    public int[] solution(long n) {
        String s = n+"";
        int[] answer = new int[s.length()];
        
        int idx =0;
        for(int i=s.length()-1;i>=0;i--)
            answer[idx++] = s.charAt(i) -'0';
        
        return answer;
    }
}