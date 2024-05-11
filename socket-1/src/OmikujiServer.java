import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OmikujiServer {
    private static final int times = 2;

    private static String serverProcess(String name) {
        String[] omikuji = { "大吉", "中吉", "小吉", "吉", "凶", "大凶" };
        return name + "さんの運勢は" + omikuji[(int) (Math.random() * omikuji.length)] + "です";
    }

    public static void main(String[] args) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            Omikuji omikuji = (Omikuji) ois.readObject();

            String name = omikuji.getName();
            System.out.println(name + "さんからの入力を受け取りました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            Omikuji response = new Omikuji();
            response.setName(serverProcess(name));

            oos.writeObject(response);
            oos.flush();
                
            ois.close();
            oos.close();
            // socketの終了。
            socket.close();
            server.close();
            
            
        }
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }

}
