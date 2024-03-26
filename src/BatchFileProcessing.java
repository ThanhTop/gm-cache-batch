import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BatchFileProcessing {

    public static void main(String[] args) throws IOException {
        String inputFilePath = args[0];
        String outputFilePath = "result.txt";

        // Pattern để xác định dòng cần giữ lại
        Pattern pattern = Pattern.compile("Interceptor DAO: com.c1s.persistence.dao.oracle(.*)");

        // Mở file input và output
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;

            // Lặp qua từng dòng trong file input
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                // Nếu dòng khớp với pattern
                if (matcher.find()) {
                    // Lấy nội dung từ cuối pattern đến hết dòng
                    String extractedText = matcher.group(1);

                    // Ghi dòng mới vào file output
                    writer.write(extractedText);
                    writer.newLine();
                }
            }
        }
    }
}

