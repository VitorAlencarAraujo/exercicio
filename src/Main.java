void main () {

    Scanner sc = new Scanner(System.in);
    List<contaBancaria> contas = new ArrayList<>();
    Menu menu = new Menu(contas);

    int opcao = -1;

    while (opcao != 0) {
        menu.menuPrincipal();

        opcao = sc.nextInt();


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

                //Boas Vindas a conta entrada
                System.out.println("olá " + contaEntrada.getTitular() + " O que deseja fazer?");

                int opcaoConta = -1;
                while (opcaoConta != 0) {
                    System.out.print("""
                            1. depositar dinheiro
                            2. sacar dinheiro
                            3. trasferir dinheiro
                            0. Sair da conta""");

                    opcaoConta = Integer.parseInt(IO.readln());
                    switch (opcaoConta) {

                        case 0:
                            System.out.println("Saindo da conta...");
                            break;

                        case 1:
                            double valorDeposito = Double.parseDouble(IO.readln("Quanto você deseja depositar?"));

                            contaEntrada.depositar(valorDeposito);
                            System.out.println("Deposito realizado! \nnovo saldo " + contaEntrada.getSaldo());
                            break;

                        case 2:
                            double valorSaque = Double.parseDouble(IO.readln("Quanto você deseja sacar?"));
                            contaEntrada.sacar(valorSaque);

                            System.out.println("Saque realizado! novo saldo" + contaEntrada.getSaldo());
                            break;

                        case 3:
                            System.out.println("Contas disponiveis:");
                            for (contaBancaria mostrarContas : contas) {
                                System.out.println(mostrarContas.toString());
                            }

                            int numeroParaTransferencia = Integer.parseInt(IO.readln("Para qual conta você deseja transferir? Informe o numero da conta:"));

                            for (contaBancaria contaParaTransferencia : contas){
                                if (numeroParaTransferencia == contaParaTransferencia.getNumero()){
                                    double valorParaTransferencia = Double.parseDouble(IO.readln("Quanto você deseja transferir?"));

                                    contaEntrada.transferir(valorParaTransferencia);
                                    contaParaTransferencia.receberTransferencia(valorParaTransferencia);

                                    System.out.println("Transferencia realizada! Novo saldo: " + contaEntrada.getSaldo());
                                }
                            }
                            break;
                    }
                }
        }
    }
}