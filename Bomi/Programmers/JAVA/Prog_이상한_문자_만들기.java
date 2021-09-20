class Solution {
    
    public static boolean isUpperCase(char c){
        if(c<='Z')
            return true;
        return false;
    }
    
    public String solution(String s) {
        String answer = "";
        int idx =0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' '){
                idx =0;
                answer +=" ";
                continue;
            }
               
            
            if(idx%2 ==1 && isUpperCase(c))
                c+=32;
            
            if(idx%2 ==0 && !isUpperCase(c))
                c-=32;
            
            answer += c+"";
            idx++;
        }
        
        return answer;
    }
}