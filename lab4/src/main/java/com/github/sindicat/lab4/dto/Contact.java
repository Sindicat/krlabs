package com.github.sindicat.lab4.dto;

import com.github.sindicat.lab4.dto.contact.Address;
import com.github.sindicat.lab4.dto.contact.Name;
import com.github.sindicat.lab4.dto.contact.Number;

import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(name = "contact")
public class Contact {

    private Long id;

    private Long nextContactId;

    private Name name;

    private Number number;

    private Address address;

    public Contact() {
    }

    public Contact(final Name name, final Number number, final Address address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }

    public Contact(final Long id, final Long nextContactId, final Name name, final Number number, final Address address) {
        this.id = id;
        this.nextContactId = nextContactId;
        this.name = name;
        this.number = number;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getNextContactId() {
        return nextContactId;
    }

    public void setNextContactId(final Long nextContactId) {
        this.nextContactId = nextContactId;
    }

    public Name getName() {
        return name;
    }

    public void setName(final Name name) {
        this.name = name;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(final Number number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) &&
                Objects.equals(nextContactId, contact.nextContactId) &&
                Objects.equals(name, contact.name) &&
                Objects.equals(number, contact.number) &&
                Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nextContactId, name, number, address);
    }
}
