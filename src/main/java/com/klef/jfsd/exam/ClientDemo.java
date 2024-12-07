package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
    	if (args.length > 0) {
            System.out.println("Command-line arguments are not required for this program.");
        }
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            // Start transaction
            session.beginTransaction();

            // Create Device
            Device device = new Device();
            device.setBrand("GenericBrand");
            device.setModel("GenericModel");
            device.setPrice(500.0);
            session.save(device);

            // Create Smartphone
            Smartphone smartphone = new Smartphone();
            smartphone.setBrand("Apple");
            smartphone.setModel("iPhone 14");
            smartphone.setPrice(1200.0);
            smartphone.setOperatingSystem("iOS");
            smartphone.setCameraResolution("12 MP");
            session.save(smartphone);

            // Create Tablet
            Tablet tablet = new Tablet();
            tablet.setBrand("Samsung");
            tablet.setModel("Galaxy Tab S8");
            tablet.setPrice(800.0);
            tablet.setScreenSize("11 inches");
            tablet.setBatteryLife("10 hours");
            session.save(tablet);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Records inserted successfully!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
