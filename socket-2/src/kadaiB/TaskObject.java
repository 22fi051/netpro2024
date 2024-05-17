package kadaiB;

import java.io.Serializable;

public class TaskObject implements ITTask, Serializable {
    private int execNumber;
    private int result;

    @Override
    public void setExecNumber(int x) {
        this.execNumber = x;
    }

    public int getExecNumber() {
        return this.execNumber;
    }

    @Override
    public void exec() {
        for (int i = execNumber; i >= 2; i--) {
            if(isPrime(i)){
                this.result = i;
                break;
            }
        }

    }

    @Override
    public int getResult() {
        return this.result;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}
