package work.designMode;

public enum SingletonEnum {


    INSTANCE;  // 枚举的唯一实例

    private int money = 10000; // 成员变量

    public void beating() {
        System.out.println("打豆豆 " + money);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
