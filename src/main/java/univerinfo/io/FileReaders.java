package univerinfo.io;

import java.util.List;

abstract class FileReaders {
    abstract List<String> getNextLine();
    abstract boolean hasNextLine();
}
