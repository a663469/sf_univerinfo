package univerinfo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader extends FileReaders{
    private Scanner scanner;
    public CSVReader(String file){
        try {
            this.scanner = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public List<String> getNextLine() {
        List<String> retVal = new ArrayList<>();
        String st[] = scanner.nextLine().split(";", -1);
        for(String word : st) {
            retVal.add(word);
        }
        return retVal;
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}
