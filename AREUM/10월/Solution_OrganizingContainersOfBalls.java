package com.algo.hackerrank;

import java.util.Arrays;
import java.util.List;

public class Solution_OrganizingContainersOfBalls {
	public static String organizingContainers(List<List<Integer>> container) {
        long [] freq = new long[container.size()];
        long [] cons = new long[container.size()];

        for(int i=0; i<container.size(); i++) {
            long sum=0;
            for(int j=0; j<container.get(i).size(); j++) {
                freq[j] += container.get(i).get(j);
                sum+=container.get(i).get(j);
            }
            cons[i] = sum;
        }
        
        Arrays.sort(cons);
        Arrays.sort(freq);
        
        boolean success = true;
        for(int i=0; i<container.size(); i++) {
            if(cons[i]==freq[i]) continue;
            else {
                success=false;
                break;
            }
        }
        if(success) return "Possible";
        else return "Impossible";        
    }
}
