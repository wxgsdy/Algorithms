class Solution {
    
    
    private int[] father;
    private int size;
    private String[] initial;  // initial index -> user name 
    
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        this.size = accounts.size();
        initial = new String[accounts.size()];
        father = new int[accounts.size()];
        Map<String, List<Integer>> EmailtoIds = getEmailtoIds(accounts);
        
        for(String email : EmailtoIds.keySet()){
            List<Integer> ids = EmailtoIds.get(email);
            if(ids.size() >= 2){
                for(int i = 1; i < ids.size(); i++){
                    union(ids.get(0), ids.get(i));
                    size--;
                }
            }
        } 
        
        
        // build result List
        Map<Integer, Set<String>> IdtoEmailSet = new HashMap<>(); // id -> set of emials 
        for(int i = 0; i < father.length; i++){            
            int curtFather = find(i);
            if(!IdtoEmailSet.containsKey(curtFather)) IdtoEmailSet.put(curtFather, new HashSet<String>());           
            for(int j = 1; j < accounts.get(i).size(); j++){
                IdtoEmailSet.get(curtFather).add(accounts.get(i).get(j));
            }            
        }
        
        // System.out.print(IdtoEmailSet.get(2));
        
        // build result 
        List<List<String>> result = new ArrayList<>();
        for(Integer id : IdtoEmailSet.keySet()){
            String user = initial[id];
            List<String> emails = new ArrayList<>(IdtoEmailSet.get(id));
            Collections.sort(emails);
            emails.add(0, user);
            result.add(emails);
        }
        
        return result;    
        
        
    }
    
    
    private Map<String, List<Integer>> getEmailtoIds(List<List<String>> accounts){        
        Map<String, List<Integer>> email2id = new HashMap<>();
        
        for(int i = 0; i < accounts.size(); i++){
            List<String> element = accounts.get(i);            
            initial[i] = element.get(0);
            father[i] = i;
            String email = null;
            for(int j = 1; j < element.size(); j++){
                email = element.get(j);
                if(email2id.containsKey(email)) email2id.get(email).add(i);
                else{
                    email2id.put(email, new ArrayList<>());
                    email2id.get(email).add(i);
                }
            }            
        }
        return email2id;
    }    
    private int find(int a){
        List<Integer> path = new ArrayList<>();
        path.add(a);
        while(father[a] != a){
            a = father[a];
            path.add(a);
        }
        
        for(Integer node : path){
            father[node] = a;
        }
        
        return a;
        
    }
    private void union(int a, int b){
        int father_a = find(a);
        int father_b = find(b);
        if(father_a != father_b){
            father[father_a] = father_b;
        }
        
    }
    
    
}


