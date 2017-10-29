package pe.edu.tecsup.database;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.tecsup.database.dao.CursoDAO;
import pe.edu.tecsup.database.model.Curso;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDAOTests {

    @Autowired
    CursoDAO cursoDAO;
    
   @Test
    public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        for (Curso curso : cursos) {
            System.out.println(curso.getId());
            System.out.println(curso.getNombre());
        }
        Assert.assertTrue(cursos.size() > 0);
    }
    
   /*
    @Test
    public void verifyFind() {
    	Curso curso = cursoDAO.get(6l);
        System.out.println(curso.getId());
        System.out.println(curso.getNombre());
        Assert.assertTrue(curso.getId() == 6l);
    }
  
    */ 
    @Test
    public void verifySave() {

    	Curso curso = new Curso();
    	curso.setCodigo("9999");
    	curso.setNombre("Prueba programa 99999");
     

        cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }
   
    
    @Test
    public void verifyUpdate() {

        // cambiar el código para validar
    	Curso curso = new Curso();
    	curso.setId(20l);
    	curso.setCodigo("99999");
    	curso.setNombre("Programa PRUEBA 2");

    	cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(20l).getCodigo().equals("99999"));
    }
    
     

    
    @Test
    public void verifyDelete() {

    	Curso curso = new Curso();
    	curso.setId(5l);
        cursoDAO.delete(curso);

        Assert.assertTrue(cursoDAO.get(5l) == null);
    }
    
    
}
