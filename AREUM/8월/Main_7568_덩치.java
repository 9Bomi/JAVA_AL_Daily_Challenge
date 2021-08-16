package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_7568_덩치 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(in.readLine());

		ArrayList<Person> pList = new ArrayList<Person>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			pList.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for(int i=0; i<N; i++) {
			int cnt=1;
			for(int j=0; j<N; j++) {
				if(pList.get(j).h>pList.get(i).h && pList.get(j).w>pList.get(i).w) cnt++;
			}
			out.write(cnt+" ");
		}
		
		in.close();
		out.flush();
		out.close();
	}

	static class Person {
		int w; //weight
		int h; //height
		
		Person(int w, int h){
			this.w = w;
			this.h = h;
		}
	}
}
