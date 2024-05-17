import java.util.Scanner;

abstract class Funcionario  {
    String nome;
    double salario;

    abstract void calcularSalario();
    abstract void exibirInformacoes();
}
class gerente extends Funcionario{
    double bonus;

    gerente(String nome, double salario, double bonus){
        this.nome = nome; 
        this.salario = salario;
        this.bonus = bonus;
    }


    @Override
    void calcularSalario() {
        salario += bonus;

    }

    @Override
    void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Bônus: " + bonus);
        System.out.println("Salário final : " + salario);

    }
}

class programador extends Funcionario{
    String nivel;

    programador(String nome, double salario, String nivel){
        this.nome = nome;
        this.salario = salario;
        this.nivel = nivel;
    }

    @Override
    void calcularSalario() {
        double salarioBase;

        switch (nivel) {
            case "Junior":
            salarioBase = 3000.0;
            break;
            case "Pleno":
            salarioBase = 6000.0;
            break;
            case "Senior":
            salarioBase = 9000.0;
            break;

            default:
            salarioBase = 0.0;
        }
       salario =+ salarioBase;
    }

    @Override
    void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Salario: " + salario);
        System.out.println("Bônus: " + nivel);
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seu nome:");
        String nome = sc.nextLine();

        System.out.println("Você é gerente ou programador: G para gerente e P para programador.");
        String cargo = sc. nextLine();

        if (cargo.equalsIgnoreCase("g")){
            System.out.println("Olá senhor " + nome + " informe o seu salário:");
            Double salario = sc.nextDouble();

            System.out.println("Informe os seu bônus:");
            Double bonus = sc.nextDouble();

            gerente gerente = new gerente(nome, salario, bonus);
            gerente.calcularSalario();
            gerente.exibirInformacoes();


       }else if (cargo.equalsIgnoreCase("p")){
        System.out.println("Olá senhor " + nome + "Informe o seu nível:");
            String nivel = sc.nextLine();
        System.out.println("insira se salário");    
            Double salario = sc.nextDouble();
        

            programador programador = new programador(nome, salario, nivel);

            programador.calcularSalario();
            programador.exibirInformacoes();
       }

       sc.close();
    }
    
}
