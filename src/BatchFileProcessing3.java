import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BatchFileProcessing3 {

    public static void main(String[] args) throws IOException {
        String inputFilePath = args[0];
        String outputFilePath = "result-2.txt";

        // Mở file input và output
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;

            // Lặp qua từng dòng trong file input
            while ((line = reader.readLine()) != null) {
                // Xóa dấu chấm đầu dòng nếu có
                if (line.startsWith(".")) {
                    line = line.substring(1);
                }

                // Ghi dòng mới vào file output
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
