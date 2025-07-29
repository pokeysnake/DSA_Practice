import java.util.HashMap;

public class TRIES {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));               //true
        System.out.println(trie.search("app"));                 //false
        System.out.println(trie.startsWith("app"));           //true

        trie.insert("app");
        System.out.println(trie.search("app"));                 //true

        trie.delete("apple");
        System.out.println(trie.search("apple"));               //false
        System.out.println(trie.search("app"));                 //true
    }
}


class TrieNode
{
    HashMap<Character, TrieNode> children = new HashMap<>();                
    boolean isWord = false;
}

class Trie {
    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    //INSERT A WORD INTO THE TRIE
    /**
     * Starts at root
     * for each character in the word --> if it doesnt exist in the current node's children we create a new node (putifabsent new node)
     * move to the new node
     * after the last character, mark the node as the end of a word (isWord = true)
     */
    public void insert(String word)
    {
        TrieNode curr = root;
        for(char c: word.toCharArray())
        {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }

        curr.isWord = true;
    }

    //SEARCH FOR A WORD WITHIN THE TRIE
    /**
     * Go character by character through the trie
     * if you ever can't find a character --> return false
     * at end, return true only if the current characters make a word (isWord == true)
     */
    public boolean search (String word)
    {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(!curr.children.containsKey(c))
            {
                return false;
            }
            curr = curr.children.get(c);
        }

        return curr.isWord;
    }

    //CHECK IF ANY WORD IN THE TRIE STARTS WITH THE PREFIX IN PARAM
    /**
     * same as a search but you dont care if something is a word
     * simply check if you can follow the path of characters (hence starts with)
     */
    public boolean startsWith(String prefix)
    {
        TrieNode curr = root;
        for(char c: prefix.toCharArray())
        {
            if(!curr.children.containsKey(c))
            {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }



    //OPTIONAL DELETE A WORD FROM THE TRIE
    public void delete(String word)
    {
        deleteHelper(root, word, 0);
    }

    //DELETE HELPER
    private boolean deleteHelper(TrieNode node, String word, int index)
    {
        if(index == word.length())
        {
            if(!node.isWord) return false;
            node.isWord = false;
            return node.children.isEmpty();
        }

        char c = word.charAt(index);

        TrieNode child = node.children.get(c);
        if(child == null) return false;

        boolean shouldDeleteChild = deleteHelper(child, word, index + 1);
        if(shouldDeleteChild)
        {
            node.children.remove(c);
            return node.children.isEmpty() && !node.isWord;
        }

        return false;
    }







}