package leetcode;

//13.给一个数转成2的次幂  3->4  10->16   0->1  7->8
public class Test13 {
    public static void main(String[] args) {
        //int i = tableSizeFor(10);
        //int i = highestOneBit(10);
        int i = roundUpToPowerOf2(10);
        System.out.println(i);
    }

    public static int highestOneBit(int i) {
        // HD, Figure 3-1
        i |= (i >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
    }

    private static int roundUpToPowerOf2(int number) {
        return number >= ((1 << 30))
                ? ((1 << 30))
                : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
    }
}
