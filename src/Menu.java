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

    contaBancaria contaEntrada = null;

    public void entrarConta() {

        System.out.println("Contas disponiveis:");
        verContas();

        System.out.println("Em qual conta você deseja entrar?");
        int numeroBuscado = Integer.parseInt(IO.readln("Número da conta:"));


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

        System.out.println("""
                1. depositar dinheiro
                2. sacar dinheiro
                3. trasferir dinheiro
                0. Sair da conta""");

    }

    // Opcao 0
    public void sairConta() {
        System.out.println("Saindo da conta...");
    }

    // Opcao 1
    public void depositar() {
        double valorDeposito = Double.parseDouble(IO.readln("Quanto você deseja depositar?"));

        contaEntrada.depositar(valorDeposito);
        System.out.println("Deposito realizado! \nnovo saldo " + contaEntrada.getSaldo());
    }

    // Opcao 2
    public void sacar() {
        double valorSaque = Double.parseDouble(IO.readln("Quanto você deseja sacar?"));
        contaEntrada.sacar(valorSaque);

        System.out.println("Saque realizado! novo saldo" + contaEntrada.getSaldo());
    }

    // Opcao 3
    public void transferir() {
        int numeroParaTransferencia = Integer.parseInt(IO.readln("Para qual conta você deseja transferir? Informe o numero da conta:"));

        for (contaBancaria contaParaTransferencia : contas) {
            if (numeroParaTransferencia == contaParaTransferencia.getNumero()) {
                double valorParaTransferencia = Double.parseDouble(IO.readln("Quanto você deseja transferir?"));

                contaEntrada.transferir(valorParaTransferencia);
                contaParaTransferencia.receberTransferencia(valorParaTransferencia);

                System.out.println("Transferencia realizada! Novo saldo: " + contaEntrada.getSaldo());
            }
        }
    }
}