package de.dbsystel.operations.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import org.springframework.core.io.ClassPathResource;

import de.dbsystel.operations.model.OperationsDTO;

/**
 * Utils for mapping CSV file
 */
public class CSVMapper {

	/**
	 * Convert CSV file into mapping of <Code, list of instances of
	 * {@link OperationsDTO}>
	 * 
	 * @param CSVResource the CSV file resource
	 * @return mapping of <Code, list of instances of {@link OperationsDTO}>
	 * @throws CsvValidationException exception on reading the CSV file
	 * @throws IOException            IO exception e.g. CSV file not found
	 */
	public static Map<String, List<OperationsDTO>> parseCSV(ClassPathResource CSVResource)
	        throws CsvValidationException, IOException {
		FileReader reader = new FileReader(CSVResource.getFile());

		Map<String, List<OperationsDTO>> operations = new CsvToBeanBuilder<OperationsDTO>(reader)
						.withType(OperationsDTO.class)
						.withSeparator(';')
						.build()
						.parse()
						.stream()
						.collect(Collectors.groupingBy(OperationsDTO::getCode));

		return operations;
	}
}
