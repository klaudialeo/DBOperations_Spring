package de.dbsystel.operations.repository;

import java.util.Map;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import de.dbsystel.operations.model.OperationsDTO;

/**
 * Implements {@link IOperationsRepository}
 */
@Repository
public class OperationsRepository implements IOperationsRepository {

    private Map<String, List<OperationsDTO>> operations;

    /**
     * Get list of all available codes sorted alphabetically
     * 
     * @return list of all available codes sorted alphabetically
     */
    public List<String> getAllCodes() {
        return operations.keySet().stream().sorted().collect(Collectors.toList());
    }

    /**
     * Get list of instances of {@link OperationsDTO} by its code
     * 
     * @param code operation code
     * @return list of corresponding instances of {@link OperationsDTO}
     */
    public List<OperationsDTO> findByCode(String code) {
        List<OperationsDTO> operation = operations.get(code);

        if (operation != null) {
            return operation;
        }

        OperationsDTO noOperation = OperationsDTO.builder().build();
        return Collections.singletonList(noOperation);
    }

    /**
     * Save all operations
     * 
     * @param operations mapping <Code, list of instances of {@link OperationsDTO}>
     */
    public void saveAll(Map<String, List<OperationsDTO>> operations) {
        this.operations = operations;
    }
}
