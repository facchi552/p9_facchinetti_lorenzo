package biblio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test per Uc23 Registra nuovo utente
 */
public class SbuTestUc23 {
	
	static Sbu sistema;
	
	/**
	 * Metodo di Setup per i vari TestCase
	 */
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
	}
	
	/**
	 * Test per lo scenario standard
	 */
	@Test
	public void uc23 () {
		UtenteRegistrato ur;
		ur = new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(1991, 20, 02), "cf", "1234", "mail@gmailcom", "1234", sistema);
		sistema.inserisciUtente(ur);
		ArrayList<Persona> personetemp;
		personetemp = sistema.getPersone();
		assertEquals(ur.getCodiceFiscale(), personetemp.get(0).getCodiceFiscale());
	}

	/**
	 * Test per lo scenario 6a 
	 */
	@Test
	public void uc236a () {
		assertNotNull(sistema);
	}
	
	/**
	 * Test per lo scenario 6b , dovrebbe essere 2 invece se e' uguale non lo inserisce  ( e lo segnala )
	 */
	@Test
	public void uc236b () {
		UtenteRegistrato ur;
		ur = new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(1991, 20, 02), "cf", "1234", "mail@gmailcom", "1234", sistema);
		sistema.inserisciUtente(ur);
		ArrayList<Persona> personetemp;
		personetemp=sistema.getPersone();
		assertEquals(personetemp.size(),1);
	}
	
}
