import java.util.*;

class Solution {
    
    static class Music implements Comparable<Music>{//노래 객체.
        int id; //인덱스 번호    
        int count;  //재생 횟수
        
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
            genrePlayList.get(genres[i]).add(new Music(i,plays[i]));//노래 추가
        }
        
        PriorityQueue<String> genrePq = new PriorityQueue<>((g1,g2)->{
            return Integer.compare(genreCount.get(g2),genreCount.get(g1));
        });
        
        for(String g: genreCount.keySet())
            genrePq.add(g);
        
        int pqSize = genrePq.size();
        for(int i=0;i<pqSize;i++) {
        	String g = genrePq.poll();
            PriorityQueue<Music> pq = genrePlayList.get(g);
            answer.add(pq.poll().id);
            if(pq.size()>=1)
                answer.add(pq.poll().id);
        }
        
        return answer;
        
    }
}