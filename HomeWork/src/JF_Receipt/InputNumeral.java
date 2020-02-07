package JF_Receipt;

import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputNumeral {

    public static JTextField InputJTextField; // 輸入的欄位
    public static JTextField ShowTextField; // 顯示輸入的欄位
    public static JLabel ShowCount; // 顯示的張數
    private static String InputStr; // 輸入的字串

    // 檢查字串長度，再依長度執行不同去比對
    public static void InputNumeralLength(String str) throws IOException {
        if (str.length() > 2 && str.length() < 9) {
            InputStr = str;
            InputCheckWinNumeral.CHeck(InputStr); // 字串去對獎
            ShowTextField.setText(InputStr); // 顯示輸入的字串
            Main.count++; // 張數累加
            ShowCount.setText("張數：" + Main.count); // 顯示張數
        } else if (str.length() == 17) {
            InputStr = str.substring(5, 13); // 取要的字串部份
            InputCheckWinNumeral.CHeck(InputStr); // 字串去對獎
            ShowTextField.setText(InputStr); // 顯示輸入的字串
            Main.count++; // 張數累加
            ShowCount.setText("張數：" + Main.count); // 顯示張數
        } else {
            Message.setMessage("輸入長度錯誤");
            PlayMusic.PlayError();
        }
    }

    // 非數字則刪除
    public static void InputNotNumeral(String str) {
        if (str.length() != 0 && !Character.isDigit(str.charAt(str.length() - 1))) {
            InputJTextField.setText(str.substring(0, str.length() - 1));
        }
    }

    // ----------------------------------------get && set
    public static JTextField getInputJTextField() {
        return InputJTextField;
    }

    public static void setInputJTextField(JTextField inputJTextField) {
        InputNumeral.InputJTextField = inputJTextField;
    }

}
