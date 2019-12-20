package bingo;

public class Random {

    private String[] Random_4 = new String[4];

    public Random() { // 建構子，一開始就取4個亂數
        setRandom_4();
    }

    public String[] getRandom_4() {
        return Random_4;
    }

    private void setRandom_4() { // 設定4個亂數
        Random_4[0] = CreateRandom(); // 設定第1個亂數
        for (int i = 1; i < 4; i++) { // 跑剩下要取的3個亂數
            Random_4[i] = CreateRandom(); // 取下一個亂數
            for (int j = 0; j < i;) { // 用此亂數去比對之前的數，看是否有重覆
                if (Random_4[i].equals(Random_4[j])) {
                    j = 0;
                    Random_4[i] = CreateRandom(); // 重新取亂數
                } else {
                    j++;
                }

            }
        }
    }

    private String CreateRandom() { // 取任一個亂數
        String s = Integer.toString((int) (Math.random() * 10));
        return s;
    }

}
