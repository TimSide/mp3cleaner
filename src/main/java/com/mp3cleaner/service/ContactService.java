package com.mp3cleaner.service;

import java.util.List;

public interface ContactService {

    Contact save(Contact contact);

    List<Contact> findAll();

}
