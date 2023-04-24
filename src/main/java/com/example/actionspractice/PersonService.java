package com.example.actionspractice;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  private static PersonDto mapToDto(Person savedPerson) {
    return new PersonDto(savedPerson.getId(), savedPerson.getName());
  }

  public PersonDto getPerson(Long id) {
    var foundPerson = personRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Person not found"));
    return mapToDto(foundPerson);
  }

  @Transactional
  public PersonDto createPerson(PersonDto personDto) {
    var person = new Person();
    person.setName(personDto.getName());
    var savedPerson = personRepository.save(person);
    return mapToDto(savedPerson);
  }

  @Transactional
  public PersonDto updatePerson(Long id, PersonDto personDto) {
    var foundPerson = personRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Person not found"));
    foundPerson.setName(personDto.getName());
    var savedPerson = personRepository.save(foundPerson);
    return mapToDto(savedPerson);
  }

  @Transactional
  public void deletePerson(Long id) {
    personRepository.deleteById(id);
  }
}
