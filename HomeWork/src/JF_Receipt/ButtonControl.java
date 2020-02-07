package JF_Receipt;

import java.util.ArrayList;
import javax.swing.JTextField;
import java.util.HashSet;
import java.util.Iterator;

public class ButtonControl {

    public static boolean statment = true; // 中獎號碼可否輸入狀態

    // 關閉欄位
    public static void Close(ArrayList al) {
        JTextField tf;
        for (Object oo : al) {
            tf = (JTextField) oo;
            tf.setEnabled(false);
        }
        ChangeStament(); // 更改輸入狀態

    }

    // 開啟欄位
    public static void Open(ArrayList al) {
        JTextField tf;
        for (Object oo : al) {
            tf = (JTextField) oo;
            tf.setEnabled(true);
        }

    }

    public static void ChangeStament() {
        if (statment) {
            statment = false;
        } else {
            statment = true;
        }
    }

    
}
