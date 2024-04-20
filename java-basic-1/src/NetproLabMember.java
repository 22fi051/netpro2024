import java.util.Random;

public class NetproLabMember {
    public static void main(String[] args) {
        int[][] students = new int[15][3];
        Random rand = new Random();
        double totalRatio = 1;
        System.out.println("岩井研に女子学生が来ない確率は以下です");

            for (int i = 0; i < 15; i++) {
                //学生の総数
                students[i][0] = 120 + (rand.nextInt(20) - 10);
                //女性の割合(%)
                students[i][1] = (int) ((int)students[i][0] * (0.2 + i * 0.01));
                //岩井研の人数
                students[i][2] = 10 + rand.nextInt(7) - 3;

                // 男性数を求める
                int men = students[i][0] - (int) (students[i][0] * ((float) students[i][1] / 100));
                // 総数から岩井研の人数を取り出す組み合わせ
                long cpsRatio = combination(students[i][0], students[i][2]);
                // 男性の中から岩井研のメンバーを取り出す組み合わせ
                long menRatio = combination(men, students[i][2]);
                // 岩井研の人数に男性しか入らない割合
                totalRatio *= (double) menRatio / cpsRatio;

            }
            //結果を出力
            System.out.println(totalRatio);
        } // Add this closing curly brace

        public static final long combination(final int n, int r) {
            long num = 1;

            for(int i = 1; i <= r; i++) {
                num = num * (n - i + 1) / i;
            }
            return num;
        }

}
