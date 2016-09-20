import javax.swing.ImageIcon;   
/**
 * Write a description of class Controlador here.
 * 
 * @autores Javier Padilla: se encargo de crear y documentar el punto dos y tres
 *          Tatiana Briones: se encargo de crear y documentar el punto cuatro y seis
 *          Hansel Calderon: crear la clase Controlador e Interfaz y aplicar patron arquitectura de clases, documentacion, y correciones al punto uno
 *          Alejandro Soto B26583: se encargó de crear y documentar el punto uno, así como de detalles de forma y presentación.
 *          Carlos Bogarín: B21013: Se encargó de realizar el punto cinco. 
 */
public class Controlador
{
    private Interfaz interfaz;
    private Experto experto;
    private final String TITULO = "Trabajo Colaborativo 2, Grupo 01, Equipo A";
    private ImageIcon IMAGEN = new ImageIcon("costa-rica.PNG"); 

    public Controlador()
    {

        interfaz = new Interfaz(TITULO,"costa-rica.png");

        experto = new Experto(interfaz);

    }

    /**
     *  metodo principal ya que representa el menu desde el cual se elije que accion ejecutar.
     */
    public void iniciar()
    {
        String opciones[] = {"Punto Uno","Punto Dos","Punto Tres","Punto Cuatro","Punto Cinco","Punto Seis","Salir"};
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
     *  metodo main, iniciar el programa 
     */
    public static void main(String[ ] argumentos)
    {
        Controlador miControlador;
        miControlador = new Controlador();
        miControlador.iniciar();
    }

}
