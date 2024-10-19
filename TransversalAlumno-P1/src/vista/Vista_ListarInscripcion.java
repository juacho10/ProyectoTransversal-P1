
package vista;

import conexion.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import persistencia.AlumnoData;


public class Vista_ListarInscripcion extends javax.swing.JInternalFrame {
        conexion con1 = new conexion();
        Connection conet;
        DefaultTableModel modelo;
        
        AlumnoData alumnoData = new AlumnoData(con1);
    
    public Vista_ListarInscripcion() {
        initComponents();
        conectarBaseDeDatos();
        inicializarModelo();
        llenarComboBoxLI();
        
        
    //actualizar tabla    
    String alumnoSeleccionado = (String) jCElegirAlumno.getSelectedItem();
    consultarInscripcionesPorAlumno(alumnoSeleccionado);
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
        modelo.addColumn("ID");
        modelo.addColumn("Nombre Materia");
        modelo.addColumn("bajaAlta");
        jTTablaMateriasIns.setModel(modelo);
    }

    private void llenarComboBoxLI() {
        try {
            List<Alumno> alumnos = alumnoData.obtenerAlumnos();
            jCElegirAlumno.removeAllItems(); // Limpiar los items actuales
            for (Alumno alumno : alumnos) {
                jCElegirAlumno.addItem(alumno.getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar las materias: " + e.getMessage());
        }

        // Actualizar la tabla después de llenar el ComboBox
        if (jCElegirAlumno.getItemCount() > 0) {
            jCElegirAlumno.setSelectedIndex(0); // Seleccionar el primer elemento por defecto
            String alumnoSeleccionado = (String) jCElegirAlumno.getSelectedItem();
            consultarInscripcionesPorAlumno(alumnoSeleccionado);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTablaMateriasIns = new javax.swing.JTable();
        jCElegirAlumno = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Informacion Alumno");

        jTTablaMateriasIns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Materias Inscriptas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTTablaMateriasIns);

        jCElegirAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCElegirAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCElegirAlumnoActionPerformed(evt);
            }
        });

        jLabel2.setText("Elegir alumno:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCElegirAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCElegirAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jCElegirAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCElegirAlumnoActionPerformed
        String alumnoSeleccionado = (String) jCElegirAlumno.getSelectedItem();
    consultarInscripcionesPorAlumno(alumnoSeleccionado);
    }//GEN-LAST:event_jCElegirAlumnoActionPerformed
    
    
    private void consultarInscripcionesPorAlumno(String nombreAlumno) {
        String sql = "SELECT inscripcion.id_inscripcion, materia.nombreMateria, inscripcion.bajaAlta " +
                     "FROM inscripcion " +
                     "JOIN alumno ON inscripcion.id_alumno = alumno.id_alumno " +
                     "JOIN materia ON inscripcion.id_materia = materia.id_materia " +
                     "WHERE alumno.nombre = ?";
        try {
            modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            PreparedStatement statement = conet.prepareStatement(sql);
            statement.setString(1, nombreAlumno);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object[] fila = new Object[3];
                fila[0] = resultSet.getInt("id_inscripcion");
                fila[1] = resultSet.getString("nombreMateria");
                fila[2] = resultSet.getBoolean("bajaAlta") ? "Activo" : "Inactivo";
                modelo.addRow(fila);
            }
            jTTablaMateriasIns.setModel(modelo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCElegirAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTTablaMateriasIns;
    // End of variables declaration//GEN-END:variables
}
