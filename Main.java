import java.util.Scanner;

//Clase Producto

class Producto{

     //Atributos...declarados como privados para el encapsulamiento
    private String nombre;
    private double precioBase;
    
    //Constructor por defecto...inicia con valores predetermindados
    
    public Producto(){
        this.nombre = "Sin Nombre";
        this.precioBase = 0.0;
        }
    //Constructor con parametros asiganados
    
    public Producto(String nombre, double precioBase){
        this.nombre = nombre;
        this.precioBase = precioBase;
    }
    
    //Logica del producto...aplicando los descuentos
    
    public double calDescuento(){
        if(this.precioBase >1000){///estructura condicional
            return this.precioBase * 0.15; ///aplicando el descuento y retorna el monto del 15%
        }
        return 0.0; //Sino cuesta mas de 2000, no aplica el descuento
    }
    
    ///metodo del precio final
    public double PrecioFinal () {
        return this.precioBase - calDescuento();
    }
    
    //desglose del producto
    
    public void mostrarDetalle(){
        
        double descuento = calDescuento();
        System.out.println("Producto" + this.nombre);
        System.out.println("Precio base: $" + String.format("%.2f",this.precioBase));
        
        //condicional para mnostra el descuento
        
        if(descuento > 0){
            System.out.println("Descuento del 15%: -$" + String.format("%.2f", descuento));
        } else {
            System.out.println("Descuento:    No aplica");
        }
        System.out.println("Precio final:    $" + String.format("%.2f", PrecioFinal()));
    }
}
///Subclase 1 - clase derivada

class ProductoElectrodomestico extends Producto {
    private int MesesGarantia; // Atributo exclusivo de esta clase
    
    //Constructor que reutliza el de la clase base con super()
    public ProductoElectrodomestico(String nombre, double precioBase, int MesesGarantia){
        super(nombre, precioBase); //reutilizacion de constructor padre
        this.MesesGarantia=MesesGarantia;
    }
    
    //Sobreescritura del metodo MostrarDetalle para agregar informacion de la garantia 
    @Override
    public void mostrarDetalle(){
        super.mostrarDetalle(); //llama primero al metodo original de producto.
        System.out.println("Garantia extendida " + this.MesesGarantia + "Meses");
    }
    
    //Subclase 2 - clase derivada
    
    class ProductoRopa extends Producto {
        private String talla; //atributo exclusivo de esta clase
        
        //constructor que reutiliza el de la clase base con super()
        
        public ProductoRopa(String nombre, double precioBase, String talla){
            super(nombre, precioBase);
            this.talla = talla;
        }
        
        //sobreescritura de metodo mostrarDetalle
        @Override 
        public void mostrarDetalle(){
            super.mostrarDetalle();
            System.out.println("Talla: "+this.talla);
        }
    }
}

public class Main {
    
    public static void main(String[]args){ ///metodo principal
        //Creacion de objeto Scanner para que permita la entrada de datos en consola
        Scanner scanner = new Scanner(System.in);
        System.out.println("===REGISTRO DE PRODUCTO ELECTRODOMESTICO===");
        System.out.println("Ingresa el nombre del producto Electrodomestico");
        //String nombre = scanner.nextLine();
        String nombreElec = scanner.nextLine();      
        System.out.println("Ingresa el precio: ");
        double precioElec = scanner.nextDouble();
        System.out.println("Ingresa los meses de Garantia: ");
        int garantia  = scanner.nextInt();
        scanner.nextLine(); //Limpiar buffer
        
        ///Instacion de objetos...creacion de objeto miProducto usan el constructor parametrizado
       // Producto miProducto = new Producto(nombre, precio);
            
       
       //Instacion de la subclase Producto electrodomestico
       ProductoElectrodomestico miElectrodomestico = new ProductoElectrodomestico(nombreElec, precioElec, garantia);
        System.out.println("----RESULTADO ELECTRODOMESTICO ---");
       miElectrodomestico.mostrarDetalle();
       
       scanner.close();
        //ejecucion de metodos....pra mostrar el calculo del precio final.
        
        //stem.out.println("---Resultado");
        //Producto.mostrarDetalle();
        
        //Cierre del objeto Scanner
        
        scanner.close();
    
    }
}
