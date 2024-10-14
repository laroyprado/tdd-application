import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraSalarioTest {

    @Test
    public void testDesenvolvedorSalarioAcimaDe3000() {
        Funcionario dev = new Funcionario("Alice", "alice@example.com", 4000, "Desenvolvedor");
        CalculadoraSalario calculadora = new CalculadoraSalario();
        assertEquals(3200, calculadora.calcularSalarioLiquido(dev));
    }

    @Test
    public void testDesenvolvedorSalarioAbaixoDe3000() {
        Funcionario dev = new Funcionario("Bob", "bob@example.com", 2500, "Desenvolvedor");
        CalculadoraSalario calculadora = new CalculadoraSalario();
        assertEquals(2250, calculadora.calcularSalarioLiquido(dev));
    }

    @Test
    public void testDbaSalarioAcimaDe2000() {
        Funcionario dba = new Funcionario("Carol", "carol@example.com", 2500, "DBA");
        CalculadoraSalario calculadora = new CalculadoraSalario();
        assertEquals(1875, calculadora.calcularSalarioLiquido(dba));
    }

    @Test
    public void testDbaSalarioAbaixoDe2000() {
        Funcionario dba = new Funcionario("Dave", "dave@example.com", 1800, "DBA");
        CalculadoraSalario calculadora = new CalculadoraSalario();
        assertEquals(1530, calculadora.calcularSalarioLiquido(dba));
    }

    @Test
    public void testGerenteSalarioAcimaDe5000() {
        Funcionario gerente = new Funcionario("Eve", "eve@example.com", 6000, "Gerente");
        CalculadoraSalario calculadora = new CalculadoraSalario();
        assertEquals(4200, calculadora.calcularSalarioLiquido(gerente));
    }

    @Test
    public void testGerenteSalarioAbaixoDe5000() {
        Funcionario gerente = new Funcionario("Frank", "frank@example.com", 4500, "Gerente");
        CalculadoraSalario calculadora = new CalculadoraSalario();
        assertEquals(3600, calculadora.calcularSalarioLiquido(gerente));
    }

    @Test
    public void testCargoDesconhecido() {
        Funcionario unknown = new Funcionario("Grace", "grace@example.com", 3000, "Designer");
        CalculadoraSalario calculadora = new CalculadoraSalario();
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularSalarioLiquido(unknown));
    }
}
