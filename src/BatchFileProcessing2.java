import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BatchFileProcessing2 {

    public static void main(String[] args) throws IOException {
        String inputFilePath = args[0];
        String outputFilePath = "result-duplicate.txt";

        // HashMap để lưu trữ số lần xuất hiện của mỗi dòng
        Map<String, Integer> lineCountMap = new HashMap<>();

        // Mở file input và output
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;

            // Lặp qua từng dòng trong file input
            while ((line = reader.readLine()) != null) {
                // Tăng số lần xuất hiện của dòng
                lineCountMap.put(line, lineCountMap.getOrDefault(line, 0) + 1);
            }

            // Ghi kết quả vào file output
            for (Map.Entry<String, Integer> entry : lineCountMap.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
        }
    }
}
