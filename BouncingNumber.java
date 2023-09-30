public final class BouncingNumber implements Bouncing {

    public static void main(String[] args) {
        System.out.println(new BouncingNumber().run());
    }

    public String run() {
        int triangle = 0;
        for (int i = 1; ; i++) {
            if (Integer.MAX_VALUE - triangle < i)
                throw new ArithmeticException("Overflow");
            triangle += i;
            if (countDivisors(triangle) > 500)
                return Integer.toString(triangle);
        }
    }

    private static int countDivisors(int n) {
        int count = 0;
        int end = sqrt(n);
        for (int i = 1; i < end; i++) {
            if (n % i == 0)
                count += 2;
        }
        if (end * end == n)
            count++;
        return count;
    }

    public static int sqrt(int x) {

        if (x < 0)
            throw new IllegalArgumentException("Square root of negative number");
        int y = 0;
        for (int i = 32768; i != 0; i >>>= 1) {
            y |= i;
            if (y > 46340 || y * y > x)
                y ^= i;
        }
        return y;
    }
}


