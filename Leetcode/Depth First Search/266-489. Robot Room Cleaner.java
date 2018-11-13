/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    
    private Set<String> visited;
    private int[] deltaX = new int[]{-1, 0, 1, 0};
    private int[] deltaY = new int[]{0, 1, 0, -1};
    
    public void cleanRoom(Robot robot) {
        
        visited = new HashSet<String>();
        dfsHelper(robot, 0, 0, 0);
        
    }
    
    
    private void dfsHelper(Robot robot,
                           int curtX, 
                           int curtY,
                           int curtDir){
        
        String curt = curtX + "-" + curtY;
        if(visited.contains(curt)) return;
        
        // not visited before, clean current cell
        visited.add(curt);
        robot.clean();
        
        
        // 4 directions
        for(int i = 0; i < 4; i++){
            
            if(robot.move()){
                dfsHelper(robot, curtX + deltaX[curtDir], curtY + deltaY[curtDir], curtDir);
                // come back to previous cell and remain the coming direction
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            
            // switch direction
            robot.turnRight();
            curtDir += 1;
            curtDir %= 4;
        }
    }
}