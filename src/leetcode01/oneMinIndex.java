package leetcode01;

import javax.sound.midi.Soundbank;

public class oneMinIndex {

    public static int oneMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return - 1;
        }

        int N = arr.length;
        if (N == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 0;
        int R = N - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] < arr[mid - 1] && arr[mid] < arr[mid+1]) {
                ans = mid;
                break;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                }else {
                    if(arr[mid] > arr[mid - 1]) {
                        R = mid - 1;
                    }else {  // arr[mid] > arr[mid+1]

                    }

                }
            }

            if(arr[mid] > arr[mid - 1]) {
                R = mid - 1;
                continue;
            }
            if(arr[mid] > arr[mid + 1]) {
                L = mid + 1;
                continue;
            }


        }

        return ans;
    }

    public static int[] randomArray(int maxLen, int maxValue){
        int len = (int)(Math.random() * maxLen);
        int[] arr = new int[len];
        if(len > 0){
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++){
                do{
                    arr[i] = (int) (Math.random() * maxValue);
                }while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    public static boolean check(int[] arr, int minIndex){
        if(arr.length == 0){
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left]> arr[minIndex]: true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex]: true;
        return leftBigger && rightBigger;
    }

    public static void printArray(int[] arr){
        for(int num: arr){
            System.out.println(num + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 1000000;
        System.out.println("the test is begin");
        for (int i = 0; i < testTime; i++){
            int[] arr = randomArray(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr, ans)){
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("test is end");
    }


}

