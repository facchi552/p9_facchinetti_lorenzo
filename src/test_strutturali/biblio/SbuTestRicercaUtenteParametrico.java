package biblio;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SbuTestRicercaUtenteParametrico {
	static Sbu sistema;
	static Biblioteca biblio;
	static UtenteRegistrato ur;
	static ArrayList<Persona> trovati;
	

	@Parameters
	public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][]{
	{"Lorenzo|Facchi",1},
	{"Lorenzo|nontrovare",1},
	{"nontrovare|Facchi",1},
	{"Non|trovare",0},
	});
	}

	@Parameter(0)
	public String nomeCognome;

	@Parameter(1)
	public int size;



	@BeforeClass
	public static void setUp() {
	sistema = new Sbu("Sbu");
	biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
	ur = new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(), "cf", "1234", "mail@gmailcom", "1234", sistema);
	
	trovati = new ArrayList<Persona>();
	
	sistema.inserisciUtente(ur);
	
	}

	@Test
	public void testLogin() {
	trovati=sistema.ricercaUtente(nomeCognome);
	assertEquals(trovati.size(),size);
	}

}
