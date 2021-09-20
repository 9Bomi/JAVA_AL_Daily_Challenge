import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        ArrayList<String> cache = new ArrayList<>();
        
        for(int i=0;i<cities.length;i++){
            String city = cities[i].toUpperCase();
            if(cache.contains(city)){
                int idx = cache.indexOf(city);
                cache.remove(idx);
                answer+=1;
            }
            else
                answer+=5;
            
            cache.add(0,city);
            if(cache.size()>cacheSize)
                cache.remove(cacheSize);
        }
    
        return answer;
    }
}