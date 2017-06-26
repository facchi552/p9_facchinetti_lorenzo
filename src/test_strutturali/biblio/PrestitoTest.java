package biblio;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class PrestitoTest {
	static Sbu sistema;
	static Biblioteca biblio;
	static UtenteRegistrato ur;
	static Prestito p;
	static Articolo l;
	
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
		ur = new UtenteRegistrato ("nome", "cognome", "indirizzo", new Date(), "codiceFiscale",
                "telefono", "email", "password", sistema);
		l = new Libro("Titolo1", "Autore1,Autore2", "Genere1", "collocazione1", biblio,  "isbn", "casa editrice", "102");
		}

	@Test
	public final void testPrestito() {
		p = new Prestito (new Date(), new Date(), 0, l, ur);
		assertNotNull(p);
	}
	
}
