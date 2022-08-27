package univerinfo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
    private Scanner scanner;
    public CSVReader(String file){
        try {
            this.scanner = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public String[] getNextLine() {
        return scanner.nextLine().split(";", -1);
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}
