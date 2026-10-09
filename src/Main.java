void main () {

    Scanner sc = new Scanner(System.in);
    List<contaBancaria> contas = new ArrayList<>();
    Menu menu = new Menu();

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

                contas.add(new contaBancaria(numeroConta, titular, saldo));
                break;

            case 2:
                for (contaBancaria mostrarContas : contas) {
                    System.out.println(mostrarContas.toString());
                }
                break;

            case 3:
                System.out.println("Contas disponiveis:");

                for (contaBancaria mostrarContas : contas) {
                    System.out.println(mostrarContas.toString());
                }

                System.out.println("Em qual conta você deseja entrar?");
                System.out.println("Número da conta:");

                int numeroBuscado = sc.nextInt();

                for (contaBancaria contaEntrada : contas) {
                    if (numeroBuscado == contaEntrada.getNumero()) {
                        System.out.println("olá " + contaEntrada.getTitular() + " O que deseja fazer?");

                        int opcaoConta = -1;
                        while (opcaoConta != 0) {
                            System.out.println("""
                                    1. depositar dinheiro 
                                    2. sacar dinheiro
                                    3. trasferir dinheiro
                                    0. Sair da conta""");

                            opcaoConta = sc.nextInt();
                            switch (opcaoConta) {

                                case 0:
                                    System.out.println("Saindo da conta...");
                                    break;

                                case 1:
                                    System.out.println("Quanto você deseja depositar?");
                                    double valorDeposito = sc.nextDouble();

                                    contaEntrada.depositar(valorDeposito);
                                    System.out.println("Deposito realizado! \nnovo saldo " + contaEntrada.getSaldo());
                                    break;

                                case 2:
                                    System.out.println("Quanto você deseja sacar?");
                                    double valorSaque = sc.nextDouble();

                                    System.out.println("Saque realizado! novo saldo" + contaEntrada.getSaldo());
                                    break;

                                case 3:
                                    System.out.println("Contas disponiveis:");
                                    for (contaBancaria mostrarContas : contas) {
                                        System.out.println(mostrarContas.toString());
                                    }

                                    System.out.println("Para qual conta você deseja transferir? Informe o numero da conta:");
                                    int numeroParaTransferencia = sc.nextInt();

                                    for (contaBancaria contaParaTransferencia : contas){
                                        if (numeroParaTransferencia == contaParaTransferencia.getNumero()){
                                            System.out.println("Quanto você deseja transferir? ");
                                            double valorParaTransferencia = sc.nextDouble();

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
    }
}