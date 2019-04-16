package TestProxy;

public class Owner implements TradeProtocol{

    @Override
    public void sellHouse(int money) {
        System.out.println("我是房主，中介告诉我：房子卖了"+money+"块钱");
    }

}