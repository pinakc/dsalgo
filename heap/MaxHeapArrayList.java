package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Maximum Heap implementation using ArrayList
 * Created by infernus on 3/21/2019.
 * https://www.youtube.com/watch?v=LhhRbRXhB40
 * https://www.youtube.com/watch?v=W81Qzuz4qH0
 */
public class MaxHeapArrayList<T extends Comparable> {

    List<T> a = new ArrayList<T>();


    public void insert(T x) {
        a.add(x);
        shiftUp();
    }

    private void shiftUp() {
        int k = a.size() - 1;
        while(k>0){
            int p = (k - 1)/2;
            T item = a.get(k);
            T parent = a.get(p);
            if(item.compareTo(parent) > 0){
                //swap elements
                a.set(p, item);
                a.set(k, parent);
                k = p;
            } else {
                break;
            }
        }
    }

    public T delete() throws NoSuchElementException {
        if (a.size() ==0 ) { // empty heap
            throw new NoSuchElementException();
        } else if (a.size() == 1){ // only 1 element in heap
            return a.remove(0);
        }

        T hold = a.get(0); // first element always pops
        a.set(0, a.remove(a.size()-1)); // place last element in place of first
        shiftDown(); // compare and shift down
        return hold;
    }

    private void shiftDown() {
        int k = 0;
        int left = 2*k+1;

        while (left < a.size()) {
            int max = left;
            int right = left + 1;

            if (right < a.size()){ // right child exists
                if (a.get(left).compareTo(a.get(right)) < 0){
                    max = right;
                }
            }

            if (a.get(k).compareTo(a.get(max)) < 0 ){
                // swap k and max posn
                T temp = a.get(max);
                a.set(max, a.get(k));
                a.set(k, temp);

                k = max;
                left = 2*k + 1;
            } else {
                break;
            }

        }
    }

    public boolean isEmpty(){
        return a.isEmpty();
    }

    public int size(){
        return a.size();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (T element: a){
            sb.append(element.toString() + " ");
        }
        return sb.append(" ]").toString();
    }

    public static void main(String[] args) {
        MaxHeapArrayList<Integer> hp = new MaxHeapArrayList<>();
        hp.insert(15);
        hp.insert(10);
        hp.insert(9);
        hp.insert(6);
        hp.insert(3);
        hp.insert(8);
        hp.insert(9);
        hp.insert(12);
        hp.insert(4);
        hp.insert(2);

        while (!hp.isEmpty()) {
            int max = hp.delete();
            System.out.println(max + " " + hp);
        }
    }


}
