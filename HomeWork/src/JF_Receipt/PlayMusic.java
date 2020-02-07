package JF_Receipt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class PlayMusic {

    static InputStream in;
    static AudioStream as;

    public static void PlayWin() throws IOException {
//        in = new FileInputStream("/../../java music/win.wav"); // 打 开 一 个 声 音 文 件 流 作 为 输 入
        in = new FileInputStream("/win.wav"); // 打 开 一 个 声 音 文 件 流 作 为 输 入
        as = new AudioStream(in); // 用 输 入 流 创 建 一 个AudioStream 对 象
        AudioPlayer.player.start(as); //“player” 是AudioPlayer 中 一 静 态 成 员 用 于 控 制 播 放 
    }

    public static void PlayLose() throws IOException {
//        in = new FileInputStream("/../../java music/lose.wav"); // 打 开 一 个 声 音 文 件 流 作 为 输 入
        in = new FileInputStream("/lose.wav"); // 打 开 一 个 声 音 文 件 流 作 为 输 入
        as = new AudioStream(in); // 用 输 入 流 创 建 一 个AudioStream 对 象
        AudioPlayer.player.start(as); //“player” 是AudioPlayer 中 一 静 态 成 员 用 于 控 制 播 放 
    }
    
    public static void PlayError() throws IOException {
//        in = new FileInputStream("/../../java music/error.wav"); // 打 开 一 个 声 音 文 件 流 作 为 输 入
        in = new FileInputStream("/error.wav"); // 打 开 一 个 声 音 文 件 流 作 为 输 入
        as = new AudioStream(in); // 用 输 入 流 创 建 一 个AudioStream 对 象
        AudioPlayer.player.start(as); //“player” 是AudioPlayer 中 一 静 态 成 员 用 于 控 制 播 放 
    }
}
