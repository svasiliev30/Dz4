package PersonTest;
import org.junit.jupiter.api.Test;
import sbp.Person.Person;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    /**
     * в данном тесте проходит сравнение добавленных  коллекций с отсортированным
     * порядком, сначала по полю city, а затем по полю name. Также сравнение 2 коллекций list и list2
     * Результат True
     */
    @Test
    public void EqualsTrue() {
        Person person = new Person("Бан", "Архангельск", 16);
        Person person1 = new Person("Сергей", "Витебск", 26);

        List<Person> list = new ArrayList<>();
        list.add(new Person("Витя", "Санкт-Петрбург", 17));
        list.add(new Person("Дурин1", "Санкт-Петрбург", 17));
        list.add(new Person("Ася", "Санкт-Петрбург", 17));
        list.add(person1);
        list.add(person);
        list.sort(Person::compareTo);
        assertEquals(person, list.get(0));
        System.out.println(person + " = " + list.get(0));

        assertEquals(person1, list.get(1));
        System.out.println(person1 + " = " + list.get(1));

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person("Витя", "Санкт-Петрбург", 17));
        list2.add(new Person("Дурин1", "Санкт-Петрбург", 17));
        list2.add(new Person("Ася", "Санкт-Петрбург", 17));
        list2.add(person1);
        list2.add(person);
        list2.sort(Person::compareTo);

        assertTrue(list.equals(list2));
        System.out.println("Объект list = объекту list2 "  );
    }

    /**
     * Идет добавление данных и сравнение 2 коллекций list и list2
     * Результат False
     */
    @Test
    public void NotEquals() {
        Person person = new Person("Бан", "Архангельск", 16);
        Person person1 = new Person("Сергей", "Витебск", 26);

        Person person2 = new Person("Бан", "Архангел", 16);
        Person person3 = new Person("Сергей", "Витеб", 26);

        List<Person> list = new ArrayList<>();
        list.add(new Person("Витя", "Санкт-Петрбург", 17));
        list.add(new Person("Дурин1", "Санкт-Петрбург", 17));
        list.add(new Person("Ася", "Санкт-Петрбург", 17));
        list.add(person);
        list.add(person1);
        list.sort(Person::compareTo);

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person("Витя", "Санкт-Петрбург", 17));
        list2.add(new Person("Дурин1", "Санкт-Петрбург", 17));
        list2.add(new Person("Ася", "Санкт-Петрбург", 17));
        list2.add(person2);
        list2.add(person3);
        list2.sort(Person::compareTo);

        list.equals(list2);
        assertFalse(list.equals(list2));
        System.out.println("Объект list != объекту list2 ");
    }

    /**
     * Идет проверка на подбрасыване ошибки NullPointerException
     * При city = null
     */
    @Test
    public void AddPersonNull() {

        List<Person> list = new ArrayList<>();
        list.add(new Person("Витя", "Санкт-Петрбург", 17));
        list.add(new Person("Дурин1", null, 17));
        list.add(new Person("Ася", "Санкт-Петрбург", 17));
       assertThrows(NullPointerException.class, () -> list.sort(Person::compareTo)) ;
    }

    /**
     * Идет проверка на подбрасыване ошибки NullPointerException
     * При name = null
     */
    @Test
    public void AddPersonNull2() {

        List<Person> list = new ArrayList<>();

        list.add(new Person(null, "Санкт-Петрбург", 17));
        list.add(new Person("Дурин1", "Санкт-Петрбург", 17));
        list.add(new Person("Ася", "Санкт-Петрбург", 17));
        assertThrows(NullPointerException.class, () -> list.sort(Person::compareTo)) ;
    }

    /**
     * Идет проверка на подбрасыване ошибки NullPointerException
     * list.add(null)
     */
    @Test
    public void AddNull() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Витя", "Санкт-Петрбург", 17));
        list.add(new Person("Дурин1", "Санкт-Петрбург", 17));
        list.add(new Person("Ася", "Санкт-Петрбург", 17));
        list.add(null);
        assertThrows(NullPointerException.class, () -> list.sort(Person::compareTo)) ;
    }
}


