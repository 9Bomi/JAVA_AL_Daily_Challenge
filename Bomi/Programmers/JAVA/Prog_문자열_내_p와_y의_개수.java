class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toUpperCase();
        
        int pnum =0;
        int ynum =0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i) == 'P')
                pnum++;
            else if(s.charAt(i) == 'Y')
                ynum++;
        
        if(pnum != ynum)
            answer=false;
        
        return answer;
    }
}