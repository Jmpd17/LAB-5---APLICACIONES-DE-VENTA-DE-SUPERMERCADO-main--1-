import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
    private String id;
    private ArrayList<Producto> productos;
    private double subTotal;
    private final double ITBIS = 0.18;
    private LocalDate fechaVenta;
    private Cliente cliente;
    private double total;

    public Venta(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.subTotal= 0;
        this.total = 0;
    }

    public boolean añadirProducto(Producto p){
        //verifica que no sea null
        if(p == null){
            return false;
        }
        // verifica cantidades y precio mayor a 0
        if(p.getCantidad() <= 0 || p.getPrecio() <= 0){
            return false;
        }
        // añade los productos y retorna true
        productos.add(p);
        return true;
    }

    public Venta registrarVenta(){

        //validacion
        if(productos.isEmpty() || cliente == null){
            return null;
        }
        // reinicio
        subTotal = 0;

        //calcular subtotal
        for (Producto p : productos){
            subTotal+= p.getPrecio() * p.getCantidad();
        }

        //calcular total
        total = subTotal + (subTotal * ITBIS);

        //fecha actual
        fechaVenta = LocalDate.now();

        return this;
    }

    public Venta mostrarDetalle(){
        IO.println("Id de venta: " + id);
        IO.println("Fecha: " + fechaVenta);

        IO.println("------Cliente-------");
        cliente.mostrarDetalle();

        IO.println("------Productos-----");
        for (Producto p : productos){
            p.mostrarDetalle();
        }

        IO.println("Subtotal: " + subTotal);
        IO.println("ITBIS (18%): " + (subTotal * ITBIS));
        IO.println("Total: " + total);

        return this;
    }
    
    @Override
    public Factura imprimirFactura() {
        if (total == 0) {
            return null;
        }


        Factura factura = new Factura(
                "FAC-" + id,      // id
                id,               // numeroFactura
                "B02" + id,       // NCF
                this,
                LocalDate.now()
        );


        System.out.println("========================================");
        System.out.println("FACTURA No. " + factura.getNumeroComprobante()); // en tu Factura este getter devuelve el número de factura
        System.out.println("NCF: " + factura.getNumComprobant());
        System.out.println("Fecha: " + factura.getfechaImpresion());
        System.out.println("Cliente: " + cliente.getNombreCompleto()
                + " (" + cliente.getCedula() + ")");
        System.out.println("----------------------------------------");


        for (Producto p : productos) {
            double importe = p.getPrecio() * p.getCantidad();
            System.out.println(String.format(Locale.US, "%s %d x %.2f = %.2f",
                    p.getNombreProducto(), p.getCantidad(), p.getPrecio(), importe));
        }


        System.out.println("----------------------------------------");
        System.out.println(String.format(Locale.US, "Subtotal: %.2f", subTotal));
        System.out.println(String.format(Locale.US, "ITBIS (18%%): %.2f", subTotal * ITBIS));
        System.out.println(String.format(Locale.US, "TOTAL: %.2f", total));
        System.out.println("========================================");


        return factura;
    }


    // Getters and Setters
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public LocalDate getFechaVenta() {
        return fechaVenta;
    }


    public void setFechaVenta(LocalDate fecha) {
        this.fechaVenta = fecha;
    }


    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }
}