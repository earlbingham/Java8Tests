package com.eyelockgames.algorithms.caterpillar;

import java.util.HashMap;
import java.util.Map;

public class FindSmallestString {

    public static int findSmallestString(String input) {
        int smallLen = Integer.MAX_VALUE;
        Map<Character, Integer> occurances = new HashMap<Character, Integer>();
        occurances.put('A', 0);
        occurances.put('C', 0);
        occurances.put('G', 0);
        occurances.put('T', 0);
        int expected = input.length()/4;
        for(Character c : input.toCharArray()) {
            occurances.put(c, occurances.get(c) == null ? 1 : occurances.get(c)+1);
        }
        if(occurances.get('A') == 0 && occurances.get('C') == 0 &&
                occurances.get('F') == 0 && occurances.get('G') == 0) {
            return 0;
        }
        Map<Character, Integer> found = new HashMap<Character, Integer>();
        found.put('A', 0);
        found.put('C', 0);
        found.put('G', 0);
        found.put('T', 0);
        int tail = 0;
        int head = 0;
        while(head != input.length()) {
            if(found.containsKey(input.charAt(head))) {
                found.put(input.charAt(head), found.get(input.charAt(head)) + 1);
            } else {
                found.put(input.charAt(head), 1);
            }
            if(found.get('A') >= occurances.get('A') &&
                    found.get('C') >= occurances.get('C') &&
                    found.get('G') >= occurances.get('G') &&
                    found.get('T') >= occurances.get('T')) {
                    smallLen = Math.min(smallLen, head-tail+1);
            }
            // shorten the string
            while(found.get(input.charAt(tail)) > occurances.get(input.charAt(tail))) {
                Integer i = found.get(input.charAt(tail)) - 1;
                found.put(input.charAt(tail), i);
                tail ++;
                smallLen = Math.min(smallLen, head-tail+1);
            }
            head ++;
        }
        return smallLen;
    }

}
