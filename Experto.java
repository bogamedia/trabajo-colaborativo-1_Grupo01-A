import javax.swing.JOptionPane;
import java.util.GregorianCalendar; 
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.io.*;
import java.text.Collator;
import java.util.Locale;
import java.lang.Character;

/**
 * Write a description of class TC1_A here.
 * 
 * @author Javier Padilla
 *         Tatiana Briones
 *         Hansel Calderon
 *         Alejandro Soto B26583
 * @version
 */
public class Experto
{
    /**campos**/
    Interfaz interfaz;

    //controlador
    public Experto(Interfaz laInterfaz)
    {
        interfaz = laInterfaz;
    }

    
         /**
    Realizado y documentado por: B26583 - Alejandro Soto Chaves
    Correcciones:
     */
    
    public void puntoUno()
    {
        //Pregunta por un número de día del mes//
        
        String [] fecha = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31"
          };
          
                    
          String fechaEscog = (String) JOptionPane.showInputDialog(null, "Escoja un día del mes:", "Fecha", JOptionPane.DEFAULT_OPTION, null, fecha, fecha[0]);
          
          
        //Pregunta por el mes que corre//
        
        String [] mes = {
            "Enero", 
            "Febrero",
            "Marzo", 
            "Abril", 
            "Mayo", 
            "Junio", 
            "Julio", 
            "Agosto", 
            "Setiembre", 
            "Octubre", 
            "Noviembre", 
            "Diciembre"
            
          };
        
        int Selection = JOptionPane.showOptionDialog (null, "Seleccione un mes:", "Mes", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, mes, mes[0]);
        
          String outcomeSelection = " ";
        
                        
        if (Selection == 0) {
            outcomeSelection = "Enero";}
        else {
            if (Selection == 1) {
                outcomeSelection = "Febrero";}
            else {
                if (Selection == 2) {
                    outcomeSelection = "Marzo";}
                else {
                    if (Selection == 3) {
                        outcomeSelection = "Abril";}
                    else {
                        if (Selection == 4) {
                            outcomeSelection = "Mayo";}
                        else { 
                            if (Selection == 5) {
                                outcomeSelection = "Junio";}
                            else {
                                if (Selection == 6) {
                                    outcomeSelection = "Julio";}
                                else {
                                    if (Selection == 7) {
                                        outcomeSelection = "Agosto";}
                                    else {
                                        if (Selection == 8) {
                                            outcomeSelection = "Setiembre";}
                                        else {
                                            if (Selection == 9) {
                                                outcomeSelection = "Octubre";}
                                            else {
                                                if (Selection == 10) {
                                                    outcomeSelection = "Noviembre";}
                                                else {
                                                    outcomeSelection = "Diciembre";}
                                                        
                                                }
                                            }
                                        }
                                    }                              
                                }                                                  
                            }
                         }
                     }
                 }
             }  
        
        //Muestra ambos datos introducidos en una ventana//
        
