
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(final String[] args) throws ParseException {

        final String expectedPattern = "MM/dd/yyyy";
        final SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);

        final Person p1 = new Person("1", formatter.parse("09/22/2009"), "Chris", "Brown", 5.3, 115.3);
        final Person p2 = new Person("2", formatter.parse("05/15/2011"), "Jen", "Mathew", 5.5, 110.0);
        final Person p3 = new Person("3", formatter.parse("05/08/2011"), "Becky", "smith", 5.7, 180.9);

        final List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        /* Sorting by the first method-using a switch case */
        final List<Person> firstNameAscPersonList = Sorting.sorting(personList, "firstName", "true");
        System.out.println("FirstNames sorted in Ascending Order");
        for (final Person person : firstNameAscPersonList) {
            System.out.println(person.firstName);
        }
        /* Sorting by the more efficient method-using a HashMap */
        try {
            final List<Person> lastNameDescPersonList = AnotherSorting.sorting(personList, "lastName", "false");
            System.out.println("LastNames sorted in Descending Order");
            for (final Person person : lastNameDescPersonList) {
                System.out.println(person.lastName);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }

    }

}