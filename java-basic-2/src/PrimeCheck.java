import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeCheck {
    public static void main(String[] args) {
        int limit = 100000;
        Map<Integer, List<Integer>> primesMap = new HashMap<>();
        Map<String, Integer> primePairs = new HashMap<>();
        List<Integer> primes = new ArrayList<>();
        
        
        for (int num = 3; num <= limit; num += 2) {
            if (isPrime(num)) {
                primesMap.computeIfAbsent(num % 10, k -> new ArrayList<>()).add(num);
                primes.add(num);
            }
        }
        // 5を素数の配列から削除
        primes.remove(primes.indexOf(5));

        for (int i = 0; i < primes.size() - 1; i++) {
            String key = primes.get(i) % 10 + "->" + primes.get(i + 1) % 10;
            primePairs.put(key, primePairs.getOrDefault(key, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortList = new ArrayList<>(primePairs.entrySet());
        sortList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        for (Map.Entry<Integer, List<Integer>> entry : primesMap.entrySet()) {
            System.out.println("下一桁: " + entry.getKey() + ", 素数: " + entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : sortList) {
            System.out.println("ペア: " + entry.getKey() + ", 回数: " + entry.getValue());
        }


    }
    // 素数判定
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
