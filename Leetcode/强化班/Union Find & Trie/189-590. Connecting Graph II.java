public class ConnectingGraph2 {
    /*
    * @param n: An integer
    */
    
    private int[] father;
    private int[] size;
    
    public ConnectingGraph2(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        size = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            father[i] = i;
            size[i] = 1;
        }
    }
    
    private int find(int a){
        // find root of node a
        if(father[a] == a) return a;
        else return find(father[a]);
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
        if(father_a != father_b){
            father[father_a] = father_b;
            size[father_b] += size[father_a];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        return size[find(a)];
    }
}