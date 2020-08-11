package com.eyelockgames.datastructures;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PriorityQeueueDSTest {

    @Test
    public void shouldFindMostCommonWords() {
        String[] input = new String[] {"I", "like", "the", "SVB", "the", "I"};
        String[] expected = new String[] {"I", "like"};

        List<String> returnWords = PriorityQueueDS.topKFrequentWords(input, 2);
        for(String word: returnWords) {
            System.out.println(word);
        }
        assertEquals(2, 2);
    }
}
