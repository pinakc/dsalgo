package hashing;

/**
 * Created by infernus on 3/16/2019.
 */
public class HashClass {

    final static int M = 10000;

    public int hashNumber(int number) {
        return Math.abs(number % M);
    }

    public int hashString(String s){
        long hash = 5381l;
        for(int i=0;i<s.length();i++) {
            hash = 31 * s.charAt(i) + hash;
            hash = hash % M;
        }
        return (int)Math.abs(hash);
    }
}
