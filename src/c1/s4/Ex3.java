package c1.s4;

import edu.princeton.cs.algs4.*;

public class Ex3 {

    private static final int MAXIMUM_INTEGER = 1000000;

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        int ignore = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void drawStandard() {
        int P = 6;
        int N = 250;
        StdDraw.setXscale(0, N * Math.pow(2, P-1));
        StdDraw.setYscale(0, 50);
        double LT = 0;
        for (int i = 1; i <= P; i++) {
            double T = timeTrial(N);
            StdDraw.point(N, T);
            if (LT > 0) {
                StdDraw.line(N / 2, LT, N, T);
            }
            StdOut.printf("N:%s T:%s %s %s\n", N, T);
            LT = T;
            N *= 2;
        }
    }

    private static double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    public static void drawLogLog() {
        int P = 6;
        int N = 250;
        StdDraw.setXscale(0, Math.log(N * Math.pow(2, P-1)));
        StdDraw.setYscale(-5, Math.log(50));
        double LT = 0;
        for (int i = 1; i <= P; i++) {
            double T = timeTrial(N);
            StdDraw.point(Math.log(N), Math.log(T));
            if (LT > 0) {
                StdDraw.line(Math.log(N / 2), Math.log(LT), Math.log(N), Math.log(T));
            }
            StdOut.printf("N:%s T:%s logN:%s, LogT:%s\n", N, T, Math.log(N), Math.log(T));
            LT = T;
            N *= 2;
        }
    }

    public static void main(String[] args) {
        drawLogLog();
    }
}
