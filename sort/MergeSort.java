package sort;

/**
 * Created by pinak on 15-03-2019.
 */
public class MergeSort {

    public static void sort(int[] a, int low, int high){
        int N = high - low;

        if (N ==1)
            return;

        int mid = low + N/2;

        sort(a, low, mid);
        sort(a, mid, high);

        int[] temp = new int[N];
        int i= low;
        int j = mid;

        for (int k=0;k<N;k++){
            if (i == mid)
                temp[k] = a[j++];
            else if (j == high)
                temp[k] = a[i++];
            else if (a[i] < a[j])
                temp[k] = a[i++];
            else
                temp[k] = a[j++];
        }

        for (int k=0;k<N;k++)
            a[low + k] = temp[k];


    }


    public static void main(String[] args) {
        int[] a = {1,13,2,9,79,83,11,5};

        MergeSort.sort(a,0,a.length);

        for(int i:a){
            System.out.println(i + "-");
        }
    }


}
