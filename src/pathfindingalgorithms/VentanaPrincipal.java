/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfindingalgorithms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author xexio
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private View v;
    private Controller ctrl;
    final JFileChooser importFile = new JFileChooser();
    private Thread algoritmo;
    /**
     * Creates new form Prueba
     */
    public VentanaPrincipal() {
        initComponents();
        this.heuristicsPanel.setVisible(false);
        this.setFocusable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        v = new View(20,25);
        this.add(v);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
         ctrl = Controller.getInstance(v);
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        startButton = new javax.swing.JButton();
        selectedAlg = new javax.swing.JComboBox<>();
        resetButton = new javax.swing.JButton();
        resetTotal = new javax.swing.JButton();
        diagonalsCheck = new javax.swing.JCheckBox();
        heuristicsPanel = new javax.swing.JPanel();
        manhattanButton1 = new javax.swing.JRadioButton();
        chebyshevButton1 = new javax.swing.JRadioButton();
        octileButton1 = new javax.swing.JRadioButton();
        euclideanButton1 = new javax.swing.JRadioButton();
        colorsPanel = new javax.swing.JPanel();
        greenButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        blackButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        orangeButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        exportButton = new javax.swing.JButton();
        importButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        timeLabel = new javax.swing.JLabel();
        delayLabel = new javax.swing.JLabel();
        delayText = new javax.swing.JTextField();
        delayLabel1 = new javax.swing.JLabel();
        opsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pthfinding");
        setMinimumSize(new java.awt.Dimension(1280, 720));

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        selectedAlg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BFS", "DFS", "A*", "Dijkstra", "Greedy" }));
        selectedAlg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectedAlgItemStateChanged(evt);
            }
        });
        selectedAlg.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                selectedAlgPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        selectedAlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedAlgActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        resetTotal.setText("Reset Total");
        resetTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetTotalActionPerformed(evt);
            }
        });

        diagonalsCheck.setText("Diagonals");

        buttonGroup1.add(manhattanButton1);
        manhattanButton1.setMnemonic('1');
        manhattanButton1.setSelected(true);
        manhattanButton1.setText("Manhattan");

        buttonGroup1.add(chebyshevButton1);
        chebyshevButton1.setMnemonic('2');
        chebyshevButton1.setText("Chebyshev");

        buttonGroup1.add(octileButton1);
        octileButton1.setMnemonic('3');
        octileButton1.setText("Octile");

        buttonGroup1.add(euclideanButton1);
        euclideanButton1.setMnemonic('4');
        euclideanButton1.setText("Euclidean");

        javax.swing.GroupLayout heuristicsPanelLayout = new javax.swing.GroupLayout(heuristicsPanel);
        heuristicsPanel.setLayout(heuristicsPanelLayout);
        heuristicsPanelLayout.setHorizontalGroup(
            heuristicsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(heuristicsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(heuristicsPanelLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addGroup(heuristicsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(manhattanButton1)
                        .addComponent(chebyshevButton1)
                        .addComponent(octileButton1)
                        .addComponent(euclideanButton1))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        heuristicsPanelLayout.setVerticalGroup(
            heuristicsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
            .addGroup(heuristicsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(heuristicsPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(manhattanButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(chebyshevButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(octileButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(euclideanButton1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        greenButton.setBackground(new java.awt.Color(0, 255, 0));
        greenButton.setForeground(new java.awt.Color(51, 255, 51));
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Start");

        blackButton.setBackground(new java.awt.Color(0, 0, 0));
        blackButton.setForeground(new java.awt.Color(0, 0, 0));
        blackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Wall");

        orangeButton1.setBackground(new java.awt.Color(255, 153, 51));
        orangeButton1.setForeground(new java.awt.Color(51, 255, 51));
        orangeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orangeButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("End");

        javax.swing.GroupLayout colorsPanelLayout = new javax.swing.GroupLayout(colorsPanel);
        colorsPanel.setLayout(colorsPanelLayout);
        colorsPanelLayout.setHorizontalGroup(
            colorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(colorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorsPanelLayout.createSequentialGroup()
                        .addGroup(colorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addGroup(colorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(orangeButton1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blackButton, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(greenButton, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(25, 25, 25))
        );
        colorsPanelLayout.setVerticalGroup(
            colorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orangeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(colorsPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        exportButton.setText("Export");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        importButton.setText("Import...");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        timeLabel.setText("0 ms");

        delayLabel.setText("Delay:");

        delayText.setText("5");

        delayLabel1.setText("ms");

        opsLabel.setText("0 ops.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(delayLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delayText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(timeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opsLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delayLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectedAlg, 0, 103, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1052, 1052, 1052)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(importButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(diagonalsCheck)
                            .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(heuristicsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resetTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colorsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(selectedAlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(startButton)
                .addGap(19, 19, 19)
                .addComponent(colorsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(diagonalsCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heuristicsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stopButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(importButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportButton)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(opsLabel)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delayLabel)
                    .addComponent(delayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delayLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        delayText.setEnabled(false);
        v.reset();
        ctrl.mapGenerator(v.cells, diagonalsCheck.isSelected());
        ctrl.setDelay(Integer.parseInt(delayText.getText()));
        algoritmo = new Thread(new Runnable() {
            public void run() {
                int ops = 0;
                long startTime = System.nanoTime();
                if(String.valueOf(selectedAlg.getSelectedItem()).equals("BFS")){
                    ops = ctrl.useBFS(v.startRow, v.startColumn);
                }else if(String.valueOf(selectedAlg.getSelectedItem()).equals("DFS")){
                    ops = ctrl.useDFS(v.startRow, v.startColumn);
                }else if(String.valueOf(selectedAlg.getSelectedItem()).equals("A*")){
                    int heuristic = 0;
                    Enumeration e = buttonGroup1.getElements();
                    while (e.hasMoreElements()){
                        JRadioButton r = (JRadioButton) e.nextElement();
                        if(r.isSelected()){
                            if(r.getText().equals("Chebyshev")){
                                heuristic = 2;
                            }else if(r.getText().equals("Octile")){
                                heuristic = 3;
                            }else if(r.getText().equals("Euclidean")){
                                heuristic = 4;
                            }else{
                                heuristic = 1;
                            }
                        }
                    }
                    ops = ctrl.useAStar(v.startRow, v.startColumn, v.goalRow, v.goalColumn, heuristic);
                }else if(String.valueOf(selectedAlg.getSelectedItem()).equals("Greedy")){
                    int heuristic = 0;
                    Enumeration e = buttonGroup1.getElements();
                    while (e.hasMoreElements()){
                        JRadioButton r = (JRadioButton) e.nextElement();
                        if(r.isSelected()){
                            if(r.getText().equals("Chebyshev")){
                                heuristic = 2;
                            }else if(r.getText().equals("Octile")){
                                heuristic = 3;
                            }else if(r.getText().equals("Euclidean")){
                                heuristic = 4;
                            }else{
                                heuristic = 1;
                            }
                        }
                    }
                    ops = ctrl.useGreedy(v.startRow, v.startColumn, v.goalRow, v.goalColumn, heuristic);
                }else if(String.valueOf(selectedAlg.getSelectedItem()).equals("Dijkstra")){
                    ops = ctrl.useDijkstra(v.startRow, v.startColumn);
                }
                long endTime = System.nanoTime();
                long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
                //duration = duration - Integer.parseInt(delayText.getText()) * 3 * ops;
                timeLabel.setText(String.format("%.2f", (float)duration) + " ms");
                opsLabel.setText(ops+" ops.");
                delayText.setEnabled(true);
            }
            
       });
        
        algoritmo.start();
    }//GEN-LAST:event_startButtonActionPerformed

    private void selectedAlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedAlgActionPerformed
        
    }//GEN-LAST:event_selectedAlgActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        v.reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void resetTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetTotalActionPerformed
        v.resetTotal();
    }//GEN-LAST:event_resetTotalActionPerformed

    private void selectedAlgPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_selectedAlgPopupMenuWillBecomeInvisible
       
    }//GEN-LAST:event_selectedAlgPopupMenuWillBecomeInvisible

    private void selectedAlgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectedAlgItemStateChanged
         Enumeration e = buttonGroup1.getElements();
        if(this.selectedAlg.getSelectedItem().equals("A*") || this.selectedAlg.getSelectedItem().equals("Greedy")){    
            
            this.heuristicsPanel.setVisible(true);
        }else{
            this.heuristicsPanel.setVisible(false);
            
        }
        this.revalidate();
        this.repaint();
        this.doLayout();
    }//GEN-LAST:event_selectedAlgItemStateChanged

    private void orangeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orangeButton1ActionPerformed
        v.colorActual = Color.ORANGE;
    }//GEN-LAST:event_orangeButton1ActionPerformed

    private void blackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackButtonActionPerformed
        v.colorActual = Color.BLACK;
    }//GEN-LAST:event_blackButtonActionPerformed

    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenButtonActionPerformed
        v.colorActual = Color.GREEN;
    }//GEN-LAST:event_greenButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        ctrl.exportMap(v.cells);
    }//GEN-LAST:event_exportButtonActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        int returnVal = importFile.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = importFile.getSelectedFile();
            v.importMap(file);
        }
    }//GEN-LAST:event_importButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        if(algoritmo.isAlive()){
            algoritmo.interrupt();
        }
    }//GEN-LAST:event_stopButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blackButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton chebyshevButton1;
    private javax.swing.JPanel colorsPanel;
    private javax.swing.JLabel delayLabel;
    private javax.swing.JLabel delayLabel1;
    private javax.swing.JTextField delayText;
    private javax.swing.JCheckBox diagonalsCheck;
    private javax.swing.JRadioButton euclideanButton1;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton greenButton;
    private javax.swing.JPanel heuristicsPanel;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton manhattanButton1;
    private javax.swing.JRadioButton octileButton1;
    private javax.swing.JLabel opsLabel;
    private javax.swing.JButton orangeButton1;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton resetTotal;
    private javax.swing.JComboBox<String> selectedAlg;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}