package mytest;

public class Tested {
    public static int method(int val) {
        return 5 * val;
    }

    public static void main(String[] args) {
        int val = method(5);
        System.out.println(val);
    }
}
