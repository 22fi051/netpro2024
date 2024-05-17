public class DinnerFullCource {
    private Dish[] list = new Dish[5];
    public static void main(String[] args) {
        DinnerFullCource fullcourse = new DinnerFullCource();
		fullcourse.eatAll();

    }

    DinnerFullCource() {
        list[0] = new Dish();
        list[0].setName("特選シーザサラダ");
        list[0].setValune(10);

        list[1] = new Dish();
        list[1].setName("コンソメスープ");
        list[1].setValune(2);

        list[2] = new Dish();
        list[2].setName("ムニエル");
        list[2].setValune(20);

        list[3] = new Dish();
        list[3].setName("ステーキ");
        list[3].setValune(30);

        list[4] = new Dish();
        list[4].setName("ショートケーキ");
        list[4].setValune(15);
    }

    void eatAll() {
        String str = "";
        for (Dish dish: list) {
            str += dish.getName() + "=" + dish.getValune() + ",";
        }
        System.out.println("本日のフルコースのメニューは" + str + "です。");
    }

}
