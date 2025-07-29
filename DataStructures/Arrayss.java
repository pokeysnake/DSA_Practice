import java.util.Arrays;

class Arrayss {
    public static void main(String[] args)
    {
        System.out.println("Hello world");

        //int [] nums = {1,2,3,4,5,6,8,9,10};

        int[] nums = {4,2,7,1,3,6,5};

        //QUESTION: find second largest num without sorting
        //one pass allowed

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums.length == 1)
                System.out.println("First and only: " + nums[0]);
            
            
            if(first < nums[i])                                 //checks new max
            {
                second = first;
                first = nums[i];                                //makes first (highest)
            } else if(second < nums[i] && nums[i] < first)      //checks if new 2nd place 
            {
                 second = nums[i];                              //makes 2nd place
            }
                
        }
        
        System.out.println("First and Second: " + first + " " + second);

        //QUESTION: Determine if the array has dupes
        int[] nums_DUPE = {1, 3, 4, 2, 5, 3, 6};
        boolean hasDupe = false;
        for(int i = 0; i < nums_DUPE.length; i++)
        {
            for(int j = i + 1; j < nums_DUPE.length; j++)
            {
                if(nums_DUPE[i] == nums_DUPE[j])
                {
                  hasDupe = true;
                  break;  
                }
                    
            }
            if(hasDupe) break;
        }
        System.out.println("Has Dupes: " + hasDupe);


        //QUESTION: Find the most frequent number
        int[] nums_Freq = {5, 3, 1, 3, 3, 2, 5, 1, 3};
        int [] unique = new int[nums_Freq.length];
        int [] counts = new int[nums_Freq.length];
        int uniqueCount = 0;
        for(int i = 0; i < nums_Freq.length; i++)
        {
            boolean isUnique = true;
            for(int j = 0; j < uniqueCount; j++)
            {
                if(nums_Freq[i] == unique[j])
                {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique){                               //basically creating a hashmap out of 2 arrays where the key is the number and the value is the count of frequency 
                unique[uniqueCount] = nums_Freq[i];     //inserts the unique num into array
                uniqueCount++;                          //increments uniqueCount by 1 to match the index of each unique number
            }
        }

        //Counts frequency
        for(int i = 0; i < nums_Freq.length; i++)
        {
            for(int j = 0; j < uniqueCount; j++)
            {
                if(nums_Freq[i] == unique[j])
                {
                    counts[j]++;
                    break;
                }
            }
        }
        
        //Finds frequency
        int maxCount = 0;
        int maxIndex = 0;
        for(int i = 0; i < counts.length; i++)
        {
            if(counts[i] > maxCount)
            {
                maxCount = counts[i];
                maxIndex = i;
            }
        }
        System.out.println("Most frequent number: " + unique[maxIndex]);


        //QUESTION: Move all ZEROES to the END, while maintaining relative order of non-zero elements
        int[] move_zero = {0, 1, 0, 3, 12};
        int nonZero = 0;
        for(int i = 0; i < move_zero.length; i++)
        {
            if(move_zero[i] != 0)
            {
                move_zero[nonZero] = move_zero[i];          //sending the nonzero numbers to the front(nonZero intialized at 0)
                nonZero++;                                  //increment the index by 1
            }
        }

        for(int i = nonZero; i < move_zero.length; i++)
        {
            move_zero[i] = 0;
        }

        System.out.println(Arrays.toString(move_zero));

        //QUESTION: Reverse the Array in place
        int[] reverse = {1, 2, 3, 4, 5};
        int start = 0;                                  //2 pointer iteration tech
        int end = reverse.length - 1;
        while(start < end)
        {
            int temp = reverse[start];                  //classic temp variable swap
            reverse[start] = reverse[end];
            reverse[end] = temp;
            start++;
            end--;
        }

        System.out.println(Arrays.toString(reverse));























    }
}

