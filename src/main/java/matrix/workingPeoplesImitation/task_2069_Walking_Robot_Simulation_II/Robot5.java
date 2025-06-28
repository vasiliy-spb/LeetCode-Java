package matrix.workingPeoplesImitation.task_2069_Walking_Robot_Simulation_II;

// from leetcode code sample (3)
public class Robot5 {

    private int width;
    private int height;
    private int x = 0;
    private int y = 0;
    private int direction = 0;
    private int perimeter;

    public Robot5(int width, int height) {
        this.width = width;
        this.height = height;
        perimeter = 2 * (width + height - 2);
    }

    public void step(int num) {
        num %= perimeter;
        if (num == 0) {
            num = perimeter;
        }
        while (num > 0) {
            if (direction == 0) {
                if (x + num < width) {
                    x += num;
                    num = 0;
                }
                else {
                    int steps = width - x - 1;
                    x = width - 1;
                    num -= steps;
                    direction++;
                }
            }
            else if (direction == 1) {
                if (y + num < height) {
                    y += num;
                    num = 0;
                }
                else {
                    int steps = height - y - 1;
                    y = height - 1;
                    num -= steps;
                    direction++;
                }
            }
            else if (direction == 2) {
                if (x - num >= 0) {
                    x -= num;
                    num = 0;
                }
                else {
                    num -= x;
                    x = 0;
                    direction++;
                }
            }
            else {
                if (y - num >= 0) {
                    y -= num;
                    num = 0;
                }
                else {
                    num -= y;
                    y = 0;
                    direction = 0;
                }
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (direction == 0) {
            return "East";
        }
        else if (direction == 1) {
            return "North";
        }
        else if (direction == 2) {
            return "West";
        }
        else {
            return "South";
        }
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
