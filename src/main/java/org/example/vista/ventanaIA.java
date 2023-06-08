package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class ventanaIA extends JFrame {
    //JFrame
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;


    //Panel1
    private JLabel lblID;
    private JLabel lblURL;
    private JLabel lblNombre;
    private JLabel lblDesarrollador;
    private JLabel lblTipo;
    private JLabel lblFecha;
    private JTextField txtID;
    private JTextField txtURL;
    private JTextField txtNombre;
    private JTextField txtDesarrollador;
    private JTextField txtTipo;
    private JTextField txtFecha;
    private JButton btnAgregar;

    //Panel2
    private JTable tblTablaIA;
    private JScrollPane scrollPane;
    private JButton btnActualizar;
    //Panel 3
    private JLabel lblImagen;
    private JLabel lblIcono;
    private JLabel lblImagenIcono;

    //Panel4
    private JLabel lblID4;
    private JLabel lblURL4;
    private JLabel lblNombre4;
    private JLabel lblDesarrollador4;
    private JLabel lblTipo4;
    private JLabel lblFecha4;
    private JTextField txtID4;
    private JTextField txtURL4;
    private JTextField txtNombre4;
    private JTextField txtDesarrollador4;
    private JTextField txtTipo4;
    private JTextField txtFecha4;
    private JButton btnActualizar4;
    private JLabel lblElimID;
    private JTextField txtElimID;
    private JButton btnEliminar4;
    private JLabel lineas;


    public ventanaIA(String title) throws HeadlessException {
        super(title);
        this.setSize(800, 800);

        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //Panel1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(232, 214, 139));
            //Labels y TextFields
        lblID = new JLabel("ID:");
        txtID = new JTextField(3);
        txtID.setText("0");
        txtID.setEnabled(false);

        lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);

        lblDesarrollador = new JLabel("Desarrollador:");
        txtDesarrollador = new JTextField(20);

        lblTipo = new JLabel("Tipo de IA:");
        txtTipo = new JTextField(30);

        lblFecha = new JLabel("Fecha de creacion:");
        txtFecha = new JTextField(6);

        lblURL = new JLabel("URL:");
        txtURL = new JTextField(40);

        btnAgregar = new JButton("Agregar");
            //Agregarlos a panel1
        panel1.add(lblID);
        panel1.add(txtID);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblDesarrollador);
        panel1.add(txtDesarrollador);
        panel1.add(lblTipo);
        panel1.add(txtTipo);
        panel1.add(lblFecha);
        panel1.add(txtFecha);
        panel1.add(lblURL);
        panel1.add(txtURL);
        panel1.add(btnAgregar);

        //Panel2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(181, 213, 201)) ;
            //Tabla Panel2
        tblTablaIA = new JTable();
        scrollPane = new JScrollPane(tblTablaIA);
        btnActualizar = new JButton("Actualizar");
        panel2.add(btnActualizar);
        panel2.add(scrollPane);


        //Panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(174, 148, 219));
        lblImagen = new JLabel("IMAGEN");
        panel3.add(lblImagen);
        this.panel3.add(lblIcono);

        //Panel4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(225, 191, 222));

        lblID4 = new JLabel("Id:");
        txtID4 = new JTextField(3);

        lblNombre4 = new JLabel("Nombre:");
        txtNombre4 = new JTextField(20);

        lblDesarrollador4 = new JLabel("Desarrollador:");
        txtDesarrollador4 = new JTextField(20);

        lblTipo4 = new JLabel("Tipo de IA:");
        txtTipo4 = new JTextField(30);

        lblFecha4 = new JLabel("Fecha de creacion:");
        txtFecha4 = new JTextField(6);

        lblURL4 = new JLabel("URL:");
        txtURL4 = new JTextField(40);

        lblElimID = new JLabel("Eliminar campo (id)");
        txtElimID = new JTextField(3);

        btnActualizar4 = new JButton("Modificar");
        btnEliminar4 = new JButton("Eliminar");
        lineas = new JLabel("-------------------------------------------------------");

        //Agregarlos a panel 4
        panel4.add(lblID4);
        panel4.add(txtID4);
        panel4.add(lblNombre4);
        panel4.add(txtNombre4);
        panel4.add(lblDesarrollador4);
        panel4.add(txtDesarrollador4);
        panel4.add(lblTipo4);
        panel4.add(txtTipo4);
        panel4.add(lblFecha4);
        panel4.add(txtFecha4);
        panel4.add(lblURL4);
        panel4.add(txtURL4);
        panel4.add(btnActualizar4);
        panel4.add(lineas);
        panel4.add(lblElimID);
        panel4.add(txtElimID);
        panel4.add(btnEliminar4);




        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getLblID() {
        return lblID;
    }

    public void setLblID(JLabel lblID) {
        this.lblID = lblID;
    }

    public JLabel getLblURL() {
        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {
        this.lblURL = lblURL;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblDesarrollador() {
        return lblDesarrollador;
    }

    public void setLblDesarrollador(JLabel lblDesarrollador) {
        this.lblDesarrollador = lblDesarrollador;
    }

    public JLabel getLblTipo() {
        return lblTipo;
    }

    public void setLblTipo(JLabel lblTipo) {
        this.lblTipo = lblTipo;
    }

    public JLabel getLblFecha() {
        return lblFecha;
    }

    public void setLblFecha(JLabel lblFecha) {
        this.lblFecha = lblFecha;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtURL() {
        return txtURL;
    }

    public void setTxtURL(JTextField txtURL) {
        this.txtURL = txtURL;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtDesarrollador() {
        return txtDesarrollador;
    }

    public void setTxtDesarrollador(JTextField txtDesarrollador) {
        this.txtDesarrollador = txtDesarrollador;
    }

    public JTextField getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(JTextField txtTipo) {
        this.txtTipo = txtTipo;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(JTextField txtFecha) {
        this.txtFecha = txtFecha;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTable getTblTablaIA() {
        return tblTablaIA;
    }

    public void setTblTablaIA(JTable tblTablaIA) {
        this.tblTablaIA = tblTablaIA;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }
    public void limpiar(){
        txtNombre.setText("");
        txtDesarrollador.setText("");
        txtTipo.setText("");
        txtFecha.setText("");
        txtURL.setText("");
    }
    public void limpiarPanel4(){
        txtID4.setText("");
        txtNombre4.setText("");
        txtDesarrollador4.setText("");
        txtTipo4.setText("");
        txtFecha4.setText("");
        txtURL4.setText("");
    }


    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public JLabel getLblID4() {
        return lblID4;
    }

    public void setLblID4(JLabel lblID4) {
        this.lblID4 = lblID4;
    }

    public JLabel getLblURL4() {
        return lblURL4;
    }

    public void setLblURL4(JLabel lblURL4) {
        this.lblURL4 = lblURL4;
    }

    public JLabel getLblNombre4() {
        return lblNombre4;
    }

    public void setLblNombre4(JLabel lblNombre4) {
        this.lblNombre4 = lblNombre4;
    }

    public JLabel getLblDesarrollador4() {
        return lblDesarrollador4;
    }

    public void setLblDesarrollador4(JLabel lblDesarrollador4) {
        this.lblDesarrollador4 = lblDesarrollador4;
    }

    public JLabel getLblTipo4() {
        return lblTipo4;
    }

    public void setLblTipo4(JLabel lblTipo4) {
        this.lblTipo4 = lblTipo4;
    }

    public JLabel getLblFecha4() {
        return lblFecha4;
    }

    public void setLblFecha4(JLabel lblFecha4) {
        this.lblFecha4 = lblFecha4;
    }

    public JTextField getTxtID4() {
        return txtID4;
    }

    public void setTxtID4(JTextField txtID4) {
        this.txtID4 = txtID4;
    }

    public JTextField getTxtURL4() {
        return txtURL4;
    }

    public void setTxtURL4(JTextField txtURL4) {
        this.txtURL4 = txtURL4;
    }

    public JTextField getTxtNombre4() {
        return txtNombre4;
    }

    public void setTxtNombre4(JTextField txtNombre4) {
        this.txtNombre4 = txtNombre4;
    }

    public JTextField getTxtDesarrollador4() {
        return txtDesarrollador4;
    }

    public void setTxtDesarrollador4(JTextField txtDesarrollador4) {
        this.txtDesarrollador4 = txtDesarrollador4;
    }

    public JTextField getTxtTipo4() {
        return txtTipo4;
    }

    public void setTxtTipo4(JTextField txtTipo4) {
        this.txtTipo4 = txtTipo4;
    }

    public JTextField getTxtFecha4() {
        return txtFecha4;
    }

    public void setTxtFecha4(JTextField txtFecha4) {
        this.txtFecha4 = txtFecha4;
    }

    public JButton getBtnActualizar4() {
        return btnActualizar4;
    }

    public void setBtnActualizar4(JButton btnActualizar4) {
        this.btnActualizar4 = btnActualizar4;
    }

    public JLabel getLblElimID() {
        return lblElimID;
    }

    public void setLblElimID(JLabel lblElimID) {
        this.lblElimID = lblElimID;
    }

    public JTextField getTxtElimID() {
        return txtElimID;
    }

    public void setTxtElimID(JTextField txtElimID) {
        this.txtElimID = txtElimID;
    }

    public JButton getBtnEliminar() {
        return btnEliminar4;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar4 = btnEliminar;
    }

    public JLabel getLineas() {
        return lineas;
    }

    public void setLineas(JLabel lineas) {
        this.lineas = lineas;
    }

    public JButton getBtnEliminar4() {
        return btnEliminar4;
    }

    public void setBtnEliminar4(JButton btnEliminar4) {
        this.btnEliminar4 = btnEliminar4;
    }

    public JLabel getLblIcono() {
        return lblIcono;
    }

    public void setLblIcono(JLabel lblIcono) {
        this.lblIcono = lblIcono;
    }

    public JLabel getLblImagenIcono() {
        return lblImagenIcono;
    }

    public void setLblImagenIcono(JLabel lblImagenIcono) {
        this.lblImagenIcono = lblImagenIcono;
    }
}
