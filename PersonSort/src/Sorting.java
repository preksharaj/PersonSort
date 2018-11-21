import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    final static Comparator<Person> fistNamecomparator = Comparator.comparing(p -> p.getFirstName().toLowerCase());
    final static Comparator<Person> lastNamecomparator = Comparator.comparing(p -> p.getLastName().toLowerCase());
    final static Comparator<Person> heightIncomparator = Comparator.comparing(p -> p.getHeightIn());
    final static Comparator<Person> weightLbcomparator = Comparator.comparing(p -> p.getWeightLb());
    final static Comparator<Person> ssncomparator = Comparator.comparing(p -> p.getSsn());
    final static Comparator<Person> dateOfBirthcomparator = Comparator.comparing(p -> p.getDateOfBirth());

    static List<Person> sorting(final Iterable<Person> people, final String sortField, final String ascending) {
        final List<Person> personList = buildPersonList(people);
        switch (sortField) {
            case "ssn":
                if (ascending.equals("true")) {
                    personList.sort(ssncomparator);
                } else {
                    personList.sort(ssncomparator.reversed());
                }
                break;
            case "dateOfBirth":
                if (ascending.equals("true")) {
                    personList.sort(dateOfBirthcomparator);
                } else {
                    personList.sort(dateOfBirthcomparator.reversed());
                }
                break;
            case "firstName":
                if (ascending.equals("true")) {
                    personList.sort(fistNamecomparator);
                } else {
                    personList.sort(fistNamecomparator.reversed());
                }
                break;
            case "lastName":
                if (ascending.equals("true")) {
                    personList.sort(lastNamecomparator);
                } else {
                    personList.sort(lastNamecomparator.reversed());
                }
                break;
            case "heightIn":
                if (ascending.equals("true")) {
                    personList.sort(heightIncomparator);
                } else {
                    personList.sort(heightIncomparator.reversed());
                }
                break;
            case "weightLb":
                if (ascending.equals("true")) {
                    personList.sort(weightLbcomparator);
                } else {
                    personList.sort(weightLbcomparator.reversed());
                }
                break;

        }
        return personList;

    }

    private static List<Person> buildPersonList(final Iterable<Person> personIterable) {
        final List<Person> personList = new ArrayList<>();
        personIterable.forEach(personList::add);
        return personList;
    }

}
