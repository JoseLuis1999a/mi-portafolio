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

//Clas princiapal

public class Main {
    
    public static void main(String[]args){ ///metodo principal
        //Creacion de objeto Scanner para que permita la entrada de datos en consola
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del producto");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa el precio: ");
        double precio = scanner.nextDouble();
        
        ///Instacion de objetos...creacion de objeto miProducto usan el constructor parametrizado
        Producto miProducto = new Producto(nombre, precio);
        
        //ejecucion de metodos....pra mostrar el calculo del precio final.
        
        System.out.println("---Resultado");
        miProducto.mostrarDetalle();
        
        //Cierre del objeto Scanner
        
        scanner.close();
    
    }
}