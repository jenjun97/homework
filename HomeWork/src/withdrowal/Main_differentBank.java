package withdrowal;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_differentBank {

    public static void main(String[] args) {
        account act = new account(1000); // 新增帳戶，並預存金額
        user u1 = new user(act, 100); // 新增取款者及取款金額
        user u2 = new user(act, 50);

        RichFather father = new RichFather(act); // 新增存款者
        father.setName("富爸爸"); // 設定存款者名稱
        father.start();

        bank b1 = new bank(u1); // 新增銀行1
        bank b2 = new bank(u2); // 新增銀行2

        b1.setName("喬治"); // 設定取款者名稱
        b2.setName("瑪莉");

        b1.start();
        b2.start();

    }
}

// ----------------------------------------- 共用帳戶
class account {

    public int money;

    public account(int i) { // 建構子，預設帳戶金額
        money = i;
    }

}

// ----------------------------------------- 取款人
class user {

    public account act; // 共用帳戶
    public int take; // 取款金額

    public user(account a, int j) { // 建構子，設定共同帳戶及取款金額
        act = a;
        take = j;
    }
}

// ----------------------------------------- 銀行
class bank extends Thread {

    public user user; // 取款者

    public bank(user u) { // 建構子，設定取款者
        user = u;
    }

    public void withdrow() { // 取款
        if (user.act.money >= user.take) { // 如果餘額>=提款金額
            System.out.print("現餘存款 =" + user.act.money + " " + Thread.currentThread().getName() + " 提款 =" + user.take);
            user.act.money = user.act.money - user.take; // 餘額 = 餘額 - 提款
            System.out.println(" 戶頭餘額 =" + user.act.money);
            if (user.act.money < user.take || user.act.money == 0) { // 檢查餘額是否足夠
                System.out.println("戶帳餘額為0，notifyAll富爸爸及所有人");
                user.act.notifyAll();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "發現沒有錢了，進入wait");
            try {
                user.act.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(bank.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (user.act) { // 以帳戶物件為同步對像
                try {
                    sleep(50); // 慢0.05秒比較容易讓二者同步取款
                    withdrow(); // 取款
                } catch (InterruptedException ex) {
                    Logger.getLogger(bank.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

// ----------------------------------------- 富爸爸
class RichFather extends Thread {

    public account act; // 共用帳戶

    public RichFather(account a) { // 建構子，設定共用帳戶去存款
        act = a;
    }

    @Override
    public void run() {
        deposit(); // 存款
    }

    public void deposit() { // 存款
        while (true) {
            synchronized (act) { // 設定帳戶為同步物件
                if (act.money == 0) { // 如果餘額為0
                    act.money = 1000; // 存款1000
                    System.out.println(Thread.currentThread().getName() + "發現沒有錢，存1000，並notify帳戶有錢了");
                    act.notify();
                } else {
                    System.out.println(Thread.currentThread().getName() + "查看帳戶還有錢，進入wait");
                    try {
                        act.wait();
                        System.out.println("富爸爸收到通知，解除wait");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RichFather.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

}
