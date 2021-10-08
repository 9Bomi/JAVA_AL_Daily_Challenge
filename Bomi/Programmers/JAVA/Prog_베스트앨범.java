import java.util.*;

class Solution {
    
    static class Music implements Comparable<Music>{
        int id;
        int count;
        
        Music(int id, int count){
            this.id = id;
            this.count = count;
        }
        
        public int compareTo(Music o){
            if(this.count == o.count)
                return this.id - o.id;
            return o.count-this.count;
        }
    }
    
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String,Integer> genreCount = new HashMap<>();
        HashMap<String,PriorityQueue<Music>> genrePlayList = new HashMap<>();
        
        int size = genres.length;
        
        for(int i=0; i<size; i++){
            if(genreCount.containsKey(genres[i]))//이미 있는 경우
                genreCount.put(genres[i],genreCount.get(genres[i])+plays[i]);
            else{//처음 넣는 경우
                genreCount.put(genres[i],plays[i]);
                genrePlayList.put(genres[i],new PriorityQueue<>());
            }
            genrePlayList.get(genres[i]).add(new Music(i,plays[i]));
        }
        
        for(String g : genreCount.keySet()){
            PriorityQueue<Music> pq = genrePlayList.get(g);
            answer.add(pq.poll().id);
            if(pq.size()>=1)
                answer.add(pq.poll().id);
        }
        
        return answer;
        
    }
}