package base;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = getArray();
//        System.out.print("創建後的數組是： ");
//        display(arr); // 展示創建的數組
//        System.out.println("\t");
//        demo1();
//        demo2();
//        max();
//        swap(10,20);
//        reverseArray(arr);
//        int[] copyArray = copyArray(arr);
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
//        System.out.println("注意下方，測試Arrays的方法\t");
//        testArrayMethod(arr);
        MultipleArrays();
    }

    // 多維數組的創建
    public static void MultipleArrays() {
        int[][] arr1 = new int[3][3];

        int[][] arr2 = new int[3][];
        arr2[0] = new int[1];
        arr2[1] = new int[2];
        arr2[2] = new int[3];
        System.out.println(Arrays.toString(arr2));
    }

    // 學習Arrays的常用方法
    public static void testArrayMethod(int[] arr) {
        System.out.println("排序之前： " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("排序之後： " + Arrays.toString(arr));
        // 複製整個數組
        int[] copyArray = Arrays.copyOf(arr, arr.length);
        copyArray[0] = 1000;
        System.out.println("原始數組： " + Arrays.toString(arr));
        System.out.println("複製之後： " + Arrays.toString(copyArray));
        // 搜索1000數值的位置
        Arrays.sort(copyArray);
        System.out.println("排序後的數組是： " + Arrays.toString(copyArray));
        System.out.println("搜索1000的位置是： " + Arrays.binarySearch(copyArray, 1000));
        // 比較兩個Object
        Integer[] integerArray = {1, 3, 5, 7, 9}; // 創建新的物件，並且物件是只包含整數的數據類型的
        System.out.println("數組1是： " + Arrays.toString(integerArray));
        Integer[] integerArray2 = {1, 3, 5, 7, 9};
        System.out.println("數組2是： " + Arrays.toString(integerArray2));
        // deepEqauls 是比較數組的內容是否一致，支持多層級的數組
        System.out.println("使用deepEquals,比較兩個數組1和2，結果是： " + Arrays.deepEquals(integerArray2, integerArray));
        System.out.println("使用Equals，比較兩個數組1和2，結果是： " + Arrays.equals(integerArray2, integerArray));
        // 填充數組的值
        Arrays.fill(arr, 888);
        System.out.println("填充自己規定的值" + Arrays.toString(arr));
    }

    // 插入排序的核心思想是從大到小的排序，
    public static void insertionSort(int[] arr) {
        int insertItem; // 要插隊的元素
        int insertIndex; // 要插隊的位置
        for (int i = 1; i < arr.length; i++) {
            insertItem = arr[i]; // 默認插隊值就是第一個值
            insertIndex = i; // 默認待在自己的位置
            for (int j = i - 1; j >= 0; j--) {
                if (insertItem > arr[j]) {
                    arr[j + 1] = arr[j]; // 元素往後移一位
                    insertIndex = j;
                } else {
                    // 如果發現自己與最近的元素少，直接跳出循環
                    break;
                }
            }
            // 經過內循環的操作，可以確定插隊的位置，進行插隊了
            // insertIndex 和 i 不相等的話，就需要數據交換了
            if (insertIndex != i) {
                arr[insertIndex] = insertItem; // 數據交換
            }
        }
        System.out.println("插入排序後的數組，結果是： ");
        display(arr);
    }

    // 選擇排序的核心思想：每次選擇值最小的元素的索引，然後交換數據
    public static void selectionSort(int[] arr) {
        // 為了避免最後一個元素重複比較，所以排序的範圍需要-1，變成arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            // 假設i就是最小元素的索引
            int minIndex = i;
            // 因此通過內循環來找出最小元素的索引
            // 1. 一開始，內循環的索引j直接變成i，為了減少與自己比較，索引j應該j + 1，從而提高循環的效率
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // minIndex 和 i 不相等，說明最小索引的元素已經改變了，那麼就可以交換數據的環節了
            if (minIndex != i) {
                arr[minIndex] = arr[minIndex] ^ arr[i];
                arr[i] = arr[minIndex] ^ arr[i];
                arr[minIndex] = arr[minIndex] ^ arr[i];
            }
        }
        System.out.println("選擇排序後的數組，結果是： ");
        display(arr);
    }

    // 冒泡排序的核心思想：兩兩相鄰比較，然後交換數據
    // 排序的順序可以由大到少，或者由小到大
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
        System.out.println("冒泡排序後的數組，結果是： ");
        display(arr);
    }


    public static int[] copyArray(int[] arr) {
        int[] newArr = new int[arr.length];
//        int[] na = arr // 只是簡單指向堆中的數組的位置，並沒有做到複製的效果
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    // 隨機生成5個整數（0-100）
    public static int[] getArray() {
        int length = 5;
        int[] scores = new int[length];
        for (int i = 0; i < length; i++) {
            scores[i] = (int) (Math.random() * 100);
        }
        return scores;
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " \t");
        }
    }

    //將數組中的數值進行頭尾交換
    public static void reverseArray(int[] arr) {
        display(arr);
        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            swap(arr[i], arr[j]); // Why does not work?
//            if (arr[i] != arr[j]){
//                arr[i] = arr[i] ^ arr[j];
//                arr[j] = arr[i] ^ arr[j];
//                arr[i] = arr[i] ^ arr[j];
//            }
        }
        System.out.println();
        display(arr);
    }

    public static void swap(int x, int y) {
        // method 1
//        int temp; // 定義一個臨時變量
//        temp = x;
//        x = y;
//        y = temp;

        // method 2: 加減法
//        x = x + y;
//        y = x - y;
//        x = x - y;

        // method 3: 異或，位運算符，不能交換相同數值。但是，效率最高的
        if (x != y) {
            x = x ^ y;
            y = x ^ y;
            x = x ^ y;
        }

//        System.out.println(x + " , " + y);
    }

    // 求最大值
    public static void max() {
//        System.out.println(Math.random()); // [0, 1)的double數字
        // 產生[1, 100]的隨機數, int類型
        System.out.println((int) (Math.random() * 100) + 1);
        int[] arr = {1000, 900, 800, 700, 600};
    }

    // Get the average mark and sum of marks of 5 students in an exam
    // 利用數組來做求和和求平均分的數據操作
    public static void demo2() {
        int[] arr = {80, 67, 75, 90, 87};
        // 求總和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("總分： " + sum);
        // 求平均分
        int avg = sum / arr.length;
        System.out.println("平均分： " + avg);
    }

    public static void demo1() {
        int[] a1 = new int[]{1, 2, 3, 4, 5};
        int[] a2 = {1, 3, 5, 7, 9};
        //System.out.println(a1); //[I@36baf30c是數組的內存地址

        int[] a3 = new int[5]; //在Java的數組中，必須指定長度
        // a3的所有元素都是以數據類型的默認值填充
        // 遍歷數組
        for (int i = 0; i < a3.length; i++) {
            System.out.println(a3[i]);
        }
        // 數組的元素位置，有一個專業名稱叫索引
        // 索引是從0開始的，索引的最後一個位置是索引的長度-1。[0, length - 1]
        // 獲取數組的長度，數組名稱.length
        // 索引超出了範圍，就會引起了數組索引越界異常，英文名是ArrayIndexOutOfBoundException

        int[] a4 = null; //a4被初始化為null
        a4[0] = 10; //如果a4沒有被初始化或者被初始化為null，那麼會報空指針異常，NullPointerException
    }
}
