package ru.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.dao.PeopleDAO;
import ru.spring.model.Person;

import javax.jws.WebParam;

@Controller
@RequestMapping("/people")
public class TestController {
    private PeopleDAO p;

    @Autowired
    public TestController(PeopleDAO p) {
        this.p = p;
    }

    @GetMapping()
    public String people(Model model) {
        model.addAttribute("people", p.people());
        return "/first/people";
    }

    @GetMapping("/{id}")
    public String person(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", p.get(id));
        return "/first/person";
    }

    @GetMapping("/new")
    public String createNew(Model model) {
        model.addAttribute("newPerson", new Person());
        return "/first/new";
    }

    @PostMapping("/added")
    public String added(@ModelAttribute(value = "person") Person person, Model model) {
        p.add(person);
        model.addAttribute("person", person);
        return "first/added";
    }

    @PatchMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id,
                       @ModelAttribute("newName") String newName, Model model) {
        model.addAttribute("editedPerson", p.get(id));
        return "first/edited";
    }

    @PatchMapping("/editingResults")
    public String editingResults(@ModelAttribute("edited") Person person) {
        return "/first/edited";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        Person person = p.get(id);
        model.addAttribute("deleted", person);
        model.addAttribute("deleted", p.delete(id) ? "deleted" : "no such element");
        return "/first/deletion";
    }

}
