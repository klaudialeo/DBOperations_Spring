package de.dbsystel.operations.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import org.springframework.core.io.ClassPathResource;

import de.dbsystel.operations.model.OperationsDTO;

/**
 * Utils for mapping CSV file
 */
public class CSVMapper {

    /**
     * Convert CSV file into mapping of <Code, an instance of {@link OperationsDTO}>
     * @param CSVResource the CSV file resource
     * @return mapping of <Code, an instance of {@link OperationsDTO}>
     * @throws CsvValidationException exception on reading the CSV file
     * @throws IOException IO exception e.g. CSV file not found
     */
    public static LinkedHashMap<String, OperationsDTO> parseCSV(ClassPathResource CSVResource) throws CsvValidationException, IOException {
        LinkedHashMap<String, OperationsDTO> operations = new LinkedHashMap<>();

        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(CSVResource.getFile())).withSkipLines(1).withCSVParser(csvParser).build();

        String[] line;

        while ((line = csvReader.readNext()) != null) {
            OperationsDTO operationsCenter = OperationsDTO.builder().name(line[1]).shortName(line[2]).type(line[3]).build();
            operations.put(line[0], operationsCenter);
        }

        csvReader.close();

        return operations;
    }
}
