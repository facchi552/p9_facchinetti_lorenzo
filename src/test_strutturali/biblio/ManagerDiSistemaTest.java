package biblio;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class ManagerDiSistemaTest {
	static Sbu sistema;
	static Biblioteca biblio;
	static ManagerDiSistema man;
	
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
		}

	@Test
	public final void testManagerDiSistema() {
		man = new ManagerDiSistema ("nome", "cognome", "indirizzo", new Date(), "codiceFiscale",
			                        "telefono", "email", "password", sistema);
		assertNotNull(man);
	}

}
