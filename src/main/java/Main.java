import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Comparator<Student> studentComparator = ComparatorFactory.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        Comparator<University> universityComparator = ComparatorFactory.getUniversityComparator(UniversityComparatorType.YEAR_OF_FOUNDATION);


        List<Student> students = new ArrayList<>();
        students.add(new Student("John Doe", "1", 2, 85.5f));
        students.add(new Student("Alice Smith", "2", 3, 92.0f));
        students.add(new Student("Bob Johnson", "1", 1, 78.0f));

        List<University> universities = new ArrayList<>();
        universities.add(new University("1" , "University A", "UA", 1980,Myclass.StudyProfile.ENGINEERING));
        universities.add(new University("2", "University B", "UB", 1975, Myclass.StudyProfile.BUSINESS));
        universities.add(new University("3", "University C", "UC", 1990, Myclass.StudyProfile.COMPUTER_SCIENCE));


        List<Student> sortedStudents = students.stream()
                .sorted(studentComparator)
                .collect(Collectors.toList());

        System.out.println("Sorted Students:");
        sortedStudents.forEach(System.out::println);


        List<University> sortedUniversities = universities.stream()
                .sorted(universityComparator)
                .collect(Collectors.toList());

        System.out.println("\nSorted Universities:");
        sortedUniversities.forEach(System.out::println);
    }
}