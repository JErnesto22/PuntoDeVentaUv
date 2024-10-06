import java.util.HashMap;
import java.util.Map;

public class Productos_db {
    public Map<String,Integer> db_productos = new HashMap<>();
    public Map<String,Double> db_precio = new HashMap<>();
    private Map<String,Double> db_corte = new HashMap<>();
    private int id = 0;

    public Map<String, Integer> getDb_productos() {
        return db_productos;
    }

    public void addDb_productos(String producto , Integer cantidad) {
        this.db_productos.put(producto,cantidad);
    }

    public Map<String, Double> getDb_precio() {
        return db_precio;
    }

    public void addDb_precio(String producto , Double precio) {
        this.db_precio.put(producto,precio);
    }

    public void modCantDb_producto(String producto , Integer cant) {
        this.db_productos.replace(producto, cant);
    }

    public void modCantDb_precio(String producto , Double precio) {
        this.db_precio.replace(producto, precio);
    }

    public void deletProducto(String producto) {
        this.db_precio.remove(producto);
        this.db_productos.remove(producto);
    }

    public void venta(String producto , int cant) {
        this.db_productos.replace(producto,this.db_productos.get(producto) - cant);
    }

    public Map<String, Double> getCorte(){
        return db_corte;
    }

    public void addCorte( double monto ){

        this.id += 1;

        this.db_corte.put(("Ticket " + this.id), monto);
    }
    public int getId(){
        return this.id;
    }
    public void mostraProductos( Map<String, Integer>  producto , Map<String, Double>  precio){
        for (Map.Entry<String, Integer> entry : producto.entrySet()) {
            System.out.println("Producto = " + entry.getKey() + ", Cantidad = " + entry.getValue() + " Precio: " + "$" + precio.get(entry.getKey()));
        }
    }

    public void crearCorte(){
        for (Map.Entry<String, Double> entry : db_corte.entrySet()) {
            System.out.println(entry.getKey() + ", Monto = " + entry.getValue());
        }
        db_corte.clear();
    }
}
