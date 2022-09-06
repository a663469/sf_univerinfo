package univerinfo.comparator;

import org.apache.commons.lang3.StringUtils;
import univerinfo.model.University;

public class UniversityShortName implements UniversityComparator{
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }
}
