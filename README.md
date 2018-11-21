# PersonSort

###Problem Statement
We have a person class:
class Person{ String ssn; Date dateOfBirth; String firstName; String lastName; Double heightIn; Double weightLb; }

And we are building a webpage that can display people sorted by any of the Person fields.
Sample request: /people?sortField=dateOfBirth&ascending=false

Please implement this method to sort the results:
static List sort(Iterable people, String sortField, String ascending){ }

###Run Instructions
Clone the git repo and use any IDE to open the package.
Run the Main.java as Java Application.

PersonTest.java can be run to test all the sorting methods based on all the sort fields.

OR

javac -d out src/*.java

javac Main.java
java Main.java

###Implementations and TradeOffs
1. I have implemented 6 comparators one for each sort field.
The sorting method used is the Java 8 comparator.
TradeOff= Since the comparator is based on Merge sort algorithm, it gives the best complexity=O(N*log(N)) in sorting based on the sort field.
Complexity: O(N)=if the list is sorted, O(N*log(N))= if list is in random order.

2. Lambda changes in Java8 has simplified the comparators code and hence reduces the amount of code written for comparison.

3. I have decoupled the sorting algorithms form the collection object. So this is an advantage when we want to change the sorting algorithms irrespective of the collection.

4. 
Sorting.java
I have used a switch case to switch between then comparators based on the sort field and in each case check for the boolean ascending. If its true then sort the list of People in the ascending order and if false then use the comparator.reversed() to sort in the descending order.

AnotherSoritng.java
Since using a switch case leads to complexity:O(n) worst time as it might have to check every conditions before a match is met, I have optimised this step and used a HashMap instead with the GET and PUT operartion complexities of O(1). 
In the map I have defined the key as the sort field and value as the respective soritng comparators.
Based on the sortfield a GET operation is done on the fieldComparatorMap and then the list of people will be sorted based on that respective comparator.
Additonaly if the ascending is set to true the list is sorted in the ascending order and if set to false then 
comparator.reversed() is used to sort in the descending order.


###Additional Features
1. When comparing and sorting based on sortfields-firstName and lastName, I have considerd the charcaters to be case insensitive and hence It will sort them in alphabetical order ignoring the case.

2. I have implmented buildPersonList which can be used to convert an iterable to a List.


###Testing
PersonTest.java is the file that can run for testing the sorting approaches.
I have defined functions to test the sorting based on all the sortfields and also in ascending and descending order.

JUnit Test Case
-We can use Mockito test framework and develope JUnit Test case to test each function

@Test
    public void sortOnFirstName() throws Exception {
    
    final String expectedPattern = "MM/dd/yyyy";
        final SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);

        final Person p1 = new Person("1", formatter.parse("09/22/2009"), "Chris", "Brown", 5.3, 115.3);
        final Person p2 = new Person("2", formatter.parse("05/15/2011"), "Jen", "Mathew", 5.5, 110.0);
        final Person p3 = new Person("3", formatter.parse("05/08/2011"), "Becky", "smith", 5.7, 180.9);

        final List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        List<Person> firstNameAscPersonList = AnotherSorting.sorting(personList, "firstName", "true");
        assertTrue(firstNameAscPersonList.get(0).getFirstName().equals("Becky"));
        assertTrue(firstNameAscPersonList.get(1).getFirstName().equals("Chris"));
        assertTrue(firstNameAscPersonList.get(2).getFirstName().equals("Jen"));

        List<Person> firstNameDescPersonList = AnotherSorting.sorting(personList, "firstName", "false");
        assertTrue(firstNameDescPersonList.get(2).getFirstName().equals("Becky"));
        assertTrue(firstNameDescPersonList.get(1).getFirstName().equals("Chris"));
        assertTrue(firstNameDescPersonList.get(0).getFirstName().equals("Jen"));

    }
