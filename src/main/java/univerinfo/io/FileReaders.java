package univerinfo.io;

import java.util.List;

abstract class FileReaders {
//    abstract public List<String> getNextLine();
    abstract boolean hasNextLine();
    abstract void nextLine();
    abstract String getCellString(int index);
    abstract double getCellDouble(int index);
    abstract float getCellFloat(int index);
    abstract int getCellInt(int index);
}
