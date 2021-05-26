package de.dbsystel.operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import de.dbsystel.operations.controller.OperationsController;
import de.dbsystel.operations.model.OperationsDTO;
import de.dbsystel.operations.service.OperationsService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebMvcTest(controllers = { OperationsController.class })
class OperationsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OperationsService service;

	private static final String SAMPLE_CODE = "aamp";
	private static final String SAMPLE_NAME = "Hamburg Anckelmannsplatz";
	private static final String SAMPLE_SHORT_NAME = "Anckelmannsplatz";
	private static final String SAMPLE_TYPE = "Üst";

	private static final String QUOTE = "'";
	private static final String DEFAULT_PATH = "/betriebsstelle/";

	private Map<String, List<OperationsDTO>> operations = new HashMap<>();

	@BeforeEach
	void init() {
		assertThat(service).isNotNull();

		OperationsDTO sampleOperation = OperationsDTO.builder()
		                                             .name(SAMPLE_NAME)
		                                             .shortName(SAMPLE_SHORT_NAME)
		                                             .type(SAMPLE_TYPE)
		                                             .build();
		
		operations.put(SAMPLE_CODE.toUpperCase(), Arrays.asList(sampleOperation));
	}

	@Test
	void testGetOperationCenterFound() throws Exception {
		when(service.getOperation(SAMPLE_CODE.toUpperCase())).thenReturn(findByCode(SAMPLE_CODE.toUpperCase()));

		String expectedResponse = getOperationInJSON(QUOTE + SAMPLE_NAME + QUOTE, QUOTE + SAMPLE_SHORT_NAME + QUOTE, QUOTE + SAMPLE_TYPE + QUOTE);
		simulateTest(DEFAULT_PATH + SAMPLE_CODE, expectedResponse);
	}

	@Test
	void testGetOperationCenterNotFound() throws Exception {
		String code = "Klaudia";
		when(service.getOperation(code.toUpperCase())).thenReturn(findByCode(code.toUpperCase()));

		String expectedResponse = getOperationInJSON(null, null, null);
		simulateTest(DEFAULT_PATH + code, expectedResponse);
	}

	@Test
	void testGetAllOperationCenter() throws Exception {
		List<String> codes = operations.keySet()
		                               .stream()
		                               .sorted()
		                               .collect(Collectors.toList());
		
		when(service.getAllOperations()).thenReturn(codes);

		List<String> codesWithQuotes = codes.stream()
		                                    .map(code -> (QUOTE + code + QUOTE))
		                                    .collect(Collectors.toList());

		String expectedResponse = "[" + String.join(",", codesWithQuotes) + "]";
		simulateTest(DEFAULT_PATH, expectedResponse);
	}

	private void simulateTest(String path, String response) throws Exception {
		mockMvc.perform(get(path))
		       .andExpect(status().isOk())
		       .andExpect(content().contentType("application/json"))
		       .andExpect(content().json(response));
	}

	private List<OperationsDTO> findByCode(String code) {
		List<OperationsDTO> operation = operations.get(code);

		if (operation != null) {
			return operation;
		}

		OperationsDTO noOperation = OperationsDTO.builder()
		                                         .build();
		
		return Collections.singletonList(noOperation);
	}

	private String getOperationInJSON(String name, String shortName, String type) {
		return "{'Name': " + name + ", 'Kurzname': " + shortName + ", 'Typ': " + type + "}";
	}
}