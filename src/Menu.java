import java.util.List;

public class Menu {

    //Cria um atributo do tipo list, uma lista que guarda contas bancarias
    private List<contaBancaria> contas;

    //Construtor com o atributo list
    public Menu(List<contaBancaria> contas) {

        //Atributo recebe o parametro do Main
        this.contas = contas;
    }

    public void menuPrincipal() {
        System.out.println("""
                -Sistema de contas bancarias-
                
                O que deseja fazer?
                
                1. adicionar contas
                2. Ver contas
                3. entrar em uma conta 
                0. sair""");
    }

    //Opcao 0
    public void sairDoSistema() {
        System.out.println("Saindo do Sistema...");
    }


    //Opcao 1
    public void adicionarConta() {

        int numeroConta = Integer.parseInt(IO.readln("Qual o número da conta?"));

        String titular = (IO.readln("Qual o titular?"));

        double saldo = Double.parseDouble(IO.readln("Qual o saldo?"));
        contas.add(new contaBancaria(numeroConta, titular, saldo));

    }

    // Opcao 2
    public void verContas() {
        for (contaBancaria mostrarContas : contas) {
            System.out.println(mostrarContas.toString());
        }
    }

    public void entrarConta() {
        System.out.println("Contas disponiveis:");
        verContas();

        System.out.println("Em qual conta você deseja entrar?");
        int numeroBuscado = Integer.parseInt(IO.readln("Número da conta:"));

        contaBancaria contaEntrada = null;

        //Entrar em uma conta
        for (contaBancaria conta : contas) {
            if (numeroBuscado == conta.getNumero()) {
                contaEntrada = conta;
                break;
            }
        }
    }

    public void opcoesContaEntrada() {
        //Boas Vindas a conta entrada
        System.out.println("olá " + contaEntrada.getTitular() + " O que deseja fazer?");

        int opcaoConta = -1;
        while (opcaoConta != 0) {
            System.out.print("""
                    1. depositar dinheiro
                    2. sacar dinheiro
                    3. trasferir dinheiro
                    0. Sair da conta""");

        }
    }
}
