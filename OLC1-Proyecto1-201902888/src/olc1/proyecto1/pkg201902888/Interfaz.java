/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.proyecto1.pkg201902888;


import Analizadores.Analizador_Lexico;
import Analizadores.Sintactico;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.Desktop;

/**
 *
 * @author ivann
 */
public class Interfaz extends javax.swing.JFrame {

    public static LinkedList<Nodo> lista_nodos_arbols = new LinkedList<Nodo>();
    public static LinkedList<AFD> AutomatasAFD = new LinkedList<AFD>();
    public static LinkedList<Conjunto> lista_conjuntos = new LinkedList<>();
    public LinkedList<String> lista_validaciones = new LinkedList<>();
    public LinkedList<Expresiones> lista_er = new LinkedList<>();

    public static ArrayList<error> listaErrores = new ArrayList<error>();
    public String path = System.getProperty("user.dir");

    private LinkedList<ImageIcon> listaImagenes = new LinkedList<>();
    private int contadorVisualizador = 0;
    private ImageIcon imagen;
    private String archivoActual = "ArchivoSinNombre";

    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        GeneracionDirectorios();
        this.setTitle("EXREGAN");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        Avisolbl = new javax.swing.JLabel();
        NombreArchivotxt = new javax.swing.JLabel();
        Generarbtn = new javax.swing.JButton();
        Analizarbtn = new javax.swing.JButton();
        SeleccionTipo = new javax.swing.JComboBox<>();
        NombreImagen = new javax.swing.JLabel();
        Siguientebtn = new javax.swing.JButton();
        Anteriorbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Validacionestxt = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaEntrada = new javax.swing.JTextArea();
        ContenedorImagen = new javax.swing.JScrollPane();
        Imagen = new javax.swing.JLabel();
        btnErros = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        Abrirbtn = new javax.swing.JMenuItem();
        NuevoArchivobtn = new javax.swing.JMenuItem();
        GuardarComobtn = new javax.swing.JMenuItem();
        Guardarbtn = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1450, 1020));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Avisolbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 39, 308, -1));

        NombreArchivotxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NombreArchivotxt.setForeground(new java.awt.Color(0, 204, 204));
        NombreArchivotxt.setText("Archivo de entrada");
        getContentPane().add(NombreArchivotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, -1));

        Generarbtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Generarbtn.setForeground(new java.awt.Color(0, 204, 204));
        Generarbtn.setText("Generar Automatas");
        Generarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Generarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 610, 170, 50));

        Analizarbtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Analizarbtn.setForeground(new java.awt.Color(0, 204, 204));
        Analizarbtn.setText("Analizar Entradas");
        Analizarbtn.setEnabled(false);
        Analizarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Analizarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 160, 50));

        SeleccionTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ver Imagemes", "Arboles", "Siguientes", "Transiciones", "Automatas AFD", "Automatas AFND" }));
        SeleccionTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionTipoActionPerformed(evt);
            }
        });
        getContentPane().add(SeleccionTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 260, 40));

        NombreImagen.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NombreImagen.setForeground(new java.awt.Color(0, 204, 204));
        NombreImagen.setText("Nombre Imagen: ");
        getContentPane().add(NombreImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 360, -1));

        Siguientebtn.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        Siguientebtn.setForeground(new java.awt.Color(0, 204, 204));
        Siguientebtn.setText(">>");
        Siguientebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Siguientebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguientebtnActionPerformed(evt);
            }
        });
        getContentPane().add(Siguientebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 620, 142, 44));

        Anteriorbtn.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        Anteriorbtn.setForeground(new java.awt.Color(0, 204, 204));
        Anteriorbtn.setText("<<");
        Anteriorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnteriorbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Anteriorbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 620, 142, 44));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setText("CONSOLA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 670, -1, -1));

        Validacionestxt.setEditable(false);
        Validacionestxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Validacionestxt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Validacionestxt.setForeground(new java.awt.Color(51, 255, 102));
        jScrollPane3.setViewportView(Validacionestxt);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, 1360, 260));

        AreaEntrada.setColumns(20);
        AreaEntrada.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        AreaEntrada.setForeground(new java.awt.Color(204, 0, 204));
        AreaEntrada.setRows(5);
        jScrollPane2.setViewportView(AreaEntrada);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 540, 560));

        ContenedorImagen.setBackground(new java.awt.Color(255, 255, 255));

        Imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ContenedorImagen.setViewportView(Imagen);

        getContentPane().add(ContenedorImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 790, 560));

        btnErros.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnErros.setForeground(new java.awt.Color(0, 204, 204));
        btnErros.setText("Ver errores");
        btnErros.setEnabled(false);
        btnErros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnErrosActionPerformed(evt);
            }
        });
        getContentPane().add(btnErros, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 610, 160, 50));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Carpeta de: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 90, 30));

        jMenuBar1.setBorder(null);

        jMenu2.setForeground(new java.awt.Color(0, 204, 204));
        jMenu2.setText("Archivo");
        jMenu2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        Abrirbtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Abrirbtn.setText("Abrir Archivo");
        Abrirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirbtnActionPerformed(evt);
            }
        });
        jMenu2.add(Abrirbtn);

        NuevoArchivobtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NuevoArchivobtn.setText("Nuevo Archivo");
        NuevoArchivobtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NuevoArchivobtnMouseClicked(evt);
            }
        });
        NuevoArchivobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoArchivobtnActionPerformed(evt);
            }
        });
        jMenu2.add(NuevoArchivobtn);

        GuardarComobtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        GuardarComobtn.setText("Guardar Como...");
        GuardarComobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarComobtnActionPerformed(evt);
            }
        });
        jMenu2.add(GuardarComobtn);

        Guardarbtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Guardarbtn.setText("Guardar");
        Guardarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarbtnActionPerformed(evt);
            }
        });
        jMenu2.add(Guardarbtn);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GeneracionDirectorios() {
        File a = new File(path + "\\src\\ARBOLES_201902888");
        boolean mkcreared1 = a.mkdir();

        a = new File(path + "\\src\\AFND_201902888");
        boolean mkcreared2 = a.mkdir();

        a = new File(path + "\\src\\SIGUIENTES_201902888");
        boolean mkcreared3 = a.mkdir();

        a = new File(path + "\\src\\TRANSICIONES_201902888");
        boolean mkcreared4 = a.mkdir();

        a = new File(path + "\\src\\AFD_201902888");
        boolean mkcreared5 = a.mkdir();

        a = new File(path + "\\src\\ERRORES_201902888");
        boolean mkcreared6 = a.mkdir();

        a = new File(path + "\\src\\SALIDAS_201902888");
        boolean mkcreared7 = a.mkdir();

        a = new File(path + "\\src\\ARCHIVOS_201902888");
        boolean mkcreared8 = a.mkdir();

    }

    private void NuevoArchivobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoArchivobtnActionPerformed
        String name = JOptionPane.showInputDialog("Ingrese el nombre del archivo nuevo");

        if (name == null || name == "") {
            return;
        }

        File nuevoArchivo = new File(path + "\\src\\ARCHIVOS_201902888\\" + name + ".olc");
        try {
            nuevoArchivo.createNewFile();
            String Mensaje = "// Archivo: " + name + "";
            archivoActual = name;
            NombreArchivotxt.setText("Archivo de Entrada: " + name);
            AreaEntrada.setText(Mensaje);
            AreaEntrada.setEditable(true);
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_NuevoArchivobtnActionPerformed

    private void AbrirbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirbtnActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);

        try {

            if (chooser.getSelectedFile() == null) {
                return;
            }

            Reader lector = new BufferedReader(new FileReader(chooser.getSelectedFile()));
            archivoActual = chooser.getSelectedFile().getName();
            AreaEntrada.read(lector, evt);
            AreaEntrada.setEditable(true);
            Validacionestxt.setText("Se cargo correctamente el archivo");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_AbrirbtnActionPerformed

    private void GuardarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarbtnActionPerformed

        String variable = AreaEntrada.getText();
        if (variable == "" || archivoActual == null) {
            return;
        }
        try {
            FileWriter myWriter = new FileWriter(path + "\\src\\ARCHIVOS_201902888\\" + archivoActual + ".olc");
            myWriter.write(variable);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }   
    }//GEN-LAST:event_GuardarbtnActionPerformed

    private void GenerarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarbtnActionPerformed
       listaErrores.clear();
        if (AreaEntrada.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese algo al area");
            return;
        }

        try {
            Sintactico sintactico = new Sintactico(new Analizador_Lexico(new BufferedReader(new StringReader(AreaEntrada.getText()))));
            sintactico.parse();
            lista_er = sintactico.lista_er; //Lista de expresiones regulares
            lista_validaciones = sintactico.lista_validaciones; //lista de Lexemas a evaluar
            LinkedList<Conjunto> temp = new LinkedList<>();
            for (int i = 0; i < lista_er.size(); i++) {

                if (lista_er.get(i).raiz != null) { //EXPRESIONES
                    String identificador_er = lista_er.get(i).id; //identificador expresiones regulares
                    LinkedList<Nodo> lista_siguientes_metodo = new LinkedList<Nodo>();

                    Arbol arbol = lista_er.get(i).getArbol(); //raiz

                    arbol.GenerarTransicionesAFND(arbol.raiz.Hijo_Izq, identificador_er);

                    arbol.raiz.CalcSiguientes(lista_er.get(i).id, lista_siguientes_metodo); 

                    lista_er.get(i).getArbol().GraficarSintactico(lista_er.get(i).id); 

                    //Obtener nodo de los arboles 
                    lista_nodos_arbols = lista_siguientes_metodo;
                    Collections.sort(lista_nodos_arbols, (Nodo p1, Nodo p2) -> new Integer(p1.id).compareTo(new Integer(p2.id)));
                    arbol.GenerarTablaTransiciones(identificador_er);

                } else if (lista_er.get(i).raiz == null) {  //obtencion de conjuntos

                
                    //conjuntos a la lista
                    String[] Pareja = lista_er.get(i).id.split("%-%");
                    if (Pareja[1].contains("~")) {
                        Conjunto conjunto = new Conjunto(Pareja[0]);
                        String[] in = Pareja[1].split("~");
                        int asciiinicio = in[0].charAt(0);
                        int asciifinal = in[1].charAt(0);
                        String elementos = "";
                        for (int j = asciiinicio; j <= asciifinal; j++) {
                            char caracter = (char) j;
                            elementos = elementos + "," + Character.toString(caracter);
                        }
                        conjunto.Elementos = elementos;
                        temp.add(conjunto);
                    } else {
                        Conjunto conjunto = new Conjunto(Pareja[0]);
                        conjunto.Elementos = Pareja[1];
                        temp.add(conjunto);
                    }
                }
            }
            lista_conjuntos = temp;

            /// creacio y asignacion de conjuntos
            for (int i = 0; i < AutomatasAFD.size(); i++) {
                AFD automata_actual = AutomatasAFD.get(i);
                LinkedList<String> alfabeto = new LinkedList<>();

                for (int j = 0; j < automata_actual.Transiciones.size(); j++) {
                    String valor_transicion = automata_actual.Transiciones.get(j).valor;
                    if (!alfabeto.contains(valor_transicion)) {
                        if (!"#".equals(valor_transicion)) {
                            alfabeto.add(valor_transicion);
                        }
                    }
                }
                automata_actual.alfabeto = alfabeto;
            }
          
            Validacionestxt.setText("Automatas Guardados Correctamente!");
            Analizarbtn.setEnabled(true);
            SeleccionTipo.setEnabled(true);
        } catch (NullPointerException e) {
             
        } catch (Exception ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (listaErrores.size() > 0) {
            try {
                generarReporteHTML();
                Validacionestxt.setText("  Se ha generado un reporte de errores para el archivo: \"" + archivoActual + "\".");
                Analizarbtn.setEnabled(false);
                btnErros.setEnabled(true);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_GenerarbtnActionPerformed

    private void AnalizarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarbtnActionPerformed
       String cadena = "";
        ArrayList<validacion_cadenas> lista_objvalidacion = new ArrayList<>();
        for (int i = 0; i < lista_validaciones.size(); i++) {
            String[] elementos = lista_validaciones.get(i).split(":",2);
            System.out.println("==========="+elementos[1]);
            System.out.println("==========="+elementos[0]);
            String id_er = elementos[0];
            String strlexema = elementos[1].substring(1, elementos[1].length() - 2);

            validacion_cadenas validacion = new validacion_cadenas(id_er, strlexema);
            lista_objvalidacion.add(validacion);
            System.out.println(id_er);
            System.out.println(strlexema);

        }

        for (int i = 0; i < lista_objvalidacion.size(); i++) {
            String id_er = lista_objvalidacion.get(i).ExpresionRegular;
            String strlexema = lista_objvalidacion.get(i).Valor;
     
            String[] elementos = strlexema.split("");

            int posAutomata = 0;
            for (int j = 0; j < AutomatasAFD.size(); j++) {
                AFD automata_actual = AutomatasAFD.get(j);
                if (automata_actual.Identificador.equals(id_er)) {
                    posAutomata = j;
                    break;
                }
            }

            AFD automata = AutomatasAFD.get(posAutomata);
            for (int j = 0; j < lista_conjuntos.size(); j++) {

                for (int k = 0; k < automata.alfabeto.size(); k++) {
                    if (lista_conjuntos.get(j).identificador.equals(automata.alfabeto.get(k))) {
                        automata.alfabeto.add(lista_conjuntos.get(j).Elementos);
                        automata.alfabeto.remove(k);
                    }
                }

                for (int k = 0; k < automata.Transiciones.size(); k++) {
                    if (lista_conjuntos.get(j).identificador.equals(automata.Transiciones.get(k).valor)) {
                        automata.Transiciones.get(k).valor = lista_conjuntos.get(j).Elementos;
                    } else {
                        automata.Transiciones.get(k).valor = automata.Transiciones.get(k).valor.replace("\"", "");

                    }
                }
            }

            boolean finalizado = false;
            boolean filtro_alfabeto = false;
            EstadoAFD estado_actual;
            estado_actual = automata.Estado_Inicial;

            for (int j = 0; j < elementos.length; j++) {
                filtro_alfabeto = false;
                for (int k = 0; k < automata.alfabeto.size(); k++) {
                    if (automata.alfabeto.get(k).equals(elementos[j]) || automata.alfabeto.get(k).contains(elementos[j])) {
                        System.out.println("existe en alfabeto: " + elementos[j]);
                        filtro_alfabeto = true;
                        break;
                    }
                }

                if (!filtro_alfabeto) {
                    break;
                }

                if (!finalizado) {
                    for (int k = 0; k < automata.Transiciones.size(); k++) {
                        TransicionAFD transicion = automata.Transiciones.get(k);
                        if (estado_actual == transicion.Estado_Origen) {
                            if (elementos[j].equals(transicion.valor) || transicion.valor.contains(elementos[j])) {
                                estado_actual = transicion.Estado_Destino;
                                if ("#".equals(automata.Transiciones.get(k + 1).valor)) {
                                    finalizado = true;
                                    cadena = cadena + "La expresion: \"" + strlexema + "\" es valida para la expresion regular: \"" + automata.Identificador + "\".\n\n";
                                    lista_objvalidacion.get(i).Resultado = "Cadena valida.";
                                    break;
                                }
                                break;
                            }
                        }
                    }
                } else {
                    break;
                }
            }
            if (!finalizado) {
                cadena = cadena + "La expresion: \"" + strlexema + "\" no es valida para la expresion regular: \"" + automata.Identificador + "\".\n\n";
                lista_objvalidacion.get(i).Resultado = "Cadena no valida.";
            }
            System.out.println("FINALIZA VALIDACION");
        }

        String nombrearchivoActual = archivoActual.replace(".olc", "");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String salida = gson.toJson(lista_objvalidacion);
        FileWriter fichero = null;
        PrintWriter escritor = null;
        try {
            fichero = new FileWriter(path + "\\src\\SALIDAS_201902888\\salida_" + nombrearchivoActual + ".json");
            escritor = new PrintWriter(fichero);
            escritor.println(salida);
            escritor.close();
            fichero.close();
        } catch (IOException e) {
            System.out.println("error en generar json");
        }
        Validacionestxt.setText(cadena);
      

    }//GEN-LAST:event_AnalizarbtnActionPerformed

   public void GenerarDot(String cadena, String nombre_imagen, String directorio) {

        FileWriter fichero = null;
        PrintWriter escritor = null;
        try {
            fichero = new FileWriter(path + "\\src\\" + directorio + "\\" + nombre_imagen + ".dot");
            escritor = new PrintWriter(fichero);
            escritor.println(cadena);
            escritor.close();
            fichero.close();
            reportar(nombre_imagen, directorio);
        } catch (Exception e) {
            System.out.println("error en generar dot");
            e.printStackTrace();
        }
    }
   
   private void reportar(String nombre_imagen, String directorio) throws IOException {
        String file_input_path = path + "\\src\\" + directorio + "\\" + nombre_imagen + ".dot";
        String do_path = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
        String file_get_path = path + "\\src\\" + directorio + "\\" + nombre_imagen + ".jpg";
        try {
            ProcessBuilder pBuilder;
            pBuilder = new ProcessBuilder(do_path, "-Tjpg", file_input_path, "-o", file_get_path);
            pBuilder.redirectErrorStream(true);
            pBuilder.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
   
   public void generarReporteHTML() throws IOException {
        String nombrearchivoActual = archivoActual.replace(".olc", "");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            String Path = path + "\\src\\ERRORES_201902888\\" + nombrearchivoActual + ".html";
            fichero = new FileWriter(Path);
            pw = new PrintWriter(fichero);
            //comenzamos a escribir el html
            pw.println("<html>");
            pw.println("<head><title>REPORTE DE ERRORES</title>");
            pw.println("<style>");
            pw.println(" *{\n" +
                "            font-family: Arial;\n" +
                "        }\n" +
                "\n" +
                "        table,th ,td{\n" +
                "            border: 1.5px solid black;\n" +
                "        }\n" +
                "\n" +
                "        table{\n" +
                "            border-collapse: collapse;\n" +
                "            width: 700px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        th,td{\n" +
                "            padding: 10px;\n" +
                "           \n" +
                "        }\n" +
                "\n" +
                "        td{\n" +
                "            transition: 1s all;\n" +
                "            \n" +
                "        }\n" +
                "\n" +
                "        th{\n" +
                "            background: rgb(61, 61, 255);\n" +
                "            color: #ffff;\n" +
                "        }\n" +
                "\n" +
                "        tr:hover{\n" +
                "           background: rgb(216, 215, 215);\n" +
                "           font-size: 16.7px;\n" +
                "           color: #e82020;\n" +
                "        }");
            pw.println("</style>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<div align=\"center\">");
            pw.println("<h1>Reporte de Errores</h1>");
            pw.println("<br></br>");
            pw.println("<table border=1>");
            pw.println("<tr>");
            pw.println("<th># No.</th>");
            pw.println("<th>TIPO</th>");
            pw.println("<th>DESCRIPCION</th>");
            pw.println("<th>FILA</th>");
            pw.println("<th>COLUMNA</th>");
            pw.println("</tr>");
            for (int i = 0; i < listaErrores.size(); i++) {
                pw.println("<tr>");
                pw.println("<td>" + (i + 1) + "</td>");
                pw.println("<td>" + listaErrores.get(i).getTipo() + "</td>");
                pw.println("<td>" + listaErrores.get(i).getDescripcion() + "</td>");
                pw.println("<td>" + listaErrores.get(i).getFila() + "</td>");
                pw.println("<td>" + listaErrores.get(i).getColumna() + "</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</div");
            pw.println("</body>");
            pw.println("</html>");
        } catch (Exception e) {
        } finally {
            if (null != fichero) {
                fichero.close();
            }
        }
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void SeleccionTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionTipoActionPerformed
    System.out.println(contadorVisualizador);
        LinkedList<ImageIcon> temp = new LinkedList<>();
        String seleccion = (String) SeleccionTipo.getSelectedItem();
        if (!"Ver Imagenes".equals(seleccion) || !"Automata AFND".equals(seleccion)) {

            File carpeta = new File(path);
            String strCarpeta = "";
            switch (seleccion) {
                case "Arboles":
                    carpeta = new File(path + "\\src\\" + "\\ARBOLES_201902888");
                    strCarpeta = "/ARBOLES_201902888/";
                    break;
                case "Siguientes":
                    carpeta = new File(path + "\\src\\" + "\\SIGUIENTES_201902888");
                    strCarpeta = "/SIGUIENTES_201902888/";
                    break;
                case "Transiciones":
                    carpeta = new File(path + "\\src\\" + "\\TRANSICIONES_201902888");
                    strCarpeta = "/TRANSICIONES_201902888/";
                    break;
                case "Automatas AFD":
                    carpeta = new File(path + "\\src\\" + "\\AFD_201902888");
                    strCarpeta = "/AFD_201902888/";
                    break;
                case "Automatas AFND":
                    carpeta = new File(path + "\\src\\" + "\\AFND_201902888");
                    strCarpeta = "/AFND_201902888/";
                    break;
            }

            String[] listado = carpeta.list();
            if (listado == null || listado.length == 0 || (listado[0].endsWith(".dot") && listado.length == 1)) {
                Imagen.setText("No hay imagenes creadas, revisar DOT");

            } else {
                for (int i = 0; i < listado.length; i++) {
                    if (!listado[i].endsWith(".dot")) {
                        imagen = new ImageIcon(getClass().getResource(strCarpeta + listado[i]), listado[i]);
                        temp.add(imagen);
                    }
                }

                listaImagenes = temp;
                String nombre = listaImagenes.getFirst().getDescription();
                NombreImagen.setText("Nombre Imagen: " + nombre);
                Imagen.setText("");

                Imagen.setIcon(listaImagenes.getFirst());
                Imagen.repaint();
            }
        }

    }//GEN-LAST:event_SeleccionTipoActionPerformed

    private void SiguientebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguientebtnActionPerformed
      if (listaImagenes.size() == 0) {
            NombreImagen.setText("\"No hay imagenes creadas, revisar DOT");
            return;
        }

        ImageIcon temp = new ImageIcon();
        if (contadorVisualizador == listaImagenes.size() - 1) {
            contadorVisualizador = -1;
        }

        contadorVisualizador++;
        temp = listaImagenes.get(contadorVisualizador);
        String nombre = temp.getDescription();
        NombreImagen.setText("Nombre Imagen: " + nombre);
        Imagen.setIcon(temp);
        Imagen.repaint();

        System.out.println(contadorVisualizador);

       


    }//GEN-LAST:event_SiguientebtnActionPerformed

    private void AnteriorbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnteriorbtnActionPerformed
       if (listaImagenes.size() == 0) {
            NombreImagen.setText("No hay imagenes creadas, revisar DOT");
            return;
        }

        ImageIcon temp = new ImageIcon();
        if (contadorVisualizador == 0) {
            contadorVisualizador = listaImagenes.size();
        }

        contadorVisualizador--;
        temp = listaImagenes.get(contadorVisualizador);
        String nombre = temp.getDescription();
        NombreImagen.setText("Nombre Imagen: " + nombre);
        Imagen.setIcon(temp);
        Imagen.repaint();

        System.out.println(contadorVisualizador);
    }//GEN-LAST:event_AnteriorbtnActionPerformed

    private void GuardarComobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarComobtnActionPerformed
       String name = JOptionPane.showInputDialog("Ingrese el nombre del archivo nuevo");
        if (name == null || name == "") {
            return;
        }

        String variable = AreaEntrada.getText();

        try {
            FileWriter myWriter = new FileWriter(path + "\\src\\ARCHIVOS_201902888\\" + name + ".olc");
            myWriter.write(variable);
            myWriter.close();
           
        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
        }
    }//GEN-LAST:event_GuardarComobtnActionPerformed
    
    public static void abrirarchivo(String archivo){

     try {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);

     }

   }  
    
    private void NuevoArchivobtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoArchivobtnMouseClicked
      
    }//GEN-LAST:event_NuevoArchivobtnMouseClicked

    private void btnErrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnErrosActionPerformed
        abrirarchivo("src/ERRORES_201902888/"+archivoActual.replace(".olc", ".html"));
    }//GEN-LAST:event_btnErrosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrirbtn;
    private javax.swing.JButton Analizarbtn;
    private javax.swing.JButton Anteriorbtn;
    private javax.swing.JTextArea AreaEntrada;
    private javax.swing.JLabel Avisolbl;
    private javax.swing.JScrollPane ContenedorImagen;
    private javax.swing.JButton Generarbtn;
    private javax.swing.JMenuItem GuardarComobtn;
    private javax.swing.JMenuItem Guardarbtn;
    private javax.swing.JLabel Imagen;
    private javax.swing.JLabel NombreArchivotxt;
    private javax.swing.JLabel NombreImagen;
    private javax.swing.JMenuItem NuevoArchivobtn;
    private javax.swing.JComboBox<String> SeleccionTipo;
    private javax.swing.JButton Siguientebtn;
    private javax.swing.JTextPane Validacionestxt;
    private javax.swing.JButton btnErros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
