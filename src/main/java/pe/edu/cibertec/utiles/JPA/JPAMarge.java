package pe.edu.cibertec.utiles.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Libro;

public class JPAMarge {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibiotecas");
        EntityManager em = emf.createEntityManager();

        //referencias libro

        Libro libro = em.find(Libro.class, "A1");
        //Aca modificamos la columana
        libro.setAutor("Gabriel Randol Sanchez");
        //persistimos Actualizar libro
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();







    }
}
