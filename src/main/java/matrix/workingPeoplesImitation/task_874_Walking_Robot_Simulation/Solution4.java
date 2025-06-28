package matrix.workingPeoplesImitation.task_874_Walking_Robot_Simulation;

// from leetcode code sample
public final class Solution4 {
    private static final int[] X_DELTAS = {0, -1, 0, 1};
    private static final int[] Y_DELTAS = {1, 0, -1, 0};

    public static int robotSim(int[] commands, int[][] obstacles) {
        int[] hashtable = new int[(obstacles.length << 2) | 0x1];
        for (int[] obstacle : obstacles) {
            add(hashtable, obstacle[0], obstacle[1]);
        }

        int x = 0;
        int y = 0;
        int dirIndex = 0;

        int maxDistSq = 0;
        for (int command : commands) {
            if (command < 0) {
                int dirDelta = (command << 1) | 0x1; // 2 LSBs are 0x1 for a left turn, 0x3 for a right turn
                dirIndex = (dirIndex + dirDelta) & 0x3; // "& 0x3" is the same as "% 4"
                continue;
            }

            // Move forward until we take all the steps or hit an obstacle.
            int xDelta = X_DELTAS[dirIndex];
            int yDelta = Y_DELTAS[dirIndex];
            for (int i = 0; i < command; i++) {
                x += xDelta;
                y += yDelta;
                if (contains(hashtable, x, y) != 0) {
                    x -= xDelta;
                    y -= yDelta;
                    break;
                }
            }

            int distSq = x * x + y * y;
            maxDistSq = Math.max(maxDistSq, distSq);
        }
        return maxDistSq;
    }

    private static void add(int[] hashtable, int x, int y){
        int code = (x << 16) | (y + 30001);

        // Map the code to a hashcode, using linear chaining
        int capacity = hashtable.length;
        int hashcode = code % capacity;
        hashcode += capacity & (hashcode >> 31); // "code % capacity" is negative if code is "negative"
        while (hashtable[hashcode] != 0) {
            hashcode = (hashcode + 1) % capacity;
        }
        hashtable[hashcode] = code;
    }

    /** Determines if the hashtable contains a coordinate, returning a non-zero number if so. */
    private static int contains(int[] hashtable, int x, int y) {
        // Calculate a non-zero code that is unique for each coordinate.
        int code = (x << 16) | ((y + 30001) & 0xFFFF);

        // Map the code to a hashcode, using linear chaining.
        int capacity = hashtable.length;
        int hashcode = code % capacity;
        hashcode += capacity & (hashcode >> 31);
        int storedCode = hashtable[hashcode];
        while ((storedCode != 0) && (storedCode != code)) {
            hashcode = (hashcode + 1) % capacity;
            storedCode = hashtable[hashcode];
        }
        return storedCode;
    }
}
