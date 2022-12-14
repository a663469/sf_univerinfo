package univerinfo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CSVReader extends FileReaders {
    private Scanner scanner;
    private String row[];
    CSVReader(String file){
        try {
            this.scanner = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }
    }
    boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    @Override
    void nextLine() {
        this.row = scanner.nextLine().split(";", -1);
    }

    @Override
    String getCellString(int index) {
        return row[index];
    }

    @Override
    double getCellDouble(int index) {
        return Double.parseDouble(row[index].replace(",", "."));
    }

    @Override
    float getCellFloat(int index) {
        return Float.parseFloat(row[index].replace(",", "."));
    }

    @Override
    int getCellInt(int index) {
        return Integer.parseInt(row[index].replace(",", "."));
    }
}
