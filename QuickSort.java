//program to implement Quick Sort
import java.util.Scanner;

public class QuickSort {
      public static void quicksort(int[] arr, int low, int high) {
            if (low < high) {
                  int pivotindex = partition(arr, low, high);
                  quicksort(arr, low, pivotindex - 1);
                  quicksort(arr, pivotindex + 1, high);
            }
      }

      public static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                  if (arr[j] < pivot) {
                        i++;
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                  }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
      }

      public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter no of elements:");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.print("Enter elements of the array:");
            for (int i = 0; i < arr.length; i++)
                  arr[i] = sc.nextInt();
            quicksort(arr, 0, arr.length - 1);
            System.out.print("Sorted array:");
            for (int i = 0; i < arr.length; i++)
                  System.out.print(arr[i] + "    ");
      }
}
