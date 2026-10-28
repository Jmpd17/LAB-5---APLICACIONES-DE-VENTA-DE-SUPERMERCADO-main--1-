import java.time.LocalDate;
import java.util.ArrayList;

public class Ventas {
    private String id;
    private ArrayList<Producto> productos;
    private double subTotal;
    private final double ITBIS = 0.18;
    private LocalDate fechaVenta;
    private Cliente cliente;
    private double total;

    public Ventas(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.subTotal= 0;
        this.total = 0;
    }

    public boolean añadirProducto(Producto p){

        if(p == null){
            return false;
        }

        if(p.getCantidad() <= 0 || p.getPrecio() <= 0){
            return false
        }

        productos.add(p);
        return true;
    }

    public Ventas registrarVenta(){

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

    public Ventas mostrarDetalle(){
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