package de.dbsystel.operations.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import de.dbsystel.operations.model.OperationsDTO;

/**
 * Implements {@link IOperationsRepository}
 */
@Repository
public class OperationsRepository implements IOperationsRepository {

    private LinkedHashMap<String, OperationsDTO> operations;

    /**
     * Get list of all available codes
     * @return list of all available codes
     */
    public List<String> getAllCodes() {
        return operations.keySet().stream().collect(Collectors.toList());
    }

    /**
     * Get the instance of {@link OperationsDTO} by its code
     * @param code operation code
     * @return the corresponding instance of {@link OperationsDTO}
     */
    public OperationsDTO findByCode(String code) {
        OperationsDTO operation = operations.get(code);

        if (operation != null) {
            return operation;
        }

        return OperationsDTO.builder().build();
    }

    /**
     * Save all operations
     * @param operations mapping <Code, instance of {@link OperationsDTO}>
     */
    public void saveAll(LinkedHashMap<String, OperationsDTO> operations) {
        this.operations = operations;
    }
}
