package transaksi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import restoran.main;

/**
 *
 * @author meita
 */
public class cari_pesanan extends javax.swing.JFrame {
    private javax.swing.table.DefaultTableModel tblModel = getDefaultTabelModel();
    private JTextField pesanan, tgl_pesan;
    private JComboBox meja;
    
    public cari_pesanan(JTextField no_pesanan, JComboBox no_meja, JTextField tgl_pesanan) {
        initComponents();
        pesanan = no_pesanan;
        meja = no_meja;
        tgl_pesan = tgl_pesanan;
        
        tblpesanan.setModel(tblModel);
        setDefaultTable();
    }
    
    private void setDefaultTable(){
        try{
            Class.forName ("com.mysql.jdbc.Driver");

            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            
            String strSQL="SELECT `no_pesanan`, `tgl_pesanan`, `no_meja`, `lunas` "
                         + "FROM `pesanan` WHERE `pesanan`.`username` = '"+main.username+"' "
                         + "ORDER BY no_pesanan, tgl_pesanan, `lunas`, `no_meja`";
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(strSQL);

            while(rs.next()){
                String lunas;
                if (rs.getInt(4) == 0){
                    lunas = "Belum";
                } else {
                    lunas = "Sudah";
                }
                tblModel.addRow(new Object[]{rs.getString(1), rs.getDate(2), rs.getInt(3), lunas});
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblpesanan = new javax.swing.JTable();
        ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cari No. Pesanan");
        setAlwaysOnTop(true);
        setResizable(false);

        tblpesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblpesanan);

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ok)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ok)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        if (tblpesanan.getRowCount()>0){
            int row = tblpesanan.getSelectedRow();
            pesanan.setText(tblModel.getValueAt(row, 0).toString());
            meja.setSelectedIndex(Integer.parseInt(tblModel.getValueAt(row, 2).toString())-1);
            tgl_pesan.setText(tblModel.getValueAt(row, 1).toString());
        }
        this.dispose();
    }//GEN-LAST:event_okActionPerformed

    private javax.swing.table.DefaultTableModel getDefaultTabelModel() {
        return new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] {"No Pesanan","Tgl. Pesanan","Meja","Terbayar"}
            ){
                boolean[] canEdit=new boolean[]{
                    false,false,false,false
                };

                public boolean isiCellEditable(int rowIndex,int columnIndex){
                        return canEdit[columnIndex];

                }
            };
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ok;
    private javax.swing.JTable tblpesanan;
    // End of variables declaration//GEN-END:variables
}
