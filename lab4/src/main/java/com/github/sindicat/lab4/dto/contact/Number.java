package com.github.sindicat.lab4.dto.contact;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(name = "number")
public class Number {

    private String home;

    private String work;

    public Number() {
    }

    public Number(final String home, final String work) {
        this.home = home;
        this.work = work;
    }

    @XmlAttribute(name = "home")
    public String getHome() {
        return home;
    }

    public void setHome(final String home) {
        this.home = home;
    }

    @XmlAttribute(name = "work")
    public String getWork() {
        return work;
    }

    public void setWork(final String work) {
        this.work = work;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Number number = (Number) o;
        return Objects.equals(home, number.home) &&
                Objects.equals(work, number.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(home, work);
    }
}
