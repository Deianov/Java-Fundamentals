//03. Opinion Poll

package F_ObjectsAndClasses.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class Person {

    private String personName;
    private int personAge;

    public String getPersonName() { return personName; }
    public int getPersonAge() { return personAge; }

    public Person(String personName, int personAge) {
        this.personName = personName;
        this.personAge = personAge;
    }

    private void print() {
        System.out.printf("%n%s - %d", this.personName, this.personAge);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personsList = new ArrayList<>();

        while (n-- > 0) {
            String[] line = scanner.nextLine().split(" ");
            Person person = new Person(line[0], Integer.parseInt(line[1]));
            personsList.add(person);
        }

        Collections.sort(personsList, new Comparator<Person>(){

            public int compare(Person object1, Person object2)
            {
                return object1.getPersonName().compareTo(object2.getPersonName());
            }
        });

        List<Person> filterList = personsList.stream().filter(e -> e.getPersonAge() > 30).collect(Collectors.toList());

        for (Person person : filterList) {
            person.print();
        }
    }
}
