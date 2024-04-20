import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderExample {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\mono2\\OneDrive\\ドキュメント\\デスクトップ\\address.csv"; // ファイルのパスを指定してください
        String line = "";
        String csvSplitBy = ","; // CSVファイルの区切り文字を指定してください
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    // 1行をカンマで分割して単語の配列を取得
                    String[] words = line.split(csvSplitBy);
        
                    // 区だけを出力
                    for (int i = 3; i < words.length; i += 5) {
                        System.out.println(words[i]);
                    }
                }//while end
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//main end

}//class end
