package modelo;

import java.time.LocalDateTime;
import java.time.Duration;

public class Registro {

    private Veiculo veiculo;
    private Vaga vaga;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double valorPago;

    public Registro(Veiculo veiculo, Vaga vaga) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.entrada = LocalDateTime.now();
    }

    public Duration calcularTempo() {
        return Duration.between(entrada, saida);
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}