import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDAOTest {

    @Test
    public void testValidPerson() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(1, "example@example.com"));
        Person person = new Person(1, "John Doe", 25, emails);

        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);

        assertTrue(errors.isEmpty());
    }

    @Test
    public void testInvalidName() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(1, "example@example.com"));
        Person person = new Person(1, "John", 25, emails);

        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);

        assertFalse(errors.isEmpty());
        assertEquals("O nome deve conter ao menos 2 partes e ser composto por letras.", errors.get(0));
    }

    @Test
    public void testInvalidAge() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(1, "example@example.com"));
        Person person = new Person(1, "John Doe", 201, emails);

        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);

        assertFalse(errors.isEmpty());
        assertEquals("A idade deve estar no intervalo [1, 200].", errors.get(0));
    }

    @Test
    public void testInvalidEmail() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(1, "example@invalid"));
        Person person = new Person(1, "John Doe", 25, emails);

        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);

        assertFalse(errors.isEmpty());
        assertEquals("O email 'example@invalid' está no formato inválido.", errors.get(0));
    }

    @Test
    public void testNoEmails() {
        Person person = new Person(1, "John Doe", 25, new ArrayList<>());

        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);

        assertFalse(errors.isEmpty());
        assertEquals("Deve haver pelo menos um email associado.", errors.get(0));
    }
}
