class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // 1
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1); //same as map.merge(n, 1, Integer::sum)
        }

        // 2
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        // 3
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            // poll() first then getKey() gets the key of whatever is saved from poll(), then we finally add that to result
            result.add(maxHeap.poll().getKey()); 
        }

        // 4
        int[] answer = new int[k];
        for(int i = 0; i < k; i++)
        {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
/**
    PROCESS:
    series of passes
    
    1: getting the counts
        - hashmap iteration with getordefault
    
    2: create the PriorityQueue (we want maxHeap)
        - PriorityQueue<Map.Entry<Integer, Integer>> 
        - new PriorityQueue<>((a,b) -> b.val - a.val) 
            - doing b - a creates a max heap
            - a-b as default is a min heap
        - maxHeap.addAll(countMap.entrySet())
    
    3: pop the top k elements 
        - iterate
        - result.add(max.poll.getKey)
    
    4: cast list<int> to array

    return result
**/