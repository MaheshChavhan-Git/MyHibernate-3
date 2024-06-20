package com.mahesh.MyHibernate_3;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author MAHESH
 *
 */
public class HibernateUtils {
	private static SessionFactory sessionfactory;

	private HibernateUtils() {
		// prevents initialization from outside class
	}

	// method to return the SessionFactory object
	public static SessionFactory getSessionFactory() {
		if (sessionfactory == null) {
			sessionfactory = createSessionFactory();
		}
		return sessionfactory;
	}

	private static SessionFactory createSessionFactory() {
		StandardServiceRegistry serviceregistry = null;
		try {
			// create StandardServiceRegistry
			StandardServiceRegistryBuilder serviceregistrybuilder = new StandardServiceRegistryBuilder();
			serviceregistrybuilder.loadProperties("hibernate.properties");
			serviceregistry = serviceregistrybuilder.build();

			// create Metadata Source
			MetadataSources metadatasource = new MetadataSources(serviceregistry);
			metadatasource.addAnnotatedClass(Employee.class);

			// create metadata
			Metadata metadata = metadatasource.getMetadataBuilder().build();

			// create SessionFatory
			return metadata.getSessionFactoryBuilder().build();

		} catch (Exception e) {
			e.printStackTrace();
			if (serviceregistry != null) {
				StandardServiceRegistryBuilder.destroy(serviceregistry);
			}
			throw new RuntimeException("There was an Error to bilding SessionFactory. . . . !", e);
		}
	}
}
