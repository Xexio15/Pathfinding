/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfindingalgorithms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author xexio
 */
public class View extends javax.swing.JPanel implements Observer {
    private int resX = 1280;
    private int resY = 720;
    private int rows,cols;
    public int startRow = -1,startColumn,goalRow,goalColumn;
    private Controller controlador;
    public Component[][] cells;
    public Color colorActual = Color.BLACK;
    private Color colorBase;
    private Dimension d;
    private GridBagConstraints gbc ;
    public View(int rows, int cols, Dimension d){
        initComponents();
        this.d = d;
        this.controlador = Controller.getInstance(this);
        this.cells = new Component [rows][cols];        
        this.rows = rows;
        this.cols = cols;
        setLayout(new GridLayout());
        gridPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
       
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                gbc.gridx = col;
                gbc.gridy = row;

                CellPane cellPane = new CellPane();
                cellPane.setName(row+","+col);
                Border border = null;
                if (row < 4) {
                    if (col < 4) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (col < 4) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                cellPane.setBorder(border);
                
                gridPanel.add(cellPane, gbc);
                cells[row][col] = cellPane;
            }
            
        }
        this.colorBase = cells[0][0].getBackground();
    }
    
    public void importMap(File dest){
        int[][] mapa = controlador.importMap(dest, this.rows, this.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mapa[i][j] == 0){
                    cells[i][j].setBackground(colorBase);
                }else if(mapa[i][j] == 1){
                    cells[i][j].setBackground(Color.BLACK);
                }else if(mapa[i][j] == 2){
                    this.goalRow = i;
                    this.goalColumn = j;
                    cells[i][j].setBackground(Color.ORANGE);
                }else{
                    this.startRow = i;
                    this.startColumn = j;
                    cells[i][j].setBackground(Color.GREEN);
                }
                
            }
        }
        
    }
    
    public void update(Dimension d){
       this.d = d;
       gridPanel.setSize(d);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                
                cells[row][col].setSize(cells[row][col].getPreferredSize());
                cells[row][col].repaint();
                cells[row][col].revalidate();
            }
            
        }
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public void update(int rows, int cols){
        this.resetTotal();
        this.rows = rows;
        this.cols = cols;
        cells = new Component [rows][cols];    
        gridPanel.removeAll();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                gbc.gridx = col;
                gbc.gridy = row;

                CellPane cellPane = new CellPane();
                cellPane.setName(row+","+col);
                Border border = null;
                if (row < 4) {
                    if (col < 4) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (col < 4) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                cellPane.setBorder(border);
                cellPane.setSize(cellPane.getPreferredSize());
                gridPanel.add(cellPane, gbc);
                cells[row][col] = cellPane;
            }
            
        }
        
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public void reset(){
        if(this.startRow != -1){
            cells[this.startRow][this.startColumn].setBackground(Color.GREEN);
            cells[this.goalRow][this.goalColumn].setBackground(Color.ORANGE);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                if(!cells[i][j].getBackground().equals(Color.BLACK) && !cells[i][j].getBackground().equals(Color.GREEN) && !cells[i][j].getBackground().equals(Color.ORANGE)){
                    cells[i][j].setBackground(colorBase);
                }
            }
        }
    }
    
    public void resetTotal(){
        this.startRow = -1;
        this.startColumn = -1;
        this.goalRow = -1;
        this.goalColumn = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j].setBackground(colorBase);
            }
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(resX, resY);
    }

    @Override
    public void update(Observable o, Object arg) {
        ArrayList arg1 = (ArrayList) arg;
        cells[(int)arg1.get(0)][(int)arg1.get(1)].setBackground((Color) arg1.get(2));
    }
    

    @Override
    public Component findComponentAt(Point p) {
        return super.findComponentAt(p); //To change body of generated methods, choose Tools | Templates.
    }
    boolean pressed = false;
    //Classe de la celda
    public class CellPane extends JPanel {
        private Color defaultBackground;

     
        public CellPane() {
            
            addMouseListener(new MouseAdapter() {
                
                @Override
                public void mousePressed(MouseEvent e) {
                    
                    if(e.getButton() == MouseEvent.BUTTON1){
                        JPanel clickedBox =(JPanel)e.getSource(); // get the reference to the box that was clicked 
                        clickedBox.setBackground(colorActual);
                        defaultBackground = getBackground();
                        if(defaultBackground.equals(Color.GREEN)){
                            String[] l = clickedBox.getName().split(",");
                            startRow = Integer.parseInt(l[0]);
                            startColumn = Integer.parseInt(l[1]);

                        }

                        if(defaultBackground.equals(Color.ORANGE)){
                            String[] l = clickedBox.getName().split(",");
                            goalRow = Integer.parseInt(l[0]);
                            goalColumn = Integer.parseInt(l[1]);

                        }
                    }else{
                        setBackground(colorBase);
                        defaultBackground = getBackground();
                    }
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                    defaultBackground = getBackground();
                    setBackground(Color.GRAY);
                    
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackground);
                }
                
                
            });
        }

        @Override
        public Dimension getPreferredSize() {
            if(((d.width-20)/cols) >= ((d.height-20)/rows)){
                return new Dimension((d.height-20)/rows, (d.height-20)/rows);
            }else{
                return new Dimension((d.width-20)/cols, (d.width-20)/cols);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gridPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(700, 700));

        gridPanel.setAlignmentX(0.0F);
        gridPanel.setAlignmentY(0.0F);
        gridPanel.setPreferredSize(new java.awt.Dimension(700, 700));

        javax.swing.GroupLayout gridPanelLayout = new javax.swing.GroupLayout(gridPanel);
        gridPanel.setLayout(gridPanelLayout);
        gridPanelLayout.setHorizontalGroup(
            gridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        gridPanelLayout.setVerticalGroup(
            gridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gridPanel;
    // End of variables declaration//GEN-END:variables
}


