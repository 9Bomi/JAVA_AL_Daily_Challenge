class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        
        String s = ""+x;
        int num =0;
        for(int i=s.length()-1;i>=0;i--)
            num += s.charAt(i)-'0';
        
        if(x%num == 0)
            answer = true;
        
        return answer;
    }
}