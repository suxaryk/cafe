package cafe.view;

import cafe.Utils.db.OrderUtils;
import cafe.model.Order;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientForm extends javax.swing.JFrame {

    public ClientForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Кафе1", "Кафе2", "Кафе3" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(20, 10, 210, 30);

        jRadioButton3.setText("чеки");
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(20, 50, 160, 23);

        jRadioButton4.setText("персонал");
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(20, 70, 220, 23);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("З");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 100, 40, 20);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("По");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 140, 40, 20);

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Long(150000), null, "Оператор 1", "2015-10-11 17:42:45",  new Integer(200),  new Integer(14)},
                { new Long(2), null, "олдлд", null,  new Integer(4),  new Integer(200)},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "№", "№ чеку", "Бармен", "Дата", "Сума (грн)", "Кіл.страв"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(60);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(2).setMinWidth(300);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(300);
            jTable1.getColumnModel().getColumn(3).setMinWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(4).setMinWidth(70);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(5).setMinWidth(70);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(529, 0, 752, 860);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Назва", "Кіл.", "Ціна", "Сума"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setRowHeight(18);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(200);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 360, 350, 200);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Опплачені страви", "Видалені страви" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(10, 330, 350, 30);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllOrders(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 190, 160, 40);
        getContentPane().add(jXDatePicker1);
        jXDatePicker1.setBounds(80, 100, 150, 22);
        getContentPane().add(jXDatePicker2);
        jXDatePicker2.setBounds(80, 140, 150, 22);

        setSize(new java.awt.Dimension(1292, 1031));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void getAllOrders(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllOrders

        Date startDate = jXDatePicker1.getDate();
        Date endDate = jXDatePicker2.getDate();
        orders.clear();
        orders.addAll(OrderUtils.getOrders(new java.sql.Timestamp(startDate.getTime()),
                new java.sql.Timestamp(endDate.getTime())));
        refreshTable(jTable1, orders);


    }//GEN-LAST:event_getAllOrders

    private void refreshTable(JTable jTable, List<Order> list) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        int k = 1;

        for (Order order : list) {
            model.addRow(new Object[]{
                k++,
                order.getDayId(),
                order.getUser(),
                dateFormat.format(order.getDate()),
                order.getOrderSum(),
                order.getCookCount()
            });
        }
    }

    public static void main(String args[]) {
        clientForm = new ClientForm();
        clientForm.setVisible(true);
    }
    private static final List<Order> orders = new ArrayList<>();
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static ClientForm clientForm;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    // End of variables declaration//GEN-END:variables
}
