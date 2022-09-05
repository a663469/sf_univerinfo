package univerinfo.comparator;

import org.apache.commons.lang3.StringUtils;
import univerinfo.model.University;

public class UniversityID implements UniversityComparator{
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getId(), o2.getId());
    }
}
