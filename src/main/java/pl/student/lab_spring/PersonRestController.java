package pl.student.lab_spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    private final PeopleService peopleService;

    public PersonRestController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        return peopleService.getPeople();
    }


    @GetMapping("/people/{index}")
    public ResponseEntity<Person> getPerson(@PathVariable int index) {
        Person p = peopleService.getPerson(index);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/people")
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        peopleService.addPerson(person);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/people/{index}")
    public ResponseEntity<?> updatePerson(@PathVariable int index, @RequestBody Person person) {
        if (peopleService.getPerson(index) != null) {
           peopleService.setPerson(index, person);
           return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/people/{index}")
    public ResponseEntity<?> deletePerson(@PathVariable int index) {
        if (peopleService.getPerson(index) != null) {
            peopleService.removePerson(index);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}