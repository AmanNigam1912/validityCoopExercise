import java.util.Comparator;

public class SortByColumn implements Comparator<Person> {
    public int compare(Person a, Person b){
        return a.getFirst_name().compareTo(b.getFirst_name());
    }
}
