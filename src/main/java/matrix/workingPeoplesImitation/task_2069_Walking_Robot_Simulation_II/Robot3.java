package matrix.workingPeoplesImitation.task_2069_Walking_Robot_Simulation_II;

// from leetcode code sample (1)
public class Robot3 {
    int dist;
    int width, height;

    public Robot3(int width, int height) {
        this.width = width;
        this.height = height;
        dist = 0;
    }

    public void step(int num) {
        //move in the direction until either we hit the edge, or we go all num steps.
        dist = (dist + num - 1) % (2 * (width + height - 2)) +  1;
    }

    public int[] getPos() {
        int x = 0, y = 0;
        if ( dist < width ) {
            x = dist;
        } else if ( dist < height + width - 2) {
            x = width - 1;
            y = dist - width + 1;
        }
        else if (dist < 2 * (width - 1) + height) {
            y = height - 1;
            x = 2 * width + height - 3 - dist;
        } else {
            y = 2 * (width + height - 2) - dist;
        }
        return new int[]{x, y};
    }

    public String getDir() {
        //between 0 and width it's east, width +1 and height + width - 1 is north, height + width and height + 2width - 1 is
        if ( dist < width )
            return "East";
        if ( dist < height + width - 1)
            return "North";
        if (dist < 2 * (width - 1) + height )
            return "West";
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
