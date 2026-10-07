/*
 * Question from the lab manual:
 * Challenge: Implement a generic bubbleSort method with a bounded type parameter.
 */
package lab08;
public class Exercise5 {
    static <T extends Comparable<T>> void bubbleSort(T[] a){for(int end=a.length-1;end>0;end--)for(int i=0;i<end;i++)if(a[i].compareTo(a[i+1])>0){T x=a[i];a[i]=a[i+1];a[i+1]=x;}}
    // Explanation: The Comparable bound guarantees that every array element supports compareTo during sorting.
    public static void main(String[] args){Integer[] values={4,1,3,2};bubbleSort(values);System.out.println(java.util.Arrays.toString(values));}
}

