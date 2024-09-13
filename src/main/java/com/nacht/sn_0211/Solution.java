package com.nacht.sn_0211;

/**
 * @author Nacht
 * Created on 2024/9/13 18:11
 */
public class Solution {
    public static class WordDictionary {
        class Trie {
            class Node{
                char val;
                Node[] nextNodes;
                boolean isWord;
                Node(){
                    isWord = false;
                    /*题目规定了只有小写的英文字母, 我们只需要26长度的数组*/
                    this.nextNodes = new Node[26];
                }
                Node(char val){
                    this();
                    this.val = val;
                }
            }
            private Node root;
            public Trie() {
                /*我们初始化一个空白的根节点*/
                root = new Node();
            }

            public void insert(String word) {
                char[] arr = word.toCharArray();
                Node current = root;
                /*循环插入到trie树中*/
                for (int i = 0; i < arr.length; i++) {
                    char c = arr[i];
                    int idx = c - 'a';
                    if (current.nextNodes[idx] == null) current.nextNodes[idx] = new Node(c);
                    current = current.nextNodes[idx];
                }
                current.isWord = true;
            }

            public boolean search(String word) {
                return search(word, root, 0);
            }

            private boolean search(String word, Node root, int i) {
                if (i == word.length()){
                    return root.isWord;
                }
                char current = word.charAt(i);
                /*当前为字母, 判断当前字符是否存在, 然后直接搜索下一个字符就好了*/
                if (Character.isLetter(current)){
                    int idx = current - 'a';
                    if (root.nextNodes[idx] == null) return false;
                    return search(word, root.nextNodes[idx], i + 1);
                }else{
                    for (char c = 'a'; c <= 'z'; c++){
                        int idx = c - 'a';
                        if (root.nextNodes[idx] == null) continue;
                        if (search(word, root.nextNodes[idx], i + 1)) return true;
                    }
                    return false;
                }
            }

        }

        private Trie tree;
        public WordDictionary() {
            tree = new Trie();
        }

        public void addWord(String word) {
            tree.insert(word);
        }

        public boolean search(String word) {
            return tree.search(word);
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search("b..d"));
    }
}
