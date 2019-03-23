/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.*;

/**
 *
 * @author Dell
 */
public class GameView extends javax.swing.JFrame {

    /**
     * Creates new form GameView
     */
    boolean draw;
    int playerOneScore = 0;
    int playerTwoScore = 0;

    controllerClass obj;
    String playerOne = "Player 1";
    String playerTwo = "Player 2";
    String determineTurn = "X";

    JButton[][] button = new JButton[3][3];

    public GameView() {
        initComponents();
        setSize(758, 476);
        setLocationRelativeTo(null);

        draw = false;
        playerTurn.setText(playerOne);

        obj = new controllerClass();
        button[0][0] = new JButton();
        button[0][0] = button1;
        button[0][0].addActionListener(listen);

        button[0][1] = new JButton();
        button[0][1] = button2;
        button[0][1].addActionListener(listen);

        button[0][2] = new JButton();
        button[0][2] = button3;
        button[0][2].addActionListener(listen);

        button[1][0] = new JButton();
        button[1][0] = button4;
        button[1][0].addActionListener(listen);

        button[1][1] = new JButton();
        button[1][1] = button5;
        button[1][1].addActionListener(listen);

        button[1][2] = new JButton();
        button[1][2] = button6;
        button[1][2].addActionListener(listen);

        button[2][0] = new JButton();
        button[2][0] = button7;
        button[2][0].addActionListener(listen);

        button[2][1] = new JButton();
        button[2][1] = button8;
        button[2][1].addActionListener(listen);

        button[2][2] = new JButton();
        button[2][2] = button9;
        button[2][2].addActionListener(listen);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public GameView(String player1, String player2) {
        this();
        this.playerOne = player1;
        this.playerTwo = player2;

        playerOneScore = obj.getScore(playerOne);
        playerTwoScore = obj.getScore(playerTwo);

    }

    private void matchTied() {

        ImageIcon btn1 = (ImageIcon) button[0][0].getIcon();
        ImageIcon btn2 = (ImageIcon) button[0][1].getIcon();
        ImageIcon btn3 = (ImageIcon) button[0][2].getIcon();
        ImageIcon btn4 = (ImageIcon) button[1][0].getIcon();
        ImageIcon btn5 = (ImageIcon) button[1][1].getIcon();
        ImageIcon btn6 = (ImageIcon) button[1][2].getIcon();
        ImageIcon btn7 = (ImageIcon) button[2][0].getIcon();
        ImageIcon btn8 = (ImageIcon) button[2][1].getIcon();
        ImageIcon btn9 = (ImageIcon) button[2][2].getIcon();

        String strB1 = "";
        String strB2 = "";
        String strB3 = "";
        String strB4 = "";
        String strB5 = "";
        String strB6 = "";
        String strB7 = "";
        String strB8 = "";
        String strB9 = "";
        if (btn1 != null) {
            strB1 = btn1.toString();
        }
        if (btn2 != null) {
            strB2 = btn2.toString();
        }
        if (btn3 != null) {
            strB3 = btn3.toString();
        }

        if (btn4 != null) {
            strB4 = btn4.toString();
        }
        if (btn5 != null) {
            strB5 = btn5.toString();
        }
        if (btn6 != null) {
            strB6 = btn6.toString();
        }
        if (btn7 != null) {
            strB7 = btn7.toString();
        }
        if (btn8 != null) {
            strB8 = btn8.toString();
        }
        if (btn9 != null) {
            strB9 = btn9.toString();
        }

        if (strB1 != "" && strB2 != "" && strB3 != "" && strB4 != "" && strB5 != "" && strB6 != "" && strB7 != "" && strB8 != "" && strB9 != "") {
            JOptionPane.showMessageDialog(null, "Match Tied!", "Draw", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void reset() {
        //   this.setVisible(false);
        this.dispose();;
        new GameView(playerOne, playerTwo).setVisible(true);
    }

    private void winnerO() {
        JOptionPane.showMessageDialog(this, playerTwo + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
        playerTwoScore++;
        String score = Integer.toString(playerTwoScore);
        obj.updateScore(playerTwo, score);
    }

    private void winnerX() {
        JOptionPane.showMessageDialog(this, playerOne + " Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
        playerOneScore++;
        String score = Integer.toString(playerOneScore);
        obj.updateScore(playerOne, score);
    }

    private void winLose() {

        ImageIcon cross = new ImageIcon(this.getClass().getResource("image8.gif"));
        String crossStr = cross.toString();
        ImageIcon knot = new ImageIcon(this.getClass().getResource("image10.gif"));
        String knotStr = knot.toString();

        ImageIcon btn1 = (ImageIcon) button[0][0].getIcon();
        ImageIcon btn2 = (ImageIcon) button[0][1].getIcon();
        ImageIcon btn3 = (ImageIcon) button[0][2].getIcon();
        ImageIcon btn4 = (ImageIcon) button[1][0].getIcon();
        ImageIcon btn5 = (ImageIcon) button[1][1].getIcon();
        ImageIcon btn6 = (ImageIcon) button[1][2].getIcon();
        ImageIcon btn7 = (ImageIcon) button[2][0].getIcon();
        ImageIcon btn8 = (ImageIcon) button[2][1].getIcon();
        ImageIcon btn9 = (ImageIcon) button[2][2].getIcon();

        //CROSS WINS
        if (btn1 != null && btn2 != null && btn3 != null) {
            String strB1 = btn1.toString();
            String strB2 = btn2.toString();
            String strB3 = btn3.toString();
            if (strB1.equals(crossStr) && strB2.equals(crossStr) && strB3.equals(crossStr)) {
                winnerX();
                System.out.println("X WINS!");
            }
        }
        if (btn4 != null && btn5 != null && btn6 != null) {
            String strB4 = btn4.toString();
            String strB5 = btn5.toString();
            String strB6 = btn6.toString();
            if (strB4.equals(crossStr) && strB5.equals(crossStr) && strB6.equals(crossStr)) {
                winnerX();
                System.out.println("X WINS!");
            }
        }

        if (btn7 != null && btn8 != null && btn9 != null) {
            String strB7 = btn7.toString();
            String strB8 = btn8.toString();
            String strB9 = btn9.toString();
            if (strB7.equals(crossStr) && strB8.equals(crossStr) && strB9.equals(crossStr)) {
                winnerX();
                System.out.println("X WINS!");
            }
        }

        if (btn1 != null && btn4 != null && btn7 != null) {
            String strB1 = btn1.toString();
            String strB4 = btn4.toString();
            String strB7 = btn7.toString();
            if (strB1.equals(crossStr) && strB4.equals(crossStr) && strB7.equals(crossStr)) {
                winnerX();
                System.out.println("X WINS!");
            }
        }

        if (btn2 != null && btn5 != null && btn8 != null) {
            String strB2 = btn2.toString();
            String strB5 = btn5.toString();
            String strB8 = btn8.toString();
            if (strB2.equals(crossStr) && strB5.equals(crossStr) && strB8.equals(crossStr)) {
                winnerX();
                System.out.println("X WINS!");
            }
        }

        if (btn3 != null && btn6 != null && btn9 != null) {
            String strB3 = btn3.toString();
            String strB6 = btn6.toString();
            String strB9 = btn9.toString();
            if (strB3.equals(crossStr) && strB6.equals(crossStr) && strB9.equals(crossStr)) {
                winnerX();
                System.out.println("X WINS!");
            }
        }

        if (btn3 != null && btn5 != null && btn7 != null) {
            String strB3 = btn3.toString();
            String strB5 = btn5.toString();
            String strB7 = btn7.toString();
            if (strB3.equals(crossStr) && strB5.equals(crossStr) && strB7.equals(crossStr)) {
                winnerX();
                System.out.println("X WINS!");
            }
        }

        if (btn1 != null && btn5 != null && btn9 != null) {
            String strB1 = btn1.toString();
            String strB5 = btn5.toString();
            String strB9 = btn9.toString();
            if (strB1.equals(crossStr) && strB5.equals(crossStr) && strB9.equals(crossStr)) {
                winnerX();
                System.out.println("X WINS!");
            }
        }

        //KNOTS WINS
        if (btn1 != null && btn2 != null && btn3 != null) {
            String strB1 = btn1.toString();
            String strB2 = btn2.toString();
            String strB3 = btn3.toString();
            if (strB1.equals(knotStr) && strB2.equals(knotStr) && strB3.equals(knotStr)) {
                winnerO();
                System.out.println("O WINS!");
            }
        }

        if (btn4 != null && btn5 != null && btn6 != null) {
            String strB4 = btn4.toString();
            String strB5 = btn5.toString();
            String strB6 = btn6.toString();
            if (strB4.equals(knotStr) && strB5.equals(knotStr) && strB6.equals(knotStr)) {
                winnerO();
                System.out.println("O WINS!");
            }
        }

        if (btn7 != null && btn8 != null && btn9 != null) {
            String strB7 = btn7.toString();
            String strB8 = btn8.toString();
            String strB9 = btn9.toString();
            if (strB7.equals(knotStr) && strB8.equals(knotStr) && strB9.equals(knotStr)) {
                winnerO();
                System.out.println("O WINS!");
            }
        }

        if (btn1 != null && btn4 != null && btn7 != null) {
            String strB1 = btn1.toString();
            String strB4 = btn4.toString();
            String strB7 = btn7.toString();
            if (strB1.equals(knotStr) && strB4.equals(knotStr) && strB7.equals(knotStr)) {
                winnerO();
                System.out.println("O WINS!");
            }
        }

        if (btn2 != null && btn5 != null && btn8 != null) {
            String strB2 = btn2.toString();
            String strB5 = btn5.toString();
            String strB8 = btn8.toString();
            if (strB2.equals(knotStr) && strB5.equals(knotStr) && strB8.equals(knotStr)) {
                winnerO();
                System.out.println("O WINS!");
            }
        }

        if (btn3 != null && btn6 != null && btn9 != null) {
            String strB3 = btn3.toString();
            String strB6 = btn6.toString();
            String strB9 = btn9.toString();
            if (strB3.equals(knotStr) && strB6.equals(knotStr) && strB9.equals(knotStr)) {
                winnerO();
                System.out.println("O WINS!");
            }
        }

        if (btn3 != null && btn5 != null && btn7 != null) {
            String strB3 = btn3.toString();
            String strB5 = btn5.toString();
            String strB7 = btn7.toString();
            if (strB3.equals(knotStr) && strB5.equals(knotStr) && strB7.equals(knotStr)) {
                winnerO();
                System.out.println("O WINS!");
            }
        }

        if (btn1 != null && btn5 != null && btn9 != null) {
            String strB1 = btn1.toString();
            String strB5 = btn5.toString();
            String strB9 = btn9.toString();
            if (strB1.equals(knotStr) && strB5.equals(knotStr) && strB9.equals(knotStr)) {
                winnerO();
                System.out.println("O WINS!");
            }
        }
    }

    private void turn() {
        if (determineTurn.equalsIgnoreCase("X")) {
            playerTurn.setText(playerTwo);
            determineTurn = "O";
        } else {
            determineTurn = "X";
            playerTurn.setText(playerOne);
        }

    }

    ActionListener listen = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            System.out.println("BUTTON CLICKED!");
            boolean buttonClicked = true;
            int detectClickRow = 0;
            int detectClickColumn = 0;

            for (detectClickRow = 0; detectClickRow < 3; detectClickRow++) {
                for (detectClickColumn = 0; detectClickColumn < 3; detectClickColumn++) {
                    if (evt.getSource() == button[detectClickRow][detectClickColumn]) {
                        if (determineTurn.equalsIgnoreCase("X")) {
                            if (button[detectClickRow][detectClickColumn].getIcon() == null) {
                                button[detectClickRow][detectClickColumn].setIcon(new ImageIcon(this.getClass().getResource("image8.gif")));

                            }
                        } else {
                            if (button[detectClickRow][detectClickColumn].getIcon() == null) {
                                button[detectClickRow][detectClickColumn].setIcon(new ImageIcon(this.getClass().getResource("image10.gif")));

                            }
                        }
                        turn();
                        winLose();
                        matchTied();
                        buttonClicked = false;
                    }
                }
                if (!buttonClicked) {
                    break;
                }
            }

        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                ImageIcon im=new ImageIcon("wp2646214.jpg");
                Image i=im.getImage();

                g.drawImage(i, 0, 0, this.getSize().width,this.getSize().height,this);

            }

        };

        // Code of sub-components - not shown here

        // Layout setup code - not shown here

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 60, 470, 470);
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button1 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        playAgain = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        playerTurn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        backButton = new javax.swing.JMenuItem();
        scoreBoard = new javax.swing.JMenuItem();
        helpMe = new javax.swing.JMenuItem();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, new java.awt.Color(255, 51, 51), java.awt.Color.red, java.awt.Color.red));
        jPanel1.setLayout(null);

        button2.setBackground(new java.awt.Color(0, 0, 0));
        button2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jPanel1.add(button2);
        button2.setBounds(115, 6, 100, 100);

        button3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(button3);
        button3.setBounds(221, 6, 100, 100);

        button1.setBackground(new java.awt.Color(0, 0, 0));
        button1.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jPanel1.add(button1);
        button1.setBounds(10, 6, 100, 100);

        button4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(button4);
        button4.setBounds(10, 112, 100, 100);

        button5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(button5);
        button5.setBounds(115, 112, 100, 100);

        button6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(button6);
        button6.setBounds(221, 112, 100, 100);

        button7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(button7);
        button7.setBounds(10, 218, 100, 100);

        button8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(button8);
        button8.setBounds(115, 218, 100, 100);

        button9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(button9);
        button9.setBounds(221, 218, 100, 100);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 70, 330, 330);

