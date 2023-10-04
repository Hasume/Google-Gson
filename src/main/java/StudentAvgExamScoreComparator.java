import java.util.Comparator;
public class StudentAvgExamScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {

        return Float.compare(student2.getAvgExamScore(), student1.getAvgExamScore());
    }
}