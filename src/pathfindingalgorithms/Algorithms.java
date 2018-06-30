/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfindingalgorithms;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Observable;
import java.util.Observer;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/**
 * BFS,DFS,A*;Djikstra,Greedy
 * @author xexio
 */

public class Algorithms extends Observable {
    private int delay = 5;
    private int operations = 0;
    private int pathLength  = 0;


    /**
     * Constructor
     * @param v
     */

    public Algorithms(View v){
        this.addObserver((Observer) v);
    }
    
    /**
     *
     * @return
     */
    public int getOperations(){
        return this.operations;
    }
    
    /**
     *
     * @param operations
     */
    public void setOperations(int operations){
        this.operations = operations;
    }
    
    /**
     *
     * @return
     */
    public int getPathLength(){
        return this.pathLength;
    }
    
    /**
     *
     */
    public void resetPathLength(){
        this.pathLength = 0;
    }
    
    /**
     *
     * @param delay
     */
    public void setDelay(int delay){
        this.delay = delay;
    }
  
    /**
     * State 0: Not explored (Base Color)
     * State 1: actual (Red)
     * State 2: In Cue (Cyan)
     * State 3: Visited (Blue)
     * State 4: Path (Yellow)
     * @param state
     * @param row
     * @param col
     */

    public void changeCellState(int state, int row, int col) {
        ArrayList arg = new ArrayList();
        Color c = Color.LIGHT_GRAY;
        arg.add(row);
        arg.add(col);
        
        switch(state){
            case 1: c = Color.RED; break;
            case 2: c = Color.CYAN; break;
            case 3: c = Color.BLUE; break;
            case 4: c = Color.YELLOW; break;
        }
        
        arg.add(c);
        setChanged();
        notifyObservers(arg);
    }
    
    /**
     * BFS Algorithm
     * @param start
     * @throws InterruptedException
     */
    public void BFS(Node start) throws InterruptedException{
        ArrayList cua = new ArrayList();
        ArrayList visitados = new ArrayList();
        start.setDistance(0);
        cua.add(start);
        visitados.add(start);
        
        while(!cua.isEmpty()){
            Node actual = (Node)((cua.get(0)));
            cua.remove(0);
            changeCellState(1,actual.getRow(),actual.getCol());
            TimeUnit.MILLISECONDS.sleep(this.delay);

            if(actual.getValue() == 2){
                getPath(new ArrayList(), actual);
                return;
            }
            
            for (int i = 0; i < actual.getNeighbours().size(); i++){
                Node vecino = actual.getNeighbours().get(i);
                
                if(!visitados.contains(vecino) && vecino.getValue() != 1){
                    changeCellState(2,vecino.getRow(),vecino.getCol());
                    TimeUnit.MILLISECONDS.sleep(this.delay);
                    vecino.setDistance(actual.getDistance()+1);
                    vecino.setFather(actual);
                    visitados.add(vecino);
                    cua.add(vecino);
                }
            }
            
            changeCellState(3,actual.getRow(),actual.getCol());//ACTUAL VISITADO
            TimeUnit.MILLISECONDS.sleep(this.delay);
            operations++;
        }
    }
    
    /**
     * DFS Algorithm
     * @param start
     * @throws InterruptedException
     */
    public void DFS(Node start) throws InterruptedException{
        ArrayList pila = new ArrayList();
        ArrayList visitados = new ArrayList();
        start.setDistance(0);
        
        pila.add(start);
        visitados.add(start);
        
        while(!pila.isEmpty()){
            Node actual = (Node)((pila.get(pila.size()-1)));
            pila.remove(pila.size()-1);

            changeCellState(1,actual.getRow(),actual.getCol());
            TimeUnit.MILLISECONDS.sleep(this.delay);

            if(actual.getValue() == 2){
                getPath(new ArrayList(), actual);
                return;
            }
            
            for (int i = 0; i < actual.getNeighbours().size(); i++){

                Node vecino = actual.getNeighbours().get(i);
                
                if(!visitados.contains(vecino) && vecino.getValue() != 1){
                    vecino.setDistance(actual.getDistance()+1);
                    vecino.setFather(actual);
                    visitados.add(vecino);
                    pila.add(vecino);
                    changeCellState(2,vecino.getRow(),vecino.getCol());
                    TimeUnit.MILLISECONDS.sleep(this.delay);
                }
            }
            
            changeCellState(3,actual.getRow(),actual.getCol());//ACTUAL VISITADO
            TimeUnit.MILLISECONDS.sleep(this.delay);
            operations++;
        }        
    }
    
