package com.example.jpa1.common;

import java.util.List;

public interface ContactRepository {

    void save(Contact contact);

    void saveBulk(List<Contact> contact);

    void update(Contact contact);

    void delete(int id);

    List<Contact> getContacts();

    Contact getContactById(int id);
}