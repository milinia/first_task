import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SimpleCSVReader {

    public List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            final CSVParser parser =
                    new CSVParserBuilder()
                            .withSeparator(';')
                            .build();
            final CSVReader csvReader =
                    new CSVReaderBuilder(reader)
                            .withCSVParser(parser)
                            .build();
            return csvReader.readAll();
        }
    }
}
