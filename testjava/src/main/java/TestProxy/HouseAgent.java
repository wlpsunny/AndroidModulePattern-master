package TestProxy;

public class HouseAgent implements TradeProtocol {
    private TradeProtocol mHouseProtocol;

    public HouseAgent(TradeProtocol houseProtocol){
        mHouseProtocol=houseProtocol;
    }
    @Override
    public void sellHouse(int money) {
        System.out.println("我是中介，业主的房子卖了"+money+"块钱");
        mHouseProtocol.sellHouse(money);
    }

}