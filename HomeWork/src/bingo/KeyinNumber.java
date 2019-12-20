package bingo;

public class KeyinNumber extends Random {

    private String[] KeyinNumber, Random_4;

    public KeyinNumber() { //  Constructor
        this.Random_4 = getRandom_4(); // 建構時去取得4位亂碼
    }

    public void KeyinNumber(String sr) { //  Constructor(String)
        this.KeyinNumber = new String[sr.length()]; // 設定int陣列長度為字串長度
        for (int i = 0; i < sr.length(); i++) {
            KeyinNumber[i] = Character.toString(sr.charAt(i)); // 將字串轉為字串陣列存入陣列
        }
        setKeyinNumber(KeyinNumber);
    }

    /**
     * @ 輸入0離開
     * @ 輸入1顯示答案
     * @ 不滿4位數
     * @ 4位數有重覆
     * @ 輸入數不為1-9
     *
     * @ Return String
     */
    public String keyinNumberChick(String[] KeyinNumber_ArraySt) { // 檢查輸入的字串
        String str = ""; // 回傳的字串值
        if (KeyinNumber_ArraySt.length == 1 && KeyinNumber_ArraySt[0].equals("0")) { // 輸入0離開 int = 0
            str = "exit"; // 離開
        } else if (KeyinNumber_ArraySt.length == 1 && KeyinNumber_ArraySt[0].equals("1")) { // 輸入1顯示答案 int = 1
            showAnswer();
            str = "showanswer";
        } else if (KeyinNumber_ArraySt.length != 4) { // 輸入數不為4位數
            System.out.println("輸入數字需為4位數，請重新輸入");
            str = "error";
        } else if (numberRepeat(KeyinNumber_ArraySt)) { // 輸入數有重覆
            System.out.println("輸入數字有重覆，請重新輸入");
            str = "error";
        } else if (number_1to9(KeyinNumber_ArraySt)) { // 輸入數不為0-9
            System.out.println("輸入值需為0-9");
            str = "error";
        }
        return str; // 回傳字串
    }

    private void showAnswer() { // 顯示答案
        System.out.print("答案為：");
        for (int j = 0; j < Random_4.length; j++) {
            System.out.print("" + Random_4[j]);
        }
        System.out.println("");
    }

    private boolean numberRepeat(String[] NumberSt) { // 檢查輸入的四位數是否有重覆
        boolean b = false;
        for (int i = 0; i < NumberSt.length - 1; i++) {
            for (int j = i + 1; j < NumberSt.length; j++) {
                if (NumberSt[i].equals(NumberSt[j])) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }

    private boolean number_1to9(String[] NumberSt) {  // 查檢輸入的字是否為0-9
        boolean b = false;
        String s = "0123456789";
        for (int i = 0; i < NumberSt.length; i++) {
            if (s.indexOf(NumberSt[i]) == -1) {
                b = true;
                break;
            }
        }

        return b;
    }

    public String[] getKeyinNumber() {
        return KeyinNumber;
    }

    public void setKeyinNumber(String[] KeyinNumber) {
        this.KeyinNumber = KeyinNumber;
    }

}
