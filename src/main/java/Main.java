import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File input = new File("input.txt");
        File output = new File("output.txt");
        Matrix matrix;
        try {
            matrix = Matrix.fromFile(input);
            Gauss.solve(matrix);
            System.out.println(matrix.toString());
            FileWriter fileWriter = new FileWriter(output,false);
            fileWriter.write(matrix.toString());
            fileWriter.flush();
        }catch (IOException e){
            System.out.println("Some problems with input/output files");
            return;
        } catch (NoSuchElementException|NumberFormatException e){
            System.out.println("Incorrect record");
        }
    }
}
