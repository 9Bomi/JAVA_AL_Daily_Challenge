class Solution {
    public int solution(String s) { 
        int answer = s.length();    
        int size = s.length();
        
        for(int i=1;i<=size/2;i++){
            
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            int count = 1;//같은 패턴이 나온 횟수
            String before = s.substring(idx,idx+i);
            idx+=i;
            
            while(true){
            	int to = idx+i;
            	if(to>=size) {
            		to =size;
            		String now = s.substring(idx,to);
            		if(now.equals(before)) {
            			sb.append(++count+before);
            		}
            		else {
            			if(count>1) 
            				sb.append(count);
            			sb.append(before+now);
            		}
            		break;
            	}
            	else {
            		String now = s.substring(idx,to);
            		if(now.equals(before))
            			count++;
            		else {
            			if(count>1) {
            				sb.append(count+before);
            				count =1;
            			}
            			else
            				sb.append(before);
            		}
            		before=now;
            		idx+=i;
            	}
            }
            
            if(sb.length()<answer) {
            	System.out.println(i+" "+ sb);
            	answer = sb.length();
            }
                
        }
        
        return answer;
    }
}