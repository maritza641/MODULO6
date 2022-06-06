package cl.aiep.java.holamundo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HolamundoSpring2ApplicationTests {
	
	@Autowired
	private AppControlador appControlador; //variable de instancia, atributo o propiedad

	@Test
	void contextLoads() {
		assertThat(appControlador).isNotNull();
	}

}
