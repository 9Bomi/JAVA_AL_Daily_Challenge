import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static int size;
    static int nums[];
    static ArrayList<Integer> list = new ArrayList<>();
    
    static void dfs(int idx,int cnt, int sum){
        
        if(idx == size){
            if(cnt == 2 && !list.contains(sum))
                list.add(sum);
            return;
        }
        
        if(cnt<2)
            dfs(idx+1,cnt+1,sum+nums[idx]);
        dfs(idx+1,cnt,sum);
        
    }
    
    public ArrayList<Integer> solution(int[] numbers) {
        size = numbers.length;
        nums = numbers;
        
        dfs(0,0,0);
        
        Collections.sort(list);
        
        return list;
    }
}