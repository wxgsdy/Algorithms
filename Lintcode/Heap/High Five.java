/* Description: There are two properties in the node student id and scores, to ensure 
                that each student will have at least 5 points, find the average of 5 highest 
                scores for each person.
*/

/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */

public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {

        // Step 1: get a PriorityQueue for each person
        Map<Integer, PriorityQueue<Integer>> grades = new hashMap<>();
        for(Record term : results){

            if(grades.containskey(term.id))
            {
                if(grades.get(id).size() < 5)
                {// add directly 
                    grades.get(id).add(term.score);
                }

                else if(grades.get(id).peek() < term.score)
                {
                    grades.get(id).poll();
                    grades.get(id).add(term.score);

                }
            } 
            else 
            {// create new pq
                grades.put(term.id, new PriorityQueue<Integer>());
                grades.get(id).add(term.score);
            }
        }


        // Step 2: build the result map: id -> average
        Map<Integer, Double> results = new HashMap<>();
        for(Integer student: grades.keySet()){
            
            PriorityQueue<Integer> pq = grades.get(student);            
            int sum = 0;
            while(!pq.isEmpty()){
                sum = sum + pq.poll();
            }
            results.put(student, sum/5);
        }

        return results;
    }
        
}