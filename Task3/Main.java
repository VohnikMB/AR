import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);

        Matrix matrix = new Matrix();

        System.out.println("Заповнення матриці користувачем: ");
        Matrix matrix1 = new Matrix(3, 4);
        matrix1.fillingMatrix();
        System.out.println("Заповнення матриці використовуючи двовимірний масив: ");
        Matrix matrix2 = new Matrix(3, 4);
        float[][] array = {{54.5f, 11f, 0.24f, 1f}, {15f, 54f, 4.0f, 0.1f}, {11f, 2f, 0.2f, 0.58f}};
        matrix2.fillingMatrix(array);
        System.out.println(matrix2 + "\n");

        System.out.println("\n Множення матриць:");
        matrix.multiplicationOfMatrices(matrix1, matrix2);
        System.out.print("\n Множення матриці на число: ");
        int i = in.nextInt();
        matrix.multiplicationOfMatrices(matrix2,i);

        System.out.println("\n Віднімання матриць:");
        matrix.matrixSubtraction(matrix1,matrix2);
        System.out.println("\n Додавання матриць:");
        matrix.matrixAddition(matrix1,matrix2);
    }
}