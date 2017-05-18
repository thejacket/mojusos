package com.thejacket;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Entity;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by mariusz on 2017-05-12.
 */
public class DataHolder {

    //static Integer lastUsedId = new Integer(0);
    static List<Student> studentList = new ArrayList<Student>();
    static List<Przedmiot> przedmiotList = new ArrayList<Przedmiot>();
    UsosSQLConnector usosSQLConnector = new UsosSQLConnector();

    private static void update(String whatToUpdate) {
        Session s = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = s.beginTransaction();

            // here get object
            if(whatToUpdate.equals("studentList")) {
                studentList = s.createCriteria(Student.class).list();
            } else if (whatToUpdate.equals("przedmiotList")) {
                przedmiotList = s.createCriteria(Przedmiot.class).list();
            }

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            Logger.getLogger("con").info("Exception: " + ex.getMessage());
            ex.printStackTrace(System.err);
        } finally {
            s.close();

        }
    }

    public static void main(String[] args) throws SQLException {
        DataHolder dh = new DataHolder();
        //dh.update();
        for (Student s : studentList) {
            System.out.println(s.toString());
        }
    }

    public static void removeFromDb(Object o, Integer i) {            // Integer id instead
        Session sess = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = sess.beginTransaction();
            Object persistentInstance = null;
            if(o.getClass() == Student.class) {
                persistentInstance = sess.load(Student.class, i);
            } else if (o.getClass() == Przedmiot.class) {
                persistentInstance = sess.load(Przedmiot.class, i);
            }
            if (persistentInstance != null) {
                sess.delete(persistentInstance);
            }

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            Logger.getLogger("con").info("Exception: " + ex.getMessage());
            ex.printStackTrace(System.err);
        } finally {
            sess.close();

        }
    }


    public static List<Student> getStudentObjectsList(){
        update("studentList");
        return studentList;
    }
    public static List<Przedmiot> getPrzedmiotObjectsList(){
        update("przedmiotList");
        return przedmiotList;
    }


}
