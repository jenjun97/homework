package withdrowal;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_sameBank {

    public static void main(String[] args) {

        Saccount act = new Saccount(100); // 新增帳戶，預存100
        Sbank bk = new Sbank(act); // 新增一間銀行
        Sfather father = new Sfather(act); // 新增富爸爸

        Suser u1 = new Suser(bk, 3); // 新增取款人到同間銀行取款
        Suser u2 = new Suser(bk, 2);

        u1.setName("喬治"); // 設定取款人名稱
        u2.setName("瑪莉");

        father.start();

        u1.start();
        u2.start();
    }
}

// -----------------------------------------------------------帳戶
class Saccount {

    public int money;

    public Saccount(int i) { // 建構子，設定帳戶金額
        money = i;
    }
}

// -----------------------------------------------------------取款人
class Suser extends Thread {

    Sbank bank; // 同間銀行
    public int take; // 取款金額

    public Suser(Sbank b, int i) { // 建構子，設定同間銀行，各自取款金額
        bank = b;
        take = i;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(50); // 停0.05秒，較容易同步執行
                synchronized (this.bank.act) {
                    bank.Swithdrow(this); // 執行取款
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Suser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

// -----------------------------------------------------------銀行
class Sbank {

    Saccount act; // 共同帳戶

    public Sbank(Saccount a) { // 建構子，設定共同取款帳戶
        act = a;
    }

    public void Swithdrow(Suser user) { // 取款
        if (act.money >= user.take) { // 餘額是否>=提款金額
            System.out.print("原餘額 " + act.money + " " + Thread.currentThread().getName() + "提款= " + user.take);
            act.money = act.money - user.take;
            System.out.println(" 帳戶餘額 =" + act.money);
            if (act.money < user.take || act.money == 0) { // 餘額<提款金額或餘額=0
                act.notify(); // 通知富爸爸
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "發現錢不夠");
            try {
                act.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Sbank.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

// -----------------------------------------------------------富爸爸
class Sfather extends Thread {

    Saccount act; // 存款帳戶

    public Sfather(Saccount a) { // 建構子，設定存款帳戶
        act = a;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (act) {
                deposit(); // 存款
            }
        }
    }

    public void deposit() { // 存款

        if (act.money == 0) { // 檢查帳戶是否為0，若是則存100
            System.out.println("富爸爸存100元");
            act.money = 100;
            act.notify();
        } else {
            System.out.println("富爸爸檢查錢還夠用");
            try {
                act.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Sfather.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
