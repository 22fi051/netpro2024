import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XmasTreeKadai {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("カンマで区切って入力してください：");
            String line = reader.readLine();
            String[] values = line.split(","); 

            int n = Integer.parseInt(values[0].trim());
            int w = Integer.parseInt(values[1].trim());
            int h = Integer.parseInt(values[2].trim());
            String mark = values[3].trim();
            
            switch (mark) {
                case "a":
                    mark = "@";
                    break;
                case "r":
                    mark = "-";
                    break;
                case "c":
                    mark = "+";
                    break;
                default:
                    mark = " ";
                    break;
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n - i ; j++) {
                    if (j % 2 == 0) {
                        System.out.print(mark);
                    } else {
                        System.out.print(" ");
                    }
                }
                for (int j = 0; j < i * 2 ; j++) {
                    System.out.print("*");
                }
                for (int j = 0; j < n - i ; j++) {
                    if (j % 2 == 0) {
                        System.out.print(mark);
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < n - 2 ; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < w ; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
        } catch (Exception e) {
            System.out.println("エラーが発生しました");
        }
    }
}
