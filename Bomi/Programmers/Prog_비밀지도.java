class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            String num1 = Integer.toBinaryString(arr1[i]);
            String num2 = Integer.toBinaryString(arr2[i]);
            int num1Size = num1.length();
            int num2Size = num2.length();
            for(int j=0;j<n-num1Size;j++)
                num1 = " "+num1;
            for(int j=0;j<n-num2Size;j++)
                num2 = " "+num2;
            for(int j=0;j<n;j++){
                if(num1.charAt(j) == '1' || num2.charAt(j)=='1')
                    sb.append("#");
                else
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}