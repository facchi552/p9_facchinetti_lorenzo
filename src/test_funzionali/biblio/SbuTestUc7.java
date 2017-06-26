package biblio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test per Uc7 Ricerca Utente Registrato
 */
public class SbuTestUc7 {
	
	static Sbu sistema;
	
	/**
	 * Metodo di Setup per i vari TestCase
	 */
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		sistema.inserisciUtente(new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(1991, 20, 02), "cf", "1234", "amail@gmailcom", "1234", sistema));
		sistema.inserisciUtente(new UtenteRegistrato ("Mario", "rossi", "via roma 11", new Date(), "cfmaria", "1234", "ehe@gmailcom", "1234", sistema));
		}
	
	/**
	 * Test per lo scenario standard
	 */
	@Test
	public void uc7 () {
		ArrayList<Persona> temp;
		UtenteRegistrato ur;
	    ur = new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(1991, 20, 02), "cf", "1234", "mail@gmailcom", "1234", sistema);
		temp = sistema.ricercaUtente("Lorenzo|Facchi");
		assertEquals(ur.getCodiceFiscale(), temp.get(0).getCodiceFiscale());
		System.out.println(temp.get(0).getCodiceFiscale());
	}


		
}
