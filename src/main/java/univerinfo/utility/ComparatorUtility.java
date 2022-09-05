package univerinfo.utility;

import univerinfo.comparator.*;
import univerinfo.comparator.StudentUniversityIdComparator;
import univerinfo.enums.StudentComparatorVariants;
import univerinfo.enums.UniversityComparatorVariants;

public class ComparatorUtility {
    public static StudentComparator getStudentComparator(StudentComparatorVariants studentComparatorVariant) {

        switch (studentComparatorVariant) {
            case ID:
                return new StudentUniversityIdComparator();
            case NAME:
                return new StudentFullNameComparator();
            case COURSE:
                return new StudentCourseComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default:
                return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorVariants universityComparatorVariant) {

        switch (universityComparatorVariant) {
            case FULL_NAME:
                return new UniversityFullName();
            case ID:
                return new UniversityID();
            case MAIN_PROFILE:
                return new UniversityMainProfile();
            case SHORT_NAME:
                return new UniversityShortName();
            case YEAR_OF_FOUNDATION:
                return new UniversityYearOfFoundation();
            default:
                return new UniversityFullName();
        }
    }
}
