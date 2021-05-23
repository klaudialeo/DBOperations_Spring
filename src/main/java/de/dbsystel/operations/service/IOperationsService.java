package de.dbsystel.operations.service;

import java.util.List;

import de.dbsystel.operations.model.OperationsDTO;

/**
 * Interface of the service class {@link OperationsService} to fetch data from {@link OperationsRepository} requested by {@link OperationsController}
 */
public interface IOperationsService {

    /**
     * Get the instance of {@link OperationsDTO} by its code from {@link OperationsRepository}
     * @param code operation code
     * @return the corresponding instance of {@link OperationsDTO}
     */
    OperationsDTO getOperation(String code);

    /**
     * Get list of all available codes from {@link OperationsRepository}
     * @return list of all available codes
     */
    List<String> getAllOperations();
}
