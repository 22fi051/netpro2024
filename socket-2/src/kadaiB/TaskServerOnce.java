package kadaiB;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TaskServerOnce {

    private static int serverProcess(int x) {
        return x;
    }
    public static void main(String[] args) {
        try {
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
            TaskObject task = (TaskObject) ois.readObject();

            System.out.println("受信しました。計算を実行します......");
            System.out.println("受信した数：" + task.getExecNumber());

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            TaskObject response = new TaskObject();
            response.setExecNumber(serverProcess(task.getExecNumber()));
            response.exec();
            System.out.println("計算結果は" + response.getResult() + "です");


            oos.writeObject(response);
            oos.flush();

            // close処理

            oos.close();
            ois.close();
            // socketの終了。
            socket.close();
            server.close();

        }
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        }
        catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }

}
