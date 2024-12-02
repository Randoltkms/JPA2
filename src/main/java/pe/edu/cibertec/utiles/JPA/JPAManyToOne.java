package pe.edu.cibertec.utiles.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Categoria;
import pe.edu.cibertec.domain.Libro;

import java.util.Date;

public class JPAManyToOne {
    public static void main(String[] args) {
        // referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        //Crear Libro
        Libro libro = new Libro("A20","Titulo 20","Autor 20",new Date(),280.93,null);


        // Referenciar categoria
        //em fin para buscar uha categoria en especifico

        Categoria categoria = em.find(Categoria.class, "C1");

        libro.setCategoria(categoria);
        //perssit
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();

    }
}