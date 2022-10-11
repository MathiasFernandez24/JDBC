package pkg13.jdbc.persistencia;

/**
 * @author Mathias Fernandez <mathias_fernandez_24@hotmail.com>
 */
import java.util.Scanner;
import pkg13.jdbc.entidades.Fabricante;
import pkg13.jdbc.servicios.FabricanteService;

public class FabricanteDAO extends DAO {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    //ejercicio g
    public void ingresarFabricanteEnDB(Fabricante f) {
        
        String sql = "INSERT INTO fabricante (nombre)VALUES ('" + f.getNombre() + "');";
        try {
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println("ERROR ingresarFabricanteEnDB");

        }
    }
}
