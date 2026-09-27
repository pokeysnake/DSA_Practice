class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return countS.equals(countT);
    }
}

/**
    ALTERNATIVE APPROACH
    char[] s_array = s.toCharArray()
    char[] t_array = t.toCharArray()
    Arrays.sort(s_array)
    Arrays.sort(t_array)
    return Arrays.equals(s_array, t_array)

    Time Complexity: O(n log n) from 2 sort commands
    Space: O(n) because we know n == m from initial checks

    Hashmap implementation 
    Time: O(n) with n == m
    Space: O(n) with n == m
    - trade-offs --> hashmap overhead is slower than basic array functions
    - arrays are more readable lolz
    - mine better space wise
    
**/