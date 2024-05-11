package oop;

public class ParameterPassing {
    public static void main(String[] args) {
        ParameterPassing parameterPassing = new ParameterPassing();

        //
        int i = 10;
        System.out.println(parameterPassing.example1(i));
        System.out.println(i);

        // 數組的傳參數
        int[] array = {1};
        int result = parameterPassing.example2(array);
        System.out.println(result);
    }

    public int example1(int x) {
        return x += 100;
    }

    public int example2(int[] arr) {
        return arr[0] += 100;
    }
}
