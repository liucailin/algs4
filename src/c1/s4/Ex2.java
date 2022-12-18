package c1.s4;

import edu.princeton.cs.algs4.StdOut;

import java.math.BigInteger;

/**
 * 修改ThreeSum，正确处理两个较大的int相加可能溢出的情况
 */
public class Ex2 {

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        BigInteger bigInteger;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    bigInteger = BigInteger.valueOf(a[i]);
                    bigInteger = bigInteger.add(BigInteger.valueOf(a[j]));
                    bigInteger = bigInteger.add(BigInteger.valueOf(a[k]));
//                    if (a[i] + a[j] + a[k] == 0) {
//                    if (a[i] == -a[j] - a[k]) {
                    if (bigInteger.intValue() == 0) {
                        count++;
                        StdOut.printf("%s %s %s\n", a[i], a[j], a[k]);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] a = new int[] {
                Integer.MAX_VALUE, 1, Integer.MIN_VALUE, 2, -3
        };
        StdOut.printf("count:%d\n", count(a));
    }
}
