package Strings;

public class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k){
        int[] charMap = new int[26]; //count of char occurences
        int mostRep = 0, start = 0, maxLen = 0;
        for(int end = 0;end<s.length();end ++){
            mostRep = Math.max(mostRep, ++ charMap[s.charAt(end) - 65]);//most rep letter encountered in window
            if(end - start + 1 -mostRep > k){//violate
                charMap[s.charAt(start) - 65]--;//update map
                start ++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
