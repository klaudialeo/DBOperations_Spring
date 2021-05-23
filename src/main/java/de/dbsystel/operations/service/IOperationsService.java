package de.dbsystel.operations.service;

import java.util.List;

import de.dbsystel.operations.model.OperationsDTO;

/**
 * Interface of the service class {@link OperationsService} to fetch data from {@link IOperationsRepository} requested by {@link OperationsController}
 */
public interface IOperationsService {

    /**
     * Get the instance of {@link OperationsDTO} by its code from {@link IOperationsRepository}
     * @param code operation code
     * @return the corresponding instance of {@link OperationsDTO}
     */
    public OperationsDTO getOperation(String code);

    /**
     * Get list of all available codes from {@link IOperationsRepository}
     * @return list of all available codes
     */
    public List<String> getAllOperations();
}
