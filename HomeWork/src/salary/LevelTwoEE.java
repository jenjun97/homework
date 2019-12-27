package salary;

import salary.LevelOneEE;

public class LevelTwoEE extends Employee {

    private int lunch, bonus;

    public LevelTwoEE(String Name, String Sex, String JobDate, String Tel, String Add) {
        super(Name, Sex, JobDate, Tel, Add);
    }

    public LevelTwoEE(String Name, String Sex, String JobDate, String Tel, String Add, int OverTime) {
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
        setBonus(3000);
        System.out.println("午餐津貼：" + getLunch());
        System.out.println("職務加給：" + getBonus());
        System.out.println("本月薪資：" + (getBasePay() + getOverTimeSalary() + getLunch() + getBonus()));
    }

// -------------------------------------------下列為set, get
    public int getLunch() {
        return lunch;
    }

    public void setLunch(int lunch) {
        this.lunch = lunch;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}
