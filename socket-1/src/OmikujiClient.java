import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class OmikujiClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("あなたの運勢を占います");
            

            int counter = 99;
            while(counter-->0) {
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("あなたの名前を入力してください");
                String name = scanner.next();

                if(name.equals("exit")) {
                    scanner.close();
                    oos.close();
                    socket.close();
                    System.out.println("終了します");
                    break;
                }
                

                Omikuji omikuji = new Omikuji();
                omikuji.setName(name);

                oos.writeObject(omikuji);
                oos.flush();

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                Omikuji unnsei = (Omikuji) ois.readObject();

                String replayName = unnsei.getName();
                System.out.println(replayName);
                //ois.close();
            }
        }
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }

}
