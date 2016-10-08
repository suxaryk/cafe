package cafe.view;

import cafe.Utils.db.DBUtils;
import static cafe.Utils.db.DBUtils.PASSWORD;
import static cafe.Utils.db.DBUtils.URL;
import static cafe.Utils.db.DBUtils.USERNAME;
import static cafe.Utils.db.DBUtils.chooseServer;
import cafe.Utils.db.EmployeeUtils;
import static cafe.Utils.db.EmployeeUtils.getEmployeeFullWorksDay;
import static cafe.Utils.db.EmployeeUtils.getEmployeeHalfWorksDay;
import cafe.Utils.db.OrderUtils;
import static cafe.Utils.db.OrderUtils.getCustomSumKeyMoneyForUserBetween;
import static cafe.Utils.db.OrderUtils.getUserKasa;
import cafe.Utils.db.ReviziaUtils;
import cafe.Utils.db.StorageUtils;
import static cafe.Utils.db.StorageUtils.getAddedIngredients;
import static cafe.Utils.db.StorageUtils.getIngTitleById;
import static cafe.Utils.db.StorageUtils.getOrderedDishes;
import static cafe.Utils.db.StorageUtils.getRemovedIngredients;
import cafe.Utils.db.UsersUtils;
import cafe.model.Employee;
import cafe.model.Ingredient;
import cafe.model.Order;
import cafe.model.OrderItem;
import cafe.model.ReviziaItem;
import cafe.model.User;
import static cafe.view.MainForm.GREEN;
import static cafe.view.MainForm.RED;
import static cafe.view.MainForm.employees;
import static cafe.view.MainForm.setColumnRender;
import static cafe.view.MainForm.setSort;
import static cafe.view.MainForm.showCalcTable;
import static cafe.view.MainForm.sortListOfIngredients;
import static cafe.view.MainForm.sortListOfOrderItems;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class ClientForm extends javax.swing.JFrame {

    public ClientForm() {
        initComponents();
        User.active = 5;

        initEnabledComponents();       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jComboBox7 = new javax.swing.JComboBox();
        jButton39 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jToggleButton1 = new javax.swing.JToggleButton();
        jComboBox9 = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jXDatePicker3 = new org.jdesktop.swingx.JXDatePicker();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Шепетівка", "Староконстянтинів", "Славута", "Хмельницький" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseCafe(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(0, 0, 220, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText(" З");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 30, 40, 20);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText(" По");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 50, 40, 20);

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setText("Показати всі дані");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllOrders(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 110, 220, 40);
        getContentPane().add(jXDatePicker1);
        jXDatePicker1.setBounds(50, 30, 170, 22);
        getContentPane().add(jXDatePicker2);
        jXDatePicker2.setBounds(50, 50, 170, 22);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setLayout(null);

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "№", "№ чеку", "Бармен", "Сума (грн)", "Дата Час", "Кіл.", "Видал"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(70);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(2).setMinWidth(75);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(3).setMinWidth(70);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(4).setMinWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(5).setMinWidth(40);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(6).setMinWidth(45);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(45);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(45);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(1, 1, 490, 520);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(490, 50, 320, 380);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Оплачені страви", "Видалені страви" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getRemovedDishes(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(490, 20, 320, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setText("Чек № ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(490, 0, 170, 20);

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton3.setText("Показати чеки");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3getAllOrders(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(520, 450, 220, 40);

        jTabbedPane1.addTab("Чеки", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });
        jPanel2.setLayout(null);

        jTable6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "№", "Назва", "Вага по базі (кг/ шт)", "Різниця", "Вибраний"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(0).setMinWidth(50);
            jTable6.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable6.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable6.getColumnModel().getColumn(2).setMinWidth(120);
            jTable6.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable6.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable6.getColumnModel().getColumn(3).setMinWidth(100);
            jTable6.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable6.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable6.getColumnModel().getColumn(4).setMinWidth(70);
            jTable6.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable6.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jPanel2.add(jScrollPane6);
        jScrollPane6.setBounds(1, 1, 566, 516);

        jComboBox7.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за вагою", "за назвою" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox7);
        jComboBox7.setBounds(573, 1, 198, 25);

        jButton39.setBackground(new java.awt.Color(204, 204, 204));
        jButton39.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton39.setText("<html>поповнити<br/>&nbsp; склад</html> ");
        jButton39.setBorder(null);
        jButton39.setEnabled(false);
        jButton39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToStorage(evt);
            }
        });
        jPanel2.add(jButton39);
        jButton39.setBounds(573, 341, 198, 48);

        jButton4.setBackground(new java.awt.Color(0, 153, 204));
        jButton4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton4.setText("Показати склад");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(570, 460, 220, 40);

        jTabbedPane1.addTab("Склад", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setLayout(null);

        jTable5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Назва", "Вага ( кг/ шт )"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
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
        jTable5.setRowHeight(20);
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(0).setMinWidth(50);
            jTable5.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable5.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable5.getColumnModel().getColumn(2).setMinWidth(100);
            jTable5.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable5.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(0, 30, 390, 496);

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("Списані продукти");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(10, 0, 220, 23);

        jTable10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Назва", "Вага ( кг/ шт )"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
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
        jTable10.setRowHeight(20);
        jScrollPane10.setViewportView(jTable10);
        if (jTable10.getColumnModel().getColumnCount() > 0) {
            jTable10.getColumnModel().getColumn(0).setMinWidth(50);
            jTable10.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable10.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable10.getColumnModel().getColumn(2).setMinWidth(100);
            jTable10.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable10.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jPanel3.add(jScrollPane10);
        jScrollPane10.setBounds(400, 30, 390, 496);

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setText("Приходи");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(690, 0, 90, 23);

        jButton5.setBackground(new java.awt.Color(0, 153, 204));
        jButton5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton5.setText("Показати приходи/списання");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(280, 0, 270, 27);

        jTabbedPane1.addTab("Продукти", jPanel3);

        jPanel7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel7ComponentShown(evt);
            }
        });
        jPanel7.setLayout(null);

        jTable11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Назва", "Вага стара", "Вага нова", "Різниця"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable11.setRowHeight(20);
        jScrollPane11.setViewportView(jTable11);
        if (jTable11.getColumnModel().getColumnCount() > 0) {
            jTable11.getColumnModel().getColumn(0).setMinWidth(40);
            jTable11.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable11.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable11.getColumnModel().getColumn(2).setMinWidth(130);
            jTable11.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTable11.getColumnModel().getColumn(2).setMaxWidth(130);
            jTable11.getColumnModel().getColumn(3).setMinWidth(130);
            jTable11.getColumnModel().getColumn(3).setPreferredWidth(130);
            jTable11.getColumnModel().getColumn(3).setMaxWidth(130);
            jTable11.getColumnModel().getColumn(4).setMinWidth(130);
            jTable11.getColumnModel().getColumn(4).setPreferredWidth(130);
            jTable11.getColumnModel().getColumn(4).setMaxWidth(130);
        }

        jPanel7.add(jScrollPane11);
        jScrollPane11.setBounds(0, 40, 810, 480);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Дата");
        jPanel7.add(jLabel6);
        jLabel6.setBounds(500, 10, 60, 18);

        jPanel7.add(jComboBox3);
        jComboBox3.setBounds(560, 10, 140, 20);

        jToggleButton1.setText("Відкрити");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRevizia(evt);
            }
        });
        jPanel7.add(jToggleButton1);
        jToggleButton1.setBounds(713, 10, 90, 23);

        jComboBox9.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за різн.ваги", "за назвою" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });
        jPanel7.add(jComboBox9);
        jComboBox9.setBounds(40, 0, 145, 29);

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Вага стара - яка мала би бути");
        jPanel7.add(jLabel24);
        jLabel24.setBounds(210, 0, 240, 17);

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("Вага нова - вага фактична яка є на складі");
        jPanel7.add(jLabel25);
        jLabel25.setBounds(210, 20, 280, 17);

        jTabbedPane1.addTab("Ревізія", jPanel7);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel4ComponentShown(evt);
            }
        });
        jPanel4.setLayout(null);

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(1).setMinWidth(200);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable3.getColumnModel().getColumn(2).setMinWidth(200);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(10, 30, 630, 260);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Час роботи працівників");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(10, 10, 230, 20);
        jPanel4.add(jXDatePicker3);
        jXDatePicker3.setBounds(290, 8, 170, 22);

        jButton2.setText("показати час");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEmployeeShedule(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(470, 8, 130, 23);

        jTabbedPane1.addTab("Працівники", jPanel4);

        jPanel5.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jPanel5.add(jLabel12);
        jLabel12.setBounds(580, 20, 210, 20);

        jTable8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ім'я", "Сума", "Кіл. змін", "Кіл. пів змін"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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
        jTable8.setRowHeight(20);
        jScrollPane8.setViewportView(jTable8);
        if (jTable8.getColumnModel().getColumnCount() > 0) {
            jTable8.getColumnModel().getColumn(1).setMinWidth(150);
            jTable8.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable8.getColumnModel().getColumn(1).setMaxWidth(150);
            jTable8.getColumnModel().getColumn(2).setMinWidth(75);
            jTable8.getColumnModel().getColumn(2).setPreferredWidth(75);
            jTable8.getColumnModel().getColumn(2).setMaxWidth(75);
            jTable8.getColumnModel().getColumn(3).setMinWidth(75);
            jTable8.getColumnModel().getColumn(3).setPreferredWidth(75);
            jTable8.getColumnModel().getColumn(3).setMaxWidth(75);
        }

        jPanel5.add(jScrollPane8);
        jScrollPane8.setBounds(10, 30, 640, 180);

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel20.setText("Аванс");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(10, 0, 220, 23);

        jTable9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ім'я", "Призначення", "Дата", "Сума"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jTable9.setRowHeight(20);
        jScrollPane9.setViewportView(jTable9);
        if (jTable9.getColumnModel().getColumnCount() > 0) {
            jTable9.getColumnModel().getColumn(1).setMinWidth(200);
            jTable9.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable9.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable9.getColumnModel().getColumn(2).setMinWidth(200);
            jTable9.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable9.getColumnModel().getColumn(2).setMaxWidth(200);
            jTable9.getColumnModel().getColumn(3).setMinWidth(150);
            jTable9.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable9.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        jPanel5.add(jScrollPane9);
        jScrollPane9.setBounds(10, 240, 640, 280);

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel21.setText("Інкасація");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(10, 210, 220, 23);

        jButton6.setBackground(new java.awt.Color(0, 153, 204));
        jButton6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton6.setText("показати аванс");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);
        jButton6.setBounds(660, 160, 150, 40);

        jButton7.setBackground(new java.awt.Color(0, 153, 204));
        jButton7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton7.setText("показати інкас");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7);
        jButton7.setBounds(660, 370, 150, 40);

        jTabbedPane1.addTab("Загальна", jPanel5);

        jPanel6.setLayout(null);

        jTable7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Назва", "Кількість"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
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
        jTable7.setRowHeight(20);
        jScrollPane7.setViewportView(jTable7);
        if (jTable7.getColumnModel().getColumnCount() > 0) {
            jTable7.getColumnModel().getColumn(1).setMinWidth(100);
            jTable7.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable7.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jPanel6.add(jScrollPane7);
        jScrollPane7.setBounds(0, 30, 420, 485);

        jComboBox8.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за назвою", "за кількістю" }));
        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeOrderedDishSort(evt);
            }
        });
        jPanel6.add(jComboBox8);
        jComboBox8.setBounds(220, 0, 198, 25);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText("Замовлені страви");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(20, 0, 195, 23);

        jButton8.setBackground(new java.awt.Color(0, 153, 204));
        jButton8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton8.setText("показати страви");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8);
        jButton8.setBounds(430, 470, 160, 40);

        jTabbedPane1.addTab("Замовлені страви", jPanel6);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(220, 0, 820, 560);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 0));
        jLabel10.setText("0");
        jLabel10.setFocusable(false);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(140, 390, 80, 18);

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 0));
        jLabel16.setText("Заг. кіл. страв:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(0, 390, 160, 18);

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 204));
        jLabel14.setText("Сума в касі:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 370, 140, 18);

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Аванс:");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(0, 350, 140, 18);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Інкасація:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 330, 140, 18);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("Заг. каса:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 310, 140, 18);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setText("0");
        jLabel9.setFocusable(false);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(140, 310, 80, 23);

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("-0");
        jLabel13.setFocusable(false);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(133, 330, 80, 18);

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("-0");
        jLabel19.setFocusable(false);
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel19);
        jLabel19.setBounds(133, 350, 80, 18);

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 204));
        jLabel15.setText("0");
        jLabel15.setFocusable(false);
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(140, 370, 80, 18);

        jTable4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
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
        jScrollPane4.setBounds(0, 410, 220, 150);

        jLabel23.setText("Є підключенення до");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(10, 170, 210, 14);

        jCheckBox1.setText("Знаходжусь в даному кафе");
        jCheckBox1.setToolTipText("");
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(4, 74, 210, 20);

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 255));
        jLabel26.setText("Безнал. каса:");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(0, 290, 140, 18);

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 255));
        jLabel27.setText("0");
        jLabel27.setFocusable(false);
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel27);
        jLabel27.setBounds(140, 290, 80, 23);

        setSize(new java.awt.Dimension(1051, 624));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

 

    private void initEnabledComponents() {

        jTable1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jButton39.setBackground(GREEN);
//        addStorageListener();

        try {
            setColumnRender(jTable6.getColumnModel().getColumn(2));
        } catch (ParseException ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean validInputDates(){
        if (tryConnectToCafe()) {
            if (jXDatePicker1.getDate() != null && jXDatePicker2.getDate() != null && jComboBox1.getSelectedIndex() >= 0) {
                startDate = new java.sql.Timestamp((jXDatePicker1.getDate().getTime() + SIX_HOURS));
                endDate = new java.sql.Timestamp(jXDatePicker2.getDate().getTime() + ONE_DAY_PLUS_THREE_HOURS);
                return true;
            } else {
                DBUtils.showMessage("Задані дати введено не корректно, спробуйте задати дати");
                return false;
            }
        }
        return false;   
    }

    private void getAllOrders(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllOrders
        if (validInputDates()) {
            jTable1.setEnabled(true);
            jComboBox2.setEnabled(true);                             

            orders.clear();
            clearAllForms();
            UsersUtils.readAllUsers();
            User.active = 5;
            refreshReviziaDates();
            
            EmployeeUtils.readAllEmployees();
            orders.addAll(OrderUtils.getOrdersBetween(startDate, endDate));

            refreshOrderTable(jTable1, orders);

//                MainForm.initBDmenu();                
            EmployeeUtils.updateEmployeesWorkedHours();
            getEmployeeFullWorksDay(startDate, endDate);
            getEmployeeHalfWorksDay(startDate, endDate);
            getStorageTable();                           
            refreshRemovedIngTable();
            refreshAddedIngTable();
            showOrderedDishes();
            //awans
            getEmployeeKeyMoney();
            getInkass();
            refreshBarmensTable();  

            jButton2.setEnabled(true);
            jButton39.setEnabled(true);


        }
    }//GEN-LAST:event_getAllOrders

    private void clearAllForms(){
        jLabel27.setText("0");
        jLabel13.setText("-0");
        jLabel19.setText("-0");
        jLabel15.setText("0");
        jLabel10.setText("0");
        ((DefaultTableModel)jTable4.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable2.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable6.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable5.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable10.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable11.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable8.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable9.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable7.getModel()).setRowCount(0);
    }
//custom db import 
//    private void updateLocalDB(){
//        SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");        
//         Date end =  new Date(new Timestamp(endDate.getTime() - ONE_DAY_PLUS_THREE_HOURS).getTime());     
//         if (end.after(actualDate)) {      
//             JFrame frame = new JFrame();
//             String[] options = new String[2];
//             options[0] = "Так";
//             options[1] = "Ні";
//             int reply = JOptionPane.showOptionDialog(frame.getContentPane(),
//                     "Дані програми актуальні до дати " + df2.format(actualDate)+
//                     "Бажаєте зактуалізувати дані до дати  " +df2.format(end) + " ?", "",
//                     0, JOptionPane.YES_NO_OPTION, null, options, null);
//             if (reply == JOptionPane.YES_OPTION) {
//                 DBUtils.doDBDumpToClientMachine();
//                 actualDate = getLastModifiedDate();
//                 jLabel26.setText("Дані актуальні на " + end);                                
//             }                      
//        }
//        DBUtils.doDBImport();
//    }
    private  void addStorageListener(){
        jTable6.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.println("changed");
                MainForm.validateCell(jTable6, 3);
            }
        });
     
    } 
    
    
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

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        jTable1MousePressed(null);
    }//GEN-LAST:event_jTable1KeyReleased

    private void showEmployeeShedule(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEmployeeShedule
        EmployeeDate = new java.sql.Timestamp((jXDatePicker3.getDate().getTime()));       
        EmployeeUtils.getEmployeeTime(EmployeeDate);
        refreshEmployeeTable();
    }//GEN-LAST:event_showEmployeeShedule

    private void chooseCafe(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseCafe
        cafeId = jComboBox1.getSelectedIndex();
        if (jCheckBox1.isSelected()) {                   
            isLocalHost = true;
        }else{            
            isLocalHost = false;
        }       
        chooseServer(cafeId);
        tryConnectToCafe();      
    }//GEN-LAST:event_chooseCafe

    private boolean tryConnectToCafe() {  
        if (DBUtils.checkConnection(cafeId)) {
            jLabel23.setText("Є підключення до " + servers[cafeId]);
            jLabel23.setForeground(GREEN);
            jButton1.setEnabled(true);
            jTabbedPane1.setEnabled(true);
            return true;                
        }else{
            System.out.println("ERROR DB Connection " + "cafeId " + cafeId + URL + "/" + USERNAME + "/" + PASSWORD);
            jLabel23.setText("Немає підключення до " + servers[cafeId]);
            jLabel23.setForeground(RED);
            jButton1.setEnabled(false);
            jTabbedPane1.setEnabled(false);
            return false;
        }   
    }

    private void addToStorage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToStorage
        StorageUtils.readStorage();
        setSort(jComboBox7, jTable6);
        MainForm.addIngCountToStorage(jTable6);
        StorageUtils.readStorage();
        setSort(jComboBox7, jTable6);
        showCalcTable(jTable6);
    }//GEN-LAST:event_addToStorage

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        setSort(jComboBox7, jTable6);
        showCalcTable(jTable6);
        System.out.println("change sort storageList  ");
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void changeOrderedDishSort(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeOrderedDishSort
        setSort(jComboBox8, jTable7);
        sortListOfOrderItems(orderedDishes, jComboBox8.getSelectedIndex());
        refreshDishesTable();
    }//GEN-LAST:event_changeOrderedDishSort

    private void showRevizia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRevizia
        showReviziaa("ingredient_id");  
        jComboBox9.setSelectedIndex(0);

    }//GEN-LAST:event_showRevizia
    
    
    private void showReviziaa(String orderCriteria){
        Timestamp date = new java.sql.Timestamp(((Date) jComboBox3.getSelectedItem()).getTime());
        DefaultTableModel model = (DefaultTableModel) jTable11.getModel();
        model.setRowCount(0);
        List<ReviziaItem> revizia = ReviziaUtils.getReviziaByDate(date, orderCriteria);
        for (ReviziaItem item : revizia) {
            model.addRow(new Object[]{
                item.getId(),
                getIngTitleById(item.getId()),
                item.getOldCount(),
                item.getNewCount(),
                item.getDiffCount()
            });

        }
    }
    
    
    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
           int index = jComboBox9.getSelectedIndex();
           if (index == 0) {
               showReviziaa("ingredient_id");            
            }else if (index == 1) {                
                showReviziaa("diff_count");            
            }else if (index == 2) {
                showReviziaa("title");            
        }     
    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        System.out.println("111");        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyPressed

    private void jButton3getAllOrders(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3getAllOrders
        if (validInputDates()) {
            orders.addAll(OrderUtils.getOrdersBetween(startDate, endDate));
            refreshOrderTable(jTable1, orders);
        }
    }//GEN-LAST:event_jButton3getAllOrders

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (validInputDates()) {
            getStorageTable();     
            jButton39.setEnabled(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (validInputDates()) {
            refreshRemovedIngTable();
            refreshAddedIngTable(); 
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (validInputDates()) {
            EmployeeUtils.readAllEmployees();
            getEmployeeFullWorksDay(startDate, endDate);
            getEmployeeHalfWorksDay(startDate, endDate);
            refreshReviziaDates();
            getEmployeeKeyMoney();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (validInputDates()) {
            getInkass();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (validInputDates()) {
            showOrderedDishes();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jPanel7ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel7ComponentShown
        // TODO add your handling code here:
        refreshReviziaDates();
    }//GEN-LAST:event_jPanel7ComponentShown

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1ComponentShown

    private void jPanel4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel4ComponentShown
        // TODO add your handling code here:
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jPanel4ComponentShown

    private void getStorageTable() {
        StorageUtils.readStorage();
        setSort(jComboBox7, jTable6);
        showCalcTable(jTable6);
    }

    private void showOrderedDishes() {
        orderedDishes.clear();
        //todo fix
        orderedDishes.addAll(getOrderedDishes(startDate, endDate));
        sortListOfOrderItems(orderedDishes, jComboBox8.getSelectedIndex());
        refreshDishesTable();

    }

    private void refreshDishesTable() {
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        model.setRowCount(0);
        for (OrderItem item : orderedDishes) {
            model.addRow(new Object[]{
                item.getDish().getTitle(),
                item.getCount()
            });
        }
    }

    private void getEmployeeKeyMoney() {        
        System.out.println("employee size " + employees.size());
        getCustomSumKeyMoneyForUserBetween(startDate, endDate);
//        for (Employee employee : employees) {
//            employee.setKeyMoney(getSumKeyMoneyForUserBetween(startDate, endDate, employee.getName()));
//        }
        refresEmployeeKeyMoneyTable();

    }

    private void refresEmployeeKeyMoneyTable() {
        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
        model.setRowCount(0);
        for (Employee employee : employees) {
            model.addRow(new Object[]{
                employee.getName(),
                employee.getKeyMoney(),
                employee.getWorkDaysCount(),
                employee.getHalfWorkDaysCount()
            });
        }
    }

    private void getInkass() {
        inkassOrders.clear();
        inkassOrders.addAll(OrderUtils.getInkassOrders(startDate, endDate));
        DefaultTableModel model = (DefaultTableModel) jTable9.getModel();
        model.setRowCount(0);
        for (Order order : inkassOrders) {
            model.addRow(new Object[]{
                order.getUser(),
                order.getComent(),
                order.getDate(),
                order.getOrderSum()
            });
        }
    }

    private void refreshEmployeeTable() {
//        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        for (Employee item : employees) {
            model.addRow(new Object[]{
                item.getName(),
                item.getStartTime(),
                //                format1.format(item.getStartTime()),
                item.getEndTime()
//                format1.format(item.getEndTime())
            });
        }
    }

    private void refreshRecipeTable(int id) {
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

    private void refreshRemoveRecipeTable(int id) {
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

    private void refreshBarmensTable() {
        getUserKasa(startDate, endDate);
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);

        for (User user : LoginForm.userList) {
            model.addRow(new Object[]{
                user.getName(),
                user.getKasa()
            });
        }
        int AllAvans = 0;
        for (Employee employee : employees) {
            AllAvans += employee.getKeyMoney();
        }
        //Hm - with card pay
        if (cafeId == 3) {
            jLabel27.setText(String.valueOf(OrderUtils.getAllBarmenSumWithCardBetween(startDate, endDate, true)));
            jLabel15.setText(String.valueOf(OrderUtils.getAllCashSumBefore(new Timestamp(new Date().getTime()))));
        }else{
            jLabel27.setText("0");
            jLabel15.setText(String.valueOf(OrderUtils.getAllSumBefore(new Timestamp(new Date().getTime()))));
        }

        jLabel9.setText(String.valueOf(OrderUtils.getAllBarmenSumBetween(startDate, endDate)));
        jLabel13.setText(String.valueOf(OrderUtils.getAllRemovedSumBetween(startDate, endDate)));
        jLabel19.setText(String.valueOf(AllAvans));
        
        jLabel10.setText(String.valueOf(OrderUtils.getAllCookCountBetween(startDate, endDate)));
    }

    private void refreshRemovedIngTable() {

        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);
        List<Ingredient> removedIng = new ArrayList<>();
        removedIng.addAll(getRemovedIngredients(startDate, endDate));
        for (Ingredient ing : removedIng) {
            ing.setTitle(getIngTitleById(ing.getId()));  //fix getIngTitleById
        }

        sortListOfIngredients(removedIng, 2);
        for (Ingredient ing : removedIng) {
            model.addRow(new Object[]{
                ing.getId(),
                ing.getTitle(),
                ing.getCount()
            });
        }      

    }

    private void refreshAddedIngTable() {

        DefaultTableModel model = (DefaultTableModel) jTable10.getModel();
        model.setRowCount(0);
        List<Ingredient> addedIng = new ArrayList<>();
        addedIng.addAll(getAddedIngredients(startDate, endDate));
        for (Ingredient ing : addedIng) {
            ing.setTitle(getIngTitleById(ing.getId()));
        }

        sortListOfIngredients(addedIng, 2);
        for (Ingredient ing : addedIng) {
            model.addRow(new Object[]{
                ing.getId(),
                ing.getTitle(),
                ing.getCount()
            });
        }    
    }

    private void refreshReviziaDates() {
        jComboBox3.removeAllItems();
        List<Date> reviziaDates = new ArrayList<>(ReviziaUtils.getReviziaDates());
        for (Date reviziaDate : reviziaDates) {
            jComboBox3.addItem(reviziaDate);
        }
    }

    private void refreshOrderTable(JTable table, List<Order> list) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        int k = 1;

        for (Order order : list) {
            model.addRow(new Object[]{
                order.getId(),
                order.getDayId(),
                order.getUser(),
                order.getOrderSum(),
                dateFormat.format(order.getDate()),
                order.getCookCount(),
                order.getRemovedItems().size()
            });
        }
    }

    public static void main(String args[]) {
        clientForm = new ClientForm();
        clientForm.setVisible(true);
        clientForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private static Date actualDate;
    private static final int SIX_HOURS = 6 * 60 * 60 * 1000;
    private static final long ONE_DAY_PLUS_THREE_HOURS = 27 * 60 * 60 * 1000;
    public static int cafeId;
    public static boolean isLocalHost;
    private static final String[] servers  = {"Шепетовка", "Староконстянтинів", "Славута", "Хмельницький"};;
    private static Timestamp startDate, endDate, EmployeeDate;
    private static int activeOrder;
    private static final List<Order> orders = new ArrayList<>();
    private static final List<Order> inkassOrders = new ArrayList<>();
    private static final List<OrderItem> orderedDishes = new ArrayList<>();
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm:ss");
    public static ClientForm clientForm;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JToggleButton jToggleButton1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker3;
    // End of variables declaration//GEN-END:variables
}
