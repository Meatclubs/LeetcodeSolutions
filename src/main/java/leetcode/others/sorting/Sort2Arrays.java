package main.java.leetcode.others.sorting;

public class Sort2Arrays {

    public static int[] merge(int[] A, int[] B) {
        int indexToInsertInto = A.length-1;
        int indexA = A.length-B.length - 1;
        int indexB = B.length - 1;

        while(indexA >= 0 && indexB >= 0) {
            if(A[indexA] > B[indexB]) {
                A[indexToInsertInto] = A[indexA];
                indexA--;
            } else {
                A[indexToInsertInto] = B[indexB];
                indexB--;
            }
            indexToInsertInto--;

            if(indexA < 0) {
                //move all remaining B into A
                for(int j = indexToInsertInto; j> 0; j--) {
                    A[j] = B[indexB];
                    indexB--;
                }
                break;
            }
        }
        return A;
    }
}