package biblio;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class BibliotecarioTest {
	static Sbu sistema;
	static Biblioteca biblio;
	static Persona b;
	
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
		b = new Bibliotecario ("Mario", "Rossi", "via bari 33", new Date(), "cfmario", "7776", "mrossi@gmailcom", "5432", sistema);
		}

	@Test
	public final void testBibliotecario() {
		assertNotNull(b);
	}

}
