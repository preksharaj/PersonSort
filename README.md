# PersonSort

Problem Statement
-----------
We have a person class:
class Person{ String ssn; Date dateOfBirth; String firstName; String lastName; Double heightIn; Double weightLb; }

And we are building a webpage that can display people sorted by any of the Person fields.
Sample request: /people?sortField=dateOfBirth&ascending=false

Please implement this method to sort the results:
static List sort(Iterable people, String sortField, String ascending){ }

Run Instructions
-----------
**Using IDE <br />**
-Clone the git repo and import the project in any IDE(eg Eclipse)<br />
-Run the project(Main.java) with Run as-> Java Application.<br />

**Command Prompt<br />**
-javac Main.java<br />
-java Main.java<br />


Implementation and Tradeoff
-----------
1. I have implemented 6 comparators one for each sort field.
The sorting method used is the Java 8 comparator.
TradeOff: Since the comparator is based on Merge sort algorithm, it gives the best complexity=O(N*log(N)) in sorting based on the sort field.
Complexity: O(N)-if the list is sorted, O(N*log(N))- if list is in random order.

2. Lambda changes in Java8 has simplified the comparators code and hence reduces the amount of code written for comparison.

3. I have decoupled the sorting algorithms form the collection object. So this is an advantage when we want to change the sorting algorithms irrespective of the collection.

4. 2 Approaches<br/>
a. Sorting.java
I have used a switch case to switch between then comparators based on the sort field and in each case check for the boolean   ascending. If its true then sort the list of People in the ascending order and if false then use the comparator.reversed()     to sort in the descending order.

b. AnotherSoritng.java
Since using a switch case leads to complexity:O(n) worst time as it might have to check every conditions before a match is     met, I have optimised this step and used a HashMap instead with the GET and PUT operartion complexities of O(1). 
In the map I have defined the key as the sort field and value as the respective soritng comparators.
Based on the sortfield a GET operation is done on the fieldComparatorMap and then the list of people will be sorted based on   that respective comparator.
Additonaly if the ascending is set to true the list is sorted in the ascending order and if set to false then 
comparator.reversed() is used to sort in the descending order.


Additional Features
-----------
1. When comparing and sorting based on sortfields-firstName and lastName, I have considerd the charcaters to be case insensitive and hence It will sort them in alphabetical order ignoring the case.

2. I have implmented buildPersonList which can be used to convert an iterable to a List.


Testing
-----------
PersonTest.java is the file that can run for testing the sorting approaches.
I have defined functions to test the sorting based on all the sortfields and also in ascending and descending order.

