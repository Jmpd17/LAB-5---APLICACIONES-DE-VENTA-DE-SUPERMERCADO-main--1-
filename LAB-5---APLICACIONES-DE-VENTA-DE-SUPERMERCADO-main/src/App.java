import java.time.LocalDate;


public class App {
    public static void main(String[] args) {
        Cliente ana = new Cliente("C-001", "Ana Pérez", "402-1234567-8");


        ProductoAlimentario leche = new ProductoAlimentario(
                "P-001", "Leche entera", 85.00, 2, "Lácteos", LocalDate.now().plusDays(5));
        ProductoAlimentario arroz = new ProductoAlimentario(
                "P-002", "Arroz 5 lb", 45.00, 3, "Granos", LocalDate.now().plusMonths(6));
        ProductoNoAlimentario detergente = new ProductoNoAlimentario(
                "P-003", "Detergente", 210.00, 1, "Limpieza");




        Venta venta = new Venta("00000001", ana);
        venta.añadirProducto(leche);
        venta.añadirProducto(arroz);
        venta.añadirProducto(detergente);


        ProductoNoAlimentario invalido = new ProductoNoAlimentario(
                "P-004", "Jabon", 40.00, 0, "Higiene");
        System.out.println("Se añadió el producto con cantidad 0? " + venta.añadirProducto(invalido));
        System.out.println();




        venta.registrarVenta();
        venta.mostrarDetalle();
        venta.imprimirFactura();

        Venta venta2 = new Venta("00000002", ana);
        if (venta2.registrarVenta() == null) {
            System.out.println("La segunda venta no se registró. No tiene productos (retornó null).");
        } else {
            System.out.println("ERROR. la venta sin productos debio retornar null.");
        }
    }
}