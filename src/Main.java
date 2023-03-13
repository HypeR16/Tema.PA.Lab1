import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] mat = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5}; //<- Matricea Initiala

        System.out.println("Matricea initiala: ");
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i] + " ");
        }
        System.out.println();

        ExempluSortare.SortareInsertie(mat);

        System.out.println("Matricea sortata prin insertie: "); //<- Sortarea prin Insertie
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i] + " ");
        }
        System.out.println();

        ExempluSortare.SortarePrinSelectie(mat);

        System.out.println("Matricea sortata prin selectie: "); //<- Sortarea prin selectie
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i] + " ");
        }
        System.out.println();

        int a = 54; //<- Algoritmul Lui Euclid
        int b = 24;
        int cmmdc = ExempluSortare.cmmdc(a, b);

        System.out.println("Cel mai mare divizor comun dintre " + a + " si " + b + " este: " + cmmdc);

        int n = 10; //<- Sirul lui Fibonacci
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        System.out.println("Sirul Fibonacci: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fib[i] + " ");
        }

        System.out.println(); //<- Inmultirea a doua matrici
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] result = ExempluSortare.InmultireMatrici(arr1, arr2);

        System.out.println("Rezultatul inmultirii matricilor: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

        int num1 = 17; //<- Inmultirea a la Russe
        int num2 = 23;
        int produs = ExempluSortare.InmultireAlaRusse(num1, num2);
        System.out.println("Rezultatul inmultirii a la Russe dintre " + num1 + " si " + num2 +" este: " + produs);
    }

    public static class ExempluSortare {
        public static void SortareInsertie(int[] mat) {
            int n = mat.length;
            for (int i = 1; i < n; i++) {
                int key = mat[i];
                int j = i - 1;

                while (j >= 0 && mat[j] > key) {
                    mat[j + 1] = mat[j];
                    j--;
                }

                mat[j + 1] = key;
            }
        }

        public static void SortarePrinSelectie(int[] arr) {
            int n = arr.length;

            for (int i = 0; i < n - 1; i++) {
                int IndexMinim = i;

                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[IndexMinim]) {
                        IndexMinim = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[IndexMinim];
                arr[IndexMinim] = temp;
            }
        }
        public static int cmmdc(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return cmmdc(b, a % b);
            }
        }
        public static int[] InmultireMatrici(int[] arr1, int[] arr2) {
            int n = arr1.length;
            int m = arr2.length;
            int[] result = new int[n + m - 1];
            Arrays.fill(result, 0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    result[i + j] += arr1[i] * arr2[j];
                }
            }
            return result;
        }
        public static int InmultireAlaRusse(int a, int b) {
            int result = 0;
            while (a > 0) {
                if (a % 2 == 1) {
                    result += b;
                }
                a /= 2;
                b *= 2;
            }
            return result;
        }
    }
}