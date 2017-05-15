package com.thejacket;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.hibernate.Session;

import javax.persistence.*;

/**
 * Created by mariusz on 2017-05-15.
 */

@Entity
@Table(name = "PRZEDMIOTY")
public class Przedmiot {
    //@Column(name = "id")
    private IntegerProperty idProperty = new SimpleIntegerProperty();
    //@Column(name = "nazwa")
    private StringProperty nazwaProperty = new SimpleStringProperty();
    //@Column(name = "typ")
    private StringProperty typProperty = new SimpleStringProperty();

    //@Column(name = "prowadzacy")
    private StringProperty prowadzacyProperty = new SimpleStringProperty();
    // @Column(name = "wymiarGodzin")
    private IntegerProperty wymiarGodzinProperty = new SimpleIntegerProperty();
    //@Column(name = "ects")
    private IntegerProperty ectsProperty = new SimpleIntegerProperty();
    //@Column(name = "wydzial")
    private StringProperty wydzialProperty = new SimpleStringProperty();
    //@Column(name = "program")
    private ProgramStudiow programStudiow = new ProgramStudiow();

    //private przedmiotyController controller;


    public Przedmiot(){}

    public Przedmiot(String nazwa, String typ, String prowadzacy, Integer wymiarGodzin, Integer ects, String wydzial, ProgramStudiow program){
        nazwaProperty = new SimpleStringProperty(nazwa);
        typProperty = new SimpleStringProperty(typ);

        prowadzacyProperty = new SimpleStringProperty(prowadzacy);
        wymiarGodzinProperty = new SimpleIntegerProperty(wymiarGodzin);
        ectsProperty = new SimpleIntegerProperty(ects);
        wydzialProperty = new SimpleStringProperty(wydzial);
        programStudiow = program;

        createNewPrzedmiotInDb();
    }

    private void createNewPrzedmiotInDb() {
        Session session = HibernateSession.getSessionFactory().getCurrentSession();
        //Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(this);

        session.getTransaction().commit();

    }


    public IntegerProperty idProperty() {
        return idProperty ;
    }
    @Id
    @GeneratedValue
    @Column(name = "id")
    public final Integer getId() {
        return this.idProperty().get();
    }

    public final void setId(Integer id) {
        idProperty().set(id);
    }

    public StringProperty nazwaProperty() {
        return nazwaProperty ;
    }
    @Column(name = "nazwa")
    public final String getNazwa() {
        return this.nazwaProperty().get();
    }

    public final void setNazwa(String nazwa) {
        nazwaProperty().set(nazwa);
    }

    public StringProperty typProperty() {
        return typProperty ;
    }
    @Column(name = "typ")
    public final String getTyp() {
        return this.typProperty().get();
    }

    public final void setTyp(String typ) {
        typProperty().set(typ);
    }

    public StringProperty prowadzacyProperty() {
        return prowadzacyProperty ;
    }
    @Column(name = "prowadzacy")
    public final String getProwadzacy() {
        return this.prowadzacyProperty().get();
    }

    public final void setProwadzacy(String prowadzacy) {
        prowadzacyProperty().set(prowadzacy);
    }

    public IntegerProperty wymiarGodzinProperty() {
        return wymiarGodzinProperty ;
    }
    @Column(name = "wymiarGodzin")
    public final Integer getWymiarGodzin() {
        return this.wymiarGodzinProperty().get();
    }

    public final void setWymiarGodzin(Integer wymiarGodzin) {
        wymiarGodzinProperty().set(wymiarGodzin);
    }

    public IntegerProperty ectsProperty() {
        return ectsProperty ;
    }
    @Column(name = "ects")
    public final Integer getEcts() {
        return this.ectsProperty().get();
    }

    public final void setEcts(Integer ects) {
        ectsProperty().set(ects);
    }

    public StringProperty wydzialProperty() {
        return wydzialProperty ;
    }
    @Column(name = "wydzial")
    public final String getWydzial() {
        return this.wydzialProperty().get();
    }

    public final void setWydzial(String wydzial) {
        wydzialProperty().set(wydzial);
    }

    public ProgramStudiow programStudiow() {
        return programStudiow;
    }
    @Column(name = "programStudiow")
    public final String getProgramStudiow() {
        return this.programStudiow().toString();
    }


}
