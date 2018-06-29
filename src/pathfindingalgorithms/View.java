/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfindingalgorithms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
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
    public int startRow = -1,startColumn;
    public int goalRow,goalColumn;
    private Controller controlador;
    public Component[][] cells;
    public Color colorActual = Color.BLACK;
    private Color colorBase;
    public View(int rows, int cols){
        initComponents();
        controlador = Controller.getInstance(this);
        cells = new Component [rows][cols];        
        this.rows = rows;
        this.cols = cols;
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
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
                add(cellPane, gbc);
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
            return new Dimension(35, 35);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}


