package pl.student.lab_spring;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PeopleService {
    private List<Person> people;

    @PostConstruct
    public void init() {
        people = new ArrayList<>();
        people.add(new Person("Jan", "Kowalski"));
        people.add(new Person("Anna", "Nowak"));
    }

    public List<Person> getPeople() { return people; }

    public void addPerson(Person p) { people.add(p); }

    public Person getPerson(int index) {
        if (index >= 0 && index < people.size()) {
            return people.get(index);
        }
        return null;
    }

    public void setPerson(int index, Person p) {
        if (index >= 0 && index < people.size()) {
            people.set(index, p);
        }
    }

    public void removePerson(int index) {
        if (index >= 0 && index < people.size()) {
            people.remove(index);
        }
    }
}