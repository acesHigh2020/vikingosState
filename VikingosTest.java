import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VikingosTest {
	
	@Test
	public void recibirDanioEnNormalDebeRetornarColerico() {
		Vikingo vikingo1 = new Vikingo("Olaf");
		Vikingo vikingo2 = new Vikingo("Erik");
		
		vikingo1.atacarVikingo(vikingo2);
		assertEquals(new Colerico(vikingo2), vikingo2.getEstado());
	}

	@Test
	public void recibirDanioEnColericoDebeRetornarBerserker() {
		Vikingo vikingo1 = new Vikingo("Olaf");
		Vikingo vikingo2 = new Vikingo("Erik");
		
		vikingo1.atacarVikingo(vikingo2);
		vikingo1.atacarVikingo(vikingo2);
		assertEquals(new Berserker(vikingo2), vikingo2.getEstado());
	}
	
	@Test
	public void recibirDanioEnCalmadoRetornaCalmado() {
		Vikingo vikingo1 = new Vikingo("Olaf");
		Vikingo vikingo2 = new Vikingo("Erik");
		
		vikingo2.meditacion();
		vikingo1.atacarVikingo(vikingo2);
				
		assertEquals(new Calmado(vikingo2), vikingo2.getEstado());
	}
	
	@Test
	public void recibirDanioEnCalmadoRetornaCalmado2() {
		Vikingo vikingo1 = new Vikingo("Olaf");
		Vikingo vikingo2 = new Vikingo("Erik");
		
		vikingo2.meditacion();
		for (int i = 0; i < 40; i++) {
			vikingo1.atacarVikingo(vikingo2);
		}
		
		assertEquals(new Calmado(vikingo2), vikingo2.getEstado());
	}
	
	@Test
	public void atacarEnCalmadoRetornaNormal() {
		Vikingo vikingo1 = new Vikingo("Olaf");
		Vikingo vikingo2 = new Vikingo("Erik");
		
		vikingo2.meditacion();
		vikingo2.atacarVikingo(vikingo1);
		
		assertEquals(new Normal(vikingo2), vikingo2.getEstado());
	}
	
	@Test
	public void meditarEnNormalRetornaCalmado( ) {
		Vikingo vikingo2 = new Vikingo("Erik");
		
		vikingo2.meditacion();
		
		assertEquals(new Calmado(vikingo2), vikingo2.getEstado());
	}
	
	@Test
	public void meditarEnColericoRetornaNormal( ) {
		Vikingo vikingo1 = new Vikingo("Olaf");
		Vikingo vikingo2 = new Vikingo("Erik");
		
		vikingo2.meditacion();
		vikingo2.atacarVikingo(vikingo1);
		
		assertEquals(new Normal(vikingo2), vikingo2.getEstado());
	}
	
	@Test
	public void meditarEnBerserkerRetornaNormal( ) {
		Vikingo vikingo1 = new Vikingo("Olaf");
		Vikingo vikingo2 = new Vikingo("Erik");
		
		vikingo1.atacarVikingo(vikingo2);
		vikingo1.atacarVikingo(vikingo2);
		vikingo2.meditacion();

		assertEquals(new Normal(vikingo2), vikingo2.getEstado());
	}
	
	@Test
	public void meditarEnCalmadoRetornaCalmado( ) {
		Vikingo vikingo2 = new Vikingo("Erik");
		
		vikingo2.meditacion();
		vikingo2.meditacion();
		
		assertEquals(new Calmado(vikingo2), vikingo2.getEstado());
	}
	
	@Test
	public void serAtacadoRetornaMuerto( ) {
		Vikingo vikingo1 = new Vikingo("Olaf");
		Vikingo vikingo2 = new Vikingo("Erik");
		
		for (int i = 0; i < 20; i++) {
			vikingo1.atacarVikingo(vikingo2);
		}

		assertEquals(new Muerto(vikingo2), vikingo2.getEstado());
	}
	
	@Test
	public void serAtacadoNoRetornaMuerto( ) {
		Vikingo vikingo1 = new Vikingo("Olaf");
		Vikingo vikingo2 = new Vikingo("Erik");
		
		vikingo1.atacarVikingo(vikingo2);

		assertNotEquals(new Muerto(vikingo2), vikingo2.getEstado());
	}
	
	@Test 
	public void muertoAtacaSinDaño() {
		Vikingo vikingo1 = new Vikingo("Ragnar"), vikingo2=new Vikingo("Olaf");
		
		vikingo1.setEstado(new Muerto(vikingo1));
		int vidaInicial = vikingo2.getVida();
		vikingo1.atacarVikingo(vikingo2);
		assertEquals(vidaInicial,vikingo2.getVida());
		
	}
	
	@Test
	public void muertoAtacadoSinCambios() {
		Vikingo vk1 = new Vikingo("Pepe"), vk2 = new Vikingo("Ragnar");
		
		vk1.setEstado(new Muerto(vk1));
		vk2.atacarVikingo(vk1);
		
		assertEquals(vk1.getEstado(), new Muerto(vk1));
	}
	
	@Test
	public void berserkerSacaElTripleDeDanio() {
		Vikingo vk1 = new Vikingo("Ragnar"), vk2 = new Vikingo("asd");
		
		int vidaInicial = vk2.getVida();
		vk1.setEstado(new Berserker(vk1));
		vk1.atacarVikingo(vk2);
		assertEquals(vk2.getVida(), vidaInicial-30);
	}
	
	@Test
	public void normalSaca10Danio() {
		Vikingo vk1 = new Vikingo("Ragnar"), vk2 = new Vikingo("asd");
		
		int vidaInicial = vk2.getVida();
		vk1.atacarVikingo(vk2);
		assertEquals(vk2.getVida(), vidaInicial-10);
	}
	
	@Test 
	public void colericoSacaElDoble() {
		Vikingo vk1 = new Vikingo("qwerty"), vk2 = new Vikingo("Ragnar");
		int vidaInicial = vk2.getVida();
		
		vk1.setEstado(new Colerico(vk1));
		vk1.atacarVikingo(vk2);
		assertEquals(vidaInicial-20,vk2.getVida());
	}
	
}	
