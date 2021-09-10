package com.pro.algo;

class Solution_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer =new StringBuilder("");
        int rdir[] = {0,2};
        int ldir[] = {0,0};
        
        for(int i=0; i<numbers.length; i++){
            int target = numbers[i];
            
            if(target==1 || target==4 ||target==7){
                answer.append("L");
                ldir=setArray(target);
            } else if(target==3 || target==6 ||target==9){
                answer.append("R");
                rdir=setArray(target);
            } else{
                int temp[] = setArray(target);
                if(getDistance(rdir[0], rdir[1],temp[0], temp[1])==getDistance(ldir[0], ldir[1],temp[0], temp[1]))
                {
                    if(hand.equals("right")){
                        rdir = temp;
                        answer.append("R");
                    }else {
                        ldir = temp;
                        answer.append("L");
                    }
                } else if (getDistance(rdir[0], rdir[1],temp[0], temp[1])>getDistance(ldir[0], ldir[1],temp[0], temp[1])) {
                        ldir = temp;
                        answer.append("L");
                } else{
                        rdir = temp;
                        answer.append("R");
                }
                
                
            }
        }
        
        return answer.toString();
    }
    public int getDistance(int x1, int y1, int x2, int y2) {
        return (Math.abs(x1-x2)+Math.abs(y1-y2));
    }
    
    public int[] setArray(int num) {
        int dir[] = new int[2];
        
        switch(num){
            case 1:
                dir[0] = 3;
                dir[1] = 0;
                break;
            case 2:
                dir[0] = 3;
                dir[1] = 1;
                break;
            case 3:
                dir[0] = 3;
                dir[1] = 2;
                break;
            case 4:
                dir[0] = 2;
                dir[1] = 0;
                break;
            case 5:
                dir[0] = 2;
                dir[1] = 1;
                break;
            case 6:
                dir[0] = 2;
                dir[1] = 2;
                break;
            case 7:
                dir[0] = 1;
                dir[1] = 0;
                break;
            case 8:
                dir[0] = 1;
                dir[1] = 1;
                break;
            case 9:
                dir[0] = 1;
                dir[1] = 2;
                break;
            case 0:
                dir[0] = 0;
                dir[1] = 1;
                break;
        }
        
        return dir;
    }
}