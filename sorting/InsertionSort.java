class Solution {
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = i;
            int prev = i - 1;

            while (prev >= 0) {
                if (arr[prev] <= arr[curr]) {
                    break;
                }
                int temp = arr[curr];
                arr[curr] = arr[prev];
                arr[prev] = temp;
                curr = prev;
                prev = curr - 1;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 23, 1, 10, 5, 2 };
        arr = insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
