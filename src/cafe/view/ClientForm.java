package cafe.view;

import cafe.Utils.db.OrderUtils;
import cafe.Utils.db.UsersUtils;
import cafe.model.Order;
import cafe.model.OrderItem;
import cafe.model.User;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientForm extends javax.swing.JFrame {

    public ClientForm() {
        initComponents();
        initEnabledComponents();
        MainForm.initBDmenu();
        UsersUtils.readAllUsers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox();
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Кафе1", "Кафе2", "Кафе3" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(20, 10, 210, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("З");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 50, 40, 20);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("По");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 90, 40, 20);

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(2).setMinWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(3).setMinWidth(180);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(180);
            jTable1.getColumnModel().getColumn(4).setMinWidth(70);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(5).setMinWidth(70);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 290, 650, 580);

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
            jTable2.getColumnModel().getColumn(1).setMinWidth(40);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable2.getColumnModel().getColumn(2).setMinWidth(50);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(3).setMinWidth(50);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(650, 290, 630, 250);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Оплачені страви", "Видалені страви" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getRemovedDishes(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(650, 260, 630, 30);

        jButton1.setText("показати дані");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllOrders(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 140, 160, 40);
        getContentPane().add(jXDatePicker1);
        jXDatePicker1.setBounds(60, 50, 170, 22);
        getContentPane().add(jXDatePicker2);
        jXDatePicker2.setBounds(60, 90, 170, 22);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Чек № ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(660, 240, 160, 20);

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null}
            },
            new String [] {
                "Ім'я", "Початок", "Кінець"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setFocusable(false);
        jTable3.setRowHeight(22);
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(650, 570, 630, 300);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Працівники");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(660, 540, 230, 20);

        jTable4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Бармен", "Каса"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
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
        jTable4.setRowHeight(20);
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(1).setMinWidth(100);
            jTable4.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable4.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(270, 40, 380, 250);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Каса");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(270, 10, 160, 20);

        setSize(new java.awt.Dimension(1292, 1031));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void initEnabledComponents(){
        jTable1.setEnabled(false);
        jComboBox2.setEnabled(false);
    }
    private void getUsersKasa(){
        
        for (int i = 0; i < LoginForm.userList.size()-1; i++) {
            OrderUtils.getUserKasa(startDate, endDate, LoginForm.userList.get(i).getDbId());            
        }
        
    }   
    
    
    private void getAllOrders(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllOrders
        jTable1.setEnabled(true);
        jComboBox2.setEnabled(true);
        
        startDate = new java.sql.Timestamp((jXDatePicker1.getDate().getTime()));
        endDate = new java.sql.Timestamp(jXDatePicker2.getDate().getTime());
        orders.clear();
        orders.addAll(OrderUtils.getOrders(startDate, endDate));
        refreshOrderTable(jTable1, orders);       
        
       refreshBarmensTable();
    }//GEN-LAST:event_getAllOrders

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        activeOrder = jTable1.getSelectedRow();
        getRemovedDishes(null);        
    }//GEN-LAST:event_jTable1MousePressed

    private void getRemovedDishes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getRemovedDishes
        int index = jComboBox2.getSelectedIndex();
        if (activeOrder != -1) {
            if (index == 0) {
                refreshRecipeTable(activeOrder);
            } else {
                refreshRemoveRecipeTable(activeOrder);
            }
            jLabel3.setText("Чек № " + orders.get(activeOrder).getDayId());
        }
    }//GEN-LAST:event_getRemovedDishes
    
    private void refreshRecipeTable(int id){
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();       
        model.setRowCount(0);
        for (OrderItem item : orders.get(id).getItems()) {
            model.addRow(new Object[]{              
                item.getDish().getTitle(),
                item.getCount(),
                item.getDish().getPrice(),                
                item.getSum()                
            });
        }              
    }
    private void refreshRemoveRecipeTable(int id){
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();       
        model.setRowCount(0);
        for (OrderItem item : orders.get(id).getRemovedItems()) {
            model.addRow(new Object[]{              
                item.getDish().getTitle(),                
                item.getCount(),
                item.getDish().getPrice(),
                item.getSum()                
            });
        }
    }
    
    private void refreshBarmensTable(){
        getUsersKasa();
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        
        for (int i = 0; i < LoginForm.userList.size()-1; i++) {
            model.addRow(new Object[]{
                LoginForm.userList.get(i).getName(),
                LoginForm.userList.get(i).getKasa()
            });
            
        }
    }
    
    private void refreshOrderTable(JTable table, List<Order> list) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
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
    
    private static Timestamp startDate, endDate;
    private static int activeOrder;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    // End of variables declaration//GEN-END:variables
}
