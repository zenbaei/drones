package com.zenbaei.drones.domain.drone;

import static com.zenbaei.drones.test.TestUtils.toJson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.zenbaei.drones.domain.medication.Medication;

@WebMvcTest
public class DroneRestControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private DroneService droneSerivce;

	@Test
	public void postDrone_shouldCallServiceSave() throws Exception {
		Drone drn = new Drone();
		drn.setSerial("ABC");

		mvc.perform(post("/api/drones")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(drn)))
				.andExpect(status().isOk());
		
		verify(droneSerivce).save(any(Drone.class));
	}

	@Test
	public void postDroneWithNoSerial_shouldReturn400() throws Exception {
		Drone drn = new Drone();

		mvc.perform(post("/api/drones")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(drn)))
		.andExpect(status().isBadRequest());
	}

	@Test
	public void givenDbHasData_whenPutingDroneWithMedications_thenItShouldCallUpdate() throws Exception {
		Medication m1 = new Medication();
		Medication m2 = new Medication();
		Drone drone = new Drone();
		drone.setMedications(Arrays.asList(m1, m2));
		
		ArgumentCaptor<Drone> argument = ArgumentCaptor.forClass(Drone.class);

		mvc.perform(put("/api/drones/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(toJson(drone)))
			.andExpect(status().isOk());
		
		verify(droneSerivce).update(1, argument.capture());
		assertThat(argument.getValue().getMedications().size()).isEqualTo(2);
	}
}
