package com.datastructures.tries;

/**
 * Created by chandrashekar.v on 4/25/2017.
 */
public class ContactList {

    public static void main(String[] args) {
        Node trie = new Node();
        trie.addWord("Netajinagar");
        trie.addWord("Tushnabad");
        trie.addWord("Uttara");
        trie.addWord("Vivekandapur");
        trie.addWord("Wandoor");
        trie.addWord("Weby");
        trie.addWord("Aerial Bay");
        trie.addWord("Beodnabad");
        trie.addWord("Bimbiton");
        trie.addWord("Brijgunj");
        trie.addWord("Calicut");
        trie.addWord("Champin");
        trie.addWord("Chouldari");
        trie.addWord("Chowra");

        //trie.wordsByPrefix("cho");


    }
    public static class Node {
        public static final int NUMBER_OF_CHARACTERS = 26;
        Node[] children = new Node[NUMBER_OF_CHARACTERS];
        int size = 0;

        private static int getCharIndex(char c) {
            return c - 'a';
        }

        private Node getNode(char c) {
            return children[getCharIndex(c)];
        }

        private void setNode(char c, Node node) {
            children[getCharIndex(c)] = node;
        }

        public void addWord(String s) {
            add(s, 0);
        }

        private void add(String s, int index) {
            size++;
            if (index == s.length())
                return;
            char current = s.charAt(index);
            Node child = getNode(current);
            if (child == null) {
                child = new Node();
                setNode(current, child);
            }
            child.add(s, index + 1);
        }

        public int findCount(String s, int index) {
            if (index == s.length())
                return size;

            Node child = getNode(s.charAt(index));
            if (child == null)
                return 0;
            return child.findCount(s, index + 1);
        }
    }
}
