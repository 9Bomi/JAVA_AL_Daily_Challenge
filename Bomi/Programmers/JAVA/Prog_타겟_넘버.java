class Solution {
    static int nums[];
    static int targetNumber;
    static int answer =0;
    
    static void dfs(int cnt, int sum){
        if(cnt == nums.length){
            if(sum == targetNumber)
                answer++;
            return;
        }
        
        dfs(cnt+1,sum+nums[cnt]);
        dfs(cnt+1,sum-nums[cnt]);
    }
    
    public int solution(int[] numbers, int target) {
        nums = numbers;
        targetNumber = target;
        
        dfs(0,0);
        
        return answer;
    }
}