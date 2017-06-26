package biblio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test per Uc2 Inserire nuovo articolo
 */
public class SbuTestUc2 {
	
	static Sbu sistema;
	static Biblioteca biblio;
	
	/**
	 * Metodo di Setup per i vari TestCase
	 */
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
	}
	
	/**
	 * Test per lo scenario standard
	 */
	@Test
	public void uc2 () {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		ArrayList<Articolo> temp;
		temp=biblio.getArticoli();
		assertEquals(temp.get(0).getTitolo(),"Titolo1");
	}
	
	/**
	 * Test per lo scenario 3a
	 */
	@Test
	public void uc23a () {
		biblio.inserisciArticolo(2, "Titolo2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> temp;
		temp=biblio.getArticoli();
		assertEquals(temp.get(1).getTitolo(),"Titolo2");
	}

	/**
	 * Test per lo scenario 8a
	 */
	@Test
	public void uc28a () {
		assertNotNull(sistema);
	}
	
}
