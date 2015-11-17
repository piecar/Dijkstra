/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 *
 * @author pieca
 */
public class Dijkstra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        class Node implements Comparable {
            private int vert;
            private String color;
            private int dist;
            private int parent;
            
            Node(int key, String val){
                this.vert = key;
                this.color = val;
                this.dist = Integer.MAX_VALUE;
                this.parent = 0;
            }
            
            int getVert(){
                return vert;
            }
            String getColor(){
                return color;
            }            
            int getDist(){
                return dist;
            }
            int getParent(){
                return parent;
            }
            void setColor(String color){
                this.color = color;
            }
            void setDist(int dist){
                this.dist = dist;
            }
            void setParent(int parent){
                this.parent = parent;
            }

            @Override
            public int compareTo(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }
    }
    
}
