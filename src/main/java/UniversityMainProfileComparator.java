import java.util.Comparator;
public class UniversityMainProfileComparator implements Comparator<University> {
    @Override
    public int compare(University university1, University university2) {

        return university1.getMainProfile().compareTo(university2.getMainProfile());
    }
}
