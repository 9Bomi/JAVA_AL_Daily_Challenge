package com.pro.algo;

class Solution_괄호변경 {
    public String solution(String p) {    
        return make(p);
    }
    
    public static String make(String w){
        if(w.equals("")) return "";
        
        String u ="";
        String v ="";
        
        boolean balanced = true;
        int start=0;
        int end=0;
         
        for(int i=0; i<w.length(); i++){
            if(w.charAt(i)=='(') start++;
            else end++;
            
            u+=w.charAt(i);
            if(end>start) balanced=false;
            if(start==end&&balanced) {
                if(i==w.length()-1) return w;
                v=w.substring(i+1,w.length());
                return u+make(v);
            } else if(start==end){
                String temp="";
                v=w.substring(i+1,w.length());
                for(int j=1; j<u.length()-1; j++) {
                    if(u.charAt(j)=='(') temp+=")";
                    else temp+="(";
                }
                return "("+make(v)+")"+temp;
            }     
        }
        
        return "";
    }
}