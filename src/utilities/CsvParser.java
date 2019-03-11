package utilities;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
	

    public List<String[]> getAllRows(String path) {
    	// "./testcsv1.csv"
    	List<String[]> returnedList = new ArrayList<String[]>();
    	try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord csvRecord : csvParser) {
            	returnedList.add(new String[] {csvRecord.get(0),csvRecord.get(1),csvRecord.get(2)});
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    	return returnedList;
    }
}
