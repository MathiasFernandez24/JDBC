package pkg13.jdbc.persistencia;

import java.util.ArrayList;
import java.util.Scanner;
import pkg13.jdbc.entidades.Producto;

/**
 * @author Mathias Fernandez <mathias_fernandez_24@hotmail.com>
 */
public class ProductoDAO extends DAO {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
// ejercicio a

    public void verNombreTodosProductos() throws Exception {
        System.out.println("    Nombres de los productos:");
        try {
            String sql = "select nombre from producto;";
            consultarBase(sql);

            ArrayList listaNombres = new ArrayList();
            while (resultado.next()) {
                listaNombres.add(resultado.getString(1));
            }
            for (Object nombre : listaNombres) {
                System.out.println(nombre);
            }
        } catch (Exception e) {
            System.out.println("ERROR verNombreTodosProductos");
        } finally {
            desconectarBase();
        };
    }

    // ejercicio b
    public void verNombreYPrecioTodosProductos() throws Exception {
        System.out.println("    Nombres y precios de los productos:");
        try {
            String sql = "select nombre, precio from producto;";
            consultarBase(sql);

            ArrayList listaNombres = new ArrayList();
            ArrayList listaPrecios = new ArrayList();
            while (resultado.next()) {
                listaNombres.add(resultado.getString(1));
                listaPrecios.add(resultado.getString(2));
            }
            for (int i = 0; i < listaNombres.size(); i++) {
                System.out.print(listaNombres.get(i));
                System.out.println(", $" + listaPrecios.get(i));
            }
        } catch (Exception e) {
            System.out.println("ERROR verNombreYPrecioTodosProductos");
        } finally {
            desconectarBase();
        };
    }

    // ejercicio c
    public void buscarProductosPorRangoDePrecio() throws Exception {
        System.out.println("    Nombres y precios de los productos:");
        System.out.println("Precio minimo a buscar: ");
        int min = sc.nextInt();
        System.out.println("Precio maximo a buscar: ");
        int max = sc.nextInt();

        try {
            String sql = "select * from producto where precio >=" + min + " and precio <= " + max + ";";
            consultarBase(sql);

            ArrayList<Producto> listaProductos = new ArrayList<Producto>();
            while (resultado.next()) {
                //armo el producto y lo agrego a la lista
                listaProductos.add(new Producto(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3), resultado.getInt(4)));
            }
            for (Producto producto : listaProductos) {
                System.out.println(producto);
            }
        } catch (Exception e) {
            System.out.println("ERROR buscarProductosPorRangoDePrecio");
        } finally {
            desconectarBase();
        };
    }

    //ejecicio d
    public void buscarProductosPorPalabraClave() throws Exception {
        System.out.println("    Nombres y precios de los productos:");
        System.out.print("Palabra a buscar: ");
        String busqueda = sc.next();

        //select * from producto where nombre like '%portatil%';
        try {
            String sql = "select * from producto where nombre like '%" + busqueda + "%';";
            consultarBase(sql);

            ArrayList<Producto> listaProductos = new ArrayList<Producto>();
            while (resultado.next()) {
                //armo el producto y lo agrego a la lista
                listaProductos.add(new Producto(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3), resultado.getInt(4)));
            }
            for (Producto producto : listaProductos) {
                System.out.println(producto);
            }
        } catch (Exception e) {
            System.out.println("ERROR buscarProductosPorPalabraClave");
        } finally {
            desconectarBase();
        };
    }

    //ejercicio e
    public void productoMasBarato() throws Exception {
        System.out.println("    Producto mas barato:");

        try {
            String sql = "select * from producto order by precio asc limit 1;";
            consultarBase(sql);
            while (resultado.next()) {
                Producto productoMasBarato = new Producto(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3), resultado.getInt(4));
                System.out.println(productoMasBarato);
            }
        } catch (Exception e) {
            System.out.println("ERROR productoMasBarato");
        } finally {
            desconectarBase();
        };
    }

    //ejercicio f
    public void ingresarProducto(Producto p) throws Exception {
        try {
            if (p == null) {
                throw new Exception("producto vacio(null)");
            }
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante)VALUES ("
                    + "'" + p.getNombre() + "'," + p.getPrecio() + "," + p.getCodigoFabricante() + ");";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println("Error ingresarProducto");
        }
    }

    //ejercicio h
    public void modificarDatosProducto() throws Exception {
        System.out.println("   MODIFICAR DATOS: \n");
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        try {
            verTodosDatosProducto(); //llamo a funcion para ver los datos actuales
            System.out.print("\nIngrese codigo del producto a modificar: ");
            int codigoAModificar = sc.nextInt();
            System.out.println("Dato a modificar: \n 1-nombre\n 2-precio\n 3-codigo fabricante");
            int datoAModificar = sc.nextInt();
            String sql;
            switch (datoAModificar) {
                case 1:
                    System.out.print("Ingrese nuevo nombre: ");
                    String nombre = sc.next();
                    sql = "update producto set nombre = '" + nombre + "' where codigo=" + codigoAModificar + ";";
                    break;
                case 2:
                    System.out.print("Ingrese nuevo precio: ");
                    int precio = sc.nextInt();
                    sql = "update producto set precio = '" + precio + "' where codigo=" + codigoAModificar + ";";
                    break;
                case 3:
                    System.out.print("Ingrese nuevo codigo de fabricante: ");
                    int codigoFabricante = sc.nextInt();
                    sql = "update producto set codigo_fabricante = '" + codigoFabricante + "' where codigo=" + codigoAModificar + ";";
                    break;
                default:
                    sql = "vacio";
                    System.out.println("ERROR Opcion Invalida");
            }
            insertarModificarEliminar(sql);

        } catch (Exception e) {
            System.out.println("Error modificarDatosProducto");
        }
    }

    //esta funcion solo sirve para printear los datos
    public void verTodosDatosProducto() throws Exception {
        System.out.println("   VER DATOS PRODUCTO: ");
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        try {
            String sql = "select * from producto;";
            consultarBase(sql);
            while (resultado.next()) {
                listaProductos.add(new Producto(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3), resultado.getInt(4)));
            }
            for (Producto producto : listaProductos) {
                System.out.println(producto);
            }

        } catch (Exception e) {
            System.out.println("Error verTodosDatosProducto");
        }
    }

}
