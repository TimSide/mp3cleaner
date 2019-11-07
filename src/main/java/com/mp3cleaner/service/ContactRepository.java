package com.mp3cleaner.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findAll();

}
