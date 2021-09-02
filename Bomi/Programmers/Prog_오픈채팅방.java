import java.util.*;

class Solution {
    static class Pair{
		String uid;
		boolean isLeaving;
		
		Pair(String uid,boolean isLeaving){
			this.uid = uid;
			this.isLeaving = isLeaving;
		}
	}
    
    public ArrayList<String> solution(String[] record) {
        Map<String,String> nameMap = new HashMap<>();
		ArrayList<Pair> ans = new ArrayList<>();
		
		for(int i=0;i<record.length;i++) {
			String line[] = record[i].split(" ");
			String order = line[0];
			String uid = line[1];
			
			if(order.equals("Leave")) 
				ans.add(new Pair(uid,true));
			else if(order.equals("Enter")) {
				nameMap.put(uid,line[2]);
				ans.add(new Pair(uid,false));
			}
			else {//change
				nameMap.put(uid,line[2]);
			}
		}
		
		String inSentence = "님이 들어왔습니다.";
		String outSentence = "님이 나갔습니다.";
		ArrayList<String> answer = new ArrayList<>();
		for(int i=0;i<ans.size();i++) {
			Pair temp = ans.get(i);
			String name = nameMap.get(temp.uid);
			if(temp.isLeaving)
				answer.add(name+outSentence);
			else
				answer.add(name+inSentence);
		}
        
        return answer;
    }
}