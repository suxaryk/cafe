package cafe.view;

import static cafe.Utils.db.Dish.DishUtils.PASSWORD;
import static cafe.Utils.db.Dish.DishUtils.URL;
import static cafe.Utils.db.Dish.DishUtils.USERNAME;
import static cafe.Utils.db.Dish.DishUtils.chooseServer;
import cafe.Utils.db.EmployeeUtils;
import cafe.Utils.db.OrderUtils;
import static cafe.Utils.db.OrderUtils.getUserDishCount;
import static cafe.Utils.db.OrderUtils.getUserKasa;
import cafe.Utils.db.StorageUtils;
import static cafe.Utils.db.StorageUtils.getIngredientById;
import static cafe.Utils.db.StorageUtils.getRemovedIngredients;
import cafe.Utils.db.UsersUtils;
import cafe.model.Employee;
import cafe.model.Ingredient;
import cafe.model.Order;
import cafe.model.OrderItem;
import static cafe.view.LoginForm.userList;
import static cafe.view.MainForm.GREEN;
import static cafe.view.MainForm.employees;
import static cafe.view.MainForm.setColumnRender;
import static cafe.view.MainForm.setSort;
import static cafe.view.MainForm.showCalcTable;
import static cafe.view.MainForm.sortListOfIngredients;
import static cafe.view.MainForm.storageList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientForm extends javax.swing.JFrame {

    public ClientForm() {
        initComponents();
//        initServer();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jXDatePicker3 = new org.jdesktop.swingx.JXDatePicker();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jButton39 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Кафе1", "Кафе2", "Кафе3" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseCafe(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(30, 10, 220, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("З");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 50, 40, 20);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("По");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 90, 40, 20);

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Long(2), null, "олдлд",  new Integer(4), null,  new Integer(200), null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "№", "№ чеку", "Бармен", "Сума (грн)", "Дата Час", "Кіл.страв", "Кіл. видал"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
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
            jTable1.getColumnModel().getColumn(2).setMinWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(3).setMinWidth(70);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(4).setMinWidth(180);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(180);
            jTable1.getColumnModel().getColumn(5).setMinWidth(70);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(6).setMinWidth(70);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 290, 650, 270);

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
        jScrollPane2.setBounds(0, 610, 650, 270);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Оплачені страви", "Видалені страви" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getRemovedDishes(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(0, 580, 650, 30);

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setText("підключитись до кафе");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllOrders(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 160, 220, 60);
        getContentPane().add(jXDatePicker1);
        jXDatePicker1.setBounds(80, 50, 170, 22);
        getContentPane().add(jXDatePicker2);
        jXDatePicker2.setBounds(80, 90, 170, 22);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setText("Чек № ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 560, 180, 20);

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ім'я", "Початок", "Кінець", "Аванс"
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
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(650, 30, 630, 220);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Працівники");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(652, 10, 230, 20);

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
        jScrollPane4.setBounds(270, 30, 380, 220);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Каса по барменах");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(270, 10, 160, 20);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setText("Чеки");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 260, 160, 20);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Загальна каса:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(270, 250, 170, 23);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 0));
        jLabel8.setText("Загальна кіл. страв:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(270, 270, 220, 23);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("0");
        jLabel9.setFocusable(false);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(520, 250, 110, 23);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 0));
        jLabel10.setText("0");
        jLabel10.setFocusable(false);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(520, 270, 110, 23);
        getContentPane().add(jXDatePicker3);
        jXDatePicker3.setBounds(780, 8, 170, 22);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setText("Кількість списаних продуктів за термін");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(660, 590, 360, 20);

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
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(0).setMinWidth(50);
            jTable5.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable5.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable5.getColumnModel().getColumn(2).setMinWidth(100);
            jTable5.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable5.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(650, 610, 630, 270);

        jButton2.setText("показати час");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEmployeeShedule(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(960, 8, 130, 23);

        jProgressBar1.setForeground(new java.awt.Color(51, 153, 0));
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(30, 140, 220, 10);

        jTable6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Назва", "Вага по базі (кг/ шт)", "Різниця"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
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
        }

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(650, 290, 630, 270);

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setText("Наявні продукти на складі");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(652, 270, 360, 20);

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
        getContentPane().add(jButton39);
        jButton39.setBounds(1090, 561, 188, 48);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(jLabel12);
        jLabel12.setBounds(30, 230, 210, 20);

        jComboBox7.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за вагою", "за назвою" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox7);
        jComboBox7.setBounds(1082, 260, 198, 30);

        setSize(new java.awt.Dimension(1292, 1031));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private static void initServer(){
        JFrame frame = new JFrame();
        String[] servers = {"кафе1", "кафе2", "кафе3"};
        Object value = JOptionPane.showInputDialog(frame,
                "Виберіть кафе для підключення",              
                "Вибір бази данних",
                JOptionPane.YES_NO_OPTION,
                null,
                servers,
                servers[0]);
        int index = employees.indexOf(value);

        if (value != null) {
          
        }
        
    }
    private void initEnabledComponents(){        
        
            jTable1.setEnabled(false);
            jComboBox2.setEnabled(false);
            jButton39.setBackground(GREEN);
            
            
        try {
            setColumnRender(jTable6.getColumnModel().getColumn(2));          
        } catch (ParseException ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void getUsersStatistics(){             
        for (int i = 0; i < LoginForm.userList.size(); i++) {
            userList.get(i).setKasa(getUserKasa(startDate, endDate, i)); 
            userList.get(i).setDishCount(getUserDishCount(startDate, endDate, i));
            OrderUtils.getUserDishCount(startDate, endDate, i);   
        }        
    }   
    public  void testCafeConnection(){
        chooseServer(jComboBox1.getSelectedIndex());
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {
            
            System.out.println(!connection.isClosed() ? "DB connected to " + URL
                    : "Error DB connecting");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Try connect to DB again");
            jLabel12.setText("Помилка підключення \n до бази кафе");
            
        } catch (Exception e) {

        }
    }
    
    private void getAllOrders(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllOrders
//        testCafeConnection();
        jTable1.setEnabled(true);
        jComboBox2.setEnabled(true);
        try {
            startDate = new java.sql.Timestamp((jXDatePicker1.getDate().getTime()));
            endDate = new java.sql.Timestamp(jXDatePicker2.getDate().getTime());
            orders.clear();
            orders.addAll(OrderUtils.getOrders(startDate, endDate));
            refreshOrderTable(jTable1, orders);            
        } finally{
            jProgressBar1.setIndeterminate(false);          
        }               
        getStorageTable();
        
       jButton2.setEnabled(true);
       jButton39.setEnabled(true);
       refreshBarmensTable();
        System.out.println("size---------getStorageTable 3 " + storageList.size());
       refreshRemovedIngTable();
        System.out.println("size---------getStorageTable 4 " + storageList.size());
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

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        jTable1MousePressed(null);
    }//GEN-LAST:event_jTable1KeyReleased

    private void showEmployeeShedule(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEmployeeShedule
        EmployeeDate = new java.sql.Timestamp((jXDatePicker3.getDate().getTime()));
        EmployeeUtils.getEmployeeTime(EmployeeDate);
        refreshEmployeeTable();             
    }//GEN-LAST:event_showEmployeeShedule

    private void chooseCafe(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseCafe
        chooseServer(jComboBox1.getSelectedIndex());
    }//GEN-LAST:event_chooseCafe

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        jProgressBar1.setIndeterminate(true);
    }//GEN-LAST:event_jButton1MousePressed

    private void addToStorage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToStorage
//            addIngCountToStorage();
//         StorageUtils.readStorage();
//         addIngCountToStorage(jTable6);
        StorageUtils.readStorage();
        setSort(jComboBox7, jTable6);
        showCalcTable(jTable6);
    }//GEN-LAST:event_addToStorage

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        setSort(jComboBox7, jTable6);
        showCalcTable(jTable6);
        System.out.println("size--------- " + storageList.size());
    }//GEN-LAST:event_jComboBox7ActionPerformed

    
    private void getStorageTable(){        
        StorageUtils.readStorage();
        System.out.println("size---------getStorageTable1  " + storageList.size());
        setSort(jComboBox7, jTable6);
        showCalcTable(jTable6);
        System.out.println("size---------getStorageTable2  " + storageList.size());
//        showStorageTable();
    }
    
    private void showStorageTable(){
        DefaultTableModel model = (DefaultTableModel) jTable6.getModel(); 
       
         for (Ingredient ingredient : storageList) {
                model.addRow(new Object[]{
                    ingredient.getId(),
                    ingredient.getTitle(),
                    ingredient.getCount(),
                    0.0
                });
            }        
    }
    private void refreshEmployeeTable(){
        DateFormat Format = new SimpleDateFormat("HH:mm:ss");
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();       
        model.setRowCount(0);
        for (Employee item : employees) {
            model.addRow(new Object[]{                          
                item.getName(),
                Format.format(item.getStartTime()),
                Format.format(item.getEndTime())
            });
        }              
    }
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
        getUsersStatistics();
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        
        for (int i = 0; i < LoginForm.userList.size()-1; i++) {
            model.addRow(new Object[]{
                LoginForm.userList.get(i).getName(),
                LoginForm.userList.get(i).getKasa()               
            });            
        }
        jLabel9.setText(String.valueOf(OrderUtils.getAllOrdersSum(startDate, endDate)));
        jLabel10.setText(String.valueOf(OrderUtils.getAllOrdersCookCount(startDate, endDate)));             
        
    }
    private void refreshRemovedIngTable(){
       
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);
        List<Ingredient> removedIng = new ArrayList<>();
        removedIng.addAll(getRemovedIngredients(startDate, endDate));
        for (Ingredient ing : removedIng) {
            ing.setTitle(getIngredientById(ing.getId()).getTitle());
        }
        //fix getIngById
        System.out.println("size---------getStorageTable 5 " + storageList.size());
        sortListOfIngredients(removedIng, 2);
        System.out.println("size---------getStorageTable  6" + storageList.size());
        for (Ingredient ing : removedIng) {
            model.addRow(new Object[]{
                ing.getId(),
                ing.getTitle(),
                ing.getCount()
            });            
        }
        System.out.println("size---------getStorageTable  7" + storageList.size());
        jLabel9.setText(String.valueOf(OrderUtils.getAllOrdersSum(startDate, endDate)));
        jLabel10.setText(String.valueOf(OrderUtils.getAllOrdersCookCount(startDate, endDate)));             
        
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
    
    private static Timestamp startDate, endDate, EmployeeDate;
    private static int activeOrder;
    private static final List<Order> orders = new ArrayList<>();
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm:ss");
    public static ClientForm clientForm;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton39;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker3;
    // End of variables declaration//GEN-END:variables
}
