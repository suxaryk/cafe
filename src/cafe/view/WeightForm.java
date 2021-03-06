package cafe.view;

import cafe.Utils.db.DishUtils;
import cafe.model.Ingredient;
import static cafe.view.MainForm.activeCat;
import static cafe.view.MainForm.activeDishes;
import static cafe.view.MainForm.dishCount;
import static cafe.view.MainForm.mainForm;
import static cafe.view.MainForm.menu;
import java.util.HashMap;
import javax.swing.JButton;

/**
 *
 * @author suxarina
 */
public class WeightForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public WeightForm() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Вага м'яса");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("ОК");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setWeightCount(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 150, 140, 38);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton2.setText("9");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 40, 50, 50);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/left145.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDigit(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(50, 40, 50, 50);

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton4.setText("8");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(150, 40, 50, 50);

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton6.setText("4");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(100, 90, 50, 50);

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton7.setText("5");
        jButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(150, 90, 50, 50);

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton8.setText("6");
        jButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(200, 90, 50, 50);

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton9.setText("3");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(200, 140, 50, 50);

        jButton10.setBackground(new java.awt.Color(204, 204, 204));
        jButton10.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton10.setText("0");
        jButton10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(50, 140, 50, 50);

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton11.setText("2");
        jButton11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(150, 140, 50, 50);

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton5.setText("7");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(100, 40, 50, 50);

        jButton12.setBackground(new java.awt.Color(204, 204, 204));
        jButton12.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton12.setText("1");
        jButton12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton12);
        jButton12.setBounds(100, 140, 50, 50);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(280, 100, 140, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("грам");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(430, 110, 60, 25);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("<html>Введіть вагу<br/>   м'яса/ковбасок<br/>    на 1 порцію</html> ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(280, 40, 150, 50);

        setSize(new java.awt.Dimension(530, 250));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        mainForm.setVisible(true);

    }//GEN-LAST:event_formWindowDeactivated

    private void clearDigit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDigit
        String pass = jTextField1.getText();
        if (pass.length() > 0) {
            jTextField1.setText("" + pass.substring(0, pass.length() - 1));
        }
    }//GEN-LAST:event_clearDigit

    private void NumberPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberPressed
        JButton myButton = (JButton) evt.getSource();
        jTextField1.setText("" + jTextField1.getText()
                + myButton.getText());
    }//GEN-LAST:event_NumberPressed

    public String removeLastFewChar(String s) {
        if (s.length() > 9) {
            s = s.substring(0, s.length() - 9);
        }
        return s;
    }

    //change ingredient weight if it is equals 0.1 KG
    public void setDishMeetWeight() {
        for (Ingredient ing : menu.get(activeCat).getDishes().get(activeDishes).getRecipe()) {
            if (ing.getCount() == 0.1) {
                if (listOfCoeffic.containsKey(ing.getId())) {
                    ing.setCount((weightCount * listOfCoeffic.get(ing.getId())) / 1000);
                } else {
                    ing.setCount(weightCount / 1000);
                }
                String title = menu.get(activeCat).getDishes().get(activeDishes).getTitle();
                int price = menu.get(activeCat).getDishes().get(activeDishes).getPrice();
                menu.get(activeCat).getDishes().get(activeDishes).setTitle(removeLastFewChar(title) + "(" + weightCount.intValue() + " гр.)");
                Double k = (weightCount * price) / 100;
                menu.get(activeCat).getDishes().get(activeDishes).setPrice((int) Math.ceil(k));
                break;
            }
        }
    }
    
    private void initCoeffic() {
       
//        listOfCoeffic = new HashMap<>();
//        listOfCoeffic.put(47, 1.2); //Ковбаски баварські
//        listOfCoeffic.put(48, 1.3);//Ковбаски на грилі
//        listOfCoeffic.put(35, 1.12);//Ковбаски мисливські
//        listOfCoeffic.put(49, 1.14);//Ковбаски салямі до пива
//        listOfCoeffic.put(50, 1.27);//М'ясо (свинина)
//        listOfCoeffic.put(94, 1.22);//М'ясо (телятина)
//        listOfCoeffic.put(103, 1.38);//індичка
//        listOfCoeffic.put(52, 1.38);//Філе куряче     
    }

    private void setWeightCount(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setWeightCount
        String line = jTextField1.getText();
        if (line.length() > 0) {
            weightCount = Double.parseDouble(line);
            System.out.println("weightCount " + weightCount);
            setDishMeetWeight();
            mainForm.addOrderItemToTable(dishCount);
            DishUtils.readDBCategoryById(4);
            mainForm.refreshDishList(4);
        }
        if (weightCount != 0) {
            this.dispose();
            mainForm.setEnabled(true);
        }
    }//GEN-LAST:event_setWeightCount

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeightForm().setVisible(true);
            }
        });
    }
    public static Double weightCount;
    public static HashMap<Integer, Double> listOfCoeffic = new HashMap<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
