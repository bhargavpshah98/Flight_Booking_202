package csvfile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

import com.opencsv.CSVReader;

import java.nio.file.Files;
import java.nio.file.Paths;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class Reader {
    private final String FILEPATH;
    private List<String[]> list;
    private final String fileName;

    public Reader(String[] header, String filepath) {
        this.list = new ArrayList<>();
        this.list.add(header);
        this.FILEPATH = filepath;
        fileName = "output.csv";
    }
    public String createFile(String path) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            writer.writeAll(list);
        }
        return path;
    }

    public void insertData(String input) throws IOException {
        String[] data = input.split(",");
        list.add(data);
        try (CSVWriter writer = new CSVWriter(new FileWriter(FILEPATH+"/"+fileName))) {
            writer.writeAll(list);
        }
    }
    public List<String[]> readData(String filename) throws IOException, CsvValidationException {
        List<String[]> res = new ArrayList<>();
        try (
                java.io.Reader reader = Files.newBufferedReader(Paths.get(filename));
                CSVReader csvReader = new CSVReader(reader);
        )
        {
            // Reading Records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                res.add(nextRecord);
            }
            res.remove(0);
        }
        return res;
    }
}
