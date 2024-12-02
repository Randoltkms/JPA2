package pe.edu.cibertec.queries;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import pe.edu.cibertec.domain.Libro;

import java.lang.reflect.Type;
import java.util.List;

public class JPAQuery {
    public static void main(String[] args) {
        // referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibiotecas");
        EntityManager em = emf.createEntityManager();

        //realizar un selec

        //TypedQuery<Libro> query = em.createQuery("select l from Libro l", Libro.class);

        // selec - where

        //TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.autor= :autor", Libro.class);
        //query.setParameter("autor", "Jose");

        // Selec * from - comparativa (><=)

       // TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.precio= :precio", Libro.class);
        //query.setParameter("precio", 50);

        TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.precio between :inicio and :fin ", Libro.class);
        query.setParameter("inicio", 50);
        query.setParameter("fin", 50);


        //obtener resultados

        List<Libro> resultado = query.getResultList();
        resultado.forEach(System.out::println);
    }
}
