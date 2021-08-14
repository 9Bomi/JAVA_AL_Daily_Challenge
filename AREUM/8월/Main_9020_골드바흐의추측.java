package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9020_골드바흐의추측 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N= Integer.parseInt(in.readLine());
			
			// 소수 구하기
			boolean [] sosu = new boolean[N];
			sosu[1]=true;
			sosu[0]=true;
			for(int i=2; i<N; i++) {
				if(!sosu[i]) {
					for(int j=i*2; j<N; j+=i) {
						sosu[j] = true;
					}
				}
			}

			// 골드바흐 파티션 찾기
			for(int i=N/2; i<N; i++) {
				if(sosu[i]==false && sosu[N-i]==false) {
					if(i>N-i) System.out.println(N-i+" "+i);
					else System.out.println(i+" "+(N-i));
					break;
				}
			}
		}
		in.close();
	}
}
