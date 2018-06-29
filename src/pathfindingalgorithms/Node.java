/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfindingalgorithms;

import java.util.ArrayList;

/**
 *
 * @author xexio
 */
public class Node {
    private int value;
    private int row;
    private int col;
    private ArrayList neighbours;
    private float distance;
    private Node father;
    private float g = 0,f = 0;
    public Node(int value, int row, int col){
        this.value = value;
        this.row = row;
        this.col = col;
        this.distance = -1;
        father = null;
        neighbours = new ArrayList();
    }
    
    public ArrayList<Node> getNeighbours(){
        return neighbours;
    }
    
    public void setFather(Node father){
        this.father = father;
    }
    
    public Node getFather(){
        return this.father;
    }
    public void setNeighbours(ArrayList neighbours){
        this.neighbours = neighbours;
    }
    public int getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public void setDistance(float distance){
        this.distance = distance;
    }
    
    public float getDistance(){
        return this.distance;
    }
    
    public void setF(float f){
        this.f = f;
    }
    
    public float getF(){
        return this.f;
    }
    
    public void setG(float g){
        this.g = g;
    }
    
    public float getG(){
        return this.g;
    }
    
    @Override
    public boolean equals(Object object){
        if (this.row == ((Node)object).getRow() && this.col == ((Node)object).getCol()){
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + (int) value;
        hash = 31 * hash + (int) row;
        hash = 31 * hash + (int) col;
        hash = 31 * hash + (neighbours == null ? 0 : neighbours.hashCode());
        return hash;
    }
}
