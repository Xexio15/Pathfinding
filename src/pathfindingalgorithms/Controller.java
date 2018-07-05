/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfindingalgorithms;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xexio
 */
public class Controller {
    private static Controller INSTANCE = null;
    private Graph graph;
    private Algorithms al;
    
    private synchronized static void createInstance(View v) {
        if (INSTANCE == null) { 
            INSTANCE = new Controller(v);
        }
    }
    public static Controller getInstance(View v) {
        if (INSTANCE == null) createInstance(v);
        return INSTANCE;
    }
    private Controller(View v){
        al = new Algorithms(v);
    }
    
    public int [][] importMap(File dest, int rows, int cols){
        int [][] mapa = new int [rows][cols];

        int character, i = 0;
        char[] characters = new char[rows*cols+1];
        try {
            FileReader reader = new FileReader(dest);
            while ((character = reader.read()) != -1) {
                characters[i] = (char) character;
                i++;
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        int k = 0;
        for(i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                mapa[i][j] = Integer.parseInt(""+characters[k]);
                k++;
            }
        }
        return mapa;
    }
    
    public void exportMap(Component[][] cells){
        String fila = "";
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                if(cells[row][col].getBackground().equals(Color.BLACK)){
                    fila = fila + "1";
                }else if(cells[row][col].getBackground().equals(Color.ORANGE)){
                    fila = fila + "2";
                }else if(cells[row][col].getBackground().equals(Color.GREEN)){
                    fila = fila + "3";
                }
                else{
                    fila = fila + "0";
                }
            }
            FileWriter writer ;
            try {
                writer = new FileWriter("map.txt", false);
                writer.write(fila+"\n");
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void mapGenerator(Component[][] cells, boolean diagonals){
        graph = new Graph();
        int[] fila = new int[cells[0].length];
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                if(cells[row][col].getBackground().equals(Color.BLACK)){
                    fila[col] = 1;
                    graph.addNode(1, row, col);
                }else if(cells[row][col].getBackground().equals(Color.ORANGE)){
                    graph.addNode(2, row, col);
                    fila[col] = 2;
                }
                else{
                    fila[col] = 0;
                    graph.addNode(0, row, col);
                }
            }
        }
        graph.generateNeighbours(diagonals);
    }
    
    public void setDelay(int delay){
        al.setDelay(delay);
        al.setOperations(0);
        al.resetPathLength();
    }
    
    public int[] useBFS(int row, int col){
        int [] length_ops = new int[2];
        Node start = graph.getNode(row, col);
        try {
            al.BFS(start);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        length_ops[0] = al.getPathLength();
        length_ops[1] = al.getOperations();
        return length_ops;
    }

    public int[] useDFS(int row, int col){
        int [] length_ops = new int[2];
        Node start = graph.getNode(row, col);
        try {
            al.DFS(start);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        length_ops[0] = al.getPathLength();
        length_ops[1] = al.getOperations();
        return length_ops;
    }
    
    public int[] useAStar(int sRow, int sCol, int gRow, int gCol, int heuristic){
        int [] length_ops = new int[2];
        Node start = graph.getNode(sRow, sCol);
        Node goal = graph.getNode(gRow, gCol);
        try {
            al.AStar(start,goal,heuristic);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        length_ops[0] = al.getPathLength();
        length_ops[1] = al.getOperations();
        return length_ops;
    }
    
    public int[] useGreedy(int sRow, int sCol, int gRow, int gCol, int heuristic){
        int [] length_ops = new int[2];
        Node start = graph.getNode(sRow, sCol);
        Node goal = graph.getNode(gRow, gCol);
        try {
            al.Greedy(start,goal,heuristic);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        length_ops[0] = al.getPathLength();
        length_ops[1] = al.getOperations();
        return length_ops;
    }
    
    public int[] useDijkstra(int sRow, int sCol){
        int [] length_ops = new int[2];
        Node start = graph.getNode(sRow, sCol);
        try {
            al.Dijkstra(graph,start);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        length_ops[0] = al.getPathLength();
        length_ops[1] = al.getOperations();
        return length_ops;
    }
    
}
