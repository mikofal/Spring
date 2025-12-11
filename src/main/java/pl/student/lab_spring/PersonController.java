package pl.student.lab_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    private final PeopleService peopleService;


    public PersonController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public String listPeople(Model model) {
        model.addAttribute("people", peopleService.getPeople());
        return "people";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
    model.addAttribute("person", new Person());
    return "add-person";
}

    @PostMapping("/save")
    public String savePerson(Person person) {
    peopleService.addPerson(person);
    return "redirect:/people";
}
}
