import java.util.List;

public class Statistics {
    private String studyProfile;
    private double avgExamScore;
    private int studentCount;
    private int universityCount;
    private List<String> universityNames;

    public String getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(String studyProfile) {
        this.studyProfile = studyProfile;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(double avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getUniversityCount() {
        return universityCount;
    }

    public void setUniversityCount(int universityCount) {
        this.universityCount = universityCount;
    }

    public List<String> getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(List<String> universityNames) {
        this.universityNames = universityNames;
    }

    public Statistics(String studyProfile, double avgExamScore, int studentCount, int universityCount, List<String> universityNames) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.studentCount = studentCount;
        this.universityCount = universityCount;
        this.universityNames = universityNames;
    }

    // Конструктор без параметров
    public Statistics() {
    }
}