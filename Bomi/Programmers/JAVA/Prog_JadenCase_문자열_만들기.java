class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(i==0 || (i!=0 && s.charAt(i-1)==' '))
                answer.append(Character.toUpperCase(s.charAt(i)));
            else
                answer.append(s.charAt(i));
        }
        
        return answer.toString();
    }
}