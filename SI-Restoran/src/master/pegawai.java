package master;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import restoran.main;

/**
 *
 * @author meita
 */
public class pegawai extends javax.swing.JInternalFrame {
    private javax.swing.table.DefaultTableModel tblModel = getDefaultTabelModel();
    
    public pegawai() {
        initComponents();
        tblpegawai.setModel(tblModel);
        setDefaultTable();
    }

    private void setDefaultTable(){
        try{
            Class.forName ("com.mysql.jdbc.Driver");

            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            
            String strSQL="SELECT * "
                        + "FROM `pegawai`";
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(strSQL);

            while(rs.next()){
                tblModel.addRow(new String[]{rs.getString(1), rs.getString(2)});
            }

            rs.close();
            st.close();
            koneksi.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("KESALAHAN SAAT"+"ME-LOAD DRIVER JDBC \n"+cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("KESALAHAN SAAT KONEKSI ATAU "+"KESALAHAN QUERY SQL \n"+sqle.getMessage());
        }
    }
    
    private javax.swing.table.DefaultTableModel getDefaultTabelModel() {
        return new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] {"Nama","Password"}
            ){
                boolean[] canEdit=new boolean[]{
                    false,false
                };

                public boolean isiCellEditable(int rowIndex,int columnIndex){
                        return canEdit[columnIndex];

                }
            };
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pswd = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpegawai = new javax.swing.JTable();
        ubah = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        hapus = new javax.swing.JButton();

        setTitle("Master Pegawai");

        jLabel1.setText("Nama");

        jLabel2.setText("Password");

        tblpegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpegawai.setColumnSelectionAllowed(true);
        tblpegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpegawai);
        tblpegawai.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblpegawai.getColumnModel().getColumn(1).setResizable(false);
        tblpegawai.getColumnModel().getColumn(1).setPreferredWidth(0);

        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37)
                                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(pswd, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(keluar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keluar)
                    .addComponent(hapus)
                    .addComponent(ubah)
                    .addComponent(tambah))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblpegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpegawaiMouseClicked
        if(evt.getClickCount()==1){
            int row = tblpegawai.getSelectedRow();
            nama.setText(tblModel.getValueAt(row, 0).toString());
            pswd.setText(tblModel.getValueAt(row, 1).toString());
        }
    }//GEN-LAST:event_tblpegawaiMouseClicked

    private boolean dataSudahAda(String nama){
        boolean hasil = false;
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            String strSQL = "SELECT * "
                            + "FROM `pegawai` "
                            + "WHERE `nama` = '"+nama+"' ";

            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(strSQL);

            if(rs.next()){
                hasil = true;
            }
            rs.close();
            st.close();
            koneksi.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("kesalahan saat"+"me-load driver jdbc \n"+cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("keslahan saat koneksi atau "+"kesalahan query sql \n"+sqle.getMessage());
        }
        return hasil;
    }
    
    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        if (dataSudahAda(nama.getText()) == false){
            try{
                Class.forName ("com.mysql.jdbc.Driver");

                String urldb="jdbc:mysql://localhost:3306/restaurant";
                String user=main.dbUser;
                String password=main.dbPassword;
                Connection koneksi = java.sql.DriverManager.getConnection(urldb,user,password);
               
                Statement st = koneksi.createStatement();
                String strSQL = "INSERT INTO `restaurant`.`pegawai` ( `nama` , `password` ) "
                              + "VALUES ( '"+nama.getText()+"', '"+pswd.getText()+"' );";
                st.executeUpdate(strSQL);
                tblModel.insertRow(0, new String[]{nama.getText(), pswd.getText()});

                nama.setText("");
                pswd.setText("");

                st.close();
                koneksi.close();
            }catch(ClassNotFoundException cnfe){
                System.out.println("KESALAHAN SAAT"+"ME-LOAD DRIVER JDBC \n"+cnfe.getMessage());
            }catch(SQLException sqle){
                System.out.println("KESALAHAN SAAT KONEKSI ATAU "+"KESALAHAN QUERY SQL \n"+sqle.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nama pegawai sudah terdaftar!");
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try{
            Class.forName ("com.mysql.jdbc.Driver");

            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            
            Statement st = koneksi.createStatement();

            String strSQL="DELETE FROM `restaurant`.`pegawai` WHERE `pegawai`.`nama` = '"+nama.getText()+"'";
            st.executeUpdate(strSQL);
            int row = tblpegawai.convertRowIndexToModel(tblpegawai.getSelectedRow());
            tblModel.removeRow(row);

            nama.setText("");
            pswd.setText("");
           
            st.close();
            koneksi.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("KESALAHAN SAAT"+"ME-LOAD DRIVER JDBC \n"+cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("KESALAHAN SAAT KONEKSI ATAU "+"KESALAHAN QUERY SQL \n"+sqle.getMessage());
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try{
            Class.forName ("com.mysql.jdbc.Driver");

            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            
            Statement st = koneksi.createStatement();

            String strSQL="UPDATE `restaurant`.`pegawai` SET `password` = '"+pswd.getText()+"' WHERE `pegawai`.`nama` = '"+nama.getText()+"'";
            st.executeUpdate(strSQL);

            int row = tblpegawai.convertRowIndexToModel(tblpegawai.getSelectedRow());
            tblModel.removeRow(row);
            tblModel.insertRow(row, new String[]{nama.getText(), pswd.getText()});

            nama.setText("");
            pswd.setText("");
            
            st.close();
            koneksi.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("KESALAHAN SAAT"+"ME-LOAD DRIVER JDBC \n"+cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("KESALAHAN SAAT KONEKSI ATAU "+"KESALAHAN QUERY SQL \n"+sqle.getMessage());
        }  
    }//GEN-LAST:event_ubahActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_keluarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField nama;
    private javax.swing.JPasswordField pswd;
    private javax.swing.JButton tambah;
    private javax.swing.JTable tblpegawai;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
