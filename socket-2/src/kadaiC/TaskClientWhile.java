package kadaiC;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            while(true) {

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                System.out.print("計算させる整数を入力してください → ");
                long x = scanner.nextInt();
                if (x <= 1) {
                    scanner.close();
                    oos.close();
                    socket.close();
                    System.out.println("終了します");
                    break;
                }

                TaskObject task = new TaskObject();
                task.setExecNumber(x);

                oos.writeObject(task);
                oos.flush();

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                TaskObject result = (TaskObject) ois.readObject();

                System.out.println(x + "以下の最大の素数は" + result.getResult() + "です");

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
