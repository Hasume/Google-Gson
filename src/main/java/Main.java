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
        universities.add(new University("1" , "University A", "UA", 1980, Myclass.StudyProfile.ENGINEERING));
        universities.add(new University("2", "University B", "UB", 1975, Myclass.StudyProfile.BUSINESS));
        universities.add(new University("3", "University C", "UC", 1990, Myclass.StudyProfile.COMPUTER_SCIENCE));

        // Сериализация коллекций в JSON и вывод в консоль
        String studentsJson = JsonUtil.serializeStudentList(students);
        String universitiesJson = JsonUtil.serializeUniversityList(universities);

        System.out.println("Serialized Students:");
        System.out.println(studentsJson);
        System.out.println("\nSerialized Universities:");
        System.out.println(universitiesJson);

        // Десериализация JSON в коллекции
        List<Student> deserializedStudents = JsonUtil.deserializeStudentList(studentsJson);
        List<University> deserializedUniversities = JsonUtil.deserializeUniversityList(universitiesJson);

        System.out.println("\nDeserialized Students:");
        deserializedStudents.forEach(System.out::println);

        System.out.println("\nDeserialized Universities:");
        deserializedUniversities.forEach(System.out::println);

        // Сравнение количества элементов в исходной и десериализованной коллекциях студентов
        int originalStudentsCount = students.size();
        int deserializedStudentsCount = deserializedStudents.size();

        if (originalStudentsCount == deserializedStudentsCount) {
            System.out.println("Количество студентов в исходной и десериализованной коллекциях совпадает: " + originalStudentsCount);
        } else {
            System.out.println("Внимание: количество студентов в исходной и десериализованной коллекциях не совпадает.");
        }

        // Сравнение количества элементов в исходной и десериализованной коллекциях университетов
        int originalUniversitiesCount = universities.size();
        int deserializedUniversitiesCount = deserializedUniversities.size();

        if (originalUniversitiesCount == deserializedUniversitiesCount) {
            System.out.println("Количество университетов в исходной и десериализованной коллекциях совпадает: " + originalUniversitiesCount);
        } else {
            System.out.println("Внимание: количество университетов в исходной и десериализованной коллекциях не совпадает.");
        }

        // Сериализация и десериализация отдельных элементов внутри стрима
        students.stream()
                .map(JsonUtil::serializeStudent)
                .forEach(json -> {
                    System.out.println("\nSerialized Student:");
                    System.out.println(json);
                    Student deserializedStudent = JsonUtil.deserializeStudent(json);
                    System.out.println("\nDeserialized Student:");
                    System.out.println(deserializedStudent);
                });

        universities.stream()
                .map(JsonUtil::serializeUniversity)
                .forEach(json -> {
                    System.out.println("\nSerialized University:");
                    System.out.println(json);
                    University deserializedUniversity = JsonUtil.deserializeUniversity(json);
                    System.out.println("\nDeserialized University:");
                    System.out.println(deserializedUniversity);
                });
    }
}