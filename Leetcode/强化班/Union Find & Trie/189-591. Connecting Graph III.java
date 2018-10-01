public class ConnectingGraph3 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
     
    private int size;
    private int[] father;
    
    public ConnectingGraph3(int n){
        this.size = n;
        father = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            father[i] = i;
        }
    }
    
    private int find(int a){
        if(father[a] == a) return a;
        else return find(father[a]);
    }
    
    public void connect(int a, int b) {
        // write your code here
        int father_a = find(a);
        int father_b = find(b);
        if(father_a != father_b){
            father[father_a] = father_b;
            size -= 1;
        }
        
    }
    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return this.size;
    }
}