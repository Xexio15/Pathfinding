/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfindingalgorithms;

import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author xexio
 */
public class Graph {
    private ArrayList<Node> nodes;
    public Graph(){
        nodes = new ArrayList();
    }
    
    public void addNode(int value, int row, int col){
        Node node = new Node(value, row, col);
        nodes.add(node);
    }
    
    public void generateNeighbours(boolean diagonals){
        Node node;
        Node actual;
        ArrayList<Node> vecinos;
        for(int j = 0; j < nodes.size(); j++){
            vecinos = new ArrayList<Node>();
            node = (Node)nodes.get(j);
            for(int i = 0; i < nodes.size(); i++){
                actual = (Node)nodes.get(i);
                if(abs(actual.getRow() - node.getRow()) == 1 && abs(actual.getCol() - node.getCol()) == 1 && diagonals){
                    vecinos.add(actual);
                }else if(abs(actual.getRow() - node.getRow()) == 1 && abs(actual.getCol() - node.getCol()) == 0){
                    vecinos.add(actual);
                }else if(abs(actual.getRow() - node.getRow()) == 0 && abs(actual.getCol() - node.getCol()) == 1){
                    vecinos.add(actual);
                }
            }
            node.setNeighbours(vecinos);
        }
    }
    
    public int getNumNodes(){
        return nodes.size();
    }
    
    public Node getNode(int idx){
        return nodes.get(idx);
    }
    
    public Node getNode(int row,int col){
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).getRow() == row && nodes.get(i).getCol() == col){
                return nodes.get(i);
            }
        }
        return null;
    }
}
