/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    
    private Map<Integer, Integer> map; // id -> importance
    
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        return dfsHelper(employees, id);
    }
    
    private int dfsHelper(List<Employee> employees, int id){
        
        if(map.containsKey(id)) return map.get(id);
        Employee curt = getEmployee(employees, id);
        if(curt == null) {
            map.put(id, 0);
            return 0;
        }            
        if(curt.subordinates == null || curt.subordinates.size() == 0) {
            map.put(id, curt.importance);
            return curt.importance;
        }
            
        
        // chai jie
        int res = curt.importance;
        for(int next: curt.subordinates){
            res += dfsHelper(employees, next);
        }
        map.put(id, res);
        return res;
    }
    
    private Employee getEmployee(List<Employee> employees, int id){
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).id == id) return employees.get(i);
        }
        return null;
    }
}