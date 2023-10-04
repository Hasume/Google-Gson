import java.util.Comparator;
public class UniversityYearOfFoundationComparator implements Comparator<University> {
    @Override
    public int compare(University university1, University university2) {

        return Integer.compare(university1.getYearOfFoundation(), university2.getYearOfFoundation());
    }
}