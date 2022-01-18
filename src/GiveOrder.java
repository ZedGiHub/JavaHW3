import java.util.Arrays;
import java.util.Scanner;

public class GiveOrder {
    public static int fibonacci(int n) {
        int counter = 1;
        int index = 0;
        int fibS;
        if (n == 1)
            fibS = 1;
        else if (n == 2)
            fibS = 1;
        else
            fibS = fibonacci(n - 1) + fibonacci(n - 2);
        return fibS;
    }


    public static boolean primeDetector(int p) {
        boolean pFlag = true;
        if (p <= 1)
            pFlag = false;
        else {
            for (int i = 2; i < p; i++) {
                if (p % i == 0) {
                    pFlag = false;
                    break;
                }
            }
        }
        return pFlag;
    }

    public static int[] denominators(int n) {
        int[] denoms = new int[n];
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                denoms[j] = i;
                j++;
            }
        }
        int[] arr = Arrays.copyOf(denoms, j);
        return arr;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your desired command");
        while (true) {
            String order = input.next();
            int number = input.nextInt();
            // F command
            if (order.equals("F")) {
                if (number < 1)
                    System.out.println("wrong");
                else {
                    int index = 1;
                    while (fibonacci(index) <= number) {
                        index++;
                    }
                    if (fibonacci(index - 1) == number)
                        System.out.println(index - 1);
                    else
                        System.out.println("wrong");
                }
            }

            // P command
            else if (order.equals("P")) {
                if (primeDetector(number) == false)
                    System.out.println("wrong");
                else {
                    int counter = 0;
                    for (int i = 1; i <= number; i++) {
                        if (primeDetector(i) == true) {
                            counter++;
                        }
                    }
                    System.out.println(counter);
                }
                // B command
            } else if (order.equals("B")) {
                if (primeDetector(number) == true) {
                    int counter = 0;
                    for (int i = 1; i <= number; i++) {
                        if (primeDetector(i) == true) {
                            counter++;
                        }
                    }
                    int z = counter;
                    int index = 1;
                    while (fibonacci(index) <= number) {
                        index++;
                    }
                    if (fibonacci(index - 1) == number) {
                        int y = index - 1;
                        int c = 1;
                        for (int i : denominators(y + z)) {
                            if (c == denominators(y + z).length)
                                System.out.println(i);
                            else
                                System.out.print(i + ",");
                            c++;
                        }
                    } else
                        System.out.println("wrong");
                } else
                    System.out.println("wrong");
            } else
                System.out.println("invalid input");
        }

    }
}

