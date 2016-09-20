// Importación de la clase ImageIcon para uso de imágenes en ventanas.
import javax.swing.ImageIcon;   
/**
 * Write a description of class Controlador here.
 * 
 * @author Javier Padilla: 
 *              se encargo de crear y documentar el punto dos y tres.
 * 
 *          Tatiana Briones: 
 *              se encargo de crear y documentar el punto cuatro y seis
 *              
 *          Hansel Calderon: 
 *              crear la clase Controlador e Interfaz y aplicar patron arquitectura 
 *                  de clases, documentacion, y correciones al punto uno
 *                  
 *          Alejandro Soto B26583: 
 *              se encargó de crear y documentar el punto uno, así como de detalles de 
 *                  forma y presentación.
 *                  
 *          Carlos Bogarín: B21013: Se encargó de realizar el punto cinco,
 *                      documentar el punto cinco y otros apartados, 
 *                      además de correcciones de estilo y redacción 
 *                      para facilitar la comprensión y lectura del código.
 *                      Correcciones menores como nombres de variables más descriptivos.
 *                      
 *  
 * @version Lunes 19 de Setiembre, 2016                      
 */
public class Controlador
{
    //  Obejto gobal de tipo interfaz, ésta extiende JOptionPane.
    private Interfaz interfaz;
    //  Objeto experto que contiene los métodos solicitados para el trabajo colaborativo.
    private Experto experto;
    //  Hilera global para los títulos de las ventanas.
    private final String TITULO = "Trabajo Colaborativo 2, Grupo 01, Equipo A";
    //  Imagen genérica para las ventanas.
    private ImageIcon IMAGEN = new ImageIcon("costa-rica.PNG"); 
    
    /**
     * El constructor de objetos Controlador se encarga de inicializar las variables
     * y objetos globales.
     */
    public Controlador()
    {
        //  La interfaz recibe el título a partir de la constante TITULO.
        interfaz = new Interfaz(TITULO,"costa-rica.png");
        //  Se inicializa un objeto experto y se le pasa la interfaz por parámetro.
        experto = new Experto(interfaz);
    }

    /**
     * El método iniciar es el método principal. Despliega un menú desde el cual se
     * pueden ejecutar los diversos métodos.
     * 
     */
    public void iniciar()
    {
        //  El arreglo opciones contiene las opciones del menú principal.
        String opciones[] = {"Punto Uno",
                                "Punto Dos",
                                    "Punto Tres",
                                        "Punto Cuatro",
                                            "Punto Cinco",
                                                "Punto Seis",
                                                    "Salir"};
        
        // La variable "eleccion" almacena la elección del usuario.
        int eleccion;
        do{
            eleccion =  interfaz.elegirEntreOpciones("¿Qué desea hacer?",opciones);
            switch (eleccion) {
                case 0:
                experto.puntoUno();
                break;

                case 1:
                experto.puntoDos();
                break;

                case 2: 
                experto.puntoTres();
                break;

                case 3: 
                experto.puntoCuatro();
                break;

                case 4: 
                experto.puntoCinco(interfaz.pedirChar("Administrador: Digite una vocal en minúscula sin acentos"));
                
                break;

                case 5: 
                experto.puntoSeis();
                break;
            }

        }while(eleccion != 6);

    }

    /**
     *  El método main ejecuta la totalidad del programa.
     */
    public static void main(String[ ] argumentos)
    {
        Controlador miControlador;
        miControlador = new Controlador();
        miControlador.iniciar();
    }

}
