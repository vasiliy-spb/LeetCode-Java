package matrix.workingPeoplesImitation.task_2069_Walking_Robot_Simulation_II;

public class Robot {
    private final int width;
    private final int height;
    private int x;
    private int y;
    private final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private final String[] dirNames = {"East", "North", "West", "South"};
    private int indexDir = 0;
    private boolean moved = false;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
    }

    public void step(int num) {
        moved = true;
        num %= 2 * (width + height) - 4;
        while (num > 0) {
            x += dirs[indexDir][0];
            y += dirs[indexDir][1];
            if (x < 0 || y < 0 || x >= width || y >= height) {
                x -= dirs[indexDir][0];
                y -= dirs[indexDir][1];
                indexDir++;
                indexDir %= 4;
                num++;
            }
            num--;
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (!moved) {
            return dirNames[0];
        }
        if (x == 0 && y == 0) {
            return dirNames[3];
        }
        if (x == 0 && y == height - 1) {
            return dirNames[2];
        }
        if (x == width - 1 && y == 0) {
            return dirNames[0];
        }
        if (x == width - 1 && y == height - 1) {
            return dirNames[1];
        }
        if (x == 0) {
            return dirNames[3];
        }
        if (x == width - 1) {
            return dirNames[1];
        }
        if (y == 0) {
            return dirNames[0];
        }
        if (y == height - 1) {
            return dirNames[2];
        }
        return "";
    }
}

/*

My previous solution (WA)

class Robot {

    int width;
    int height;
    int x;
    int y;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    String[] dirNames = {"East", "North", "West", "South"};
    int indexDir = 0;
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
    }

    public void step(int num) {
        num %= 2 * (width + height) - 4;
        while (num > 0) {
            x += dirs[indexDir][0];
            y += dirs[indexDir][1];
            if (x < 0 || y < 0 || x >= width || y >= height) {
                x -= dirs[indexDir][0];
                y -= dirs[indexDir][1];
                indexDir++;
                indexDir %= 4;
                num++;
            }
            num--;
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return dirNames[indexDir];
    }
}
 */