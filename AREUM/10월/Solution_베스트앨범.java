package com.pro.algo;

import java.util.*;

class Solution_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> map = new HashMap<String, Integer> ();
        HashMap<String, PriorityQueue<Music>> queueMap = new HashMap<>();
                
        for(int i=0; i<genres.length; i++) {
            int play = plays[i];
            String genre = genres[i];
            
            if(map.containsKey(genre)){
                map.put(genre, map.get(genre)+play);
                queueMap.get(genre).add(new Music(i, play, genre));
            }else{
                map.put(genre, play);
                queueMap.put(genre, new PriorityQueue<>((o1, o2) -> {if(o1.play==o2.play) return o1.index-o2.index; return o2.play-o1.play;}));
                queueMap.get(genre).add(new Music(i, play, genre));
            }
        }
        
        int answer[] = new int[map.size()*2];
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1,o2)->map.get(o2)-map.get(o1));
        
        int cnt=0;
        for(int i=0; i<list.size(); i++){
            PriorityQueue<Music> queue = queueMap.get(list.get(i));
            answer[cnt++] = queue.poll().index;
            if(queue.isEmpty()) continue;
            answer[cnt++] = queue.poll().index;
        }
        
        return Arrays.copyOf(answer, cnt);
    }
    
    static class Music{
        int index;
        int play;
        String genre;
        
        Music(int index, int play, String genre) {
            this.index = index;
            this.play = play;
            this.genre = genre;
        }
    }
}
