package ar.com.nec.blockbuster;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ar.com.nec.blockbuster.entities.*;
public class MainClass {

/*	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;*/

	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();


				Cliente pepe = new Cliente("pepe",123);
				Pelicula batman = new Pelicula("Batman","Accion");
				Pelicula superman = new Pelicula("Superman","Accion");
				sessionObj.save(batman);
				sessionObj.save(superman);
				Alquileres alquiler1 = new Alquileres();
				alquiler1.setPelicula(batman);
				alquiler1.setCliente(pepe);
				pepe.addAlquiler(alquiler1);
				Alquileres alquiler2 = new Alquileres();
				alquiler2.setPelicula(superman);
				alquiler2.setCliente(pepe);
				pepe.addAlquiler(alquiler2);
				sessionObj.save(pepe);
				sessionObj.getTransaction().commit();

		} catch(Exception sqlException) {

			sqlException.printStackTrace();
		}


		/*try {
			con = connection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select p.nombre, g.nombre as genero from blockbuster.peliculas p\n" +
					"join blockbuster.generos g on g.idGeneros = p.genero\n" +
					"where g.nombre = \"accion\" ");
			String nombre ="";
			String genero = "";

			while (rs.next()) {
				nombre = rs.getString("nombre");
				genero = rs.getString("genero");
				System.out.println(nombre + " " +genero);
			}

		}
		catch (Exception e){
			System.out.println(e);
		}*/

	}

}
