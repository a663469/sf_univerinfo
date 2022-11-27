package univerinfo.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CSVReader extends FileReaders {
    private Scanner scanner;
    private String row[];
    private static Logger log = LoggerFactory.getLogger(CSVReader.class);
    CSVReader(String file){
        try {
            this.scanner = new Scanner(new FileInputStream(file));
            log.info("Чтение данных с " + new File(file).getAbsolutePath());
        } catch (FileNotFoundException e) {
            log.error("Ошибка чтения "+ file + ":" + e);
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
