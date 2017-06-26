package biblio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class BibliotecaTest {
	static Sbu sistema;
	static Biblioteca biblio;
	static Libro l;
	static Miscellanea m;
	
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
		l = new Libro ("Titolo1", "Autore1,Autore2", "Genere1", "collocazione1", biblio,  "isbn", "casa editrice", "102");
		m = new Miscellanea ("Titolo1", "Autore1", "Genere1", "collocazione1", biblio, "dvd");
		}

	@Test
	public final void testBiblioteca() {
		assertNotNull(biblio);
	}

	@Test
	public final void testInserisciArticoloLibro() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		assertTrue(biblio.getArticoli().size() > 0);
	}
	
	@Test
	public final void testInserisciArticoloMiscellanea() {
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		assertTrue(biblio.getArticoli().size() > 0 );
	}
	
	@Test
	public final void testInserisciArticoloInesistnente() {
		int oldsize = biblio.getArticoli().size();
		biblio.inserisciArticolo(3, "nonesiste|nonesiste|nonesiste|nonesiste|nonesiste", biblio);
		assertEquals(biblio.getArticoli().size(),oldsize);
	}

	@Test
	public final void testRicercaArticoloLibro1() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		ArrayList<Articolo> trovati;
		trovati = biblio.ricercaArticolo("Tit", 1, null);
		assertTrue(trovati.size() > 0);
	}
	
	
	@Test
	public final void testRicercaArticoloLibro2() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		ArrayList<Articolo> trovati;
		trovati = biblio.ricercaArticolo("nontrovare", 1, null);
		assertTrue(trovati.size() == 0);
	}
	
	@Test
	public final void testRicercaArticoloLibro3() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autore1,Autore2";
		filtri[1]=null;
		trovati = biblio.ricercaArticolo(null, 1, filtri);
		assertTrue(trovati.size() > 0);
	}
	
	@Test
	public final void testRicercaArticoloLibro4() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autoreeeeee";
		filtri[1]=null;
		trovati = biblio.ricercaArticolo(null, 1, filtri);
		assertTrue(trovati.size() == 0);
	}
	
	@Test
	public final void testRicercaArticoloLibro5() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autore1,Autore2";
		filtri[1]="Genere1";
		trovati = biblio.ricercaArticolo(null, 1, filtri);
		assertTrue(trovati.size() > 0);
	}
	
	@Test
	public final void testRicercaArticoloLibro6() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autoreeeeee";
		filtri[1]="Genere1";
		trovati = biblio.ricercaArticolo(null, 1, filtri);
		assertTrue(trovati.size() > 0);
	}
	
	@Test
	public final void testRicercaArticoloLibro7() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		trovati = biblio.ricercaArticolo("MISC2", 1, null);
		assertTrue(trovati.size() == 0);
	}
	
	@Test
	public final void testRicercaArticoloMiscellanea1() {
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		trovati = biblio.ricercaArticolo("MISC2", 2, null);
		assertTrue(trovati.size() > 0);
	}
	
	
	@Test
	public final void testRicercaArticoloMiscellanea2() {
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		ArrayList<Articolo> trovati;
		trovati = biblio.ricercaArticolo("nontrovare", 2, null);
		assertTrue(trovati.size() == 0);
	}
	
	@Test
	public final void testRicercaArticoloMiscellanea3() {
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autore2";
		filtri[1]=null;
		trovati = biblio.ricercaArticolo(null, 2, filtri);
		assertTrue(trovati.size() > 0);
	}
	
	@Test
	public final void testRicercaArticoloMiscellanea4() {
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autoreeeeee";
		filtri[1]=null;
		trovati = biblio.ricercaArticolo(null, 2, filtri);
		assertTrue(trovati.size() == 0);
	}
	
	@Test
	public final void testRicercaArticoloMiscellanea5() {
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autore2";
		filtri[1]="Genere1";
		trovati = biblio.ricercaArticolo(null, 2, filtri);
		assertTrue(trovati.size() > 0);
	}
	
	@Test
	public final void testRicercaArticoloMiscellanea6() {
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autoreeeeee";
		filtri[1]="Genere1";
		trovati = biblio.ricercaArticolo(null, 2, filtri);
		assertTrue(trovati.size() > 0);
		
	}
	
	@Test
	public final void testRicercaArticoloMiscellanea7() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		trovati = biblio.ricercaArticolo("Titolo1", 2, null);
		assertTrue(trovati.size() == 0);
	}
	
	@Test
	public final void testRicercaArticoloLibera1() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		trovati = biblio.ricercaArticolo("MISC2", 3, null);
		assertTrue(trovati.size() > 0);
	}
	
	
	@Test
	public final void testRicercaArticoloLibera2() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		trovati = biblio.ricercaArticolo("nontrovare", 3, null);
		assertTrue(trovati.size() == 0);
	}
	
	@Test
	public final void testRicercaArticoloLibera3() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autore2";
		filtri[1]=null;
		trovati = biblio.ricercaArticolo(null, 3, filtri);
		assertTrue(trovati.size() > 0);
	}
	
	@Test
	public final void testRicercaArticoloLibera4() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autoreeeeee";
		filtri[1]=null;
		trovati = biblio.ricercaArticolo(null, 3, filtri);
		assertTrue(trovati.size() == 0);
	}
	
	@Test
	public final void testRicercaArticoloLibera5() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autore2";
		filtri[1]="Genere1";
		trovati = biblio.ricercaArticolo(null, 3, filtri);
		assertTrue(trovati.size() > 0);
	}
	
	@Test
	public final void testRicercaArticoloLibera6() {
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		biblio.inserisciArticolo(2, "MISC2|Autore2|Genere1|collocazione2|rivista", biblio);
		ArrayList<Articolo> trovati;
		String filtri[] = new String[2];
		filtri[0]="Autoreeeeee";
		filtri[1]="Genere1";
		trovati = biblio.ricercaArticolo(null, 3, filtri);
		assertTrue(trovati.size() > 0);
	}
	
	@Test
	public final void testGetNome() {
		String nome = biblio.getNome();
		assertEquals("Biblio 1", nome);
	}

	@Test
	public final void testGetArticoli() {
	   ArrayList<Articolo> articoli = new ArrayList<Articolo>();
	   articoli = biblio.getArticoli();
	   assertTrue(articoli.size() > 0);
	}

}
