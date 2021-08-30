class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int score[] = new int[4];
        
        int set =0;
        int num =0;
        for(int i=0;i<dartResult.length();i++){
            char c = dartResult.charAt(i);
            
            if(Character.isDigit(c))
                num = num*10+(c-'0');
            else
                switch(c){  
                    case 'S':
                        score[++set]=num;
                        num =0;
                        break;
                    case 'D':
                        score[++set]=num;
                        num=0;
                        score[set] = (int)Math.pow(score[set],2);
                        break;
                    case 'T':
                        score[++set]=num;
                        num =0;
                        score[set] = (int)Math.pow(score[set],3);
                        break;
                    case '*':
                        if(set>1)
                            score[set-1] *=2;
                        score[set]*=2;
                        break;
                    case '#':
                        score[set] = -score[set];
                        break;
                }
            
        }
    
        for(int i=1;i<4;i++)
            answer +=score[i];
        
        return answer;
    }
}