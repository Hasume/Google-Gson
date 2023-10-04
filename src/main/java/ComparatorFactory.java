import java.util.Comparator;

public class ComparatorFactory {
    public static Comparator<Student> getStudentComparator(StudentComparatorType type) {
        switch (type) {
            case COURSE_NUMBER:
                return new StudentCourseNumberComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default:
                throw new IllegalArgumentException("Unknown comparator type for Student");
        }
    }

    public static Comparator<University> getUniversityComparator(UniversityComparatorType type) {
        switch (type) {
            case YEAR_OF_FOUNDATION:
                return new UniversityYearOfFoundationComparator();
            case MAIN_PROFILE:
                return new UniversityMainProfileComparator();
            default:
                throw new IllegalArgumentException("Unknown comparator type for University");
        }
    }
}