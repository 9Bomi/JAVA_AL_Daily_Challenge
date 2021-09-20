import java.util.*;

class Solution {
    static int answer =0;
    static String[] conditions;
    static int condN;
    static char friends[] = {'A','C','F','J','M','N','R','T'};
    static char ch[] = new char[8];
    static boolean visited[] = new boolean[8];
    
    public static void dfs(int cnt){
        if(cnt==8){
            String picture = new String(ch);
            
            for(int i=0;i<condN;i++){
                String cond = conditions[i];
                int aIdx = picture.indexOf(cond.charAt(0)+"");
                int bIdx = picture.indexOf(cond.charAt(2)+"");
                char sign = cond.charAt(3);
                int diff = cond.charAt(4)-'0'+1;
                
                if((sign == '<' && Math.abs(aIdx-bIdx) >= diff) ||
                    (sign =='>' && Math.abs(aIdx-bIdx) <= diff) ||
                    (sign =='=' && Math.abs(aIdx-bIdx) != diff) ){
                        break;
                }
                
                if(i==condN-1)
                	answer++;
            }
            
            return;
        }
    
        for(int i=0;i<8;i++){
            if(!visited[i]){
                visited[i] = true;
                ch[cnt] = friends[i];
                dfs(cnt+1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int n, String[] data) {//n: 조건의 개수 , data: n개의 조건
        condN = n;
        conditions = data;
        answer =0;
        
        dfs(0);
        
        return answer;
    }
}