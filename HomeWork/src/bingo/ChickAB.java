package bingo;

public class ChickAB {

    public static String chick(String[] keyin, String[] answer) { // 回傳幾A幾B
        int A = 0, B = 0; // 先預設為0A0B

        for (int i = 0; i < keyin.length; i++) { // 如果位置對，數字對則A+1
            if (keyin[i].equals(answer[i])) {
                A++;
            }
        }

        for (int i = 0; i < keyin.length; i++) { // 如果位置錯，數字對則B+1
            for (int j = 0; j < keyin.length; j++) {
                if (keyin[i].equals(answer[j])) {
                    B++;
                }
            }
        }

        B = B - A; // 因為AB會有重疊，所以用B減去A，會得到剩下的B值

        if (4 == A) {
            System.out.println("恭喜答對了");
            return "exit"; // 輸入回傳"exit"讓程式結束
        } else {
            System.out.printf("%dA, %dB\n", A, B); // 顯示幾A幾B
            return ""; // 回傳空值讓loop繼續跑
        }
    }
}
