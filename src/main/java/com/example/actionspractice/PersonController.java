package com.example.actionspractice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

  private final PersonService personService;

  @PostMapping
  public PersonDto createPerson(@RequestBody PersonDto personDto) {
    return personService.createPerson(personDto);
  }

  @GetMapping("/{id}")
  public PersonDto getPerson(@PathVariable Long id) {
    return personService.getPerson(id);
  }

  @DeleteMapping("/{id}")
  public void deletePerson(@PathVariable Long id) {
    personService.deletePerson(id);
  }

  @PutMapping("/{id}")
  public PersonDto updatePerson(@PathVariable Long id, @RequestBody PersonDto personDto) {
    return personService.updatePerson(id, personDto);
  }
}
