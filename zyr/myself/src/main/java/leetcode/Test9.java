package leetcode;

/*
走台阶 一次可以走1个台阶或者2个台阶 走n个台阶有多少种走法
 */
public class Test9 {
    public static void main(String[] args) {
        int shift = new Test9().shift(5);
        System.out.println(shift);
    }

    /*f(n)表示n个台阶的走法
     * 先走了1个台阶,剩下n-1个台阶的走法是f(n-1)
     * 先走了2个台阶,剩下n-2个台阶的走法是f(n-2)
     * f(n)=f(n-1)+f(n-2)*/
    public int shift(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return shift(n - 1) + shift(n - 2);
    }
}
