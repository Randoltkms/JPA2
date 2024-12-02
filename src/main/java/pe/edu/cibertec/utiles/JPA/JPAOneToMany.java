package pe.edu.cibertec.utiles.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Categoria;
import pe.edu.cibertec.domain.Libro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class JPAOneToMany {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibiotecas");
        EntityManager em = emf.createEntityManager();

        //Crear categoria
        Categoria categoria = new Categoria("C6","Terror",null);


        //Crear libro
        Libro libro1 = new Libro("A11","Titulo 11","Autor 11",new Date(), 50.20,categoria);
        Libro libro2 = new Libro("A12","Titulo 12","Autor 12",new Date(), 50.20,categoria);

        //referencia libros en categorias
        categoria.setLibros(Arrays.asList(libro1, libro2));
        //pesist


        em.getTransaction().begin();
        em.persist(categoria);
        em.persist(libro1);
        em.persist(libro2);

        em.getTransaction().commit();
    }
}
