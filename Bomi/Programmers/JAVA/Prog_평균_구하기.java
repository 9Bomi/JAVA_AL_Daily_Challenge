class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double num = arr.length;
        double sum =0;
        for(int i=0;i<num;i++)
            sum +=arr[i];
        
        answer = sum/num;
        
        return answer;
    }
}