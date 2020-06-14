package app;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Model {

    public List<String[]> loadCsv(String filePath) throws FileNotFoundException, IOException, CsvException {
        CSVReaderHeaderAware c = new CSVReaderHeaderAware(new FileReader(filePath));
        List<String[]> rows = c.readAll();
        return rows;
    }

    public void saveCsv(List<String[]> rows, String fileName) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(fileName));
        String[] header = {"Id", "Name", "Quantity", "Price"};
        writer.writeNext(header);
        for (String[] row : rows) {
            writer.writeNext(row);
        }
        writer.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, CsvValidationException, CsvException {
        
    }
}
