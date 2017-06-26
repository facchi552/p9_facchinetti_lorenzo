package biblio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test per Uc27 Cosniglia Acquisto nuovi libri
 */
public class SbuTestUc27 {
	
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
	public void uc27 () {
		ArrayList<String> temp;
		
		sistema.consigliaLibro("Vorrei che venisse acquistato il libro xxx dell'autore yyy");
		temp=sistema.getArticoliConsigliati();
		System.out.println(temp);
		assertEquals("Vorrei che venisse acquistato il libro xxx dell'autore yyy" + " |pending|", temp.get(0));
	}

	/**
	 * Test per lo scenario 7a 
	 */
	@Test
	public void uc277a () {
		assertNotNull(sistema);
	}
}