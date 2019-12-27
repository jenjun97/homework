package salary;

public class HR_Salary {

    public static void main(String[] args) {
        Employee e1 = new Employee("a", "aa", "aaa", "aaaa", "aaaaa");
        e1.Print();
        System.out.println("-------------------");
        Employee e2 = new Employee("a", "aa", "aaa", "aaaa", "aaaaa", 10);
        e2.Print();
        System.out.println("-------------------");
        Employee e3 = new LevelTwoEE("b", "bb", "bbb", "bbbb", "bbbbb");
        e3.Print();
        System.out.println("-------------------");
        Employee e4 = new LevelTwoEE("b", "bb", "bbb", "bbbb", "bbbbb", 20);
        e4.Print();
        System.out.println("-------------------");

        Employee e5 = new LevelOneEE("c", "cc", "ccc", "ccc", "cccc");
        e5.Print();
        System.out.println("-------------------");
        Employee e6 = new LevelOneEE("c", "cc", "ccc", "ccc", "cccc", 30);
        e6.Print();
        System.out.println("-------------------");
    }

}
