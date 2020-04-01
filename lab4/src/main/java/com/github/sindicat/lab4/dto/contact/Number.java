package com.github.sindicat.lab4.dto.contact;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

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
}
