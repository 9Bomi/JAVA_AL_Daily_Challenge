package com.pro.algo;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution_오픈채팅방 {
    public String[] solution(String[] record) {
    	
        Map<String, String> nick= new HashMap();
        String[][] log = new String[record.length][2];
        int cnt=0;
        StringTokenizer st;
        
        for(int i=0; i<record.length; i++){
            st= new StringTokenizer(record[i]);
           
            String status = st.nextToken();
            String id = st.nextToken();
            
            if(status.equals("Enter")){
                log[cnt][0] = status;
                log[cnt++][1] = id;
                nick.put(id, st.nextToken());
            } else if(status.equals("Leave")){
                log[cnt][0] = status;
                log[cnt++][1] = id;
                
            } else {
                nick.replace(id, st.nextToken());
            }

        }
        
        String[] answer = new String[cnt];
        
        for(int i=0; i<cnt; i++){
            answer[i] = nick.get(log[i][1])+"님이 ";
            if(log[i][0].equals("Enter")){
                answer[i]+="들어왔습니다.";
            } else answer[i]+= "나갔습니다.";
        }
        return answer;
    }
}