        playAgain.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        playAgain.setForeground(new java.awt.Color(204, 0, 0));
        playAgain.setText("PLAY AGAIN");
        playAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgainActionPerformed(evt);
            }
        });
        getContentPane().add(playAgain);
        playAgain.setBounds(410, 210, 310, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/image (12).gif"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(410, 140, 105, 30);

        playerTurn.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        playerTurn.setForeground(new java.awt.Color(204, 0, 51));
        playerTurn.setText("PlayerName");
        getContentPane().add(playerTurn);
        playerTurn.setBounds(540, 140, 152, 38);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/image (13).gif"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 20, 345, 38);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/image6.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-2, 0, 760, 490);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("Game ");
        jMenu1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N

        backButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        backButton.setText("Home");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jMenu1.add(backButton);

        scoreBoard.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        scoreBoard.setText("Score Board");
        scoreBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreBoardActionPerformed(evt);
            }
        });
        jMenu1.add(scoreBoard);

        helpMe.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        helpMe.setText("Help");
        helpMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMeActionPerformed(evt);
            }
        });
        jMenu1.add(helpMe);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgainActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_playAgainActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        HomeScreenView object = new HomeScreenView();
        object.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void scoreBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreBoardActionPerformed
        // TODO add your handling code here:

        ScoreBoardView object = new ScoreBoardView();
        object.setVisible(true);
    }//GEN-LAST:event_scoreBoardActionPerformed

    private void helpMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMeActionPerformed
        // TODO add your handling code here:
        HowToPlayView object = new HowToPlayView();
        object.setVisible(true);
    }//GEN-LAST:event_helpMeActionPerformed

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
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem backButton;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JMenuItem helpMe;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton playAgain;
    private javax.swing.JLabel playerTurn;
    private javax.swing.JMenuItem scoreBoard;
    // End of variables declaration//GEN-END:variables

}
