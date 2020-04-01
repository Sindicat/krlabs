package com.github.sindicat.lab4.dto.contact;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(name = "name")
public class Name {

    private String first;

    private String last;

    public Name() {
    }

    public Name(final String first, final String last) {
        this.first = first;
        this.last = last;
    }

    @XmlAttribute(name = "first")
    public String getFirst() {
        return first;
    }

    public void setFirst(final String first) {
        this.first = first;
    }

    @XmlAttribute(name = "last")
    public String getLast() {
        return last;
    }

    public void setLast(final String last) {
        this.last = last;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name = (Name) o;
        return Objects.equals(first, name.first) &&
                Objects.equals(last, name.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }
}
