/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.proyecto1.pkg201902888;


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

/**
 *
 * @author ivann
 */
public class Interfaz extends javax.swing.JFrame {

    public static LinkedList<Nodo> lista_nodos_arbols = new LinkedList<Nodo>();
    
 

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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        NuevoArchivobtn = new javax.swing.JMenuItem();
        Abrirbtn = new javax.swing.JMenuItem();
        Guardarbtn = new javax.swing.JMenuItem();
        GuardarComobtn = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1480, 990));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Avisolbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 39, 308, -1));

        NombreArchivotxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NombreArchivotxt.setText("Archivo de entrada");
        getContentPane().add(NombreArchivotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 130, -1));

        Generarbtn.setText("Generar Automatas");
        Generarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Generarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 660, 164, 44));

        Analizarbtn.setText("Analizar Entradas");
        Analizarbtn.setEnabled(false);
        Analizarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Analizarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 660, 142, 44));

        SeleccionTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ver Imagemes", "Arboles", "Siguientes", "Transiciones", "Automatas AFD", "Automatas AFND" }));
        SeleccionTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionTipoActionPerformed(evt);
            }
        });
        getContentPane().add(SeleccionTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 30, 260, 30));

        NombreImagen.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NombreImagen.setText("Nombre");
        getContentPane().add(NombreImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 360, -1));

        Siguientebtn.setText(">>");
        Siguientebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Siguientebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguientebtnActionPerformed(evt);
            }
        });
        getContentPane().add(Siguientebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 660, 142, 44));

        Anteriorbtn.setText("<<");
        Anteriorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnteriorbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Anteriorbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 660, 142, 44));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("CONSOLA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 730, -1, -1));

        Validacionestxt.setEditable(false);
        Validacionestxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Validacionestxt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Validacionestxt.setForeground(new java.awt.Color(51, 255, 102));
        jScrollPane3.setViewportView(Validacionestxt);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 760, 1340, 180));

        AreaEntrada.setEditable(false);
        AreaEntrada.setColumns(20);
        AreaEntrada.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        AreaEntrada.setForeground(new java.awt.Color(0, 204, 204));
        AreaEntrada.setRows(5);
        jScrollPane2.setViewportView(AreaEntrada);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 540, 570));

        ContenedorImagen.setBackground(new java.awt.Color(255, 255, 255));

        Imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ContenedorImagen.setViewportView(Imagen);

        getContentPane().add(ContenedorImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 760, 560));

        jMenuBar1.setBorder(null);

        jMenu2.setText("Archivo");
        jMenu2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

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

        Abrirbtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Abrirbtn.setText("Abrir Archivo");
        Abrirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirbtnActionPerformed(evt);
            }
        });
        jMenu2.add(Abrirbtn);

        Guardarbtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Guardarbtn.setText("Guardar");
        Guardarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarbtnActionPerformed(evt);
            }
        });
        jMenu2.add(Guardarbtn);

        GuardarComobtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        GuardarComobtn.setText("Guardar Como...");
        GuardarComobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarComobtnActionPerformed(evt);
            }
        });
        jMenu2.add(GuardarComobtn);

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
        

    }//GEN-LAST:event_GenerarbtnActionPerformed

    private void AnalizarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarbtnActionPerformed

      

    }//GEN-LAST:event_AnalizarbtnActionPerformed

   

    private void SeleccionTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionTipoActionPerformed

 


    }//GEN-LAST:event_SeleccionTipoActionPerformed

    private void SiguientebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguientebtnActionPerformed

       


    }//GEN-LAST:event_SiguientebtnActionPerformed

    private void AnteriorbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnteriorbtnActionPerformed
       
    }//GEN-LAST:event_AnteriorbtnActionPerformed

    private void GuardarComobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarComobtnActionPerformed
       
    }//GEN-LAST:event_GuardarComobtnActionPerformed

    private void NuevoArchivobtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoArchivobtnMouseClicked

    }//GEN-LAST:event_NuevoArchivobtnMouseClicked

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
