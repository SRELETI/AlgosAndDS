public class RecursiveInsertionSort {
    static int[] arr = {5, 2, 4, 6, 1, 3};
    int maxIndex = arr.length;

    public static void main(String[] args) {
        print(arr);
        new RecursiveInsertionSort().sort(arr.length);
    }

    /*
      The sorting function uses 'index' instead of 'copying the array' in each    
      recursive call to conserve memory and improve efficiency.
    */
    private int sort(int maxIndex) {
        if (maxIndex <= 1) {
            // at this point maxIndex points to the second element in the array.
            return maxIndex;
        }

        maxIndex = sort(maxIndex - 1);  // recursive call

        // save a copy of the value in variable 'key'.
        // This value will be placed in the correct position
        // after the while loop below ends.
        int key = arr[maxIndex];  

        int i = maxIndex - 1;

        // compare value in 'key' with all the elements in array 
        // that come before the element key. 
        while ((i >= 0) && (arr[i] > key)) {
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = key;
        print(arr);
        return maxIndex + 1;
    }

    // code to print the array on the console.
    private static void print(int[] arr) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}