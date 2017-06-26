package biblio;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;
import java.util.Arrays;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SbuTestLoginParametrico {
	static Sbu sistema;
	static Biblioteca biblio;
	static UtenteRegistrato ur;

	@Parameters
	public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][]{
	{"mail@gmailcom","1234",true},
	{"nontrovare@mail.com","1234",false},
	{"mail@gmailcom","nontrovare",false},
	{"nontrovare@no.it","nontrovare",false}
	});
	}

	@Parameter(0)
	public String user;

	@Parameter(1)
	public String pass;

	@Parameter(2)
	public boolean found;

	@BeforeClass
	public static void setUp() {
	sistema = new Sbu("Sbu");
	biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
	ur = new UtenteRegistrato ("Lorenzo", "Facchi", "via roma 11", new Date(), "cf", "1234", "mail@gmailcom", "1234", sistema);
	
	sistema.inserisciUtente(ur);
	}

	@Test
	public void testLogin() {
	assertEquals(sistema.login(user, pass),found);
	}

}