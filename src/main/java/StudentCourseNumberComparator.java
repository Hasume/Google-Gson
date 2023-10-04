import java.util.Comparator;

public class StudentCourseNumberComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {

        return Integer.compare(student2.getCurrentCourseNumber(), student1.getCurrentCourseNumber());
    }
}