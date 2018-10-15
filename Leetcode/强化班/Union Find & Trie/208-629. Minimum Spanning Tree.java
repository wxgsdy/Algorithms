/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
public class Solution {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
     
    private Comparator<Connection> cmpt = new Comparator<Connection>(){
        
        public int compare(Connection left, Connection right){
            if(left.cost != right.cost) return left.cost - right.cost;
            if(!left.city1.equals(right.city1)) return left.city1.compareTo(right.city1);
            else return left.city2.compareTo(right.city2);
        }
        
    };
    private int find(int[] father, int index){
        if(father[index] == 0) return index;
        else return find(father, father[index]);
    }
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        // sort
        Collections.sort(connections, cmpt);
        
        // get hash encode for city name
        Map<String, Integer> hash = new HashMap<>();
        int n = 0;
        for(Connection curt : connections){
            if(!hash.containsKey(curt.city1)) hash.put(curt.city1, ++n);
            if(!hash.containsKey(curt.city2)) hash.put(curt.city2, ++n);
        }
        
        int[] father = new int[n + 1];
        List<Connection> results = new ArrayList<>();
        for(Connection temp : connections){
            int code1 = hash.get(temp.city1);
            int code2 = hash.get(temp.city2);
            int father1 = find(father, code1);
            int father2 = find(father, code2);
            if(father1 != father2){
                father[father1] = father2;
                results.add(temp);
            }
        }
        
        return results.size() == n - 1 ? results : new ArrayList<Connection>();
        
        
    }
    
}