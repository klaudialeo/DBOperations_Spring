package de.dbsystel.operations.service;

import de.dbsystel.operations.model.OperationsDTO;
import de.dbsystel.operations.repository.OperationsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements {@link IOperationsService}
 */
@Service
public class OperationsService implements IOperationsService {

    @Autowired
    OperationsRepository operationsRepository;

    /**
     * Get the instance of {@link OperationsDTO} by its code from {@link OperationsRepository}
     * @param code operation code
     * @return the corresponding instance of {@link OperationsDTO}
     */
    @Override
    public OperationsDTO getOperation(String code) {
        return operationsRepository.findByCode(code);
    }

    /**
     * Get list of all available codes from {@link OperationsRepository}
     * @return list of all available codes
     */
    @Override
    public List<String> getAllOperations() {
        return operationsRepository.getAllCodes();
    }
}
