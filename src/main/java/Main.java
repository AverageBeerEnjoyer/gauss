import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File input = new File("input.txt");
        Matrix matrix;
        try {
            matrix = Matrix.fromFile(input);
            Gauss.solve(matrix);
            System.out.println(matrix.toString());
        } catch (FileNotFoundException e){
            System.out.println("File \"input.txt\" not found");
            return;
        } catch (NoSuchElementException|NumberFormatException e){
            System.out.println("Incorrect record");
        }
    }
}
