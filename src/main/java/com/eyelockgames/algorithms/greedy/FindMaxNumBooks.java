package com.eyelockgames.algorithms.greedy;
import java.util.*;
import java.lang.*;
import java.io.*;
public class FindMaxNumBooks {

    public static int findMaxBooks(int noofBooks, int[] costofBooks, int credits)
    {
        int result=-404;
        //write your Logic here:
        if(noofBooks == 0) return result;
        PriorityQueue<Integer> q
                = new PriorityQueue<Integer>(costofBooks.length);
        for(int i = 0; i < costofBooks.length; i++) { q.add(costofBooks[i]); }
        int matchSum = 0;
        int numBooks = 0;
        while (!q.isEmpty()) {
            Integer i = q.poll();
            if(i < credits) {
                if(matchSum < credits) {
                    matchSum += i;
                    numBooks++;
                    if(matchSum > credits)
                        return numBooks - 1;
                }
            }
        }
        result = numBooks;
        return result;
    }

    public static void main(String[] args)
    {
        int N,X;
        Scanner sc=new Scanner(System.in);

        //INPUT [uncomment & modify if required]
        N=sc.nextInt();
        int[] costofBooks=new int[N];

        for(int i=0;i<N;i++)
        {
            costofBooks[i]=sc.nextInt();
        }

        X=sc.nextInt();


        //OUTPUT [uncomment & modify if required]
        System.out.print(findMaxBooks(N,costofBooks,X));
    }
}