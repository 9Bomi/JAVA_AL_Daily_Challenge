import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int height[] = new int[board.length];
        Arrays.fill(height,-1);
        
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++)
                if(board[j][i] !=0){
                    height[i] = j;
                    break;
                }
                    
        
        Stack<Integer> box = new Stack<>();
        
        for(int num:moves)
            if(height[num-1]!=-1){
                int doll = board[height[num-1]][num-1];
                    if(height[num-1] == board.length-1)
                        height[num-1] = -1;
                    else
                        height[num-1]++;
                
                if(!box.isEmpty() && box.peek() == doll){
                    answer+=2;
                    box.pop();
                }
                else
                    box.add(doll);
            }
        
        return answer;
    }
}