import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnotherSorting {

    final static Comparator<Person> fistNamecomparator = Comparator.comparing(p -> p.getFirstName().toLowerCase());
    final static Comparator<Person> lastNamecomparator = Comparator.comparing(p -> p.getLastName().toLowerCase());
    final static Comparator<Person> heightIncomparator = Comparator.comparing(p -> p.getHeightIn());
    final static Comparator<Person> weightLbcomparator = Comparator.comparing(p -> p.getWeightLb());
    final static Comparator<Person> ssncomparator = Comparator.comparing(p -> p.getSsn());
    final static Comparator<Person> dateOfBirthcomparator = Comparator.comparing(p -> p.getDateOfBirth());

    private static Map<String, Comparator> fieldComparatorMap;

    static List<Person> sorting(final Iterable<Person> people, final String sortField,
                                final String ascending) throws Exception {
        /*
         * Map with key as the fieldName and value as the matching field
         * comparator
         */
        if (fieldComparatorMap == null) {
            fieldComparatorMap = new HashMap();
            fieldComparatorMap.put("ssn", ssncomparator);
            fieldComparatorMap.put("dateOfBirth", dateOfBirthcomparator);
            fieldComparatorMap.put("firstName", fistNamecomparator);
            fieldComparatorMap.put("lastName", lastNamecomparator);
            fieldComparatorMap.put("heightIn", heightIncomparator);
            fieldComparatorMap.put("weightLb", weightLbcomparator);
        }
        /* Get the comparator based on the sortfield */
        final Comparator comparator = fieldComparatorMap.get(sortField);
        if (comparator == null) throw new Exception("There is no comparator for the sort field mentioned");

        final List<Person> personList = buildPersonList(people);

        if (ascending.equalsIgnoreCase("true")) {
            Collections.sort(personList, comparator);
        } else {
            Collections.sort(personList, comparator.reversed());
        }
        return personList;
    }

    /* Method to build a list from the iterable<People> */
    private static List<Person> buildPersonList(final Iterable<Person> personIterable) {
        final List<Person> personList = new ArrayList<>();
        personIterable.forEach(personList::add);
        return personList;
    }
}
