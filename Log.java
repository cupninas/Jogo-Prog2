package Jogo;

import java.util.ArrayList;
import java.util.List;

public class Log {
    private List<String> logs = new ArrayList<>();

    public void addLog(String message) {
        logs.add(message);
    }

    public void showLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
