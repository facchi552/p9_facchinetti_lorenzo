package biblio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArticoloTest {
	static Sbu sistema;
	static Biblioteca biblio;
	static Articolo l;
	
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
		l = new Libro("Titolo1", "Autore1,Autore2", "Genere1", "collocazione1", biblio,  "isbn", "casa editrice", "102");
		}

	
	@Test
	public final void testGetTitolo() {
		String titolo = l.getTitolo();
		assertEquals("Titolo1",titolo);
	}

	@Test
	public final void testGetSetAutore() {
		String autore = "provautore";
		l.setAutore(autore);
		assertEquals(autore,l.getAutore());
	}

	@Test
	public final void testGetSetGenere() {
		String genere = "provagenere";
		l.setGenere(genere);
		assertEquals(genere,l.getGenere());
	}

	@Test
	public final void testSetGetCollocazione() {
		String collocazione = "provacollocazione";
		l.setCollocazione(collocazione);
		assertEquals(collocazione,l.getCollocazione());
	}

	@Test
	public final void testGetBiblio() {
		biblio.getArticoli().add(l);
		assertEquals(biblio,l.getBiblio());
	}
	
}
