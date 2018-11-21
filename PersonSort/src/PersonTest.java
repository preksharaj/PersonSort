import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PersonTest {

    public static void main(final String[] args) throws Exception {

        final String expectedPattern = "MM/dd/yyyy";
        final SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);

        final Person p1 = new Person("1", formatter.parse("09/22/2009"), "Chris", "Brown", 5.3, 115.3);
        final Person p2 = new Person("2", formatter.parse("05/15/2011"), "Jen", "Mathew", 5.5, 110.0);
        final Person p3 = new Person("3", formatter.parse("05/08/2011"), "Becky", "smith", 5.7, 180.9);

        final List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        /* Example Sorting by the first method */
        final List<Person> result1 = Sorting.sorting(people, "firstName", "true");
        System.out.println("Sorted by the first method of switch case");
        for (final Person a : result1) {
            System.out.println(a.firstName);
        }

        /* Methods to test the sorting by the second approach */
        firstNameSortingAscending(people);
        firstNameSortingDescending(people);
        lastNameSortingAscending(people);
        lastNameSortingDescending(people);
        dateOfBirthSortingAscending(people);
        dateOfBirthSortingDescending(people);
        ssnSortingAscending(people);
        ssnSortingDescending(people);
        heightSortingAscending(people);
        heightSortingDescending(people);
        weightSortingAscending(people);
        weightSortingDescending(people);

    }

    /* Testing Methods for firstNames */
    public static void firstNameSortingAscending(final List<Person> people) throws Exception {
        System.out.println("FirstNames sorted in Ascending Order");
        final List<Person> firstNameAscPersonList = AnotherSorting.sorting(people, "firstName", "true");
        for (final Person person : firstNameAscPersonList) {
            System.out.println(person.firstName);
        }
    }

    public static void firstNameSortingDescending(final List<Person> people) throws Exception {
        System.out.println("FirstNames sorted in Descending Order");
        final List<Person> firstNameDescPersonList = AnotherSorting.sorting(people, "firstName", "false");
        for (final Person person : firstNameDescPersonList) {
            System.out.println(person.firstName);
        }
    }

    /* Testing Methods for lastNames */
    public static void lastNameSortingAscending(final List<Person> people) throws Exception {
        System.out.println("LastNames sorted in Ascending Order");
        final List<Person> lastNameAscPersonList = AnotherSorting.sorting(people, "lastName", "true");
        for (final Person person : lastNameAscPersonList) {
            System.out.println(person.lastName);
        }
    }

    public static void lastNameSortingDescending(final List<Person> people) throws Exception {
        System.out.println("LastNames sorted in Descending Order");
        final List<Person> lastNameDescPersonList = AnotherSorting.sorting(people, "lastName", "false");
        for (final Person person : lastNameDescPersonList) {
            System.out.println(person.lastName);
        }
    }

    /* Testing Methods for DateOfBirth */
    public static void dateOfBirthSortingAscending(final List<Person> people) throws Exception {
        System.out.println("dateofBith sorted in Ascending Order");
        final List<Person> dateOfBirthAscPersonList = AnotherSorting.sorting(people, "dateOfBirth", "true");
        for (final Person person : dateOfBirthAscPersonList) {
            System.out.println(person.firstName + " " + person.lastName + " dateOfBirth: " + person.dateOfBirth);
        }
    }

    public static void dateOfBirthSortingDescending(final List<Person> people) throws Exception {
        System.out.println("dateodBirth sorted in Descending Order");
        final List<Person> dateOfBirthDescPersonList = AnotherSorting.sorting(people, "dateOfBirth", "false");
        for (final Person person : dateOfBirthDescPersonList) {
            System.out.println(person.firstName + " " + person.lastName + " dateOfBirth: " + person.dateOfBirth);
        }
    }

    /* Testing Methods for ssn */
    public static void ssnSortingAscending(final List<Person> people) throws Exception {
        System.out.println("SSN sorted in Ascending Order");
        final List<Person> ssnAscPersonList = AnotherSorting.sorting(people, "ssn", "true");
        for (final Person person : ssnAscPersonList) {
            System.out.println(person.ssn + " " + person.firstName + " " + person.lastName);
        }
    }

    public static void ssnSortingDescending(final List<Person> people) throws Exception {
        System.out.println("SSN sorted in Descending Order");
        final List<Person> ssnDescPersonList = AnotherSorting.sorting(people, "ssn", "false");
        for (final Person person : ssnDescPersonList) {
            System.out.println(person.ssn + " " + person.firstName + " " + person.lastName);
        }
    }

    /* Testing Methods for height */
    public static void heightSortingAscending(final List<Person> people) throws Exception {
        System.out.println("heights in Inches sorted in Ascending Order");
        final List<Person> heightInAscPersonList = AnotherSorting.sorting(people, "heightIn", "true");
        for (final Person person : heightInAscPersonList) {
            System.out.println(person.ssn + " " + person.firstName + " " + person.lastName + " " + person.heightIn);
        }
    }

    public static void heightSortingDescending(final List<Person> people) throws Exception {
        System.out.println("heights in Inches sorted in Descending Order");
        final List<Person> heightInDescPersonList = AnotherSorting.sorting(people, "heightIn", "false");
        for (final Person person : heightInDescPersonList) {
            System.out.println(person.ssn + " " + person.firstName + " " + person.lastName + " " + person.heightIn);
        }
    }

    /* Testing Methods for height */
    public static void weightSortingAscending(final List<Person> people) throws Exception {
        System.out.println("weights in lb sorted in Ascending Order");
        final List<Person> weightLbAscPersonList = AnotherSorting.sorting(people, "weightLb", "true");
        for (final Person person : weightLbAscPersonList) {
            System.out.println(person.ssn + " " + person.firstName + " " + person.lastName + " " + person.weightLb);
        }
    }

    public static void weightSortingDescending(final List<Person> people) throws Exception {
        System.out.println("weights in lb sorted in Descending Order");
        final List<Person> weightLbDescPersonList = AnotherSorting.sorting(people, "weightLb", "false");
        for (final Person person : weightLbDescPersonList) {
            System.out.println(person.ssn + " " + person.firstName + " " + person.lastName + " " + person.weightLb);
        }
    }

}
