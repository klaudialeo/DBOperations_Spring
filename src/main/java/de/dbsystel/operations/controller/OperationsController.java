package de.dbsystel.operations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import de.dbsystel.operations.model.OperationsDTO;
import de.dbsystel.operations.service.IOperationsService;

/**
 * Controller for the API endpoint
 */
@RestController
public class OperationsController {

    @Autowired
    private IOperationsService operationsService;

    /**
     * Handle GET method to fetch operation data by code
     * @param code operation code
     * @return status code OK (200) and the correspondent instance of {@link OperationsDTO} as response body
     */
    @GetMapping(path = "/betriebsstelle/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> handleGetOperationByCode(@PathVariable("code") String code) {
        OperationsDTO operation = operationsService.getOperation(code.toUpperCase());
        return ResponseEntity.ok(operation);
    }

    /**
     * Handle GET method to fetch all available operation codes
     * @return status code OK (200) and list operation codes as response body
     */
    @GetMapping(path = "/betriebsstelle", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> handleGetAllOperations() {
        List<String> operations = operationsService.getAllOperations();
        return ResponseEntity.ok(operations);
    }
}