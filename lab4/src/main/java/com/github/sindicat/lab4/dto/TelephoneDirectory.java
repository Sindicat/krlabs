package com.github.sindicat.lab4.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "records")
public class TelephoneDirectory {

    private List<Contact> contact;

    public TelephoneDirectory() {
    }

    public TelephoneDirectory(final List<Contact> contact) {
        this.contact = contact;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(final List<Contact> contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TelephoneDirectory that = (TelephoneDirectory) o;
        return Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact);
    }
}
