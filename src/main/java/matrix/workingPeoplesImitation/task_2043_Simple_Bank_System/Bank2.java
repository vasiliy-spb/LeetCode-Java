package matrix.workingPeoplesImitation.task_2043_Simple_Bank_System;

// from walkccc.me
public class Bank2 {
    private long[] balance;

    public Bank2(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValid(account2))
            return false;
        return withdraw(account1, money) && deposit(account2, money);
    }

    public boolean deposit(int account, long money) {
        if (!isValid(account))
            return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValid(account))
            return false;
        if (balance[account - 1] < money)
            return false;
        balance[account - 1] -= money;
        return true;
    }

    private boolean isValid(int account) {
        return 1 <= account && account <= balance.length;
    }
}
