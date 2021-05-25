package de.dbsystel.operations.service;

import de.dbsystel.operations.model.OperationsDTO;
import de.dbsystel.operations.repository.IOperationsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements {@link IOperationsService}
 */
@Service
public class OperationsService implements IOperationsService {

    @Autowired
    private IOperationsRepository operationsRepository;

    /**
     * Get list of instances of {@link OperationsDTO} by its code from
     * {@link IOperationsRepository}
     * 
     * @param code operation code
     * @return list of corresponding instances of {@link OperationsDTO}
     */
    @Override
    public List<OperationsDTO> getOperation(String code) {
        return operationsRepository.findByCode(code);
    }

    /**
     * Get list of all available codes from {@link IOperationsRepository}
     * 
     * @return list of all available codes
     */
    @Override
    public List<String> getAllOperations() {
        return operationsRepository.getAllCodes();
    }
}
