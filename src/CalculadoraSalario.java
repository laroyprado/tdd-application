
public class CalculadoraSalario {

    public double calcularSalarioLiquido(Funcionario funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        String cargo = funcionario.getCargo().toLowerCase();

        switch (cargo) {
            case "desenvolvedor":
                return salarioBase >= 3000 ? salarioBase * 0.8 : salarioBase * 0.9;
            case "dba":
            case "testador":
                return salarioBase >= 2000 ? salarioBase * 0.75 : salarioBase * 0.85;
            case "gerente":
                return salarioBase >= 5000 ? salarioBase * 0.7 : salarioBase * 0.8;
            default:
                throw new IllegalArgumentException("Cargo desconhecido: " + cargo);
        }
    }
}