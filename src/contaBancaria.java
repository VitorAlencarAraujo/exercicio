public class contaBancaria {

    //Atributos
    int numero;
    String titular;
    double saldo;

    //Construtor
    public contaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    //Getters
    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    //Metodos
    public void depositar(double valor){
        saldo += valor;
    }

    public void sacar (double valor){
        saldo -= valor;
    }

    public void transferir (double valor){
        saldo -= valor;
    }

    public void receberTransferencia (double valor){
        saldo += valor;
    }

    @Override
    public String toString() {
        return "contaBancaria{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
