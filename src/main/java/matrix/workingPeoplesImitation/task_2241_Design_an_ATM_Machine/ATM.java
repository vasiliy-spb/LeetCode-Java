package matrix.workingPeoplesImitation.task_2241_Design_an_ATM_Machine;

// my solution
public class ATM {
    private final int[] banknotes;
    private final int[] value;

    public ATM() {
        this.banknotes = new int[5];
        this.value = new int[]{20, 50, 100, 200, 500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            banknotes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] cash = new int[5];
        for (int i = 4; i >= 0; i--) {
            if (banknotes[i] == 0) {
                continue;
            }
            int count = amount / value[i];
            if (count > banknotes[i]) {
                count = banknotes[i];
            }
            amount -= value[i] * count;
            cash[i] = count;
        }

        if (amount > 0) {
            return new int[]{-1};
        }

        for (int i = 0; i < 5; i++) {
            banknotes[i] -= cash[i];
        }
        return cash;
    }
}
