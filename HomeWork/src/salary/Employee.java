package salary;

public class Employee {

    private String Name, Sex, JobDate, Tel, Add;
    private int BasePay = 22000;
    private double OverTimeSalary;

    public Employee(String Name, String Sex, String JobDate, String Tel, String Add) {
        this.Name = Name;
        this.Sex = Sex;
        this.JobDate = JobDate;
        this.Tel = Tel;
        this.Add = Add;
    }

    public Employee(String Name, String Sex, String JobDate, String Tel, String Add, int OverTime) {
        this(Name, Sex, JobDate, Tel, Add);
        setOverTimeSalary(OverTime);
    }

    public void Print() {
        PrintBase();
        PrintSalary();
    }

    public void PrintBase() {
        System.out.println("姓名：" + getName());
        System.out.println("性別：" + getSex());
        System.out.println("到職日：" + getJobDate());
        System.out.println("電話：" + getTel());
        System.out.println("地址：" + getAdd());
        System.out.println("本薪：" + getBasePay());
        if (OverTimeSalary != 0) {
            System.out.println("加班薪資：" + getOverTimeSalary());
        }
    }

    public void PrintSalary() {
        System.out.println("本月薪資：" + (getBasePay() + getOverTimeSalary()));
    }

    // ----------------------------------------------------下列為 get and set
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getJobDate() {
        return JobDate;
    }

    public void setJobDate(String JobDate) {
        this.JobDate = JobDate;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String Add) {
        this.Add = Add;
    }

    public int getBasePay() {
        return BasePay;
    }

    public void seBasePay(int Pay) {
        this.BasePay = Pay;
    }

    public double getOverTimeSalary() {
        return OverTimeSalary;
    }

    public void setOverTimeSalary(double OverVimePay) {
//        this.OverTimeSalary = Math.round(getBasePay() / 240 / 1.5 * OverVimePay * 100.0)/100;
        this.OverTimeSalary = Math.round(getBasePay() / 240 / 1.5 * OverVimePay * 100.0) / 100.0;
    }

}
