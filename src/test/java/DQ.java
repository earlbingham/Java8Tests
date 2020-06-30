
import java.io.*;
import java.util.*;

public class DQ {

/*
 Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.


Input: ["i", "like", "SVB", "i", "like", "coding"], k = 2
Output: ["i", "like"]
Explanation: "i" and "like" are the two most frequent words.
    Note that "i" comes before "like" due to a lower alphabetical order.


Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
 */

    public static void main(String[] args) {

    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> occur = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++ ) {
            if(occur.containsKey(words[i])) {
                occur.put(words[i], occur.get(words[i])+1);
            } else {
                occur.put(words[i], 1);
            }
        }
        occur.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> occur.put(x.getKey(), x.getValue()));
        List<String> occurL = new ArrayList<String>();
        for(int i = 0; i< k; i++) {
            // occurL.add(occur.gget(i));
        }
        return occurL;
    }

}

