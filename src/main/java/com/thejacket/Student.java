package com.thejacket;

import javax.persistence.*;
import java.lang.String;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import org.hibernate.Session;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

/**
 * Created by mariusz on 2017-05-11.
 */
@Entity
//@Indexed
@Table(name = "Student")
public class Student extends Osoba {

    //@Column(name = "id")
    private IntegerProperty idProperty = new SimpleIntegerProperty();
    //@Column(name = "pesel")
    //@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private StringProperty peselProperty = new SimpleStringProperty();
    //@Column(name = "telefon")
    private StringProperty telefonProperty = new SimpleStringProperty();

    //@Column(name = "imie")
    //@Field(index=Index.YES, analyze=Analyze.YES, store= Store.NO)
    private StringProperty imieProperty = new SimpleStringProperty();
   // @Column(name = "nazwisko")
    //@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private StringProperty nazwiskoProperty = new SimpleStringProperty();
    //@Column(name = "kierunek")
    private StringProperty kierunekProperty = new SimpleStringProperty();
    //@Column(name = "mail")
    private StringProperty mailProperty = new SimpleStringProperty();

    private studenciController controller;

    public IntegerProperty idProperty() {
        return idProperty ;
    }
    @Id @GeneratedValue
    @Column(name = "id")
    public final Integer getId() {
        return this.idProperty().get();
    }

    public void setId(Integer id) {
        idProperty().set(id);
    }

    public StringProperty imieProperty() {
        return imieProperty ;
    }
    @Column(name = "imie")
    public String getImie() {
        return this.imieProperty().get();
    }

    public void setImie(String imie) {
        imieProperty().set(imie);
    }

    public StringProperty nazwiskoProperty() {
        return nazwiskoProperty ;
    }
    @Column(name = "nazwisko")
    public String getNazwisko() {
        return this.nazwiskoProperty().get();
    }

    public void setNazwisko(String nazwisko) {
        nazwiskoProperty().set(nazwisko);
    }

    public StringProperty peselProperty() {
        return peselProperty ;
    }
    @Column(name = "pesel")
    public String getPesel() {
        return this.peselProperty().get();
    }

    public void setPesel(String pesel) {
        peselProperty().set(pesel);
    }

    public StringProperty kierunekProperty() {
        return kierunekProperty ;
    }
    @Column(name = "kierunek")
    public String getKierunek() {
        return this.kierunekProperty().get();
    }

    public void setKierunek(String kierunek) {
        kierunekProperty().set(kierunek);
    }

    public StringProperty mailProperty() {
        return mailProperty ;
    }
    @Column(name = "mail")
    public String getMail() {
        return this.mailProperty().get();
    }

    public void setMail(String mail) {
        mailProperty().set(mail);
    }

    public StringProperty telefonProperty() {
        return telefonProperty ;
    }
    @Column(name = "telefon")
    public String getTelefon() {
        return this.telefonProperty().get();
    }

    public void setTelefon(String telefon) {
        telefonProperty().set(telefon);
    }

    public Student(){}

    public Student(String imie, String nazwisko, String kierunek, String pesel, String telefon, String mail){
        peselProperty = new SimpleStringProperty(pesel);
        telefonProperty = new SimpleStringProperty(telefon);
        imieProperty = new SimpleStringProperty(imie);
        nazwiskoProperty = new SimpleStringProperty(nazwisko);
        kierunekProperty = new SimpleStringProperty(kierunek);
        mailProperty = new SimpleStringProperty(mail);

        createNewStudentInDb();
    }


    public void createNewStudentInDb(){
        Session session = HibernateSession.getSessionFactory().getCurrentSession();
        //Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(this);

        session.getTransaction().commit();

        //HibernateSession.getSessionFactory().close();                 //with this exc: DataHolder.update : entitymanagerfactory is closed ????
                                                                        //is this because of running static methods?

    }



    public String toString(){
        return "Student" + this.idProperty + ": " + this.imieProperty + " " + this.nazwiskoProperty;
    }
}
