/******************************************************************************************************************************************************
--------------------
Level-Medium
Question No- 211
----------------------------
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.'
where dots can be matched with any letter.
 
---------------------------------------------------------------------------------------

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class TrieNode {
    TrieNode[] children;
    boolean isWordCompleted;

    TrieNode() {
        children = new TrieNode[26];
        isWordCompleted = false;
    }
}

class WordDictionary {
    TrieNode root;

    WordDictionary() {
        root = new TrieNode();
    }
    
    void addWord(String word) {
        TrieNode newRoot = root;
        for (char ch : word.toCharArray()) {
            int alphabetIndex = ch - 'a';
            if (newRoot.children[alphabetIndex] == null) {
                newRoot.children[alphabetIndex] = new TrieNode();
            }
            newRoot = newRoot.children[alphabetIndex];
        }
        newRoot.isWordCompleted = true;
    }
    
    boolean searchHelper(String word, int index, TrieNode newRoot) {
        if (index == word.length())
            return newRoot.isWordCompleted;
        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (newRoot.children[i] != null && searchHelper(word, index + 1, newRoot.children[i])) {
                    return true;
                }
            }
            return false;
        }
        else {
            if (newRoot.children[ch - 'a'] == null) {
                return false;
            }
            return searchHelper(word, index + 1, newRoot.children[ch - 'a']);
        }
    }

    boolean search(String word) {
        return searchHelper(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
