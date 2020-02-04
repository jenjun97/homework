package filePath;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    
    static int fileCount = 0; // 累計檔案數
    static SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss"); // 設定顯示日期之格式
    static Date date = new Date();
    
    public static void main(String[] args) {
        
        File file = new File("C:\\java"); // 設定最上層資料夾起始路徑
        printPath(file); // 列印出所有檔案名稱，並累加檔案數
//        System.out.println(file.listFiles().length);
        System.out.println("FileCount == " + fileCount); // 印出檔案數
    }
    
    static void printPath(File files) {
        if (files.listFiles().length != 0) { // 若該層資料夾內有其他的檔案
            System.out.println(files.getPath()); // 印出該目錄之絕對路徑
            for (File f : files.listFiles()) { // 印出所有檔案、資料夾名稱
                System.out.println(f.getName() + "\t最後更新時間 " + sdf.format(f.lastModified()));
//                System.out.println(f.getName() + "\t最後更新時間 " + sdf.format(f.lastModified()-60265296000000.0));
                date.setTime(f.lastModified());
//                System.out.println(f.getName() + "\t最後更新時間 " + (date.getYear() - 11) + "-" + date.getMonth() + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
                fileCount++;
            }
            System.out.println("------------------");
            for (File f : files.listFiles()) { // 每一個檔案及資料夾
                if (f.isDirectory()) { // 檢查是否為目錄
                    printPath(f); // 若為目錄再去列出所有檔案
                }
            }
        }
    }
    
}
