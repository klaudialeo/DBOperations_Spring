package de.dbsystel.operations.config;

import java.util.TreeMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import de.dbsystel.operations.model.OperationsDTO;
import de.dbsystel.operations.repository.OperationsRepository;
import de.dbsystel.operations.utils.CSVMapper;

/**
 * Data configuration
 */
@Configuration
public class DataConfig {

    private static final ClassPathResource CSVResource = new ClassPathResource("DBNetz-Betriebsstellenverzeichnis-Stand2018-04.csv");

    /**
     * Initializes the {@link OperationsRepository} with the mapping <Code, an instance of {@link OperationsDTO}> parsed from the CSV file {@link DataConfig#CSVResource}
     * @param repository repository class
     * @return saved mapping
     */
    @Bean
    CommandLineRunner initRepository(OperationsRepository repository) {
        return args -> {
            TreeMap<String, OperationsDTO> operations = CSVMapper.parseCSV(CSVResource);
            repository.saveAll(operations);
        };
    }
}
