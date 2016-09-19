package streams; /**
 * Created by Yaroslav on 19.09.16.
 */

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestStreams extends TestCase {
    private void addItem(Person item, List<Person> l1, List<Person> l2) {
        l1.add(new Person(item));
        l2.add(new Person(item));
    }

    private boolean auxiliary(List<Person> l1, List<Person> l2) {
        if (l1.size() == l2.size()) {
            for (int i = 0; i < l1.size(); i++) {
                if (l1.get(i).equals(l2.get(i)) == false) return false;
            }
        }
        return true;
    }

    private void fillLists(List<Person> l1, List<Person> l2) {
        addItem(new Person("Jim", 2), l1, l2);
        addItem(new Person("Addy", 203), l1, l2);
        addItem(new Person("James", 10), l1, l2);
        addItem(new Person("Jilly", 8), l1, l2);
        addItem(new Person("Jack", 13), l1, l2);
        addItem(new Person("Bred", 215), l1, l2);
        addItem(new Person("Eddi", 120), l1, l2);
        addItem(new Person("Tom", 23), l1, l2);
        addItem(new Person("Tommy", 2), l1, l2);
        addItem(new Person("Ben", 29), l1, l2);
        addItem(new Person("Alice", 4), l1, l2);
    }


    public void testFilter() {
        List<Person> persons1 = new ArrayList<>();
        List<Person> persons2 = new ArrayList<>();
        fillLists(persons1, persons2);
        Map map = Streams.of(persons1).filter(p -> p.getAge() > 20).toMap(Person::getName, Person::getAge);
        persons2.forEach(p -> {
            if (p.getAge() <= 20) {
                assertEquals(false, map.containsKey(p.getName()));
            } else {
                assertEquals(true, map.containsKey(p.getName()));
                assertEquals(p.getAge(), map.get(p.getName()));
            }
        });
        assertEquals(true, auxiliary(persons1, persons2));
    }


    public void testToMap() {
        List<Person> persons1 = new ArrayList<>();
        List<Person> persons2 = new ArrayList<>();
        fillLists(persons1, persons2);
        Map map = Streams.of(persons1).toMap(Person::getName, Person::getAge);
        persons2.forEach(p -> {
            assertEquals(true, map.containsKey(p.getName()));
            assertEquals(p.getAge(), map.get(p.getName()));

        });
        assertEquals(true, auxiliary(persons1, persons2));
    }

    public void testTransform() {
        List<Person> persons1 = new ArrayList<>();
        List<Person> persons2 = new ArrayList<>();
        fillLists(persons1, persons2);
        Map map = Streams.of(persons1).transform(p ->
                new OldPerson((Person) p)).toMap(OldPerson::getName, OldPerson::getPension);
        persons2.forEach(person -> {
            assertEquals(true, map.containsKey(person.getName()));
            assertEquals(OldPerson.getMinimumPension(), map.get(person.getName()));
        });
    }
}
