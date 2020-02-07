package JF_Receipt;

import java.util.ArrayList;
import javax.swing.JTextField;

public class WinNumeral {

    public static ArrayList WinNumeralArrayListString = new ArrayList();

    // 檢查輸入的中獎號碼格式
    public static void CheckWinNumeral(JTextField tf, int i) {
        if (tf.getText().length() > i) {
            WinNumeralLength(tf, i); // 檢查長度
        } else {
            NotNumeral(tf); // 檢查是否為數字
        }
    }

    // 檢查字串長度，太長刪除
    public static void WinNumeralLength(JTextField tf, int i) {
        if (tf.getText().length() > i) {
            tf.setText(tf.getText().substring(0, i));
        }
    }

    // 非數字則刪除
    public static void NotNumeral(JTextField tf) {
        if (tf.getText().length() != 0 && !Character.isDigit(tf.getText().charAt(tf.getText().length() - 1))) {
            tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
        }
    }

    // 儲存輸入的中獎號碼
    public static void SaveWinNumeral(ArrayList ary) {
        JTextField tf;
        for (int i = 0; i < ary.size(); i++) {
            tf = (JTextField) ary.get(i); // 取出ArrayList轉成JTextField
            WinNumeralArrayListString.add(tf.getText()); // 取出欄位的每個字串放入ArrayList
        }
    }

    // ---------------------------------------------------get & set
    public static ArrayList getWinNumeralArrayListString() {
        return WinNumeralArrayListString;
    }
}
