package univerinfo.model;

import univerinfo.enums.StudyProfile;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private StudyProfile mainProfile;
    private float avgExamScore;
    private int numberOfStudentsByProfile;
    private int numberOfUniversitiesByProfile;
    private List<String> universitiesName;

    public Statistics(StudyProfile mainProfile, float avgExamScore, int numberOfStudentsByProfile, int numberOfUniversitiesByProfile, List<String> universitiesName) {
        this.mainProfile = mainProfile;
        this.avgExamScore = avgExamScore;
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
        this.universitiesName = universitiesName;
    }

    public Statistics(StudyProfile mainProfile, List<Student> students, List<University> universities) {
        this.mainProfile = mainProfile;
        this.avgExamScore = 0;
        this.numberOfStudentsByProfile = 0;
        this.numberOfUniversitiesByProfile = 0;
        this.universitiesName = new ArrayList<>();
        for(University university : universities) {
            if(university.getMainProfile() == mainProfile) {
                System.out.println(university.getFullName());
                universitiesName.add(university.getFullName());
                numberOfUniversitiesByProfile++;
                for(Student student : students) {
                    if(student.getUniversityId().equals(university.getId())) {
                        if(numberOfStudentsByProfile > 0) {
                            avgExamScore = (avgExamScore * numberOfStudentsByProfile + student.getAvgExamScore()) / (numberOfStudentsByProfile + 1);
                        } else {
                            avgExamScore = student.getAvgExamScore();
                        }
                        numberOfStudentsByProfile++;
                    }
                }
            }
        }
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public int getNumberOfStudentsByProfile() {
        return numberOfStudentsByProfile;
    }

    public int getNumberOfUniversitiesByProfile() {
        return numberOfUniversitiesByProfile;
    }

    public List<String> getUniversitiesName() {
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
