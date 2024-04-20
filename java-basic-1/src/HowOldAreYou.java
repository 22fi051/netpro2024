import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class HowOldAreYou {

    private static TreeMap<Integer, String> eraMap = new TreeMap<>();

    static {
        eraMap.put(1869, "明治");
        eraMap.put(1912, "大正");
        eraMap.put(1926, "昭和");
        eraMap.put(1989, "平成");
        eraMap.put(2019, "令和");
    }

    public static String getEra(int year) {
        Integer eraYear = eraMap.floorKey(year);
        if (eraYear == null) {
            return "不明";
        } else {
            Integer birthEraYear = year - eraYear + 1;
            if(birthEraYear == 1) {
                return eraMap.get(eraYear) + "元";
            }else {
                return eraMap.get(eraYear) + birthEraYear;
            }
            
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int counter=1;
		int birthyear=0;
		int age=0;

		while(true) {
		try {
			System.out.println("========="+(counter++)+"回目の質問");
			System.out.println("あなたは今何歳ですか?");
			String line = reader.readLine();
			if(line.equals("q")||line.equals("e")){
				System.out.println("終了します");
				break;
			}
			
			age = Integer.parseInt(line);
			if(age < 0 || age >= 120) {
                System.out.println("もう一度入力してください");
            }else {
                birthyear = 2024 - age;
                System.out.println("2030年には、" + (age + 6) + "歳ですね。");
                System.out.println("あなたは" + getEra(birthyear) + "年生まれですね。");
            }
            
		}
		catch(IOException e) {
			System.out.println(e);
		}
        }
    }

}
