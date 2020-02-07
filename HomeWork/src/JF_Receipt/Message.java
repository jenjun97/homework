package JF_Receipt;

import javax.swing.JTextField;

public class Message {

    private static JTextField jf; // 預設顯示訊息欄位

    // 設定顯示的訊息
    public static void setMessage(String str) {
        jf.setText(str);
    }

    // -----------------------------------------set && get
    public static JTextField getJf() {
        return jf;
    }

    public static void setJf(JTextField jf) {
        Message.jf = jf;
    }
}
