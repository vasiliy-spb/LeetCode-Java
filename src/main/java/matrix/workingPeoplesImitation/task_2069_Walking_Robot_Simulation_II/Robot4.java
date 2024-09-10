package matrix.workingPeoplesImitation.task_2069_Walking_Robot_Simulation_II;

// from leetcode code sample (2)
public class Robot4 {
    private final int width, height, perimeter, rightTop, leftTop, rightBottom;
    private int steps = 0;
    private boolean started = false; //
    public Robot4(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = (width + height - 2) * 2; // Number of steps to go around a circle.
        this.rightBottom = width - 1; // Number of steps to reach bottom right corner.
        this.rightTop = width + height - 2; // Number of steps to reach top right corner.
        this.leftTop = width * 2 + height - 3; // Number of steps to reach top left corner.
    }
    public void step(int num) {
        if(num == 0) return;
        steps = (steps + num) % perimeter;
        started = true; // Since the initial direction is different from later direction at 0/0, a boolean is needed.
    }
    public int[] getPos() {
        if(steps == 0) return new int[]{0, 0};
        if(steps > 0 && steps <= rightBottom) return new int[]{steps, 0};
        if(steps > rightBottom && steps <= rightTop) return new int[]{width -1, steps - rightBottom};
        if(steps > rightTop && steps <= leftTop) return new int[]{leftTop - steps , height - 1};
        return new int[]{0, perimeter - steps};
    }
    public String getDir() {
        if(steps > 0 && steps < width) return "East";
        if(steps >= width && steps <= rightTop) return "North";
        if(steps > rightTop && steps <= leftTop) return "West";
        if(steps == 0 && !started) return "East"; // If it's the initial state.
        return "South";
    }
}
