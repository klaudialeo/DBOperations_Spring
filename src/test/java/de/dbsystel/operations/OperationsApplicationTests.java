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

import java.util.LinkedHashMap;
import java.util.List;
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

	private LinkedHashMap<String, OperationsDTO> operations = new LinkedHashMap<>();

	@BeforeEach
	void init() {
		assertThat(service).isNotNull();

		OperationsDTO sampleOperation = OperationsDTO.builder().name(SAMPLE_NAME).shortName(SAMPLE_SHORT_NAME)
				.type(SAMPLE_TYPE).build();
		operations.put(SAMPLE_CODE.toUpperCase(), sampleOperation);
	}

	@Test
	void testGetOperationCenterFound() throws Exception {
		when(service.getOperation(SAMPLE_CODE.toUpperCase())).thenReturn(findByCode(SAMPLE_CODE.toUpperCase()));

		String expectedResponse = getOperationInJSON(SAMPLE_NAME, SAMPLE_SHORT_NAME, SAMPLE_TYPE);
		simulateTest("/betriebsstelle/" + SAMPLE_CODE, expectedResponse);
	}

	@Test
	void testGetOperationCenterNotFound() throws Exception {
		String code = "Klaudia";
		when(service.getOperation(code.toUpperCase())).thenReturn(findByCode(code.toUpperCase()));

		String expectedResponse = getOperationInJSON("", "", "");
		simulateTest("/betriebsstelle/" + code, expectedResponse);
	}

	@Test
	void testGetAllOperationCenter() throws Exception {
		List<String> codes = operations.keySet().stream().collect(Collectors.toList());
		when(service.getAllOperations()).thenReturn(codes);

		String expectedResponse = "["
				+ String.join(",", codes.stream().map(code -> ("'" + code + "'")).collect(Collectors.toList())) + "]";
		simulateTest("/betriebsstelle/", expectedResponse);
	}

	private void simulateTest(String path, String response) throws Exception {
		mockMvc.perform(get(path)).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
				.andExpect(content().json(response));
	}

	private OperationsDTO findByCode(String code) {
		OperationsDTO operation = operations.get(code);

		if (operation != null) {
			return operation;
		}

		return OperationsDTO.builder().build();
	}

	private String getOperationInJSON(String name, String shortName, String type) {
		return "{'Name': '" + name + "', 'Kurzname': '" + shortName + "', 'Typ': '" + type + "'}";
	}
}