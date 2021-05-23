package de.dbsystel.operations.config;

import java.util.LinkedHashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import de.dbsystel.operations.model.OperationsDTO;
import de.dbsystel.operations.repository.IOperationsRepository;
import de.dbsystel.operations.utils.CSVMapper;

/**
 * Data configuration
 */
@Configuration
public class DataConfig {

    private static final ClassPathResource CSVResource = new ClassPathResource("DBNetz-Betriebsstellenverzeichnis-Stand2018-04.csv");

    /**
     * Initializes the {@link IOperationsRepository} with the mapping <Code, an instance of {@link OperationsDTO}> parsed from the CSV file {@link DataConfig#CSVResource}
     * @param repository repository class
     * @return saved mapping
     */
    @Bean
    CommandLineRunner initRepository(IOperationsRepository repository) {
        return args -> {
            LinkedHashMap<String, OperationsDTO> operations = CSVMapper.parseCSV(CSVResource);
            repository.saveAll(operations);
        };
    }
}
