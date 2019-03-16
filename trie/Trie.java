package trie;

/**
 * Created by pinak on 16-03-2019.
 */
public class Trie {

    final static int alphabet_size = 26;

    class Node {
        Node[] children = new Node[alphabet_size];
        boolean isEnd;
    }

    Node root = new Node();


    public int getIndex(char c) {
        return  c - 'a';
    }

    public void add(String s) {

        Node current = root;
        for(int i=0;i<s.length();i++) {
            if(current.children[getIndex(s.charAt(i))] == null)
                current.children[getIndex(s.charAt(i))] = new Node();

            current = current.children[getIndex(s.charAt(i))];
        }
        current.isEnd = true;
    }

    public void delete(String s){
        Node current = root;
        for(int i=0;i<s.length();i++) {
            if(current.children[getIndex(s.charAt(i))] == null)
                return;

            current = current.children[getIndex(s.charAt(i))];
        }
        current.isEnd = false;

    }

    public boolean find(String s){
        Node current = root;
        for(int i=0;i<s.length();i++) {
            if(current.children[getIndex(s.charAt(i))] == null)
                return false;

            current = current.children[getIndex(s.charAt(i))];
        }
        return current.isEnd;
    }


    public static void main(String[] args) {
        Trie t = new Trie();

        t.add("pinak");
        t.add("pineapple");
        t.add("pinacolada");

        System.out.println(t.find("pinacolada"));
        t.delete("pinacolada");
        System.out.println(t.find("pinacolada"));
        System.out.println(t.find("pinak"));
        System.out.println(t.find("pina"));

    }
}
