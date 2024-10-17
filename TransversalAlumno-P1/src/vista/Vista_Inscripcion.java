
package vista;

import conexion.conexion;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Inscripcion;
import modelo.Materia;
import persistencia.AlumnoData;
import persistencia.InscripcionData;
import persistencia.MateriaData;

public class Vista_Inscripcion extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla = new DefaultTableModel();

    public Vista_Inscripcion() {
        initComponents();
        cargarMateriasEnComboBox();
        cargarAlumnosEnComboBox();
        CargarTablaModel();
        actualizarTabla();
        grupoBajaAlta = new ButtonGroup();
        grupoBajaAlta.add(jRInscribir);
        grupoBajaAlta.add(jRNoInscripto);
    }
    
    private ButtonGroup grupoBajaAlta;
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JComboMateria = new javax.swing.JComboBox<>();
        JComboAlumno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRInscribir = new javax.swing.JRadioButton();
        jRNoInscripto = new javax.swing.JRadioButton();
        JBInscribir = new javax.swing.JButton();
        JBAnular = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTInscripcion = new javax.swing.JTable();

        setClosable(true);

        JComboMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboMateriaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Materia");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Alumno");

        jRInscribir.setText("Inscripto");
        jRInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRInscribirActionPerformed(evt);
            }
        });

        jRNoInscripto.setText("No inscripto");

        JBInscribir.setText("Inscribir");
        JBInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBInscribirActionPerformed(evt);
            }
        });

        JBAnular.setText("Anular inscripsion");
        JBAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAnularActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inscripciones");

        jTInscripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTInscripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JComboMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRInscribir)
                            .addComponent(JBInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JBAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRNoInscripto))
                                .addGap(66, 66, 66))
                            .addComponent(JComboAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JComboMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JComboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRInscribir)
                    .addComponent(jRNoInscripto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRInscribirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRInscribirActionPerformed

    private void JBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBInscribirActionPerformed
        Materia materiaSeleccionada = (Materia) JComboMateria.getSelectedItem();
        Alumno alumnoSeleccionado = (Alumno) JComboAlumno.getSelectedItem();

        if (materiaSeleccionada != null && alumnoSeleccionado != null) {
            conexion con = new conexion();
            InscripcionData inscripcionData = new InscripcionData(con);

            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setId_materia(materiaSeleccionada.getId_materia());
            inscripcion.setId_alumno(alumnoSeleccionado.getId_alumno());
            inscripcion.setBajaAlta(true);

            inscripcionData.crearInscripcion(inscripcion);

            // Limpiar la tabla antes de cargar los nuevos datos
            modeloTabla.setRowCount(0);

            // Obtener todas las inscripciones y agregarlas a la tabla
            List<Inscripcion> inscripciones = inscripcionData.obtenerInscripciones();
            for (Inscripcion ins : inscripciones) {
                Object[] fila = new Object[4];
                fila[0] = ins.getId_inscripcion();
                fila[1] = ins.getAlumnoNombre(); // Asegúrate de tener este método en Inscripcion
                fila[2] = ins.getMateriaNombre(); // Asegúrate de tener este método en Inscripcion
                fila[3] = ins.isBajaAlta() ? "Activo" : "Inactivo";
                modeloTabla.addRow(fila);
            }

            JOptionPane.showMessageDialog(this, "Inscripción realizada con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un alumno y una materia.");
        }
        actualizarTabla();
    }//GEN-LAST:event_JBInscribirActionPerformed

    private void JBAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAnularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBAnularActionPerformed

    private void JComboMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboMateriaActionPerformed

    }//GEN-LAST:event_JComboMateriaActionPerformed

    private void cargarMateriasEnComboBox() {
        JComboMateria.removeAllItems();
        conexion con = new conexion();
        MateriaData materiaData = new MateriaData(con);

        List<Materia> materias = materiaData.obtenerMateria();
        for (Materia materia : materias) {
            JComboMateria.addItem(materia); // Agregar objeto Materia
        }
    }

    private void cargarAlumnosEnComboBox() {
        JComboAlumno.removeAllItems();
        conexion con = new conexion();
        AlumnoData alumnoData = new AlumnoData(con);

        List<Alumno> alumnos = alumnoData.obtenerAlumnos();
        for (Alumno alumno : alumnos) {
            JComboAlumno.addItem(alumno); // Agregar objeto Alumno
        }
    }

    private void CargarTablaModel() {

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nº de Inscripcion");
        modeloTabla.addColumn("Alumno");
        modeloTabla.addColumn("Materia");
        modeloTabla.addColumn("Estado");
        // Asignar el modelo a la JTable
        jTInscripcion.setModel(modeloTabla);
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        InscripcionData inscripcionData = new InscripcionData(new conexion());
        List<Inscripcion> inscripciones = inscripcionData.obtenerInscripciones();
        for (Inscripcion ins : inscripciones) {
            Object[] fila = new Object[4];
            fila[0] = ins.getId_inscripcion();
            fila[1] = ins.getAlumnoNombre();
            fila[2] = ins.getMateriaNombre();
            fila[3] = ins.isBajaAlta() ? "Activo" : "Inactivo";
            modeloTabla.addRow(fila);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAnular;
    private javax.swing.JButton JBInscribir;
    private javax.swing.JComboBox<Alumno> JComboAlumno;
    private javax.swing.JComboBox<Materia> JComboMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRInscribir;
    private javax.swing.JRadioButton jRNoInscripto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTInscripcion;
    // End of variables declaration//GEN-END:variables
}
