package biblio;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class LibroTest {
	static Sbu sistema;
	static Biblioteca biblio;
	static Libro l;
	
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
		}
	
	@Test
	public final void testLibro() {
		l = new Libro("Titolo1", "Autore1,Autore2", "Genere1", "collocazione1", biblio,  "isbn", "casa editrice", "102");
		assertNotNull(l);
	}

	@Test
	public final void testGetIsbn() {
		String isbn;
		isbn = l.getIsbn();
		assertEquals(isbn,"isbn");
	}

	@Test
	public final void testGetCasaEditrice() {
		String casaEd;
		casaEd = l.getCasaEditrice();
		assertEquals(casaEd,"casa editrice");
	}

	@Test
	public final void testGetPagine() {
		String pagine;
		pagine = l.getPagine();
		assertEquals(pagine, "102");
	}

}
