class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String word : strs)
        {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); //chars gets sorted then casted to String to be used as a key

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
