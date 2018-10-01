public class ConnectingGraph {
    /*
    * @param n: An integer
    */
    
    private int[] father;
    
    public ConnectingGraph(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            father[i] = i;
        }
    }
    
    private int find(int node){
        
        // exit
        if(father[node] == node) return node;
        else return find(father[node]);
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int father_a = find(a);
        int father_b = find(b);
        if(father_a != father_b) father[father_a] = father_b;
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        int father_a = find(a);
        int father_b = find(b);
        return father_a == father_b;
    }
}