
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Venta {
    public static void menuVenta(Productos_db db){
        int op = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("M E N U   D E   D E   V E N T A S");
        System.out.println(" ");
        System.out.println("Que deseas realizar: ");

        System.out.println("[1]NuevaVenta   [2]CrearCorte   [3]Salir ");
        System.out.println("Que opcion deseas realizar: ");

        op = scan.nextInt();

        switch (op) {
            case 1:
                nuevaVenta(db,scan);
                break;
            case 2:
                db.crearCorte();

                break;
            case 3:
                MenuPrincipal.menu(db);
                break;
            default:
                System.out.println("Ingresa una opcion valida ");
                break;
        }
        menuVenta(db);
    }

    public static void nuevaVenta(Productos_db db , Scanner scan){

        Map<String,Integer> productos = new HashMap<>();
        Map<String,Double> precios = new HashMap<>();
        String producto;
        int it = 1 , cantidad, cantTotal = 0;
        double subtotal = 0.0, precio , total = 0.0 , totalVentas = 0.0 ,
                totalDescuento = 0.0 , descuento = 0.0 , subtotalVentas = 0.0 , pago = 0.0;

        do {
            System.out.println("Ingresa el producto que deseas vender: ");

            producto = scan.nextLine();
            producto = scan.nextLine();

            if (db.getDb_productos().containsKey(producto)) {

                System.out.println("Ingrese la cantidad de producto a vender");

                cantidad = scan.nextInt();

                if (cantidad > db.getDb_productos().get(producto)) {
                    System.out.println("La cantidad excede el stock!");
                } else {


                    subtotal = (cantidad * db.getDb_precio().get(producto));


                    if ((cantidad / 3) >= 1) {
                        descuento = db.getDb_precio().get(producto) * ((int) cantidad / 3);
                        total = (subtotal - descuento);
                    } else {
                        total = subtotal;
                    }


                    productos.put(producto, cantidad);
                    precios.put(producto, total);

                    for (Map.Entry<String, Integer> entry : productos.entrySet()) {
                        System.out.println("Producto = " + entry.getKey() + ", Cantidad = " + entry.getValue() + " Precio: " + "$" + precios.get(entry.getKey()));
                    }
                    totalDescuento += descuento;
                    totalVentas += total;
                    subtotalVentas += subtotal;

                    System.out.println("El total del ticket es de: $" + totalVentas);


                }
            } else{
                    System.out.println("Producto no encontrado");

                }

                System.out.println("Finalizar venta?: [0]Si  [1]SeguirVendiendo");

                it = scan.nextInt();

                if (it == 0) {
                    System.out.println("El subtotal de la venta es de: " + subtotalVentas);
                    System.out.println("El total del descuento es de: " + totalDescuento);
                    System.out.println(" ");
                    System.out.println("El total es de: " + totalVentas);

                    System.out.println("Ingresa el monto recibido:");

                    pago = scan.nextDouble();

                    if (pago >= totalVentas) {
                        System.out.println("Pago exitoso");
                        System.out.println("Cambio :" + (totalVentas - pago));


                        for (Map.Entry<String, Integer> entry : productos.entrySet()) {

                            db.venta(entry.getKey(), entry.getValue());
                        }

                        db.addCorte(totalVentas);


                        menuVenta(db);
                    } else {
                        System.out.println("Pago insuficiente!");
                        System.out.println("Faltan: " + (totalVentas - pago));
                        it = 1;
                    }
                }

        }while (it != 0);


    }
}
