package univerinfo.comparator;

import org.apache.commons.lang3.StringUtils;
import univerinfo.model.University;

public class UniversityMainProfile implements UniversityComparator{
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getMainProfile().name(), o2.getMainProfile().name());
    }
}
