package com.pro.algo;

class Solution_단체사진찍기{
    public int solution(int n, String[] data) {
        int answer = 0;
        
        int num[] = new int[8];
        for(int i=0; i<8; i++){
            num[i]=i;
        }
        
        int me[] = new int[n];
        int your[] = new int[n];
        char oper[] = new char[n];
        int dis[] = new int[n];
        
        for(int i=0; i<n; i++){
            me[i]=match(data[i].charAt(0));
            your[i]=match(data[i].charAt(2));
            oper[i]=data[i].charAt(3);
            dis[i]=data[i].charAt(4)-'0';
        }
        
        do{
            boolean isSuccess=true;
            for(int i=0; i<n; i++){
                if(!check(me[i],your[i],oper[i],dis[i], num, n)) {
                    isSuccess=false;
                    break;
                }
            }
            
            if(isSuccess) answer++;
            
        }while(np(num));
        return answer;
    }
    
    public boolean check(int me, int your, char oper, int dis, int res[], int n){
        int indexM=0;
        int indexY=0;
        for(int i=0; i<8; i++){
            if(me==res[i]) indexM=i;
            else if(your==res[i]) indexY=i;
        }
        
        if(oper=='>'){
            if(Math.abs(indexM-indexY)-1>dis) return true;
        }else if(oper=='<'){
            if(Math.abs(indexM-indexY)-1<dis) return true;
        }else{
            if(Math.abs(indexM-indexY)-1==dis) return true;
        }
        return false;
    }
    
    
    public static boolean np(int num[]){
        int n = num.length;
        
        int i= n-1;
        while(i>0 && num[i-1] >= num[i])i--;
        if(i==0) return false;
        
        int j=n-1;
        while(num[i-1]>=num[j]) j--;
        
        swap(i-1,j,num);
        
        int k=n-1;
        while(k>i) swap(k--,i++, num);

        return true;
    }
    
    public static void swap (int x, int y, int num[]){
        int temp = num[x];
        num[x] = num[y];
        num[y] = temp;
    }
    
    public int match(char c){
        switch(c){
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'F':
                return 2;
            case 'J':
                return 3;
            case 'M':
                return 4;
            case 'N':
                return 5;
            case 'R':
                return 6;
            case 'T':
                return 7;
        }
        return 0;
    }
}