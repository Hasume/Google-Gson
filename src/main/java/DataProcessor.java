import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessor {
    public static List<Statistics> generateStatistics(List<Student> students, List<University> universities) {
        Map<String, List<Student>> studentsByProfile = students.stream()
                .collect(Collectors.groupingBy(student -> {
                    Myclass.StudyProfile profile = universities
                            .stream()
                            .filter(university -> university.getUniversityId().equals(student.getUniversityId()))
                            .findFirst()
                            .orElse(new University()) // Handle if no matching university is found
                            .getMainProfile();

                    return profile.toString(); // Use toString() to convert Myclass.StudyProfile to a String
                }));

        Map<String, List<University>> universitiesByProfile = universities.stream()
                .collect(Collectors.groupingBy(university -> university.getMainProfile().toString())); // Do the same here

        return Stream.concat(studentsByProfile.keySet().stream(), universitiesByProfile.keySet().stream())
                .distinct()
                .map(studyProfile -> {
                    List<Student> profileStudents = studentsByProfile.get(studyProfile);
                    List<University> profileUniversities = universitiesByProfile.get(studyProfile);

                    double avgExamScore = profileStudents != null ?
                            profileStudents.stream()
                                    .mapToDouble(Student::getAvgExamScore)
                                    .average()
                                    .orElse(0) :
                            0;

                    int studentCount = profileStudents != null ? profileStudents.size() : 0;
                    int universityCount = profileUniversities != null ? profileUniversities.size() : 0;
                    List<String> universityNames = profileUniversities != null ?
                            profileUniversities.stream()
                                    .map(University::getFullName)
                                    .collect(Collectors.toList()) :
                            Collections.emptyList();

                    return new Statistics(studyProfile, avgExamScore, studentCount, universityCount, universityNames);
                })
                .collect(Collectors.toList());
    }
}