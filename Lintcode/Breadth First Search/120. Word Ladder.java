public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        
        if(dict == null) return 0;
        if(start.equals(end)) return 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        dict.add(end);
        int length = 1;
        while(! queue.isEmpty()){
        	length++; // depend on when you want to return the result -- length
        	int size = queue.size(); // level traverse
        	for(int i = 0; i < size; i++){
        		String head = queue.poll();
        		for(String nextString : getNextStrings(dict, head)){

            		if(nextString.equals(end)) return length;
        			if(visited.contains(nextString)) continue;

        			queue.offer(nextString);
        			visited.add(nextString);
        		}
        	}
        }
        return 0;
    }

    private ArrayList<String> getNextStrings(Set<String> dict, String curt){
    	// change one digit only and newString in dict
    	ArrayList<String> group = new ArrayList<>();

    	for(char c = 'a'; c < 'z'; c++){
    		for(int i = 0; i < curt.length(); i++){
    			String newString = replace(curt, i, c);
    			if(dict.contains(newString)) group.add(newString);
    		}
    	}

    	return group;
    }

    private String replace(String s, int index, char c){

    	char[] chars = s.toCharArray();
    	chars[index] = c;
    	return new String(chars);
    }
        

}