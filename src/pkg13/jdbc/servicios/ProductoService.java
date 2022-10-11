package pkg13.jdbc.servicios;

/**
 * @author Mathias Fernandez <mathias_fernandez_24@hotmail.com>
 */
import java.util.Scanner;
import pkg13.jdbc.entidades.Producto;
import pkg13.jdbc.persistencia.ProductoDAO;

public class ProductoService {

    ProductoDAO DAOproducto = new ProductoDAO();

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Producto crearProducto() {
        Producto producto = new Producto();

        System.out.println("    CREAR PRODUCTO:");
        System.out.print("Nombre:");
        producto.setNombre(sc.next());
        System.out.print("Precio:");
        producto.setPrecio(sc.nextFloat());
        System.out.print("Codigo de Fabricante:");
        producto.setCodigoFabricante(sc.nextInt());
        return producto;
    }

    public void ingresarProducto(Producto producto) throws Exception {
        DAOproducto.ingresarProducto(producto);
    }

    public void verNombreTodosProductos() throws Exception {
        DAOproducto.verNombreTodosProductos();
    }

    public void verNombreYPrecioTodosProductos() throws Exception {
        DAOproducto.verNombreYPrecioTodosProductos();
    }

    public void buscarProductosPorRangoDePrecio() throws Exception {
        DAOproducto.buscarProductosPorRangoDePrecio();
    }

    public void buscarProductosPorPalabraClave() throws Exception {
        DAOproducto.buscarProductosPorPalabraClave();
    }

    public void productoMasBarato() throws Exception {
        DAOproducto.productoMasBarato();
    }

    public void modificarDatosProducto() throws Exception {
        DAOproducto.modificarDatosProducto();
    }


}

//    private Integer codigo;
//    private String nombre;
//    private double precio;
//    private Integer codigoFabricante;
