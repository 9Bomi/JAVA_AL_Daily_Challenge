class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder("");
        for(int i=0;i<phone_number.length()-4;i++)
            answer.append("*");
        for(int i=phone_number.length()-4;i<phone_number.length();i++)
            answer.append(phone_number.charAt(i));
        
        return answer.toString();
    }
}