package pe.edu.cibertec.utiles.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Categoria;

public class JPAOneToManyRemove {

    public static void main(String[] args) {
        // referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibiotecas");
        EntityManager em = emf.createEntityManager();

        //Referencias a una categoria
        Categoria categoria = em.find(Categoria.class, "C2");
        //Eliminamos la categoria

        em.getTransaction().begin();
        em.remove(categoria);
        em.getTransaction().commit();

    }
}
