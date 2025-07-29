import java.util.HashMap;

public class HashMapImplementation {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("apple", 3);
        map.put("banana", 4);
        map.put("orange", 5);
        map.put("pear", 6);

        //Printing the map is easy
        System.out.println(map);

        //.get(key) --> returns the value of the key in a key-value pair
        System.out.println(map.get("apple"));


        //.containsLey(key) checks existence boolean 
        System.out.println(map.containsKey("apple"));

        //.remove --> removes the entry of a key-value pair but returns the value 
        int removed = map.remove("apple");
        System.out.println("Removing apple and display its return (3): " + removed);
        System.out.println(map);
    }

    /**
     * NOTE: IMPLEMENTATION BELOW IS FOR INT TYPES --> TYPICALLY GENERIC
     * IF GENERIC: REPLACE INT KEY / INT VALUE WITH K KEY AND V VALUE EVERYWHERE THAT IT IS 
     * WOULD ALSO BE PRIVATE ENTRY<K,V>[] BUCKETS 
     * NEXT TO ENTRY WOULD HAVE TO SPECIFY IT IS GENERIC --> ENTRY variable_name --> ENTRY<K, V> variable_name 
     * WHEREEVER ENTRY IS WITH CREATION OF A NEW ENTRY --> ENTRY(KEY,VALUE) --> ENTRY<>(KEY,VALUE)
     */


    class Entry{
        int key;
        int value;
        Entry next;

        public Entry(int key, int value)
        {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    class myHashMap
    {
        private Entry[] buckets;                                        //EACH ELEMENT IN THIS ARRAY IS A 'BUCKET'
        private int size = 1000;

        public myHashMap()
        {
            buckets = new Entry[size];
        }

        private int getIndex(int key)                                   //HASH FUNCTION DETERMINES WHICH BUCKET TO PLACE A KEY INTO 
        {
            return key % size;                                          //IF GENERIC USE --> Math.abs(key.gethashCode() % size)
        }

        //PUT IMPLEMENTATION
        /**
         * IF BUCKET IS EMPTY --> CREATE A NEW NODE
         * IF KEY ALREADY EXISTS --> UPDATE THE VALUE 
         * IF THE KEY DOESNT EXIST BUT THE BUCKET IS OCCUPIED --> ADD TO END OF THE LIST 
         */
        public void put(int key, int value)                         
        {
            int index = getIndex(key);
            Entry head = buckets[index];

            if(head == null)
            {
                buckets[index] = new Entry(key, value);
                return;
            }

            Entry curr = head;
            while(true)
            {
                if(curr.key == key)
                {
                    curr.value = value;
                    return;
                }

                if(curr.next == null) break;
                curr = curr.next;
            }

            curr.next = new Entry(key, value);
        }

        //GET IMPLEMENTATION
        /**
         * FIND THE CORRECT BUCKET USING THE HASH (key %size get index from hash function)
         * TRAVERSE THE LINKED LIST TO FIND THE NODE WITH THE MATCHING KEY
         * EITHER RETURN VALUE OR -1 IF NOT FOUND 
         */
        public int get (int key)
        {
            int index = getIndex(key);
            Entry curr = buckets[index];

            while (curr != null)
            {
                if (curr.key == key) return curr.value;
                curr = curr.next;
            }

            return -1;
        }

        //REMOVE IMPLEMENTATION
        /**
         * FIND THE BUCKET USIING THE HASH LIKE PREVIOUS FUNCTIONS
         * USE A PREV AND CURR POINTER TO REMOVE THE NODE FROM THE CHAIN 
         */

        public void remove(int key)
        {
            int index = getIndex(key);
            Entry curr = buckets[index];
            Entry prev = null;

            while(curr != null)
            {
                if(curr.key == key)
                {
                    if(prev == null)
                    {
                        buckets[index] = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                    return;
                }
            }
            
        }


    }


}
