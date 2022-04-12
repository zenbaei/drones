- Run the App:
	./mvnw spring-boot:run

- Application runs on default port localhost:8080

- In memory db can be accessed over 8080/h2-console 
    use default values except url -> jdbc:h2:mem:testdb

- Rest APIs:
	Register new Drone: POST -> /api/drones
		sample data: {"serial": "ZOU"}
		
	Load a Drone with Medications: PUT -> /api/drones/1
	  sample data: {"medications": [{"id": 1, "weight": 100}, {"id": 2, "weight" : 20}]}
	  
	Checking loaded medication for a given Drone: GET -> /api/drones/1	
	
	
	Available Drones for loading: GET -> /api/drones?status=IDLE


- to run integration tests: 
	./mvnw verify -Pfailsafe
	
Sorry I was busy and didn't have enough time to implement the Executor to log battery status and prevent loading 
for drones with 25% remaing battery.

