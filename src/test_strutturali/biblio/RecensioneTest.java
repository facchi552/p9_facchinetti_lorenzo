package biblio;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class RecensioneTest {
	static Sbu sistema;
	static Biblioteca biblio;
	static UtenteRegistrato ur;
	static Recensione r;
	
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
		ur = new UtenteRegistrato ("nome", "cognome", "indirizzo", new Date(), "codiceFiscale",
                "telefono", "email", "password", sistema);
		}

	@Test
	public final void testRecensione() {
		r = new Recensione ("Titolo", "testo", ur);
		assertNotNull(r);
	}

}
