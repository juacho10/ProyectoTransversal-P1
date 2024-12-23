/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import conexion.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import java.time.ZoneId;
import java.util.Date;

import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import persistencia.AlumnoData;
import static vista.Vista_transversal.modelo;

/**
 *
 * @author Lenovo
 */
public class Vista_Alumno extends javax.swing.JInternalFrame {
    conexion con1 = new conexion();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idA;
    private ButtonGroup grupoEstado;

    AlumnoData alumnoData = new AlumnoData(con1);

    /**
     * Creates new form Vista_Alumno
     */
    
    public Vista_Alumno() {
        initComponents();
        conectarBaseDeDatos();
        inicializarModelo();
        consultar();
        
        grupoEstado = new ButtonGroup();
        grupoEstado.add(jRAlta);
        grupoEstado.add(jRBaja);
        
    }
        private void conectarBaseDeDatos() {
        String url = "jdbc:mariadb://127.0.0.1:3306/transversalDB";
        String user = "root";
        String password = "";

        try {
            conet = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión a la base de datos exitosa!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
        }
    }
        private void inicializarModelo() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Id_alumno");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("DNI");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("activo");
        jTtablaAlumnos.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jBInsertar = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTtablaAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jTFApellido = new javax.swing.JTextField();
        jTFDni = new javax.swing.JTextField();
        jDFechaNac = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jBLimpiar = new javax.swing.JButton();
        jRBaja = new javax.swing.JRadioButton();
        jRAlta = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        setClosable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );

        jBInsertar.setText("Insertar");
        jBInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInsertarActionPerformed(evt);
            }
        });

        jBBorrar.setText("Borrar");
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });

        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jTtablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Apellido", "Dni", "Fecha Nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTtablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTtablaAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTtablaAlumnos);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Apellido:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("DNI:");

        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });

        jTFApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFApellidoActionPerformed(evt);
            }
        });

        jTFDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDniActionPerformed(evt);
            }
        });

        jDFechaNac.setDateFormatString("y-MM-dd");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Fecha:");

        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jRBaja.setText("Baja");
        jRBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBajaActionPerformed(evt);
            }
        });

        jRAlta.setText("Alta");
        jRAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRAltaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cargar Alumno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBLimpiar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jBBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jRBaja)
                        .addGap(18, 18, 18)
                        .addComponent(jRAlta)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFApellido))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFDni, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                .addGap(5, 5, 5)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRAlta)
                            .addComponent(jRBaja))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInsertarActionPerformed
        Agregar1();
        consultar();
    }//GEN-LAST:event_jBInsertarActionPerformed

    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
        Borrar();
        consultar();
    }//GEN-LAST:event_jBBorrarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        Actualizar();
        consultar();
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreActionPerformed

    private void jTFApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFApellidoActionPerformed

    private void jTFDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDniActionPerformed

    private void jTtablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTtablaAlumnosMouseClicked
        int fila = jTtablaAlumnos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "No se selecionó una fila");
        } else{
            idA = Integer.parseInt((String)jTtablaAlumnos.getValueAt(fila,0) .toString());
            String nombre = (String) jTtablaAlumnos.getValueAt(fila,1);
            String apellido = (String) jTtablaAlumnos.getValueAt(fila,2);
            int dni = Integer.parseInt((String)jTtablaAlumnos.getValueAt(fila,3) .toString());
            LocalDate fechaNacimiento = LocalDate.parse(jTtablaAlumnos.getValueAt(fila, 4).toString());
            
            jTFNombre.setText(nombre);
            jTFApellido.setText(apellido);
            jTFDni.setText("" + dni);
            
            Date date = Date.from(fechaNacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());
            jDFechaNac.setDate(date);
            
        }
    }//GEN-LAST:event_jTtablaAlumnosMouseClicked

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
            jTFNombre.setText("");
            jTFApellido.setText("");
            jTFDni.setText("");
            jDFechaNac.setDate(null);
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jRBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBajaActionPerformed
        int fila = jTtablaAlumnos.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un alumno de la tabla para dar de baja.");
        return;
    }
    int id_alumno = Integer.parseInt(jTtablaAlumnos.getValueAt(fila, 0).toString());
    try {
        alumnoData.bajaLogica(id_alumno);
        JOptionPane.showMessageDialog(this, "Alumno dado de baja correctamente.");
        consultar();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al dar de baja el alumno: " + ex.getMessage());
    }
    }//GEN-LAST:event_jRBajaActionPerformed

    private void jRAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRAltaActionPerformed
       int fila = jTtablaAlumnos.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un alumno de la tabla para dar de alta.");
        return;
    }
    int id_alumno = Integer.parseInt(jTtablaAlumnos.getValueAt(fila, 0).toString());
    try {
        alumnoData.altaLogica(id_alumno);
        JOptionPane.showMessageDialog(this, "Alumno dado de alta correctamente.");
        consultar();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al dar de alta el alumno: " + ex.getMessage());
    }
    }//GEN-LAST:event_jRAltaActionPerformed
    
    void consultar() {
        String sql = "SELECT * FROM alumno";
        try {
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            Object[] alumno = new Object[6];
            modelo.setRowCount(0); // Limpiar la tabla
            while (rs.next()) {
                alumno[0] = rs.getInt("id_alumno");
                alumno[1] = rs.getString("nombre");
                alumno[2] = rs.getString("apellido");
                alumno[3] = rs.getString("dni");
                alumno[4] = rs.getDate("fecha_nacimiento").toLocalDate();
                alumno[5] = rs.getBoolean("activo");
                modelo.addRow(alumno);
            }
            jTtablaAlumnos.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void Agregar1(){
    String nombre = jTFNombre.getText();
    String apellido = jTFApellido.getText();
    String dni = jTFDni.getText();
    Date fechaNacimientoDate = jDFechaNac.getDate();
    boolean activo = true;

    try {
        if (nombre.equals("") || apellido.equals("") || dni.equals("") || fechaNacimientoDate == null) {
            JOptionPane.showMessageDialog(this, "Faltan datos en las casillas");
        } else {
            // Convertir Date a LocalDate
            LocalDate fechaNacimiento = fechaNacimientoDate.toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();


 
            Alumno crearAlumno = new Alumno(nombre, apellido, dni, fechaNacimiento, activo);
            alumnoData.agregarAlumno(crearAlumno);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Alumno agregado correctamente");


        }
        } catch(Exception e){
            e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al agregar el alumno: " + e.getMessage());
    } 
    }
    /*void Agregar(){
        String nombre = jTFNombre.getText();
        String apellido = jTFApellido.getText();
        String dni = jTFDni.getText();
        String fecha = ((JTextField)jDFechaNac.getDateEditor().getUiComponent()).getText();
        System.out.println(fecha);
        
        try{
            if(nombre.equals("") || apellido.equals("") || dni.equals("") || fecha.equals("")){
                JOptionPane.showMessageDialog(this, "Faltan datos en las casillas");
            }
            else{
                String sql = "INSERT INTO `alumno`(`nombre`, `apellido`, `dni`, `fecha_nacimiento`) VALUES ('" + nombre + "', '" + apellido + "', '" + dni + "', '" + fecha + "')";
                st = conet.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Nuevo alumno registrado");
                
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    } */
   
    
    void Actualizar(){
    String nombre = jTFNombre.getText();
    String apellido = jTFApellido.getText();
    String dni = jTFDni.getText();
    Date fechaNacimientoDate = jDFechaNac.getDate();
    boolean activo = true;
    
    try {
        if (nombre.equals("") || apellido.equals("") || dni.equals("") || fechaNacimientoDate == null) {
            JOptionPane.showMessageDialog(this, "Faltan datos en las casillas");
        } else {
            // Convertir Date a LocalDate
            LocalDate fechaNacimiento = fechaNacimientoDate.toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();

            // Obtener el ID del alumno seleccionado en la tabla
            int fila = jTtablaAlumnos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un alumno de la tabla para actualizar.");
                return;
            }
            int id_alumno = Integer.parseInt(jTtablaAlumnos.getValueAt(fila, 0).toString());

            // Crear una instancia de Alumno con los valores actualizados
            Alumno alumnoActualizado = new Alumno(id_alumno, nombre, apellido, dni, fechaNacimiento, activo);

            // Llamar al método actualizar de AlumnoData
            alumnoData.actualizar(alumnoActualizado);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Alumno actualizado correctamente");


        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al actualizar el alumno: " + ex.getMessage());
    }
    }
    
    void Borrar(){
    String nombre = jTFNombre.getText();
    String apellido = jTFApellido.getText();
    String dni = jTFDni.getText();
    Date fechaNacimientoDate = jDFechaNac.getDate();

    try {
        if (nombre.equals("") || apellido.equals("") || dni.equals("") || fechaNacimientoDate == null) {
            JOptionPane.showMessageDialog(this, "Faltan datos en las casillas");
        } else {
            // Obtener el ID del alumno seleccionado en la tabla
            int fila = jTtablaAlumnos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un alumno de la tabla para eliminar.");
                return;
            }
            int id_alumno = Integer.parseInt(jTtablaAlumnos.getValueAt(fila, 0).toString());

 
            alumnoData.borrar(id_alumno);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Alumno eliminado correctamente");


        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al eliminar el alumno: " + ex.getMessage());
    } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBInsertar;
    private javax.swing.JButton jBLimpiar;
    private com.toedter.calendar.JDateChooser jDFechaNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRAlta;
    private javax.swing.JRadioButton jRBaja;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFDni;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jTtablaAlumnos;
    // End of variables declaration//GEN-END:variables
     
   
 





}
