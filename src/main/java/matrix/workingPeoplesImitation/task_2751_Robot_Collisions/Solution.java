package matrix.workingPeoplesImitation.task_2751_Robot_Collisions;

import java.util.*;

// my solution
public class Solution {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> robotList = new ArrayList<>(n);
        Set<Integer> idSet = new HashSet<>();
        Map<Integer, Robot> idRobotMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Robot robot = new Robot(i, positions[i], healths[i], directions.charAt(i));
            robotList.add(robot);
            idSet.add(i);
            idRobotMap.put(i, robot);
        }
        robotList.sort(Comparator.comparingInt(r -> r.position));

        Stack<Robot> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            Robot robot = robotList.get(i);
            if (stack.empty()) {
                stack.push(robot);
                continue;
            }
            Robot prev = stack.peek();
            if (robot.direction == prev.direction || robot.direction == 'R') {
                stack.push(robot);
                continue;
            }
            while (robot.direction != prev.direction) {
                if (robot.health < prev.health) {
                    prev.health--;
                    idSet.remove(robot.id);
                    break;
                } else if (robot.health == prev.health) {
                    stack.pop();
                    idSet.remove(prev.id);
                    idSet.remove(robot.id);
                    break;
                }
                stack.pop();
                robot.health--;
                idSet.remove(prev.id);
                if (stack.empty()) {
                    stack.push(robot);
                    break;
                } else {
                    prev = stack.peek();
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Robot robot = idRobotMap.get(i);
            if (idSet.contains(robot.id)) result.add(robot.health);
        }
        return result;
    }

    static class Robot {
        int id;
        int position;
        int health;
        char direction;

        public Robot(int id, int position, int health, char direction) {
            this.id = id;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Robot robot = (Robot) o;
            return id == robot.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}
