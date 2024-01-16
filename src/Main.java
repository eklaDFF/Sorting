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



        System.out.println("\n-------------------Example for Merge Sort-----------------");
        int[] arrMerge = {45,67,33,42,90,23,-9};
        MergeSort(arrMerge);

        for (int n : arrMerge){
            System.out.print(n + ",");
        }



        System.out.println("\n-------------------Example for Quick Sort-----------------");
        int[] arrQuick = {45,67,33,42,90,23,-9};
        QuickSort(arrQuick,0,arrQuick.length-1);

        for (int n : arrQuick){
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

    public static void MergeSort(int[] arr){
        divide(arr,0,arr.length-1);
    }
    public static void divide(int[] arr,int startIndex,int endIndex){
        if (startIndex>=endIndex){
            return;
        }
        int midIndex = startIndex + (endIndex-startIndex)/2;
        divide(arr,startIndex,midIndex); // Dividing Left Part of the Array
        divide(arr,midIndex+1,endIndex);
        conquer(arr,startIndex,midIndex,endIndex);
    }
    public static void conquer(int[] arr,int startIndex,int midIndex,int endIndex){
        int[] tempArr = new int[endIndex-startIndex+1];

        int i = startIndex; // pointer for 1st part of array
        int j = midIndex+1; // pointer for 2nd part of array
        int k = 0; //to track index of tempArr

        while (i<=midIndex & j<=endIndex){
            tempArr[k++] = (arr[i]>arr[j]) ? arr[j++]:arr[i++];
        }

        while (i<=midIndex){
            tempArr[k++] = arr[i++];
        }

        while (j<=endIndex){
            tempArr[k++] = arr[j++];
        }

        //copying tempArr into original one
        int ii = startIndex;
        for (int a:tempArr){
            arr[ii++] = a;
        }
    }

    public static void QuickSort(int[] arr,int startIndex,int endIndex){
        if (startIndex>=endIndex){
            return;
        }
        int pivotIndex = partition(arr,startIndex,endIndex);

        // Calling the Quick Sort Recursively on left and right side
        QuickSort(arr,startIndex,pivotIndex-1);
        QuickSort(arr,pivotIndex+1,endIndex);
    }
    public static int partition(int[] arr,int startIndex,int endIndex){
        int pivot = endIndex;
        int i = startIndex-1;

        for (int j=startIndex;j<endIndex;j++){
            if (arr[j]<arr[pivot]){
                i++;

                // swapping
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        // putting our pivot at correct position
        i++;
        int t = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = t;
        return i;
    }
}