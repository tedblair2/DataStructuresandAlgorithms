package com.company.array.Trie;

public class Trie {
    private TrieNode root;

    public Trie(){
        root=new TrieNode();
    }

    public static class TrieNode{
        TrieNode[] children;
        boolean isWord;

        public TrieNode(){
            this.children=new TrieNode[26];
            this.isWord=false;
        }
    }
    private int getIndex(char letter){
        return letter-'a';
    }
    private void insertWord(String word){
        TrieNode current=root;
        word=word.toLowerCase();
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            int index=getIndex(c);
            if (current.children[index]==null){
                TrieNode node=new TrieNode();
                current.children[index]=node;
                current=node;
            }else {
                current=current.children[index];
            }
        }
        current.isWord=true;
    }

    public static void main(String[] args){
        Trie trie=new Trie();
        trie.insertWord("ted");
        trie.insertWord("cup");
        trie.insertWord("cat");

    }
}
