package leetcode;

/*
斐波那契数列
1 1 2 3 5 8 .....
*/
public class Test8 {
    public static void main(String[] args) {

        int sum = new Test8().sum(6);
        System.out.println(sum);
    }

    public int sum(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return sum(n - 1) + sum(n - 2);
        }
    }
}
