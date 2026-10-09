public class Menu {

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

        int numeroConta = Integer.parseInt(IO.readln());

        String titular = (IO.readln("Qual o titular?"));

        double saldo = Double.parseDouble(IO.readln("Qual o saldo?"));

    }
}
