package com.example.jpa1.common;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "firstName")
    private String firstName;

    @Basic
    @Column(name = "lastName")
    private String lastName;

    @Basic
    @Column(name = "phone")
    private String phone;

    public Contact(){

    }

    public Contact(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Contact(int id, String firstName, String lastName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
    public String getLastName() {
        return lastName;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contacts = (Contact) o;

        if (id != contacts.id) return false;
        if (firstName != null ? !firstName.equals(contacts.firstName) : contacts.firstName != null) return false;
        if (lastName != null ? !lastName.equals(contacts.lastName) : contacts.lastName != null) return false;
        if (phone != null ? !phone.equals(contacts.phone) : contacts.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}'+"\n";
    }
}
