class Solution {
    
    List<String> res;
    public List<String> findItinerary(String[][] tickets) {
        // PriorityQueue<String> minH = new PriorityQueue<>();
        
        res = new ArrayList<String>();
        if(tickets == null || tickets.length == 0) return res;
        
        Map<String, Queue<String>> map = new HashMap<>();
        // build directed graph: Map<String, Queue>
        for(int i = 0; i < tickets.length; i++){
            String u = tickets[i][0], v = tickets[i][1]; // u -> v
            if(!map.containsKey(u)) map.put(u, new PriorityQueue<String>());            
            map.get(u).add(v);
        }  
        
        dfsHelper(map, "JFK");
        
        Collections.reverse(res);
        return res;
    }
    
    private void dfsHelper(Map<String, Queue<String>> map, String curt){
        
        while(map.containsKey(curt) && !map.get(curt).isEmpty()){
            String temp = map.get(curt).poll();
            dfsHelper(map, temp);
        }
        
        res.add(curt);
    }
}