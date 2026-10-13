import java.util.List;

public class Menu {

    private List<contaBancaria> contas;

    public Menu(List<contaBancaria> contas) {
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
}
