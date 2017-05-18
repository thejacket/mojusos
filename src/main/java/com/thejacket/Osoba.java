package com.thejacket;

import javafx.scene.image.Image;

/**
 * Created by mariusz on 2017-05-11.
 */
public abstract class Osoba {
    public abstract Integer getId();
    public abstract String getPesel();
    public abstract String getTelefon();
    public abstract String getImie();
    public abstract String getNazwisko();
    public abstract String getKierunek();
    public abstract String getMail();           // deleting this abstract method causes getMail method from Student class to hide from Hibernate?
}
