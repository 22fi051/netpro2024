package kadaiC;

import java.io.Serializable;

public class TaskObject implements ITTask, Serializable {
    private long execNumber;
    private long result;

    @Override
    public void setExecNumber(long x) {
        this.execNumber = x;
    }

    public long getExecNumber() {
        return this.execNumber;
    }

    @Override
    public void exec() {
        for (long i = execNumber; i >= 2; i--) {
            if(isPrime(i)){
                this.result = i;
                break;
            }
        }

    }

    @Override
    public long getResult() {
        return this.result;
    }

    private boolean isPrime(long n) {
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
