import java.util.Scanner;

public class NoTailRecursion {
    public static int[] recursiveMethod(int n) {
        int[] finalArr = new int[2 * n - 1];
        if (n == 2) finalArr = new int[]{1, 2, 1};
        else {
            int[] arr = recursiveMethod(n - 1);
            System.arraycopy(arr, 0, finalArr, 0, n - 1);
            finalArr[n - 1] = n;
            System.arraycopy(arr, n - 2, finalArr, n, n - 1);

        }
        return finalArr;
    }

    public static void main(String[] args) {
        Scanner inputN = new Scanner(System.in);
        System.out.println("Please enter n:");
        int n = inputN.nextInt();
        if (n < 2)
            System.out.println("invalid input");
        else {
            int[] outArr = recursiveMethod(n);
            int l = outArr.length;
            for (int i : outArr) {
                if (l > 1)
                    System.out.print(i + ",");
                else
                    System.out.println(i);
                l--;
            }
            ;
        }
    }
}
