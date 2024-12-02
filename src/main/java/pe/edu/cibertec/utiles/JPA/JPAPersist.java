
package pe.edu.cibertec.utiles.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Libro;

import java.util.Date;

public class JPAPersist {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibiotecas");
        EntityManager em = emf.createEntityManager();

        //Registrar nuevo libro
        //Establecemos la transacion
        //Toda insercion o acion que haga cambios tiene que estar emcapsulado
        //registrar libro

        em.getTransaction().begin();

        em.persist(new Libro("A7", "Titulo3","Autor3",new Date(), 100.5,null));
        //confirmamos una transaccion
        em.getTransaction().commit();






    }



}