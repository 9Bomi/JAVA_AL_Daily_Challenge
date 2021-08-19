package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//백준 단계별-그리디
public class Main_1931_회의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		ClassRoom[] rooms =new ClassRoom[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			rooms[i] = new ClassRoom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(rooms, (o1,o2)->{
			if(o1.end==o2.end) {
				return o1.start-o2.start;
			}
			return o1.end-o2.end;
		});
		
		Stack<ClassRoom> meeting = new Stack<ClassRoom>();
		
		meeting.add(rooms[0]);
		
		for(int i=1; i<N; i++) {
			if(meeting.peek().end<=rooms[i].start) {
				meeting.add(rooms[i]);
			}
		}
		
		System.out.println(meeting.size());
		
		in.close();
	}
	
	public static class ClassRoom{
		int start;
		int end;
		
		public ClassRoom(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
}
