package univerinfo.model;

import com.google.gson.annotations.SerializedName;
import univerinfo.enums.StudyProfile;

public class University {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String fullName;
    @SerializedName("shortName")
    private String shortName;
    @SerializedName("year")
    private int yearOfFoundation;
    @SerializedName("profile")
    private StudyProfile mainProfile;

    public University() {
    }

    public University(String id, String fullName, String shortName,int yearOfFoundation, StudyProfile mainProfile) {
        setId(id);
        setFullName(fullName);
        setShortName(shortName);
        setYearOfFoundation(yearOfFoundation);
        setMainProfile(mainProfile);
    }

    public University(String id, String fullName, String shortName,int yearOfFoundation, String mainProfile) {
        setId(id);
        setFullName(fullName);
        setShortName(shortName);
        setYearOfFoundation(yearOfFoundation);
        setMainProfile(StudyProfile.valueOf(mainProfile));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "univerinfo.model.University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}