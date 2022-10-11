package pkg13.jdbc.servicios;

/**
 * @author Mathias Fernandez <mathias_fernandez_24@hotmail.com>
 */
import java.util.Scanner;
import pkg13.jdbc.entidades.Fabricante;
import pkg13.jdbc.persistencia.FabricanteDAO;

public class FabricanteService {
    FabricanteDAO DAOfabricante = new FabricanteDAO();
    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Fabricante crearFabricante() {
        Fabricante f1 = new Fabricante();
        System.out.println("    Crear fabricante:");
        System.out.print("Nombre: ");
        f1.setNombre(sc.next());
        return f1;
    };
    
    
    public void ingresarFabricanteEnDB(Fabricante f){
        DAOfabricante.ingresarFabricanteEnDB(f);
    }
}
