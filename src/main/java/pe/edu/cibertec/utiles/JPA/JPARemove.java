package pe.edu.cibertec.utiles.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Libro;

public class JPARemove {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibiotecas");
        EntityManager em = emf.createEntityManager();

        //referenciar un libro

        Libro libro = em.find(Libro.class, "A7");

        //Eliminar libro

        //Abro transaccion
        em.getTransaction().begin();

        //remuevo libro
        em.remove(libro);
        //Cierro transasccion

        em.getTransaction().commit();
    }
}
