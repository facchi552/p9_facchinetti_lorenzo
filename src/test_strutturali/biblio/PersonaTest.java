package biblio;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class PersonaTest {
	static Sbu sistema;
	static Biblioteca biblio;
	static Persona p;
	static Persona p2;
	
	@BeforeClass 
	public static void setUp() {
		sistema = new Sbu("Sbu");
		biblio = new Biblioteca ("Biblio 1", "piazza Deffe 4", sistema);
		p = new Bibliotecario ("Mario", "Rossi", "via bari 33", new Date(), "cfmario", "7776", "mrossi@gmailcom", "5432", sistema);
		}

	@Test
	public final void testPersona() {
		assertNotNull(p);
	}

	@Test
	public final void testGetCodiceFiscale() {
		String cf;
		cf = p.getCodiceFiscale();
		assertEquals(cf,"cfmario");
	}

	@Test
	public final void testGetEmail() {
		String mail;
		mail = p.getEmail();
		assertEquals(mail,"mrossi@gmailcom");
	}

	@Test
	public final void testGetPassword() {
		String pw;
		pw = p.getPassword();
		assertEquals(pw,"5432");
	}

	
	@Test
	public final void testGetId2() {
		p2 = new Bibliotecario ("Maria", "Rossi", "via bari 33", new Date(), "cfmaria", "7776", "marossi@gmailcom", "5432", sistema);
		int id;
		id = p2.getId();
		assertTrue(id>0);
	}

	@Test
	public final void testGetNome() {
		String nome;
		nome = p.getNome();
		assertEquals(nome,"Mario");
	}

	@Test
	public final void testGetCognome() {
		String cognome;
		cognome = p.getCognome();
		assertEquals(cognome,"Rossi");
	}

}
