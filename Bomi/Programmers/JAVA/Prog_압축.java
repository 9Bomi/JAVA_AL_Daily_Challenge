import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Map<String,Integer> dict = new HashMap<>();
        //26번까지 알파벳 사전에 삽입
        char c='A';
        for(int i=1;i<=26;i++)
            dict.put(c++ +"",i);
        
        int idx = 27;
        while(msg.length()>0){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<msg.length();i++){
                sb.append(msg.charAt(i));
                
                if(!dict.containsKey(sb.toString())){
                    answer.add(dict.get(sb.substring(0,i)));  //w색인 출력
                    msg = msg.substring(i); //w 제거
                    dict.put(sb.toString(),idx++);//사전에 추가
                    break;
                }
                else if(i == msg.length()-1){
                    answer.add(dict.get(sb.substring(0,i+1)));  //w색인 출력
                    msg = "";
                    break;
                }
            }
        }
        
        return answer;
    }
}