package de.dbsystel.operations.repository;

import java.util.Map;
import java.util.List;

import de.dbsystel.operations.model.OperationsDTO;

/**
 * Interface of the repository {@link OperationsRepository} for the
 * {@link OperationsDTO} objects
 */
public interface IOperationsRepository {

    /**
     * Get list of all available codes sorted alphabetically
     * 
     * @return list of all available codes sorted alphabetically
     */
    public List<String> getAllCodes();

    /**
     * Get list of instances of {@link OperationsDTO} by its code
     * 
     * @param code operation code
     * @return list of corresponding instances of {@link OperationsDTO}
     */
    public List<OperationsDTO> findByCode(String code);

    /**
     * Save all operations
     * 
     * @param operations mapping <Code, list of instances of {@link OperationsDTO}>
     */
    public void saveAll(Map<String, List<OperationsDTO>> operations);
}
