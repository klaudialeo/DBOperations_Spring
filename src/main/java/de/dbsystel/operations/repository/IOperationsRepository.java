package de.dbsystel.operations.repository;

import java.util.LinkedHashMap;
import java.util.List;

import de.dbsystel.operations.model.OperationsDTO;

/**
 * Interface of the repository for the {@link OperationsDTO} objects
 */
public interface IOperationsRepository {

    /**
     * Get list of all available codes
     * @return list of all available codes
     */
    public List<String> getAllCodes();

    /**
     * Get the instance of {@link OperationsDTO} by its code
     * @param code operation code
     * @return the corresponding instance of {@link OperationsDTO}
     */
    public OperationsDTO findByCode(String code);

    /**
     * Save all operations
     * @param operations mapping <Code, instance of {@link OperationsDTO}>
     */
    public void saveAll(LinkedHashMap<String, OperationsDTO> operations);
}
