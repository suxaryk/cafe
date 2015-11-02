package cafe.view;


import cafe.Utils.db.Dish.DishUtils;
import cafe.model.Ingredient;
import static cafe.view.MainForm.activeCat;
import static cafe.view.MainForm.activeDishes;
import static cafe.view.MainForm.dishCount;
import static cafe.view.MainForm.mainForm;
import static cafe.view.MainForm.menu;
import java.util.ArrayList;
import java.util.Collections;
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
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
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
        jButton1.setBounds(250, 120, 140, 38);

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
        jButton2.setBounds(170, 10, 50, 50);

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
        jButton3.setBounds(20, 10, 50, 50);

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
        jButton4.setBounds(120, 10, 50, 50);

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
        jButton6.setBounds(70, 60, 50, 50);

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
        jButton7.setBounds(120, 60, 50, 50);

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
        jButton8.setBounds(170, 60, 50, 50);

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
        jButton9.setBounds(170, 110, 50, 50);

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
        jButton10.setBounds(20, 110, 50, 50);

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
        jButton11.setBounds(120, 110, 50, 50);

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
        jButton5.setBounds(70, 10, 50, 50);

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
        jButton12.setBounds(70, 110, 50, 50);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(250, 70, 140, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("грам");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(400, 90, 60, 25);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("<html>Введіть вагу<br/>   м'яса/ковбасок<br/>    на 1 порцію</html> ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(250, 10, 150, 50);

        setSize(new java.awt.Dimension(456, 215));
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        MainForm.closeSystem();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void NumberPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberPressed
        JButton myButton = (JButton) evt.getSource();
        jTextField1.setText("" + jTextField1.getText()
            + myButton.getText());
    }//GEN-LAST:event_NumberPressed

    public String removeLastFewChar(String s){
        if (s.length() > 9) {
            s = s.substring(0, s.length() - 9);
        }        
        return s;
    } 
            
    public  void setDishMeetWeight(){   
        for (Ingredient ing : menu.get(activeCat).getDishes().get(activeDishes).getRecipe()) {                      
            if (ing.getCount() == 0.1) {
                ing.setCount(weightCount/1000);     
                String title = menu.get(activeCat).getDishes().get(activeDishes).getTitle();
                int price = menu.get(activeCat).getDishes().get(activeDishes).getPrice();
                menu.get(activeCat).getDishes().get(activeDishes).setTitle(removeLastFewChar(title) + "(" + weightCount.intValue() + " гр.)");
                Double k = (weightCount * price) / 100;
                menu.get(activeCat).getDishes().get(activeDishes).setPrice(k.intValue() + 1);
                break;                          
            }                     
        }        
    }
    private void setWeightCount(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setWeightCount
        String line = jTextField1.getText();        
        if (line.length() > 0) {
            weightCount = Double.parseDouble(line);
            System.out.println("weightCount "+ weightCount);
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
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeightForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeightForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeightForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeightForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeightForm().setVisible(true);
            }
        });
    }
    // private boolean sw = true;
    public static  Double weightCount;

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
