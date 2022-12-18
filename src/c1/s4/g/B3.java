package c1.s4.g;

/*
For each of the functions shown, give the best order of growth of the running time.
f1 N
f2 N^3      内循环是N^2
f3 2^N      2^N-1
f4 N        1 + 2 + 4 + 8 + 16 + ... 等比数列
f5 N*log(N) 树高log(N)，每层N个操作
 */
public class B3 {
    private static int cf1;
    public static int f1 (int n) {
        int x = 0;
        for (int i = 0; i < n; i++) {
            x++;
            cf1++;
        }
        return x;
    }

    private static int cf2;
    public static int f2(int n) {
        int x = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i*i; j++) {
                x++;
                cf2++;
            }
        return x;
    }

    private static int cf3;
    public static int f3 (int n) {
        cf3++;
        if (n <= 1) return 1;
        return f3(n-1) + f3(n-1);
    }

    private static int cf4;
    public static int f4 (int n) {
        cf4++;
        if (n <= 1) return 1;
        return f4(n/2) + f4(n/2);
    }

    private static int cf5;
    public static int f5 (int n) {
        cf5++;
        if (n <= 1) return 1;
        return f1(n) + f5(n/2) + f5(n/2);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
//        f2(N);
//        f3(N);
        f4(N);
        f5(N);
        System.out.println("f2: " + cf2);
        System.out.println("f3: " + cf3);
        System.out.println("f4: " + cf4);
        System.out.println("f5: " + (cf5 + cf1));
    }
}
