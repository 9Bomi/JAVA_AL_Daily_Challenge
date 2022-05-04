package com.pro.algo;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_셔틀버스 {
	public String solution(int n, int t, int m, String[] timetable) {
        Crew answer = new Crew(9, 0);
        Arrays.sort(timetable);
        Crew[] crews = new Crew[timetable.length];
        
        for (int i = 0; i < timetable.length; i++) {
            StringTokenizer st = new StringTokenizer(timetable[i], ":");
            
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            
            crews[i] = new Crew(hour, minute);
        }
        
        int index = -1;
        
        for (int i = 0; i < n; i++) {
            int currentHour = 9 + (i * t) / 60;
            int currentMinute = (i * t) % 60;
            
            int cnt = 0;
            answer = new Crew(currentHour, currentMinute);
            
            for (int j = 0; j < m; j++) {
                if (index + 1 >= timetable.length) {
                    break;
                }
                
                if (currentHour < crews[index + 1].hour) {
                    break;
                } else if (currentHour == crews[index + 1].hour) {
                    if (currentMinute < crews[index + 1].minute) {
                        break;   
                    }
                }
                
                index++;

                if (j == m - 1) {
                    answer.hour = crews[index].minute == 0 ? crews[index].hour - 1 : crews[index].hour;
                    answer.minute = crews[index].minute == 0 ? 59 : crews[index].minute - 1;
                } else if (answer.toString().compareTo(crews[index].toString()) < 0) {
                    answer.hour = crews[index].hour;
                    answer.minute = crews[index].minute;
                }
            }
        }
        
        return answer.toString();
    }
    
    static class Crew {
        int hour;
        int minute;
        
        Crew(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }
        
        public String toString() {
            return ((hour / 10 == 0) ? "0" : "") + hour + ":" + ((minute / 10 == 0) ? "0" : "") + minute;
        }
    }
}
