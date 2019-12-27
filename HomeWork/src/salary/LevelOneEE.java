package salary;

import salary.LevelTwoEE;

public class LevelOneEE extends LevelTwoEE {

    private int traffic;

    public LevelOneEE(String Name, String Sex, String JobDate, String Tel, String Add) {
        super(Name, Sex, JobDate, Tel, Add);
    }

    public LevelOneEE(String Name, String Sex, String JobDate, String Tel, String Add, int OverTime) {
        super(Name, Sex, JobDate, Tel, Add, OverTime);
    }

    @Override
    public void Print() {
        PrintBase();
        PrintSalary();
    }

    @Override
    public void PrintSalary() {
        setLunch(1800);
        setBonus(5000);
        setTraffic(2000);
        System.out.println("午餐津貼：" + getLunch());
        System.out.println("交通津貼：" + getTraffic());
        System.out.println("職務加給：" + getBonus());
        System.out.println("本月薪資：" + (getBasePay() + getOverTimeSalary() + getLunch() + getBonus() + getTraffic()));
    }

    // -------------------------------------------下列為set, get
    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }
}
