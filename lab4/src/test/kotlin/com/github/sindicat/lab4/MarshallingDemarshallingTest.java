package com.github.sindicat.lab4;

import com.github.sindicat.lab4.dto.Contact;
import com.github.sindicat.lab4.dto.TelephoneDirectory;
import com.github.sindicat.lab4.dto.contact.Address;
import com.github.sindicat.lab4.dto.contact.Name;
import com.github.sindicat.lab4.dto.contact.Number;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MarshallingDemarshallingTest {

    @Test
    public void marshallingTest() throws JAXBException, IOException {
        final TelephoneDirectory telephoneDirectory = createTestTelephoneDirectory();

        JAXBContext context = JAXBContext.newInstance(TelephoneDirectory.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter writer = new StringWriter();
        marshaller.marshal(telephoneDirectory, writer);

        List<String> demarshallingResultByLine = Arrays.stream(writer.toString().split("\n"))
                .map(line -> line.trim())
                .collect(Collectors.toList());

        Path pathToTestFile = Paths.get("src/test/resources/data/telephone_book_test.xml");
        List<String> expectedValue = Files.readAllLines(pathToTestFile)
                .stream()
                .map(line -> line.trim())
                .collect(Collectors.toList());

        Assert.assertEquals(expectedValue, demarshallingResultByLine);
    }

    @Test
    public void demarshallingTest() throws JAXBException, IOException {
        File file = new File("src/test/resources/data/telephone_book_test.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(TelephoneDirectory.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        TelephoneDirectory actualTelephoneDirectory = (TelephoneDirectory) jaxbUnmarshaller.unmarshal(file);
        TelephoneDirectory expectedTelephoneDirectory = createTestTelephoneDirectory();

        Assert.assertEquals(expectedTelephoneDirectory, actualTelephoneDirectory);
    }

    private TelephoneDirectory createTestTelephoneDirectory() {
        final var name1 = new Name("Rowan", "Gill");
        final var address1 = new Address("London", "New York");
        final var number1 = new Number("+1-532-521-23", "+1-533-654-12");
        final var contact1 = new Contact(name1, number1, address1);

        final var name2 = new Name("Harley", "Gibson");
        final var address2 = new Address("Denver", "Denver");
        final var number2 = new Number("+1-331-521-77", "+1-939-654-32");
        final var contact2 = new Contact(name2, number2, address2);

        final var name3 = new Name("Ashley", "Evans");
        final var address3 = new Address("Waterville", "Bedford");
        final var number3 = new Number("+1-831-521-10", "+1-144-654-65");
        final var contact3 = new Contact(name3, number3, address3);

        return new TelephoneDirectory(
                List.of(
                        contact1,
                        contact2,
                        contact3
                )
        );
    }
}
