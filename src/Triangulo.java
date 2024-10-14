public class Triangulo {

    public String determinarTipoTriangulo(int lado1, int lado2, int lado3) {
        if (!isTrianguloValido(lado1, lado2, lado3)) {
            return "Não é um triângulo";
        }

        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    private boolean isTrianguloValido(int lado1, int lado2, int lado3) {
        return (lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1);
    }
}
