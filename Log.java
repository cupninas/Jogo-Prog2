package Jogo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Log {
    private final List<String> logs = Collections.synchronizedList(new ArrayList<>());
    private static final int MAX_LOGS = 1000; // Limite de logs armazenados
    private static final String LOG_FILE = "log.txt"; // Arquivo para persistência

    public void addLog(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = "[" + timestamp + "] " + message;

        synchronized (logs) {
            if (logs.size() >= MAX_LOGS) {
                logs.remove(0); // Remove o mais antigo para manter o limite
            }
            logs.add(logMessage);
        }

        saveToFile(logMessage);
    }

    public void showLogs() {
        synchronized (logs) {
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }

    public void clearLogs() {
        synchronized (logs) {
            logs.clear();
        }
    }

    private void saveToFile(String logMessage) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logMessage + "\n");
        } catch (IOException e) {
            System.err.println("Erro ao salvar log no arquivo: " + e.getMessage());
        }
    }
}
