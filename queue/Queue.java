package queue;

/**
 * Created by pinak on 16-03-2019.
 */
public class Queue {
    int size;
    int[] a;
    int count;

    int front=-1,rear = -1;

    public Queue(int size) {
        this.size = size;
        this.a = new int[size];
        this.count = 0;
    }

    public void add(int x) {
        if (rear == size){
            System.out.println("Array limit reached");
            return;
        }
        a[++rear] = x;
        count++;
    }

    public int pop() {
        int t = a[++front];
        a[front] = 0;
        count--;
        return t;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public boolean isFull(){
        return (rear == size-1);
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        System.out.println(q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.isFull());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.isEmpty());
    }
}
