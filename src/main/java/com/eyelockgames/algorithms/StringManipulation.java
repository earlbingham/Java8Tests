package com.eyelockgames.algorithms;

import java.util.Arrays;

public class StringManipulation {

    static String biggerIsGreater(String w) {
        int current = 1;
        int prev = 0;
        int largestChar = -1;
        while(current < w.length()) {
            if(w.charAt(prev) < w.charAt(current)) {
                largestChar = current;
                prev = current;
            }
            current++;
            if(largestChar == -1) prev++;
        }
        if(largestChar == -1) return "no answer";
        return w.substring(0, largestChar-1) + w.substring(largestChar, largestChar+1) + w.substring(largestChar-1, largestChar)
                + (largestChar == w.length()-1 ? "" : w.substring(largestChar+1, w.length()));
    }

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        int i = 0;
        int changes = 0;
        while (i < b.length()) {
            if(b.substring(i, i+3).equals("010")) {
                changes++;
                i = i+2;
            }
            if(i+3 < b.length()) {
                i++;
            } else {
                break;
            }
        }
        return changes;
    }

    public static void main(String[] args) {
        String a = "0101010";

        String b = LexographOut(a);
        // should be acbd, but got adbc
        System.out.println(beautifulBinaryString(a));
    }

    public static String LexographOut(String a){
        String out = "";
        char[] aCArr = a.toCharArray();
        int aLen = aCArr.length;
        int swap2 = 0;
        for (int i = aLen-2; i>=0; i--){
            int index = i;
            char aVal = aCArr[index];
            int ctr;
            for (int j = index+1; j <= aLen-1; j++){
                if (aVal < aCArr[j]){
                    int swap1 = i;
                    ctr = i;
                    int local = i;
                    char base = 'a';
                    int cnt = 1;
                    for (int m = local+1; m < aLen; m++){
                        if (aCArr[m] > aCArr[swap1] && aCArr[m] < base || cnt == 1){
                            base = aCArr[m];
                            swap2 = m;
                            cnt++;
                        }
                    }
                    char temp = aCArr[swap1];
                    aCArr[swap1] = aCArr[swap2];
                    aCArr[swap2] = temp;
                    for (char k:aCArr){
                        out = out+k;
                    }
                    out = SubstringSort(out, ctr);
                    return out;
                }

            }
        }
        return "no answer";
    }

    public static String SubstringSort(String a, int ctr){
        String sub1 = a.substring(ctr+1);
        String sub2 = a.substring(0,ctr+1);
        char[] sub1Arr = sub1.toCharArray();
        String out = "";
        Arrays.sort(sub1Arr);
        for (char k:sub1Arr){
            out = out+k;
        }
        out = sub2+out;
        return out;
    }
}
