package com.journaldev.hibernate.main;

/**
 * Created by bb on 13.10.2016.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.model.ImageWrapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.journaldev.hibernate.model.Employee1;
import com.journaldev.hibernate.util.HibernateUtil;



public class ImageSaveTest {

    public static void main(String[] args) {



        File file = new File("C:\\test.png");
        byte[] imageData = new byte[(int) file.length()];
        System.out.println(file.length());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(imageData);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageWrapper imageWrapper = new ImageWrapper();
        imageWrapper.setName("firstImage.jpeg");
        imageWrapper.setData(imageData);

        //Get Session
        SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(imageWrapper);


        //session.delete(emp);
        //Commit transaction

        System.out.println("ImageName ="+imageWrapper.getName());


        ImageWrapper imRead = (ImageWrapper) session.get(ImageWrapper.class, 2);
        byte[] rData = imRead.getData();

        try{
            FileOutputStream fos = new FileOutputStream("C:\\test_read2.png");
            fos.write(rData);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        session.getTransaction().commit();
        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }
}
