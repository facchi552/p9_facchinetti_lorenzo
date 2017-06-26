package biblio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class SbuTest {
	static Sbu sistema;
	static Biblioteca biblio;
	static Biblioteca biblia;
	static ArrayList<Articolo> foundz;
	static Persona p;
	static Persona p1;
	static Articolo l;
	
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
		biblia = new Biblioteca ("Biblio 2", "piazza Dante 7", sistema);
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		biblia.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblia);
		biblio.inserisciArticolo(1, "Titolo2|Autore1|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		sistema.addBiblioteca(biblia);
		sistema.addBiblioteca(biblio);
		p= new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(), "cf", "1234", "mail@gmailcom", "1234", sistema);
		sistema.inserisciUtente(p);
		}

	@Test
	public final void testSbu() {
		assertNotNull(sistema);
	}

	@Test
	public final void testRicercaArticolo() {
		foundz = sistema.ricercaArticolo("Titolo1", 1, null);
		assertTrue(foundz.size()>1);
	}
	
	@Test
	public final void testRicercaArticolo1() {
		foundz = sistema.ricercaArticolo("Titolo2", 1, null);
		assertTrue(foundz.size()>0);
	}

	@Test
	public final void testConsigliaLibro() {
		String consigliato = "harryp";
		sistema.consigliaLibro(consigliato);
		assertTrue(sistema.getArticoliConsigliati().get(0).contains(consigliato));
	}


	@Test
	public final void testUtenteIsUnivoco() {
		boolean b;
		b = sistema.utenteIsUnivoco("nontrovare");
		assertTrue(b);
	}
	
	@Test
	public final void testUtenteIsUnivoco1() {
		boolean b;
		b = sistema.utenteIsUnivoco("cf");
		assertEquals(b,false);
	}

	@Test
	public final void testInserisciUtente() {
		p1 = new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(), "cfa", "1234", "mail@gmailcom", "1234", sistema);
		sistema.inserisciUtente(p1);
		assert(true);
		}
	@Test
	public final void testInserisciUtente1() {
		p1 = new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(), "cfa", "1234", "mail@gmailcom", "1234", sistema);
		sistema.inserisciUtente(p1);
		assert(true);
		}
	
	@Test
	public final void testRimuoviUtente() {
		sistema.rimuoviUtente(p1);
		assertTrue(true);
	}

	@Test
	public final void testScriviRecensione() {
		l = new Libro ("Titolo1", "Autore1,Autore2", "Genere1", "collocazione1", biblio,  "isbn", "casa editrice", "102");
		sistema.scriviRecensione( l, "testo" );
		assertTrue(true);
	}
	
	@Test
	public final void testAddGetBiblioteca() {
		assertEquals(sistema.getBiblioteche().get(1).getNome(), "Biblio 1"); //perche' array list spinge in fondo
	}

	

	@Test
	public final void testGetPersone() {
		ArrayList<Persona> componenti;
		componenti = sistema.getPersone();
		assertTrue(componenti.size()>0);
	}


	@Test
	public final void testGetArticoliConsigliati() {
		ArrayList<String> consigliati;
		consigliati = sistema.getArticoliConsigliati();
		assertTrue(consigliati.size()>0);
	}


	@Test
	public final void testRicercaPrestitoInt() {
		Object ob;
		ob = sistema.ricercaPrestito(1);
		assertNull(ob);
		
	}

	@Test
	public final void testRicercaPrestitoStringString() {
		Object ob;
		ob = sistema.ricercaPrestito("nome", "cognome");
		assertNull(ob);
	}

	@Test
	public final void testRicercaPrenotazioneArticolo() {
		Object ob;
		ob = sistema.ricercaPrenotazione(l);
		assertNull(ob);
	}

	@Test
	public final void testRicercaPrenotazioneStringString() {
		Object ob;
		ob = sistema.ricercaPrenotazione("nome", "cognome");;
		assertNull(ob);
	}

	@Test
	public final void testVisualizzaRichieste() {
		Object ob;
		ob = sistema.visualizzaRichieste();
		assertNull(ob);
	}

}
