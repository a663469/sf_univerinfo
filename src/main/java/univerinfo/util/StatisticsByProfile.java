package univerinfo.util;

import org.apache.commons.lang3.StringUtils;
import univerinfo.enums.StudyProfile;
import univerinfo.model.Statistics;
import univerinfo.model.Student;
import univerinfo.model.University;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsByProfile {

    public static List<Statistics> createStatistics(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics(profile);
            statisticsList.add(statistics);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());

            statistics.setNumberOfUniversitiesByProfile(profileUniversityIds.size());

            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversiry -> statistics.setUniversitiesName(
                            statistics.getUniversitiesName() + fullNameUniversiry + "; "));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setNumberOfStudentsByProfile(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(avgExamScore);
        });

        return statisticsList;
    }
    public static List<Statistics> getStatisticsList(List<Student> students, List<University> universities) {
        ArrayList sts = new ArrayList<Statistics>();

        for(StudyProfile mainProfile : StudyProfile.values()) {
            OptionalDouble avgExamScore = OptionalDouble.empty();
            int numberOfStudentsByProfile = 0;
            int numberOfUniversitiesByProfile = 0;
            String universitiesName = StringUtils.EMPTY;
            for(University university : universities) {
                if(university.getMainProfile() == mainProfile) {
                    universitiesName = universitiesName + university.getFullName() + ";";
                    numberOfUniversitiesByProfile++;
                    for(Student student : students) {
                        if(student.getUniversityId().equals(university.getId())) {
                            if(numberOfStudentsByProfile > 0) {
                                avgExamScore = OptionalDouble.of((avgExamScore.getAsDouble() * numberOfStudentsByProfile + student.getAvgExamScore()) / (numberOfStudentsByProfile + 1));
                            } else {
                                avgExamScore = OptionalDouble.of(student.getAvgExamScore());
                            }
                            numberOfStudentsByProfile++;
                        }
                    }
                }
            }
            if(avgExamScore.isPresent()) {
                MathContext context = new MathContext(3, RoundingMode.HALF_UP);
                BigDecimal result = new BigDecimal(avgExamScore.getAsDouble(), context);
                avgExamScore = OptionalDouble.of(result.doubleValue());
            }
            sts.add(new Statistics(mainProfile, avgExamScore, numberOfStudentsByProfile, numberOfUniversitiesByProfile, universitiesName));
        }
        return sts;
    }
}
