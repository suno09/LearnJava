package watch_service;

import java.io.IOException;
import java.nio.file.*;

public class WatchServiceAPI {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("d:/logs");
        new Java8WatchService(dir).processEvents();
    }
}
