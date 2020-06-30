package com.eyelockgames.datastructures;

import java.util.*;

public class PriorityQueueDS {

    // givein input ["I", "like", "SVB", "the", "the" }

    public static List<String> topKFrequentWords(String[] words, int k) {
        //count the frequency for each element
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // create a min heap
        PriorityQueue<Map.Entry<String, Integer>> queue
                = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));

        //maintain a heap of size k.
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        //get all elements from the heap
        List<String> result = new ArrayList<>();
        while (queue.size() > 0) {
            result.add(queue.poll().getKey());
        }

        //reverse the order
        Collections.reverse(result);

        // sort the list
        Collections.sort(result);
        return result;
    }

    public List<Integer> topKFrequentInts(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // create a min heap
        PriorityQueue<Map.Entry<Integer, Integer>> queue
                = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));

        //maintain a heap of size k.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        //get all elements from the heap
        List<Integer> result = new ArrayList<>();
        while (queue.size() > 0) {
            result.add(queue.poll().getKey());
        }

        //reverse the order
        Collections.reverse(result);

        return result;
    }
}
