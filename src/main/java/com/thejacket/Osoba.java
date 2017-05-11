package com.thejacket;

import javafx.scene.image.Image;

/**
 * Created by mariusz on 2017-05-11.
 */
public abstract class Osoba {
    public abstract int getId();
    public abstract int getPesel();
    public abstract int getTelefon();
    public abstract String getImie();
    public abstract String getNazwisko();
    public abstract String getKierunek();
    public abstract Image getZdjecie();
}
