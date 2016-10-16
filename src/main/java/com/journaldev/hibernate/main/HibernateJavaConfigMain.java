package com.journaldev.hibernate.main;

import java.util.Date;

import com.journaldev.hibernate.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.journaldev.hibernate.model.Employee1;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateJavaConfigMain {

    public static void main(String[] args) {
        Employee1 emp = new Employee1();
        emp.setName("trr");
        emp.setRole("e");
        emp.setInsertTime(new Date());

        //Get Session
        SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);


        //session.delete(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID="+emp.getId());

        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }

}