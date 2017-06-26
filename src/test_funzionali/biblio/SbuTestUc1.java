package biblio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test per Uc1 Autenticarsi
 */
public class SbuTestUc1 {
	
	static Sbu sistema;
	
	/**
	 * Metodo di Setup per i vari TestCase
	 */
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		sistema.inserisciUtente(new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(), "cf", "1234", "amail@gmailcom", "1234", sistema));
		}
	
	/**
	 * Test per lo scenario standard
	 */
	@Test
	public void uc1 () {
		
	assertTrue(sistema.login("amail@gmailcom", "1234"));
	}

	/**
	 * Test per lo scenario 5a 
	 */
	@Test
	public void uc15a () {
		assertFalse(sistema.login("aaaaaaaaaaaamail@gmailcom", "1234"));
	}
	
}