        interfaz.showMessageDialog(null, "Día: " + fechaEscog + "\nMes: "  + outcomeSelection,"T.C. 1, Grupo 1A",JOptionPane.INFORMATION_MESSAGE);

    }

    /**
    Realizado y documentado por: Javier Padilla
    Correcciones:
     */
    public void puntoDos()
    {

        try{
            //Pide al usuario la fecha y divide la string en un array para acceder cada int independientemente.
            String inputFecha = interfaz.pedirHilera("Digite una fecha con el formato  AÑO/MES/DÍA");
            String[] fecha = inputFecha.split("/");
            int año = Integer.parseInt(fecha[0]);
            int mes = Integer.parseInt(fecha[1]);
            int dia = Integer.parseInt(fecha[2]);
            GregorianCalendar primerFecha = new GregorianCalendar(año,mes,dia); //Instancia la primer fecha tipo GregorianCalendar con los ints obtenidos del array.

            //Repite el proceso anterior para la segunda fecha. Utiliza las mismas variables para ahorrar espacio(Excluyendo el GregorianCalendar).
            inputFecha = interfaz.pedirHilera("Digite una fecha con el formato  AÑO/MES/DÍA");
            fecha = inputFecha.split("/");
            año = Integer.parseInt(fecha[0]);
            mes = Integer.parseInt(fecha[1]);
            dia = Integer.parseInt(fecha[2]);
            GregorianCalendar segundaFecha = new GregorianCalendar(año,mes,dia); //Genera la segunda fecha.

            //Transforma las fechas en milisegundos utilizando métodos heredados de la clase Calendar y calcula la diferencia de días.
            long diferencia = segundaFecha.getTimeInMillis() - primerFecha.getTimeInMillis();
            long diasTranscurridos = diferencia/(1000*60*60*24);
            interfaz.decirMensaje("Han pasado " + diasTranscurridos + " días aproximadamente"); //muestra al usuario el resultado
        }
        catch(Exception e)
        {
            interfaz.decirMensaje("Error");
        }
    }

    /**
    Realizado y documentado por: Javier Padilla.
    Correcciones:
     */
    public void puntoTres()
    {

        try{
            //crea los objetos tipo filereader y bufferedreader para leer el archivo de texto
            FileReader lectorFile = new FileReader("punto3.txt");
            BufferedReader lector = new BufferedReader(lectorFile);

            //Le muestra al usuario las lineas del archivo de texto hasta que estén en blanco
            String line;
            while((line = lector.readLine()) != null)
            {
                interfaz.showMessageDialog(null, line, "Leyendo archivo", interfaz.PLAIN_MESSAGE);
            }

            //Crea los campos filewriter y bufferedwriter necesarios para guardar el texto en el archivo .txt
            FileWriter escritorFile = new FileWriter("punto3.txt", true);         
            BufferedWriter escritor = new BufferedWriter(escritorFile);
            escritor.newLine();
            //Pregunta al usuario su nombre, edad y los guarda en el archivo de texto.
            line = interfaz.pedirHilera("Escriba su nombre");
            escritor.write("Nombre: " + line);
            escritor.flush();
            escritor.newLine(); //new line se encarga de que cambie de renglón
            line = interfaz.pedirHilera("Escriba su edad");
            escritor.write("Edad: " + line);
            escritor.flush();
            escritor.newLine();     
            escritor.close();
            //El código anterior utiliza la misma variable line para ahorrar espacio.
        } 
        catch (Exception e){
            interfaz.decirMensaje("No se encontró el archivo");
        }
    }

    /**
    Realizado y documentado por: Tatiana Briones.
    Correcciones:
     */
    public void puntoCuatro()
    {
        //Crea el objecto para abrir el fichero.
        JFileChooser selector = new JFileChooser();        
        int seleccion = selector.showOpenDialog(null);
        //Filtro para tipo de archivos.
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        selector.setFileFilter(filtro);

        //Verifica si el usuario presiona aceptar.
        if (seleccion == selector.APPROVE_OPTION)
        {
            //Obtener el archivo.
            File fichero = selector.getSelectedFile();
            try{
                //Crea el icono con el nombre del archivo.
                ImageIcon icono = new ImageIcon(fichero.toString());
                interfaz.showMessageDialog(null, "Mensaje", "TITULO", interfaz.PLAIN_MESSAGE, icono);
            }catch(Exception ex){
                interfaz.decirMensaje("Error al abrir la imagen");
            }            
        }
    }
    
    /**
     * El método puntoCinco recibe como parámetro una vocal en minúscula y sin acento. 
     * El método pide al usuario que la ingrese y verifica si lo hizo sin importar si fue en 
     * mayúscula o con acento.
     * 
     * Realizado por: Carlos Bogarín
     * Correcciones: 
     */
    public void puntoCinco(char vocal)
    {
        //  Declaración de variables locales.
        char[] vocalesMinusculas;
        boolean esVocalMinuscula;
        int posicion;
        int cantidadVocales;
        char vocalUsuario;
        boolean vocalesSonIguales;
        
        //  Declaración de objetos locales.
        Collator colador;   /* El objeto colador se encargará de comparar los caracteres, 
        obviando diferencias como acentos o mayúsculas y minúsculas.*/
        
        /* Los objetos de tipo Character perimitirán la conversión de caracteres a String
           para su posterior comparación*/
        Character vocalOriginal;
        Character vocalAComparar;
        
        //  Inicialización de variables y objetos locales.
        vocalesMinusculas = new char[] {'a', 'e', 'i', 'o', 'u'};
        esVocalMinuscula = false;
        posicion = 0;
        cantidadVocales = vocalesMinusculas.length;
        vocalUsuario = '0';
        vocalesSonIguales = false;
        
        /*  El objeto colador tomará como regla de comparación el conjunto de
           caracteres del alfabeto inglés estadounidense.*/
        colador = Collator.getInstance(Locale.US);
        /*  El objeto colador tomará como relevantes las diferencias de tipo primarias,
           por ejemplo "a" vs "b", ;pero obviará diferencias como acentos o mayúsculas
           y minúsculas. */
        colador.setStrength(Collator.PRIMARY);
        //  Se asigna la vocal suministrada por el administrador a un objeto Character.
        vocalOriginal = new Character(vocal);
        
        for (posicion = 0; posicion < cantidadVocales; posicion++)
        {
            //  Se verifica que la vocal recibida por el administrador sea en efecto una vocal en minúsucla.
            if(vocal == vocalesMinusculas[posicion])
            {
                esVocalMinuscula = true;
            }
            else
            {
                //  Caso intencionalmente en blanco.
            }

        }
        
        if (!esVocalMinuscula)
        {
            //  Se hace saber que el administrador introdujo un carácter que no es una vocal.
            this.interfaz.decirMensaje("Administrador ha ingresado un carácter inválido.");
        }
        else
        {
            //  Se le pide al usuario que digite un caracter.
            vocalUsuario = this.interfaz.pedirChar("Usuario: Digite la vocal.");
            //  Se asigna la vocal al objeto de tipo Character.
            vocalAComparar = new Character(vocalUsuario);
            //  Se comparan los caracters y se asigna si son iguales a la variable vocalesSonIguales.
            vocalesSonIguales = colador.equals(vocalOriginal.toString(), vocalAComparar.toString());
            if(vocalesSonIguales)
            {
                //  Si las vocales son iguales.
                this.interfaz.decirMensaje("Usuario ha ingresado la vocal correcta.");
            }
            else
            {
                //  Si las vocales son distintas
                this.interfaz.decirMensaje("Usuario ha ingresado la vocal incorrecta.");
            }
        }
        //Fin del método.
    }

    /**
    Realizado y documentado por: Tatiana Briones.
    Correcciones:
     */
    public void puntoSeis()
    {
        //Crea los objetos para los campos
        JTextField campoUno = new JTextField();
        JTextField campoDos = new JTextField();
        Object[] componentesGraficos = {"Peso: ", campoUno, "Estatura: ", campoDos};

        try{
            //Muestra la ventana de dialogo con los dos campos
            interfaz.showMessageDialog(null, componentesGraficos);
            //Conversion de datos a tipo double
            double peso = Double.parseDouble(campoUno.getText());
            double estatura = Double.parseDouble(campoDos.getText());
            //Calculo del Indice de Masa Corporal
            double resultadoIndice = peso / (estatura * estatura);
            //Ventana que muestra el resultado
            interfaz.decirMensaje("Indice de Masa Corporal: " + resultadoIndice);
        }catch(Exception e) {
            interfaz.decirMensaje("Digite correctamente los datos");
        }
    }
}