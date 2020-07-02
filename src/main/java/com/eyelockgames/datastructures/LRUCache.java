package com.eyelockgames.datastructures;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {

/**
    Example data structure for LRU Cache Coupons
    [ "C1" : 100,  "C2" : 80, "C3" : 70, "C4" : 50 ]
    list.get(0) -> C1
    In which the value in this map represents the amount of times that element has been used
    based upon current TTL
 */

    class Coupons {

        PriorityQueue<Map.Entry<String, Coupon>> queue
                = new PriorityQueue<Map.Entry<String, Coupon>>(Map.Entry.<String, Coupon>comparingByValue());
        int rateLimit = 100;
        Map<String, Integer> queueUsage = new HashMap<>();

        Coupons(int r) {
            this.rateLimit = r;
        }
        public boolean insertCoupon(Coupon c) {
            if(queue.size() == rateLimit) {
                queue.remove(queue.size() -1);
            }
            //queue.offer(c);
            return true;
        }

        public Coupon getMostUsedCoupon(){
            // most used
            Coupon c = (Coupon) queue.poll();
//            Integer location = queueUsage.get(c.getId());
//            queue.put(id, usgae-1);
            queue.poll();
        }

    }

    class Coupon implements Comparable<Coupon> {
        LocalTime t1;
        LocalTime t2;
        int freq;

        @Override
        public int compareTo(Coupon o) {
            if(o.t1.isAfter(t1) && o.t2.isBefore(t2))
                return 1;
            return -1;
        }
    }
// time period -> t1 -> t2
// If we find any coupon which is not used in this time period (t1->t2), we want to delete that coupon

}

