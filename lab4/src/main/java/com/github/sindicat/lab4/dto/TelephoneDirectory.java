package com.github.sindicat.lab4.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

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
}
