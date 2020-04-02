package com.github.sindicat.lab4.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TelephoneDirectoryService {

    private final Map<Long, Contact> contactById;

    public TelephoneDirectoryService(final TelephoneDirectory telephoneDirectory) {
        contactById = telephoneDirectory.getContact().stream()
                .collect(Collectors.toMap(Contact::getId, Function.identity()));
    }

    public List<Contact> findAllSubContacts(final Long contactId) {
        final Contact contact = contactById.get(contactId);
        if (contact.getNextContactId() == null) {
            return List.of();
        } else {
            return findSubContacts(contactById.get(contact.getNextContactId()));
        }
    }

    private List<Contact> findSubContacts(final Contact contact) {
        final var nextContactId = contact.getNextContactId();
        if (nextContactId == null) {
            return List.of(contact);
        }
        final var subContacts = new ArrayList<Contact>();
        subContacts.add(contact);
        subContacts.addAll(findSubContacts(contactById.get(nextContactId)));
        return subContacts;
    }

}
