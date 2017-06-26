package biblio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test per Uc3 Ricerca Articolo
 */
public class SbuTestUc3 {
	
	static Sbu sistema;
	static Biblioteca biblio;
	static Biblioteca biblia;
	
	/**
	 * Metodo di Setup per i vari TestCase
	 */
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio= new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
		biblia= new Biblioteca ("Biblio 2", "piazza Dante 7", sistema);
		sistema.addBiblioteca(biblio); 
		sistema.addBiblioteca(biblia);
		
		/** Inserisco qualche libro */
		biblio.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblio);
		biblia.inserisciArticolo(1, "Titolo1|Autore1,Autore2|Genere1|collocazione1|isbn|casa editrice|102", biblia);
		biblia.inserisciArticolo(1, "Titolo3|Autore3|Genere3|collocazione3|isbn|casa editrice|565", biblia);
		
		/** Inserisco qualche miscellanea */
		biblio.inserisciArticolo(2, "Titolo1|Autore1|Genere1|collocazione1|dvd", biblia);
		biblio.inserisciArticolo(2, "Titolo5|Autore2|Genere1|collocazione2|rivista", biblio);
		
		}
	
	
	/**
	 * Test per lo scenario standard mi aspetto che per titolo 1 trovi 2 entry ( e non 3 ) poiche' selezionato libro
	 */
	@Test
	public void uc3a () {
		ArrayList<Articolo> founda = new ArrayList<Articolo>();
		
		founda = sistema.ricercaArticolo("Titolo1",1,null);
		System.out.println(founda.size());
		assertEquals(founda.size(), 2);
	}

	/**
	 * Test per lo scenario 2a 
	 */
	@Test
	public void uc32a () {
		ArrayList<Articolo> founda = new ArrayList<Articolo>();
		
		founda = sistema.ricercaArticolo("Titolo5",2,null);
		assertEquals(founda.size(), 1);
	}
	
	/**
	 * Test per lo scenario 2b mi aspetto che per titolo1 trovi 3 entry poiche' non ha selezionato filtri
	 */
	@Test
	public void uc32b () {
		ArrayList<Articolo> founda = new ArrayList<Articolo>();
		
		founda = sistema.ricercaArticolo("Titolo1",0,null);
		assertEquals(founda.size(), 3);
	}
	
	/**
	 * Test per lo scenario 4a mi aspetto che trovi 2 entry per Autore1,Autore2 fra i libri
	 */
	@Test
	public void uc34a () {
		String fil[]=new String [2]; // versione prototipale implementati solo genere e autore
		ArrayList<Articolo> founda = new ArrayList<Articolo>();
		fil[0]="Autore1,Autore2";
		fil[1]="";
		founda = sistema.ricercaArticolo(null,1,fil);
		assertEquals(founda.size(), 2);
	}
	
	/**
	 * Test per lo scenario 4d mi aspetto che trovi 1 entry per Genere 3 fra i libri
	 */
	@Test
	public void uc34d () {
		String fil[]=new String [2]; // versione prototipale implementati solo genere e autore
		ArrayList<Articolo> founda = new ArrayList<Articolo>();
		fil[0]="";
		fil[1]="Genere3";
		founda = sistema.ricercaArticolo(null,1,fil);
		assertEquals(founda.size(), 1);
	}
	
	/**
	 * Test per lo scenario 7a
	 */
	@Test
	public void uc37a () {
		ArrayList<Articolo> founda = new ArrayList<Articolo>();
		
		founda = sistema.ricercaArticolo("Titolo52",2,null);
		assertEquals(founda.size(), 0);
	}
		
}
