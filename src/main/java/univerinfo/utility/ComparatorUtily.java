package univerinfo.utility;

import univerinfo.comparator.*;
import univerinfo.comparator.StudentUniversityIdComparator;
import univerinfo.enums.StudentComparatorVariants;

public class ComparatorUtily {
    public static StudentComparator getStudentComparator(StudentComparatorVariants studentComparatorType) {

        switch (studentComparatorType) {
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
}
