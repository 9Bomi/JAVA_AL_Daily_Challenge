package com.pro.algo;

public class Solution_로또의최고순위와최저순위 {
	public int[] solution(int[] lottos, int[] win_nums) {
        int zero=0;
        int same=0;
        boolean isChecked[] = new boolean[6];
        for(int i=0; i<6; i++){
            if(lottos[i]==0) {
                zero++;
                continue;
            }
            for(int j=0; j<6; j++){
                if(isChecked[j]) continue;
                if(lottos[i]==win_nums[j]) {
                    same++;
                    isChecked[j] = true;
                    break;
                }
            }
        }

        int[] answer = {rank(same+zero), rank(same)};
        
        return answer;
    }
    
    
    public int rank(int n){
        switch(n){
            case 0:
            case 1:
                return 6;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
        }
        return 0;
    }
}
