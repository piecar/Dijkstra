/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author pieca
 */
public class Dijkstra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        class AdjEle{
            private int vert;
            private int dist;
            
            AdjEle(int vert, int dist){
                this.vert = vert;
                this.dist = dist;
            }
            
            int getVert(){
                return vert;
            }     
            int getDist(){
                return dist;
            }
            
        }
        class Node implements Comparable {
            private int vert;
            private int dist;
            private int parent;
            
            Node(int key){
                this.vert = key;
                this.dist = Integer.MAX_VALUE;
                this.parent = 0;
            }
            
            int getVert(){
                return vert;
            }     
            int getDist(){
                return dist;
            }
            int getParent(){
                return parent;
            }
            void setDist(int dist){
                this.dist = dist;
            }
            void setParent(int parent){
                this.parent = parent;
            }

            @Override
            public int compareTo(Object o) {
                Node temp = (Node) o;
                if (dist > temp.getDist())
                    return 1;
                else if (dist == temp.getDist())
                    return 0;
                else
                    return -1;
            }
        }
        
        System.out.print("STDIN: ");
        //Scanner scan = new Scanner(System.in);   
        Scanner scan = new Scanner(new File("SampleInput.txt"));
        int numGraphs = scan.nextInt();
        for(int i=1; i <= numGraphs; i++)
        {
            int numVerts = scan.nextInt();
            int numEdges = scan.nextInt();
            ArrayList[] adjList = new ArrayList[numVerts+1];
            ArrayList visitedNodes = new ArrayList();
            Node[] nodes = new Node[numVerts+1];
            PriorityQueue<Node> pQueue = new PriorityQueue(numVerts);
            
            //Populate adjacency list with linked lists
            for(int j=1; j <= numVerts; j++)
            {
                ArrayList adjVerts = new ArrayList();
                adjList[j] = adjVerts;
                nodes[j] = new Node(j);
            }
            
            // Create adjacency List with all nodes initilized to white
            for(int j=1; j <= numEdges; j++)
            {
                int x = scan.nextInt();
                int y = scan.nextInt();
                int dist = scan.nextInt();
                
                
                adjList[x].add(new AdjEle(y, dist));
                adjList[y].add(new AdjEle(x, dist));
            }
            
            int startNode = scan.nextInt();
            nodes[startNode].setDist(0);            
            // Add all the nodes into the priority queue
            for(int j =1; j <= numVerts; j++)
            {
                pQueue.add(nodes[j]);
            }
            
            //Start traversing shortest paths
            while(!pQueue.isEmpty())
            {
                Node curr = pQueue.poll();
                visitedNodes.add(curr);
            }
        }
    }
    
}
