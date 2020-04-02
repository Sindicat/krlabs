package com.github.sindicat.lab4;

import com.github.sindicat.lab4.dto.Contact;
import com.github.sindicat.lab4.dto.TelephoneDirectory;
import com.github.sindicat.lab4.dto.TelephoneDirectoryService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class TelephoneDirectoryServiceTest {

    @Test
    public void findAllSubContacts() throws JAXBException {
        File file = new File("src/test/resources/data/contact_links_test.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(TelephoneDirectory.class);

        final var jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        final var telephoneDirectory = (TelephoneDirectory) jaxbUnmarshaller.unmarshal(file);
        final var telephoneDirectoryService = new TelephoneDirectoryService(telephoneDirectory);
        final List<Contact> subContacts = telephoneDirectoryService.findAllSubContacts(2L);

        Assert.assertEquals(2, subContacts.size());
        Assert.assertEquals(Long.valueOf(1L), subContacts.get(0).getId());
        Assert.assertEquals(Long.valueOf(3L), subContacts.get(1).getId());
    }
}
