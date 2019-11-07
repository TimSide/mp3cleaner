package com.mp3cleaner.service;

import com.mp3cleaner.entity.Contact;

import java.util.List;

/**
 * Date: 27.08.15
 * Time: 17:22
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 * @author http://mruslan.com
 */
public interface ContactService {

    Contact save(Contact contact);

    List<Contact> findAll();

}
