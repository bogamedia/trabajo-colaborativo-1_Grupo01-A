    import javax.swing.JOptionPane;
import javax.swing.ImageIcon;   
/**
 * Write a description of class Interfaz here.
 * 
 * @author (Hansel Calderon) 
 * @version (a version number or a date)
 */
public class Interfaz extends JOptionPane
{
    // costante que se refere al titulo que se mostrara en todas las ventanas.
    private final String TITULO;
     // costante que se refere la imagen  que se mostrara en todas las ventanas.
    private final ImageIcon IMAGEN;

    public Interfaz(String elTitulo, String elNombreArchivoImagen)
    {
        TITULO = elTitulo;
        IMAGEN = new ImageIcon(this.getClass().getResource(elNombreArchivoImagen));
    }

    /**
     *  muestra un mensaje al usuario
     */
    public void decirMensaje(String mensaje)
    {
        this.showMessageDialog(null, mensaje, TITULO,this.PLAIN_MESSAGE, IMAGEN);
    }

    /**
     *  solicita al usuario una hilera de caracteres
     */
    public String pedirHilera( String mensaje)
    {
        Object objetoString;
        String hilera = "";
        objetoString = this.showInputDialog(null, mensaje,TITULO,2,IMAGEN,null,null);

        if(objetoString != null){   
            hilera = objetoString.toString();
        }
        else{

        }
        return hilera;
    }

    /**
     *  solicita al usuario un numero
     */
    public int pedirNumero( String mensaje)
    {
        Object objetoString;
        int numero = 0;
        String hilera = "";
        objetoString = this.showInputDialog(null, mensaje,TITULO,2,IMAGEN,null,null);
        if(objetoString == null){
            numero = 0;
        }else if(objetoString.equals("")){
            numero = 0;
        }else{
            try {
                hilera = objetoString.toString();
                numero = Integer.parseInt(hilera);
            }
            catch (Exception e) {

            }
        }

        return numero;
    }

    /**
     *  solicita al usuario un char
     */
    public char pedirChar( String mensaje)
    {
        Object objetoString;
        String hilera;
        char caracter;
        objetoString = this.showInputDialog(null, mensaje,TITULO,2,IMAGEN,null,null);
        if(objetoString == null){   
            caracter = ' ';
        } else if(objetoString.equals("")){
            caracter = ' ';
        } else{
            hilera = objetoString.toString();
            caracter = hilera.charAt(0);
        }

        return caracter;
    }

    /**
     * muestras opciones en un cuadro de texto recibidas en un arreglo, devuelve un int segun 
     * la opcion que eliija el usuario
     */
    public int elegirEntreOpciones(String mensaje,Object[] misOpciones)
    {
        int eleccion;
        eleccion = this.showOptionDialog(null,mensaje, TITULO,this.DEFAULT_OPTION, PLAIN_MESSAGE,IMAGEN, misOpciones, misOpciones[0]);
        return eleccion;
    }

    /**
     *  muestra una lista desplegable de opciones para poder elegir y devuelve un int segun 
     *  la opcion que elija el usuario
     */
    public Object elegirEntreOpcionesDesplegables(String mensaje,Object[] misOpciones)
    {
        Object opcion;
        opcion = this.showInputDialog(null, mensaje, TITULO, this.INFORMATION_MESSAGE, IMAGEN, misOpciones,misOpciones[0]);
        return opcion ;
    }

    public int pedirConfirmacionYesNo(String mensaje)
    {

        int eleccion = JOptionPane.showConfirmDialog (null,mensaje,TITULO,YES_NO_OPTION,3,IMAGEN);

        return eleccion;
    }
}

