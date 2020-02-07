package JF_Receipt;

import java.io.IOException;
import java.util.ArrayList;

public class InputCheckWinNumeral {

    private static String InputString; // 輸入的字串

    public static void CHeck(String str) throws IOException {
        InputString = str;
        Special_Top_Num(); // 比對特別獎和特獎
    }

    // ----------------------------------------------------------- 0特別獎, 1特獎
    private static void Special_Top_Num() throws IOException {
        if (InputString.equals(WinNumeral.WinNumeralArrayListString.get(0).toString())) { // 比對特別獎8碼
            Message.setMessage("特別獎1,000萬元");
            PlayMusic.PlayWin();
        } else if (WinNumeral.WinNumeralArrayListString.get(0).toString().length() >= InputString.length() && WinNumeral.WinNumeralArrayListString.get(0).toString().substring(8 - InputString.length()).equals(InputString)) { // 比對特別獎不滿8碼
            Message.setMessage("可能中獎請重輸");
            PlayMusic.PlayWin();
        } else if (InputString.equals(WinNumeral.WinNumeralArrayListString.get(1).toString())) { // 比對特獎
            Message.setMessage("特獎200萬元");
            PlayMusic.PlayWin();
        } else if (WinNumeral.WinNumeralArrayListString.get(1).toString().length() >= InputString.length() && WinNumeral.WinNumeralArrayListString.get(1).toString().substring(8 - InputString.length()).equals(InputString)) { // 比對特獎不滿8碼
            Message.setMessage("可能中獎請重輸");
            PlayMusic.PlayWin();
        } else {
            Normal_Num(); // 都沒中再去對頭獎
        }
    }

    // ----------------------------------------------------------- 2,3,4頭獎
    private static void Normal_Num() throws IOException {
        /**
         * @先取一組陣列(共3組) 先檢查InputString為幾碼 然後去比對是否中獎
         * @若沒中keyin去掉第1碼 再回去比對
         */
        boolean flag = true; // 跳離巢狀迴圈記號
        for (int i = 2; i < 5 && flag; i++) { // 取每一個array的號碼比對
            String strKeyin = InputString; // 重新取輸入號碼進行比對
            String WinStr = WinNumeral.WinNumeralArrayListString.get(i).toString();
            for (int j = strKeyin.length(); j > 2 && flag; j--) {
                if (WinStr.length() >= strKeyin.length() && WinStr.substring(8 - strKeyin.length()).equals(strKeyin)) { // 對獎號碼與輸入號碼進行比對
                    NormalNumBonus(strKeyin); // 查看中獎獎金
                    flag = false; // 如果有中獎跳離巢狀迴圈
                    PlayMusic.PlayWin();
                } else {
                    strKeyin = strKeyin.substring(1); // 沒有中，輸入字串去前1碼繼續比對
                }
            } // -----Loop 2 end
        } // -----Loop 1 end

        if (flag) { // 如果都沒有中，繼續去比對六獎
            Six_Num(); // 比對六獎
        }
    }

    // -------------------------------------------------- 頭獎獎金
    private static void NormalNumBonus(String str) {
        int i = str.length(); // 中獎號長度
        switch (i) {
            case 8:
                Message.setMessage("頭獎20萬元");
                break;
            case 7:
                Message.setMessage("二獎4萬元");
                break;
            case 6:
                Message.setMessage("三獎1萬元");
                break;
            case 5:
                Message.setMessage("四獎4千元");
                break;
            case 4:
                Message.setMessage("五獎1千元");
                break;
            case 3:
                Message.setMessage("六獎200元");
                break;
        }

    }

    // -------------------------------------------------- 5,6,7增開六獎
    private static void Six_Num() throws IOException {
        boolean flag = true;
        for (int i = 5; i < 8 && flag; i++) {
            if (WinNumeral.WinNumeralArrayListString.get(i).equals(InputString.substring(InputString.length() - 3))) {
                Message.setMessage("六獎200元");
                flag = false;
                PlayMusic.PlayWin();
            }
        }
        if (flag) {
            Message.setMessage("沒中。");
            PlayMusic.PlayLose();
        }
    }

}
