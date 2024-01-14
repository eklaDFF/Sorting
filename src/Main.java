public class Main {
    public static void main(String[] args) {

        System.out.println("-------------------Example for Bubble Sort-----------------");
        int[] arr = {45,67,33,42,90,23,-9};
        BubbleSort(arr);

        for (int n : arr){
            System.out.print(n + ",");
        }



        System.out.println("\n-------------------Example for Selection Sort-----------------");
        int[] arrSelection = {45,67,33,42,90,23,-9};
        SelectionSort(arrSelection);

        for (int n : arrSelection){
            System.out.print(n + ",");
        }



        System.out.println("\n-------------------Example for Insertion Sort-----------------");
        int[] arrInsertion = {45,67,33,42,90,23,-9};
        InsertionSort(arrInsertion);

        for (int n : arrInsertion){
            System.out.print(n + ",");
        }



        System.out.println("\n-------------------Example for Shell Sort-----------------");
        int[] arrShell = {45,67,33,42,90,23,-9};
        ShellSort(arrShell);

        for (int n : arrShell){
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

    public static void SelectionSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            int indexOfMinimumNumber = i;
            for (int j = i; j< arr.length; j++){
                if (arr[j]<arr[indexOfMinimumNumber]){
                    indexOfMinimumNumber = j;
                }
            }

            int minimumNumber = arr[indexOfMinimumNumber];
            arr[indexOfMinimumNumber] = arr[i];
            arr[i] = minimumNumber;
        }
    }

    public static void InsertionSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            for (int j=i;j>0;j--){
                if (arr[j]<arr[j-1]){
                    int t = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = t;
                }else {
                    break;
                }
            }
        }
    }

    public static void ShellSort(int[] arr){
        int gap;
        gap = (arr.length)/2;
        while (gap>=1){
            for (int i=gap;i<arr.length;i+=gap){
                for (int j=i;j>0;j-=gap){
                    if (arr[j]<arr[j-gap]){
                        int t = arr[j];
                        arr[j] = arr[j-gap];
                        arr[j-gap] = t;
                    }else {
                        break;
                    }
                }
            }
            gap/=2;
        }

        //When the gap becomes 1
//        InsertionSort(arr);
    }
}