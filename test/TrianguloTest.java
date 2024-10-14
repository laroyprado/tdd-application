import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrianguloTest {

    @Test
    public void testTrianguloEquilatero() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Equilátero", triangulo.determinarTipoTriangulo(3, 3, 3));
    }

    @Test
    public void testTrianguloIsosceles() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Isósceles", triangulo.determinarTipoTriangulo(3, 3, 2));
        assertEquals("Isósceles", triangulo.determinarTipoTriangulo(3, 2, 3));
        assertEquals("Isósceles", triangulo.determinarTipoTriangulo(2, 3, 3));
    }

    @Test
    public void testTrianguloEscaleno() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Escaleno", triangulo.determinarTipoTriangulo(3, 4, 5));
    }

    @Test
    public void testLadoZero() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Não é um triângulo", triangulo.determinarTipoTriangulo(0, 4, 5));
    }

    @Test
    public void testLadoNegativo() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Não é um triângulo", triangulo.determinarTipoTriangulo(-1, 4, 5));
    }

    @Test
    public void testSomaDoisLadosIgualTerceiro() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Não é um triângulo", triangulo.determinarTipoTriangulo(1, 2, 3));
        assertEquals("Não é um triângulo", triangulo.determinarTipoTriangulo(2, 1, 3));
        assertEquals("Não é um triângulo", triangulo.determinarTipoTriangulo(3, 1, 2));
    }

    @Test
    public void testTresLadosZero() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Não é um triângulo", triangulo.determinarTipoTriangulo(0, 0, 0));
    }
}
