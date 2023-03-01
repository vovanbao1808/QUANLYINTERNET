
package Function;

import DATABASE.ConnectDB;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.sql.Statement;

public class DOANHTHU extends javax.swing.JFrame {
DefaultTableModel tbn = new DefaultTableModel();
DefaultTableModel tbn1 = new DefaultTableModel();
    public DOANHTHU() {
        initComponents();
        loadDOANHTHU();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        LICHSUTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        OUT = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DOANH THU");

        TT.setEditable(false);
        TT.setBackground(new java.awt.Color(204, 204, 204));
        TT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LICHSUTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên Máy", "Ngày Tính", "Tổng Tiền"
            }
        ));
        jScrollPane1.setViewportView(LICHSUTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TỔNG TIỀN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VND");

        jMenu2.setText("File");

        OUT.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
        OUT.setText("Thoát");
        OUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OUTActionPerformed(evt);
            }
        });
        jMenu2.add(OUT);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 public void loadDOANHTHU()
    {
        try {
           ConnectDB a = new ConnectDB();
           Connection conn =  (Connection) a.ConnectDB();
           PreparedStatement pst1 = conn.prepareStatement("select sum(TONGTIEN) AS '' from LICHSU a inner join MAY b on a.TENMAY=b.TENMAY;");
           ResultSet rs1 = pst1.executeQuery();
           while(rs1.next())
           {
               TT.setText(rs1.getString(1));
           }
           int number;
            Vector row,column;
            column = new Vector();
            Statement st;
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select LICHSU.TENMAY,NGAYDUNG,TONGTIEN from LICHSU inner join MAY on LICHSU.TENMAY=MAY.TENMAY");
            ResultSetMetaData metaData = rs.getMetaData();
            number = metaData.getColumnCount();
            for (int i = 1 ; i<=number ; i++)
            {
                column.add(metaData.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
                
            while(rs.next())
            {
                row = new Vector();
                for (int i =1; i<=number;i++)
                {   row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                LICHSUTable.setModel(tbn);
            }
            conn.close();
        } catch (Exception e) {
        }
    }
 
 
    private void OUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OUTActionPerformed
         new Manager().setVisible(true);
                        this.dispose();
    }//GEN-LAST:event_OUTActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable LICHSUTable;
    private javax.swing.JMenuItem OUT;
    private javax.swing.JTextField TT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
