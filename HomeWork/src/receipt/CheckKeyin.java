package receipt;

/**
 *
 * @author Jun 至少3位數 最多8位數 必需為數字
 */
public class CheckKeyin {

    static String str;

    static String CheckKeyin(String keyin) {
        str = Exit(keyin); // 檢查是否為0，若不為0回傳continue
        if (str.equals("continue")) {
            KeyinLength3to8(keyin); // 檢查是否為3-8碼
            KeyinIsNumeral(keyin); // 查檢是否為數字
        }
        return str; // 回傳字串continue or exit
    }

    static void KeyinLength3to8(String keyin) { // 檢查是否為3-8碼
        if (keyin.length() < 3 || keyin.length() > 8) {
            System.out.println("錯誤，只能輸入3-8碼數字，請重新輸入。");
            str = "error";
        }
    }

    static void KeyinIsNumeral(String keyin) { // 檢查是否為數字
        String[] strArray = keyin.split(""); // 將字串拆解成array
        String numeral = "0123456789";
        for (String element : strArray) {
            if (numeral.indexOf(element) == -1) { // 檢查字串陣列是否為數字
                System.out.println("錯誤，只能輸入數字，請重新輸入。");
                str = "error";
                break;
            }
        }
    }

    static String Exit(String keyin) { // 檢查輸入是否為0
        String str = "continue";
        if (keyin.equals("0")) { // 字串一位且為0
            str = "exit";
            System.out.println("程式結束");
        }
        return str;
    }

}
