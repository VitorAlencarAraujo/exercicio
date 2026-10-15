void main () {

    List<contaBancaria> contas = new ArrayList<>();
    Menu menu = new Menu(contas);

    int opcao = -1;

    while (opcao != 0) {
        menu.menuPrincipal();

        opcao = Integer.parseInt(IO.readln());


        switch (opcao) {

            case 0:
                menu.sairDoSistema();
                return;

            case 1:
                menu.adicionarConta();
                break;

            case 2:
                menu.verContas();
                break;

            case 3:
                menu.entrarConta();

                int opcaoConta = -1;
                while (opcaoConta != 0) {

                    //Boas vindas + menu de opcoes da conta Entrada
                    menu.opcoesContaEntrada();

                    opcaoConta = Integer.parseInt(IO.readln());
                    switch (opcaoConta) {

                        case 0:
                            menu.sairConta();
                            break;

                        case 1:
                            menu.depositar();
                            break;

                        case 2:
                            menu.sacar();
                            break;

                        case 3:

                            // Transferir dinheiro
                            menu.verContas();
                            menu.transferir();
                            break;
                    }
                }
        }
    }
}