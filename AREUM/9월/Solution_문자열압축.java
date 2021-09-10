package com.pro.algo;

class Solution_문자열압축 {
    
    public int solution(String s) {
    	int min = Integer.MAX_VALUE;
        
        for(int i=1; i<s.length()/2+s.length()%2+1; i++){
            String past = s.substring(0,i);
            StringBuilder sb = new StringBuilder(past);
            int cnt=1;
            int j;
            
            for(j=i; j<s.length(); j+=i){
                if(j+i<=s.length()){
                    
                    String temp = s.substring(j,j+i);
                    if(past.equals(temp)){
                        cnt++;
                    } else{
                        if(cnt==1) sb.append(temp);
                        else {
                            sb.insert(sb.length()-1,cnt+"");
                            sb.append(temp);
                        }
                        past=temp;
                        cnt=1;
                     }
                }
            }
            
            if(cnt!=1){
                sb.insert(sb.length()-1,cnt+"");
            }
            sb.append(s.substring(s.length()-s.length()%i));
            if(min>sb.length()) min=sb.length();
        }
        return min;
    }
}