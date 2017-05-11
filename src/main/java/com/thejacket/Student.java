package com.thejacket;

import javafx.scene.image.Image;
import org.hibernate.Session;

/**
 * Created by mariusz on 2017-05-11.
 */
public class Student extends Osoba {

    private int id;
    private int pesel;
    private int telefon;

    private String imie;
    private String nazwisko;
    private String kierunek;
    private String mail;

    private Image zdjecie;

    public void Student(int pesel, int telefon, String imie, String nazwisko, String kierunek, String mail){
        this.pesel = pesel;
        this.telefon = telefon;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.kierunek = kierunek;
        this.mail = mail;

        createNewStudentInDb();
    }

    public void createNewStudentInDb(){
        Session session = HibernateSession.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(this);

        session.getTransaction().commit();

        HibernateSession.getSessionFactory().close();
    }




    public void setId(int id) {
        this.id = id;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public void setZdjecie(Image zdjecie) {
        this.zdjecie = zdjecie;
    }

    public int getId() {
        return id;
    }

    public int getPesel() {
        return pesel;
    }

    public int getTelefon() {
        return telefon;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getKierunek() {
        return kierunek;
    }

    public Image getZdjecie() {
        return zdjecie;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
