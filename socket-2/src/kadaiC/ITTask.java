package kadaiC;

public interface ITTask {
    public void setExecNumber(long x);//クライアントで最初に計算させる数字を入力しておく関数
    public void exec();//サーバで計算を実行をさせる関数...計算アルゴリズムが記載される。下記アルゴリズムを参照のこと
    public long getResult();//クライアントで結果を取り出す関数

}
