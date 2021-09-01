class Solution {
    static int Lx = 4;
    static int Ly = 1;
    static int Rx = 4; 
    static int Ry = 3;
    
    static int getDis(int x,int y,int a,int b){
        return Math.abs(x-a)+Math.abs(y-b);
    }
    
    static void changeLidx(int num){
        if(num ==0){
            Lx = 4;
            Ly = 2;
            return;
        }
        
        Lx = (num-1)/3+1;
        Ly = (num-1)%3+1;
    }
    
    static void changeRidx(int num){
        if(num ==0){
            Rx = 4;
            Ry = 2;
            return;
        }
        
        Rx = (num-1)/3+1;
        Ry = (num-1)%3+1;
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        char defaultHand = hand.equals("right") ? 'R' : 'L';
        
        for(int num:numbers)
            if(num%3==1){
                answer.append("L");
                changeLidx(num);
            }
            else if(num==0 || num%3 ==2){
                int dx = num == 0 ? 4 : (num-1)/3+1;
                int dy = num == 0 ? 2 : (num-1)%3+1;
                int ldis = getDis(Lx,Ly,dx,dy);
                int rdis = getDis(Rx,Ry,dx,dy);
                
                if(ldis == rdis){
                    answer.append(defaultHand);
                    if(defaultHand == 'R')
                        changeRidx(num);
                    else
                        changeLidx(num);
                }
                else if(ldis<rdis){
                    answer.append("L");
                    changeLidx(num);
                }
                else{
                    answer.append("R");
                    changeRidx(num);
                }
            }
            else{
                answer.append("R");
                changeRidx(num);
            }
        
        return answer.toString();
    }
}