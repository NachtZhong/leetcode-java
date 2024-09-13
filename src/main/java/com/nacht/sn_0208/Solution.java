package com.nacht.sn_0208;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/9/13 17:41
 */
public class Solution {
    class Trie {
        class Node{
            char val;
            Map<Character, Node> nextNodes;
            boolean isWord;
            Node(){
                isWord = false;
                this.nextNodes = new HashMap<>(32);
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
                current.nextNodes.computeIfAbsent(c, k -> new Node(c));
                current = current.nextNodes.get(c);
            }
            current.isWord = true;
        }

        public boolean search(String word) {
            char[] arr = word.toCharArray();
            Node current = root;
            /*循环查找每一个节点*/
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                /*某个字符匹配不上, 就直接返回false, 匹配上了就继续匹配下一个字符*/
                if (!current.nextNodes.containsKey(c)){
                    return false;
                }else{
                    current = current.nextNodes.get(c);
                }
            }
            /*最后一个节点必须是word的结尾, 才说明之前有插入过这个字符串*/
            return current.isWord;
        }

        public boolean startsWith(String prefix) {
            char[] arr = prefix.toCharArray();
            Node current = root;
            /*循环查找每一个节点*/
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                /*某个字符匹配不上, 就直接返回false, 匹配上了就继续匹配下一个字符*/
                if (!current.nextNodes.containsKey(c)){
                    return false;
                }else{
                    current = current.nextNodes.get(c);
                }
            }
            /*最后一个节点必须是word的结尾, 才说明之前有插入过这个字符串*/
            return true;
        }
    }
}
