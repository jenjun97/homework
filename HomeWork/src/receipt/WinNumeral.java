package receipt;

/**
 * 數字先比對頭獎，中部份號碼顯示訊息，要求再比對 頭獎沒中，再往下比對
 */
public class WinNumeral {

    private static final String SpecialNum = "41482012"; // 特別獎號碼
    private static final String TopNum = "58837976"; // 特獎號碼
    private static final String[] NormalNum = {"20379435", "47430762", "36193504"}; // 頭獎號碼
    private static final String[] MoreNum = {"693", "043", "425"}; // 六獎

    // 依序比對每個獎，若沒有中，則再比對下一個
    public static void CheckWinNumeral(String str, String keyin) {
        switch (str) {
            case "SpecialNum": // 特別獎
                SpecialNum(keyin);
                break;
            case "TopNum": // 特獎
                TopNum(keyin);
                break;
            case "NormalNum": // 頭獎
                NormalNum(keyin);
                break;
            case "MoreNum": // 增開六獎
                MoreNum(keyin);
                break;
        }
    }

    // -------------------------------------------------- 特別獎
    private static void SpecialNum(String keyin) {
        if (keyin.equals(SpecialNum)) {
            System.out.println("恭喜中特別獎1,000萬元");
        } else if (SpecialNum.substring(SpecialNum.length() - keyin.length()).equals(keyin)) {
            System.out.println("可能中特別獎，請輸入完整8位數");
        } else {
            CheckWinNumeral("TopNum", keyin); // 都沒中再去對特獎
        }

    }

    // -------------------------------------------------- 特獎
    private static void TopNum(String keyin) {
        if (keyin.equals(TopNum)) {
            System.out.println("恭喜中特獎200萬元");
        } else if (TopNum.substring(TopNum.length() - keyin.length()).equals(keyin)) {
            System.out.println("可能中特獎，請輸入完整8位數");
        } else {
            CheckWinNumeral("NormalNum", keyin);
        }
    }

    // -------------------------------------------------- 頭獎
    private static void NormalNum(String keyin) {
        /**
         * @先取一組陣列(共3組) 先檢查keyin為幾碼 然後去比對是否中獎
         * @若沒中keyin去掉第1碼 再回去比對
         */
        boolean flag = true; // 跳離巢狀迴圈記號
        for (int i = 0; i < NormalNum.length && flag; i++) { // 取每一個array的號碼比對
            String strKeyin = keyin; // 重新取輸入號碼進行比對
            for (int j = strKeyin.length(); j > 2 && flag; j--) {
                if (NormalNum[i].substring(8 - strKeyin.length()).equals(strKeyin)) { // 對獎號碼與輸入號碼進行比對
                    NormalNumBonus(strKeyin); // 查看中獎獎金
                    flag = false; // 如果有中獎跳離巢狀迴圈
                } else {
                    strKeyin = strKeyin.substring(1); // 沒有中，輸入字串去前1碼繼續比對
                }
            } // -----Loop 2 end
        } // -----Loop 1 end

        if (flag) { // 如果都沒有中，繼續去比對六獎
            CheckWinNumeral("MoreNum", keyin);
        }

    }

    // -------------------------------------------------- 頭獎獎金
    private static void NormalNumBonus(String str) {
        int i = str.length(); // 中獎號長度
        switch (i) {
            case 8:
                System.out.printf("恭喜中頭獎20萬元，中獎號碼為%s\n", str);
                break;
            case 7:
                System.out.printf("恭喜中二獎4萬元，中獎號碼為%s\n", str);
                break;
            case 6:
                System.out.printf("恭喜中三獎1萬元，中獎號碼為%s\n", str);
                break;
            case 5:
                System.out.printf("恭喜中四獎4千元，中獎號碼為%s\n", str);
                break;
            case 4:
                System.out.printf("恭喜中五獎1千元，中獎號碼為%s\n", str);
                break;
            case 3:
                System.out.printf("恭喜中六獎200元，中獎號碼為%s\n", str);
                break;
        }

    }

    // -------------------------------------------------- 增開六獎
    private static void MoreNum(String keyin) {
        boolean flag = true;
        for (int i = 0; i < MoreNum.length && flag; i++) {
            if (MoreNum[i].equals(keyin.substring(keyin.length() - 3))) {
                System.out.printf("恭喜中增開六獎200元，號碼為%s\n", keyin.substring(keyin.length() - 3));
                flag = false;
            }
        }
        if (flag) {
            System.out.println("殘念沒中。");
        }
    }

}
