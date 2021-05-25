package de.dbsystel.operations.service;

import java.util.List;

import de.dbsystel.operations.model.OperationsDTO;

/**
 * Interface of the service class {@link OperationsService} to fetch data from
 * {@link IOperationsRepository} requested by {@link OperationsController}
 */
public interface IOperationsService {

    /**
     * Get list of instances of {@link OperationsDTO} by its code from
     * {@link IOperationsRepository}
     * 
     * @param code operation code
     * @return list of corresponding instances of {@link OperationsDTO}
     */
    public List<OperationsDTO> getOperation(String code);

    /**
     * Get list of all available codes from {@link IOperationsRepository}
     * 
     * @return list of all available codes
     */
    public List<String> getAllOperations();
}
