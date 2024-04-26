import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HeikinCKadai {

    public static void main(String[] args) {
        Map<Integer, Integer> students = new HashMap<>();
        int StudentNumber = 100;
        int avreage;
        int total = 0;
        Random rand = new Random();

        for (int i = 1; i <= StudentNumber; i++) {
            int n = rand.nextInt(101);
            students.put(i,n);
            total += n;
        }

        avreage = total / StudentNumber;
        System.out.println("平均点:" + avreage);
        System.out.println("以下合格者の点数です。");

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(students.entrySet());

        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() >= 80) {
                System.out.println(entry.getValue() + " :学籍番号 " + entry.getKey());
            }
        }

    }

}
