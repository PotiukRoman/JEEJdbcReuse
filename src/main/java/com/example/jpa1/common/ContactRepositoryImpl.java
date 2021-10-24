package com.example.jpa1.common;
import com.example.jpa1.common.Contact;
import com.example.jpa1.common.ContactRepository;

import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    int id;
    String first_name;
    String last_name;
    String phone;
    String command;

    public ContactRepositoryImpl() {
        // default
    }

    public ContactRepositoryImpl(Contact contact) {
        this.first_name = contact.getFirstName();
        this.last_name = contact.getLastName();
        this.phone = contact.getPhone();
    }

    @Override
    public void save(Contact contact) {
        command = "INSERT into contacts(firstName, lastName, phone) VALUES (?, ?, ?);";
        Command.insertIon(first_name, last_name, phone, command);
    }

    @Override
    public void saveBulk(List<Contact> list) {
        command = "INSERT into contacts(firstName, lastName, phone) VALUES (?, ?, ?);";
        Command.listToTable(list, command);
    }

    @Override
    public void update(Contact contact) {
        id = contact.getId();
        command = "update contacts set firstName= (?), lastName= (?), phone=(?)  where id=(?);";
        Command.renovatIon(id, first_name, last_name, phone, command);
    }

    @Override
    public void delete(int id) {
        command = "delete from contacts where id=(?);";
        Command.deletIon(id, command);
    }

    @Override
    public List<Contact> getContacts() {
        command = "SELECT * FROM test2.contacts;";
        return Command.allDataToList(command);
    }

    @Override
    public Contact getContactById(int id) {
        command = "SELECT * FROM test2.contacts where id=" + id + ";";
        return Command.selectIon(id, command);
    }
}