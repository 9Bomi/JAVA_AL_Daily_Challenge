class Solution {
    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        String kim = "Kim";
        for(int i=0;i<seoul.length;i++)
            if(seoul[i].equals(kim)){
                answer += i+"";
                break;
            }
        
        return answer + "에 있다";
    }
}