    /**
     * A* Algorithm
     * @param start
     * @param goal
     * @param heuristic
     * @throws InterruptedException
     */
    public void AStar( Node start, Node goal, int heuristic) throws InterruptedException{
        ArrayList<Node> visitados = new ArrayList();
        PriorityQueue<Node> scoreNode = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if(a.getF() < b.getF()) return -1;
                if(a.getF() > b.getF()) return 1;
                return 0;
            }
        });
        
        scoreNode.add(start);
        visitados.add(start);
        
        while (!scoreNode.isEmpty()){
            Node actual = scoreNode.poll();
            
            if(actual.getValue() != 1){
                changeCellState(1,actual.getRow(),actual.getCol());
                TimeUnit.MILLISECONDS.sleep(this.delay);
                
                if (actual.getValue() == 2){
                    getPath(new ArrayList(), actual);
                    return;
                }
                
                for(int i = 0; i < actual.getNeighbours().size(); i++){
                    Node vecino = actual.getNeighbours().get(i);
                    
                    if(vecino.getValue() != 1){
                        float h,g,f;
                        //heuristic
                        switch(heuristic){
                            //manhattan
                            case 1: h = manhattanDistance(vecino,goal);
                                    //g = manhattanDistance(vecino,start);
                                    break;
                            //chebyshev
                            case 2: h = chebyshevDistance(vecino,goal);
                                    //g = manhattanDistance(vecino,start);
                                    break;
                            //octile
                            case 3: h = octileDistance(vecino,goal);
                                    //g = manhattanDistance(vecino,start);
                                    break;
                            //euclidean
                            case 4: h = euclideanDistance(vecino,goal);
                                    //g = manhattanDistance(vecino,start);
                                    break;
                            default:h = manhattanDistance(vecino,goal);
                                    //g = manhattanDistance(vecino,start);
                                    break;
                        }

                        float cost = calculateCost(actual,vecino);
                        float tentative_g = actual.getG() + cost;
                        
                        if(!visitados.contains(vecino) && (!scoreNode.contains(vecino) || tentative_g < vecino.getG())){
                            vecino.setG(tentative_g);
                            vecino.setFather(actual);
                            vecino.setF(tentative_g + h);
                            scoreNode.add(vecino);
                            visitados.add(vecino);
                            changeCellState(2,vecino.getRow(),vecino.getCol());
                            TimeUnit.MILLISECONDS.sleep(this.delay);    
                        }
                    }
                }
                changeCellState(3,actual.getRow(),actual.getCol());//ACTUAL VISITADO
                TimeUnit.MILLISECONDS.sleep(this.delay);
            }
            operations++;
        }
    }
    
    /**
     * Greedy Algorithm
     * @param start
     * @param goal
     * @param heuristic
     * @throws InterruptedException
     */
    public void Greedy(Node start, Node goal, int heuristic) throws InterruptedException{
        ArrayList<Node> camino = new ArrayList();
        ArrayList<Node> visitados = new ArrayList();
        ArrayList<Node> minim = new ArrayList();
        visitados.add(start);
        Node actual = start;
        int control = 0;
        
        while(control < 1500){
            camino.add(actual);
            changeCellState(4,actual.getRow(),actual.getCol());
            this.pathLength++;
            TimeUnit.MILLISECONDS.sleep(this.delay);
            if(actual.getValue() == 2){
                //getPath(new ArrayList(), actual);
                return;
            }
            
            for(int i = 0; i < actual.getNeighbours().size(); i++){
                Node vecino = actual.getNeighbours().get(i);
                
                    if(vecino.getValue() != 1){
                        float dist;
                        //heuristic
                        switch(heuristic){
                            //manhattan
                            case 1: dist = manhattanDistance(vecino,goal);
                                    break;
                            //chebyshev
                            case 2: dist = chebyshevDistance(vecino,goal);
                                    break;
                            //octile
                            case 3: dist = octileDistance(vecino,goal);
                                    break;
                            //euclidean
                            case 4: dist = euclideanDistance(vecino,goal);
                                    break;
                            default:dist = manhattanDistance(vecino,goal);
                                    break;
                        }
                        minim.add(vecino);
                        vecino.setDistance(dist);
                        
                        if(!camino.contains(vecino)){
                            changeCellState(2,vecino.getRow(),vecino.getCol());
                            TimeUnit.MILLISECONDS.sleep(this.delay);    
                        }
                        
                        if(camino.contains(vecino)){
                            vecino.setDistance( (vecino.getDistance() + (float) Math.pow(dist,camino.stream().filter(p -> p.equals(vecino)).count())));
                        }
                    }
            }
            actual = minim.get(0);
            
            for(int i = 0; i < minim.size(); i++){
                Node j = minim.get(i);
                if(j.getDistance() < actual.getDistance()){
                    actual = j;
                }
            }
            
            minim.clear();
            camino.add(actual);
            changeCellState(1,actual.getRow(),actual.getCol());//ACTUAL VISITADO
            TimeUnit.MILLISECONDS.sleep(this.delay);
            control++;
            operations++;
        }
        
    }
    
    /**
     * Djikstra Algorithm
     * @param graph
     * @param start
     * @throws InterruptedException
     */
    public void Dijkstra(Graph graph, Node start) throws InterruptedException{
        for(int i = 0; i < graph.getNumNodes(); i++){
            Node n = graph.getNode(i);
            n.setDistance(Float.POSITIVE_INFINITY);
        }
        
        ArrayList<Node> visitados = new ArrayList();
        
        PriorityQueue<Node> cua = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if(a.getDistance() < b.getDistance()) return -1;
                if(a.getDistance() > b.getDistance()) return 1;
                return 0;
            }
        });
        
        start.setDistance(0);
        cua.add(start);
        
        while(!cua.isEmpty()){
            Node actual = cua.poll();
            visitados.add(actual);
            changeCellState(1,actual.getRow(),actual.getCol());
            TimeUnit.MILLISECONDS.sleep(this.delay);
            
            if(actual.getValue() == 2){
                getPath(new ArrayList(), actual);
                return;
            }
            
            for(int i = 0; i < actual.getNeighbours().size(); i++){
                Node vecino = actual.getNeighbours().get(i);
                
                if(vecino.getValue() != 1){
                    float peso = this.calculateCost(actual, vecino);
                    
                    if(vecino.getDistance() > actual.getDistance() + peso){
                        vecino.setDistance(actual.getDistance()+peso);
                        vecino.setFather(actual);
                        changeCellState(2,vecino.getRow(),vecino.getCol());
                        TimeUnit.MILLISECONDS.sleep(this.delay);    
                        cua.add(vecino);
                    }
                }
            }
            
            changeCellState(3,actual.getRow(),actual.getCol());//ACTUAL VISITADO
            TimeUnit.MILLISECONDS.sleep(this.delay);
            operations++;
            
        }
        
    }
    
    private ArrayList getPath(ArrayList list, Node node) throws InterruptedException{
        list.add(node);
        this.pathLength++;
        operations++;
        
        if(node.getFather() == null){
            changeCellState(4,node.getRow(),node.getCol());
            TimeUnit.MILLISECONDS.sleep(10);
            return list;
        }
        
        changeCellState(4,node.getRow(),node.getCol());
        TimeUnit.MILLISECONDS.sleep(10);
        getPath(list, node.getFather());
        
        return list;
    }
    
    private float manhattanDistance(Node a, Node b){
        return Math.abs(a.getRow() - b.getRow()) + Math.abs(a.getCol() - b.getCol());
    }
    
    private float  chebyshevDistance(Node a, Node b){
        int dx = Math.abs(a.getRow() - b.getRow());
        int dy = Math.abs(a.getCol() - b.getCol());
        
        return 1 * (dx + dy) + (1 - 2 * 1) * Math.min(dx, dy);
    }
    
    private float  octileDistance(Node a, Node b){
        int dx = Math.abs(a.getRow() - b.getRow());
        int dy = Math.abs(a.getCol() - b.getCol());
        
        return (float)(1 * (dx + dy) + (Math.sqrt(2) - 2 * 1) * Math.min(dx, dy));
    }
    
    private float euclideanDistance(Node a, Node b){
        int dx = Math.abs(a.getRow() - b.getRow());
        int dy = Math.abs(a.getCol() - b.getCol());
        
        return (float) Math.sqrt(dx * dx + dy * dy);
    }
    
    private float calculateCost(Node a, Node b){
        if(Math.abs(a.getRow() - b.getRow()) == 1 && Math.abs(a.getCol() - b.getCol()) == 1){
            return 1.f;
        }
        
        return 1.f;
    }
    
}
