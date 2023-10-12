import com.google.gson.annotations.SerializedName;

public class University {
    @SerializedName("id")
    private String universityId;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("short_name")
    private String shortName;

    @SerializedName("year_of_foundation")
    private int yearOfFoundation;

    @SerializedName("main_profile")
    private Myclass.StudyProfile mainProfile;

    public University() {
    }

    public University(String universityId, String fullName, String shortName, int yearOfFoundation, Myclass.StudyProfile mainProfile) {
        this.universityId = universityId;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
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

    public Myclass.StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(Myclass.StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId='" + universityId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}