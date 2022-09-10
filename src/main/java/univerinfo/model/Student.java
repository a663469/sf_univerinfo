package univerinfo.model;

import com.google.gson.annotations.SerializedName;

public class Student {
    //        11. В классах Student и University добавить аннотации @SerializedName для каждого поля, чтобы изменить названия полей в сериализованном JSON-е. Названия можно изменить на произвольные, но подходящие по смыслу.
    @SerializedName("name")
    private String fullName;
    @SerializedName("id")
    private String universityId;
    @SerializedName("course")
    private int currentCourseNumber;
    @SerializedName("avgExamScore")
    private float avgExamScore;

    public Student() {}

    public Student(String universityId, String fullName, int currentCourseNumber, float avgExamScore){
        setUniversityId(universityId);
        setFullName(fullName);
        setCurrentCourseNumber(currentCourseNumber);
        setAvgExamScore(avgExamScore);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public String toString() {
        return "univerinfo.model.Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }
}