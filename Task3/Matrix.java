import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Matrix {
    private int b;
    private int a;
    private float[][] matrixMas;
    Scanner in = new Scanner(System.in);

    public Matrix() {
    }

    public Matrix(int a, int b) {
        this.a = a;
        this.b = b;
        matrixMas = new float[a][b];

        for (int i = 0; i < a; i++) {
            for (int y = 0; y < b; y++) {
                matrixMas[i][y] = 0;
            }
        }
    }

    public void print() {
        for (int i = 0; i < a; i++) {
            System.out.print("[ ");
            for (int y = 0; y < b; y++) {
                System.out.print(matrixMas[i][y] + " ");
            }
            System.out.println("]");
        }
    }

    public void fillingMatrix() {
        for (int i = 0; i < a; i++) {
            System.out.println("\n" + "[ ");
            for (int y = 0; y < b; y++) {
                float a;
                a = in.nextFloat();
                matrixMas[i][y] = a;
            }
            System.out.println("]");
        }
    }

    public void fillingMatrix(float[][] s) {
        if (s.length == matrixMas.length) {
            for (int i = 0; i < a; i++) {
                if (b >= 0) System.arraycopy(s[i], 0, matrixMas[i], 0, b);
            }
        } else
            System.out.println("Error. The number of characters in the array must match the number of characters in the matrix.");
    }

    public void matrixAddition(@NotNull Matrix a, @NotNull Matrix b) {
        if (a.matrixMas.length == b.matrixMas.length) {
            Matrix c = new Matrix(a.a, a.b);
            for (int i = 0; i < a.a; i++) {
                for (int y = 0; y < a.b; y++) {
                    c.matrixMas[i][y] = a.matrixMas[i][y] + b.matrixMas[i][y];
                }
            }
            c.print();
        } else
            System.out.println("Error. The number of characters in the matrix1 must match the number of characters in the matrix2.");
    }

    public void matrixSubtraction(@NotNull Matrix a, @NotNull Matrix b) {
        if (a.matrixMas.length == b.matrixMas.length) {
            Matrix c = new Matrix(a.a, a.b);
            for (int i = 0; i < a.a; i++) {
                for (int y = 0; y < a.b; y++) {
                    c.matrixMas[i][y] = a.matrixMas[i][y] - b.matrixMas[i][y];
                }
            }
            c.print();
        } else
            System.out.println("Error. The number of characters in the matrix1 must match the number of characters in the matrix2.");
    }

    public void multiplicationOfMatrices(@NotNull Matrix a, @NotNull Matrix b) {
        Matrix c;
        if (a.matrixMas.length == b.matrixMas.length) {
            c = new Matrix(a.a, a.b);
            for (int i = 0; i < a.a; i++) {
                for (int y = 0; y < a.b; y++) {
                    c.matrixMas[i][y] = a.matrixMas[i][y] * b.matrixMas[i][y];
                }
            }
        } else {
            c = new Matrix(Math.max(a.a, b.a), Math.max(a.b, b.b));
            for (int i = 0; i < c.a; i++) {
                for (int y = 0; y < c.b; y++) {
                    c.matrixMas[i][y] = a.matrixMas[i][y] * b.matrixMas[i][y];
                }
            }
        }
        c.print();

    }

    public void multiplicationOfMatrices(@NotNull Matrix a, int b) {
        Matrix c;
        c = new Matrix(a.a, a.b);
        for (int i = 0; i < a.a; i++) {
            for (int y = 0; y < a.b; y++) {
                c.matrixMas[i][y] = a.matrixMas[i][y] * b;
            }
        }
        c.print();

    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < a; i++) {
            StringBuilder sBuilder = new StringBuilder(s + ("[ "));
            for (int y = 0; y < b; y++) {
                sBuilder.append(matrixMas[i][y]).append(" ");
            }
            s = sBuilder.toString();
            s = s + ("]\n");
        }
        return s;
    }

}
