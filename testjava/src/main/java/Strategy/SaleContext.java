package Strategy;

/**
 * Created by  wlp on 2018/8/21.
 */

public class SaleContext {
    private Strategy strategy;

    public SaleContext(String type) {

        switch (type) {
            case "A":
                strategy = new StrategyA();
                break;
            case "B":
                strategy = new StrategyB();
                break;
        }

    }

    public void salecontextshow() {
        strategy.show();
    }

}
