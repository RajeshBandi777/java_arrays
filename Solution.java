import java.io.*;
import java.util.*;

class Solution {

    public boolean areIsomorphic(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {

            int idx1 = s1.charAt(i) - 'a';
            int idx2 = s2.charAt(i) - 'a';

            // If both characters are not mapped
            if (map1[idx1] == 0 && map2[idx2] == 0) {
                map1[idx1] = idx2 + 1;
                map2[idx2] = idx1 + 1;
            }
            // If mapping mismatch
            else if (map1[idx1] != idx2 + 1) {
                return false;
            }
        }

        return true;
    }
}

// Driver Code
public class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            String s1 = br.readLine().trim();
            String s2 = br.readLine().trim();

            Solution obj = new Solution();
            System.out.println(obj.areIsomorphic(s1, s2));
        }
    }
}
