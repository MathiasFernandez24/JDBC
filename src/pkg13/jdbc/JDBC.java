package pkg13.jdbc;

import pkg13.jdbc.entidades.Fabricante;
import pkg13.jdbc.entidades.Producto;
import pkg13.jdbc.servicios.FabricanteService;
import pkg13.jdbc.servicios.ProductoService;

/**
 *
 * @author Mathias Fernandez <mathias_fernandez_24@hotmail.com>
 */
public class JDBC {

    public static void main(String[] args) throws Exception {
        ProductoService pSv = new ProductoService();
        FabricanteService fSv = new FabricanteService();
        
//        Producto p1 = pSv.crearProducto(); //descomentar cuando se necesite un objeto producto para ingresar a la DB
//        Fabricante f1 = fSv.crearFabricante(); //descomentar cuando se necesite un objeto fabricante para ingresar a la DB
        
        //-----------------------------------------//
        
//        pSv.verNombreTodosProductos();
//        pSv.verNombreYPrecioTodosProductos();
//        pSv.buscarProductosPorRangoDePrecio();
//        pSv.buscarProductosPorPalabraClave();
//        pSv.productoMasBarato();

//        pSv.ingresarProducto(p1);
//        fSv.ingresarFabricanteEnDB(f1);

//        pSv.modificarPrecioProducto(p1);
        pSv.modificarDatosProducto();
    }
}
