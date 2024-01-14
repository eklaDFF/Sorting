public class Main {
    public static void main(String[] args) {

        System.out.println("-------------------Example for Bubble Sort-----------------");
        int[] arr = {45,67,33,42,90,23,-9};
        BubbleSort(arr);

        for (int n : arr){
            System.out.print(n + ",");
        }
    }
    public static void BubbleSort(int[] arr){
        for(int i= arr.length-2;i>=0;i--){
            for (int j=0;j<=i;j++){
                if (arr[j]>arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }
}