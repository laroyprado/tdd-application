import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();

        if (!isValidName(p.getName())) {
            errors.add("O nome deve conter ao menos 2 partes e ser composto por letras.");
        }

        if (p.getAge() < 1 || p.getAge() > 200) {
            errors.add("A idade deve estar no intervalo [1, 200].");
        }

        // Verificar emails
        if (p.getEmails() == null || p.getEmails().isEmpty()) {
            errors.add("Deve haver pelo menos um email associado.");
        } else {
            for (Email email : p.getEmails()) {
                if (!isValidEmail(email.getName())) {
                    errors.add("O email '" + email.getName() + "' está no formato inválido.");
                }
            }
        }

        return errors;
    }

    private boolean isValidName(String name) {
        String[] parts = name.split(" ");
        if (parts.length < 2) {
            return false;
        }
        for (String part : parts) {
            if (!part.matches("[a-zA-Z]+")) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        return email.matches(".+@.+\\..+");
    }
}