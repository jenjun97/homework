package bingo;

import java.util.Scanner;

public class BingoStart {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 系統輸入
        KeyinNumber kn = new KeyinNumber(); // 處理輸入值
        String KeyinSr; // user輸入的字串
        String status;
        
        do {
            System.out.print("請輸入4位不重覆數(0離開，1顯示答案)：");
            KeyinSr = sc.nextLine(); // 輸入的字串
            kn.KeyinNumber(KeyinSr); // 將輸入的字串轉成字串陣列
            status = kn.keyinNumberChick(kn.getKeyinNumber()); // 將字串送去檢查，再依回傳值做判斷

            if (status.equals("")) { // 判斷字串是否為空值
                status = ChickAB.chick(kn.getKeyinNumber(), kn.getRandom_4());
            }
            System.out.println("-----------------");
            
        } while (!status.equals("exit")); // 若不是exit，則繼續迴圈
    }
    
}
