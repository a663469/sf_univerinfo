package univerinfo.model;

import org.apache.commons.lang3.StringUtils;
import univerinfo.enums.StudyProfile;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Statistics {
    private StudyProfile mainProfile;
    private OptionalDouble avgExamScore = OptionalDouble.empty();

    public void setAvgExamScore(OptionalDouble avgExamScore) {
        if(avgExamScore.isPresent()) {
            MathContext context = new MathContext(3, RoundingMode.HALF_UP);
            BigDecimal result = new BigDecimal(avgExamScore.getAsDouble(), context);
            this.avgExamScore = OptionalDouble.of(result.doubleValue());
        }
    }

    public void setNumberOfStudentsByProfile(int numberOfStudentsByProfile) {
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
    }

    public void setNumberOfUniversitiesByProfile(int numberOfUniversitiesByProfile) {
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
    }

    public void setUniversitiesName(String universitiesName) {
        this.universitiesName = universitiesName;
    }

    private int numberOfStudentsByProfile = 0;
    private int numberOfUniversitiesByProfile = 0;
    private String universitiesName = StringUtils.EMPTY;

    public Statistics(StudyProfile mainProfile, OptionalDouble avgExamScore, int numberOfStudentsByProfile, int numberOfUniversitiesByProfile, String universitiesName) {
        this.mainProfile = mainProfile;
        this.avgExamScore = avgExamScore;
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
        this.universitiesName = universitiesName;
    }

    public Statistics(StudyProfile studyProfile) {
        this.mainProfile = studyProfile;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public OptionalDouble getAvgExamScore() {
        return avgExamScore;
    }

    public int getNumberOfStudentsByProfile() {
        return numberOfStudentsByProfile;
    }

    public int getNumberOfUniversitiesByProfile() {
        return numberOfUniversitiesByProfile;
    }

    public String getUniversitiesName() {
        return universitiesName;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                ", avgExamScore=" + avgExamScore +
                ", numberOfStudentsByProfile=" + numberOfStudentsByProfile +
                ", numberOfUniversitiesByProfile=" + numberOfUniversitiesByProfile +
                ", universitiesName=" + universitiesName +
                "mainProfile=" + mainProfile +
                '}';
    }
}
