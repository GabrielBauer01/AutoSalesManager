package autosalesmanager.service;

public class LoanProcessingService {

    private double valorCarro;
    private double saldoCliente;

    public LoanProcessingService (double saldoCliente, double valorCarro) {
        this.saldoCliente = saldoCliente;
        this.valorCarro = valorCarro;
    }

    // Método para simular financiamento
    public void LoanSimulator(int meses) {
        double valorFinanciado = valorCarro - saldoCliente;

        if (valorFinanciado <= 0) {
            System.out.println("Valor de entrada suficiente para comprar o carro à vista.");
            return;
        }

        double jurosMensal = 0.02; // Juros de 2% ao mês
        double valorParcela = valorFinanciado * (jurosMensal / (1 - Math.pow(1 + jurosMensal, -meses)));

        System.out.printf("Valor total financiado: R$ %.2f%n", valorFinanciado);
        System.out.printf("Número de parcelas: %d%n", meses);
        System.out.printf("Valor de cada parcela: R$ %.2f%n", valorParcela);
    }

    public double getValorCarro() {
        return valorCarro;
    }

    public void setValorCarro(double valorCarro) {
        this.valorCarro = valorCarro;
    }

    public double getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }
}

