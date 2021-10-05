import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String nums[] = s.split(" ");
        int arr[] = new int[nums.length];
        
        for(int i=0;i<arr.length;i++)
            arr[i] = Integer.parseInt(nums[i]);
        
        Arrays.sort(arr);
        
        answer.append(arr[0]+" ");
        answer.append(arr[arr.length-1]);
        
        return answer.toString();
    }
}