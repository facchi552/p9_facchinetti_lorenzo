package biblio;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class MiscellaneaTest {

	static Sbu sistema;
	static Biblioteca biblio;
	static Miscellanea m;
	
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
		}
	
	@Test
	public final void testLibro() {
		m = new Miscellanea ("MISC2", "Autore2", "Genere1", "collocazione2", biblio, "rivista");
		assertNotNull(m);
	}

	@Test
	public final void testTipo() {
		String tipo;
		tipo = m.getTipo();
		assertEquals(tipo,"rivista");
	}

}
