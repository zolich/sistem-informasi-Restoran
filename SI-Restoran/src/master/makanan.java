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
public class makanan extends javax.swing.JInternalFrame {
    private javax.swing.table.DefaultTableModel tblModel = getDefaultTabelModel();
    
    public makanan() {
        initComponents();
        tblmakanan.setModel(tblModel);
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
                         + "FROM `makanan`";
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(strSQL);

            while(rs.next()){
                String jenis;
                if (rs.getInt(2) == 0){
                    jenis = "Makanan";
                } else {
                    jenis = "Minuman";
                }
                tblModel.addRow(new String[]{rs.getString(1), jenis, rs.getString(3)});
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
                new String[] {"Nama Makanan","Kategori","Harga"}
            ){
                boolean[] canEdit=new boolean[]{
                    false,false,false
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
        kategori = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        harga = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmakanan = new javax.swing.JTable();
        keluar = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        tambah = new javax.swing.JButton();

        setTitle("Master Makanan");

        jLabel1.setText("Nama Makanan");

        jLabel2.setText("Kategori");

        kategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Makanan", "Minuman" }));

        jLabel3.setText("Harga");

        harga.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        tblmakanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Makanan", "Kategori", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblmakanan.setColumnSelectionAllowed(true);
        tblmakanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmakananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmakanan);
        tblmakanan.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
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
                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keluar)
                    .addComponent(hapus)
                    .addComponent(ubah)
                    .addComponent(tambah))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblmakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmakananMouseClicked
        if(evt.getClickCount()==1){
            int row = tblmakanan.getSelectedRow();
            int jenis;
            if (tblModel.getValueAt(row, 1).toString() == "Makanan"){
                jenis = 0;
            } else {
                jenis = 1;
            }
                
            nama.setText(tblModel.getValueAt(row, 0).toString());
            kategori.setSelectedIndex(jenis);
            harga.setText(tblModel.getValueAt(row, 2).toString());
        }
    }//GEN-LAST:event_tblmakananMouseClicked

    private boolean dataSudahAda(String nama){
        boolean hasil = false;
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            String strSQL = "SELECT * "
                            + "FROM `makanan` "
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
                String strSQL = "INSERT INTO `restaurant`.`makanan` ( `nama` , `kategori` , `harga` ) "
                              + "VALUES ( '"+nama.getText()+"', '"+kategori.getSelectedIndex()+"', '"+harga.getText()+"');";
                st.executeUpdate(strSQL);
                
                String jenis;
                if (kategori.getSelectedIndex() == 0){
                    jenis = "Makanan";
                } else {
                    jenis = "Minuman";
                }
                
                tblModel.insertRow(0, new String[]{nama.getText(), jenis, harga.getText()});

                nama.setText("");
                kategori.setSelectedIndex(-1);
                harga.setText("");
                
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

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try{
            Class.forName ("com.mysql.jdbc.Driver");

            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            
            Statement st = koneksi.createStatement();

            String strSQL="UPDATE `restaurant`.`makanan` SET "
                                + "`kategori` = '"+kategori.getSelectedIndex()+"', "
                                + "`harga` = '"+harga.getText()+"' "
                          + "WHERE `makanan`.`nama` = '"+nama.getText()+"'";
            st.executeUpdate(strSQL);

            int row = tblmakanan.convertRowIndexToModel(tblmakanan.getSelectedRow());
            tblModel.removeRow(row);
            String jenis;
            if (kategori.getSelectedIndex() == 0){
                jenis = "Makanan";
            } else {
                jenis = "Minuman";
            }

            tblModel.insertRow(0, new String[]{nama.getText(), jenis, harga.getText()});

            nama.setText("");
            kategori.setSelectedIndex(-1);
            harga.setText("");
            
            st.close();
            koneksi.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("KESALAHAN SAAT"+"ME-LOAD DRIVER JDBC \n"+cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("KESALAHAN SAAT KONEKSI ATAU "+"KESALAHAN QUERY SQL \n"+sqle.getMessage());
        }  
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try{
            Class.forName ("com.mysql.jdbc.Driver");

            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            
            Statement st = koneksi.createStatement();

            String strSQL="DELETE FROM `restaurant`.`makanan` WHERE `makanan`.`nama` = '"+nama.getText()+"'";
            st.executeUpdate(strSQL);
            int row = tblmakanan.convertRowIndexToModel(tblmakanan.getSelectedRow());
            tblModel.removeRow(row);

            nama.setText("");
            kategori.setSelectedIndex(-1);
            harga.setText("");
           
            st.close();
            koneksi.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("KESALAHAN SAAT"+"ME-LOAD DRIVER JDBC \n"+cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("KESALAHAN SAAT KONEKSI ATAU "+"KESALAHAN QUERY SQL \n"+sqle.getMessage());
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_keluarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapus;
    private javax.swing.JFormattedTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox kategori;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField nama;
    private javax.swing.JButton tambah;
    private javax.swing.JTable tblmakanan;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
