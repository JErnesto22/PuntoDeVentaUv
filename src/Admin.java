import java.util.Map;
import java.util.Scanner;

public class Admin {

    public static void admin(Productos_db db){
        Scanner scan = new Scanner(System.in);

        int op = 0 , cant;
        double precio;
        String prod;


        System.out.println("[1]Consultar   [2]Editar   [3]Eliminar [4]Agregar  [5]Salir");
        System.out.println("Que accion deseas realizar: ");
        op = scan.nextInt();

        switch (op){
            case 1:

               db.mostraProductos(db.getDb_productos() , db.getDb_precio());

                break;
            case 2:
                System.out.println("Que producto deseas editar: ");
                prod = scan.nextLine();
                prod = scan.nextLine();

                if (db.getDb_productos().containsKey(prod)){
                    int _op = 0;
                    System.out.println("[1]EditarCantidad   [2]EditarPrecio");
                    System.out.println("Que desea realizar? ");

                    _op = scan.nextInt();

                    switch (_op){
                        case 1:
                            System.out.println("Ingresa la nueva cantidad de producto: ");
                            cant = scan.nextInt();
                            db.modCantDb_producto(prod,cant);
                            break;
                        case 2:
                            System.out.println("Ingresa el nuevo precio ");
                            precio = scan.nextDouble();
                            db.modCantDb_precio(prod,precio);
                            break;
                        case 3:
                            admin(db);
                        default:
                            System.out.println("Ingresa una opcion valida");
                            break;
                    }

                } else {
                    System.out.println("Producto no encontrado");
                }



                break;
            case 3:
                System.out.println("Que producto deseas eliminar: ");
                prod = scan.nextLine();
                prod = scan.nextLine();

                if (db.getDb_productos().containsKey(prod)){
                    System.out.println("Eliminando producto: " + prod );
                    db.deletProducto(prod);

                }
                System.out.println(db.getDb_productos());
                break;

            case 4:
                System.out.println("Ingresa el nombre del producto: ");
                prod = scan.nextLine();
                prod = scan.nextLine();
                if (db.getDb_productos().containsKey(prod)){
                    System.out.println("El producto ya existe");
                } else {
                    System.out.println("Ingresa la cantidad en stock");
                    cant = scan.nextInt();
                    System.out.println("Ingresa el precio: ");
                    precio = scan.nextDouble();

                    db.addDb_productos(prod,cant);
                    db.addDb_precio(prod,precio);


                    System.out.println(db.getDb_productos());
                }

                break;
            case 5:
                MenuPrincipal.menu(db);
                break;
            default:
                System.out.println("Ingresa una opcion valida");

        }
        admin(db);
    }




}
