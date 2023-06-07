package br.com.impressora;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimulaImpressoraApplicationTests {

	@Test
    public void testApplicationRun() {
      SimulaImpressoraApplication.main(new String[]{});
    }
	
	@Test
	public void testCopyRight() {
		SimulaImpressoraApplication simulaApplication = Mockito.spy(SimulaImpressoraApplication.class);
		simulaApplication.copyright();
		Mockito.verify(simulaApplication, Mockito.times((1))).copyright();
	}
}
