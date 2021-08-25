class Solution {
    public String solution(int a, int b) {
        String ans[] = {"FRI","SAT","SUN","MON","TUE","WED","THU",};
        
        int days = b;
        
        for(int i=1;i<a;i++)
            if(i<=7){
                if(i%2==1)
                    days+=31;
                else
                    days += (i==2 ? 29 : 30);
            }
            else{
                if(i%2==1)
                    days+=30;
                else
                    days += 31;
            }
        
        
        days = (days-1)%7;
        
        return ans[days];
    }
}