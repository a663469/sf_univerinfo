package univerinfo.io;

import java.util.List;

public abstract class FileReaders {
//    abstract public List<String> getNextLine();
    abstract public boolean hasNextLine();
    abstract public void nextLine();
    abstract public String getCellString(int index);
    abstract public double getCellDouble(int index);
    abstract public float getCellFloat(int index);
    abstract public int getCellInt(int index);
}
