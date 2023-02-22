import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Matrix {
    public final int rows, columns;
    private double[][] numbers;
    private double[] extension;

    public Matrix(double[][] numbers, double[] extension) {
        this(numbers);
        this.extension = extension;
    }

    public Matrix(double[][] numbers) {
        if (numbers.length < 1 || numbers[0].length < 1) throw new IllegalArgumentException("empty matrix");
        this.numbers = numbers;
        this.rows = numbers.length;
        this.columns = numbers[0].length;
        extension = new double[rows];
        Arrays.fill(extension, 0);
    }

    public static Matrix fromFile(File file) throws FileNotFoundException, NoSuchElementException, NumberFormatException {
        Scanner scanner = new Scanner(file);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        double[][] numbers = new double[rows][columns];
        double[] extension = new double[rows];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                numbers[i][j] = scanner.nextDouble();
            }
            extension[i] = scanner.nextDouble();
        }
        return new Matrix(numbers, extension);
    }

    public void multiplyRow(int rowNum, double c) {
        for (int i = 0; i < columns; ++i) {
            numbers[rowNum][i] *= c;
        }
        extension[rowNum] *= c;
    }

    public void addRowtoRow(int targetRow, int additionalRow, double multiplyCoef) {
        for (int i = 0; i < columns; ++i) {
            numbers[targetRow][i] += (numbers[additionalRow][i] * multiplyCoef);
        }
        extension[targetRow] += (extension[additionalRow] * multiplyCoef);
    }

    public void swapRows(int row1, int row2) {
        double x;
        for (int i = 0; i < columns; ++i) {
            x = numbers[row1][i];
            numbers[row1][i] = numbers[row2][i];
            numbers[row2][i] = x;
        }
        x = extension[row1];
        extension[row1] = extension[row2];
        extension[row2] = x;
    }


    public double[][] getNumbers() {
        return numbers;
    }

    public double[] getExtension() {
        return extension;
    }

    public double get(int row, int column) {
        try {
            return numbers[row][column];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public double getExt(int row) {
        try {
            return extension[row];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                sb.append(get(i, j));
                sb.append("\t");
            }
            sb.append("|\t");
            sb.append(getExt(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
