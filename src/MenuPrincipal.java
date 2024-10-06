import java.util.Map;
import java.util.Scanner;

public class MenuPrincipal {
    public static void menu(Productos_db db){
        Scanner scan = new Scanner(System.in);

        int op = 0;
        System.out.println("P U N T O   D E   V E N T A   U V ");
        System.out.println("Que deseas realizar: ");
        System.out.println("[1]Venta  [2]AdministrarProductos  [3]Salir");
        op = scan.nextInt();

        switch (op){
            case 1:
                Venta.menuVenta(db);
                break;
            case 2:
                Admin.admin(db);
                break;
            case 3:
                break;
            default:
                System.out.println("Ingresa una opcion valida");
                menu(db);
        }
    }


}
