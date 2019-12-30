package receipt;

import java.util.Scanner;
import receipt.CheckKeyin;
import static receipt.CheckKeyin.CheckKeyin;
import static receipt.WinNumeral.CheckWinNumeral;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String keyin; // 輸入的字串
        String status = ""; // 預設執行狀態
        do {
            System.out.print("請輸入發票號碼至少3位數，或輸入0離開：");
            keyin = sc.nextLine();
            status = CheckKeyin(keyin); // 檢查字串為，3-8位，數字，或0離開
            if (status.equals("continue")) {
                CheckWinNumeral("SpecialNum", keyin); // 比對中獎號碼
            }
        } while (!status.equals("exit"));
    }

}
