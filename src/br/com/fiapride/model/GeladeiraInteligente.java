package br.com.fiapride.model;

// Uma classe pode herdar (extends) e assinar contratos (implements) ao mesmo tempo
public class GeladeiraInteligente extends Geladeira implements Conectavel {

    private boolean conexaoWiFi;

    public GeladeiraInteligente(String marca, int capacidadeMaxima, Sensor sensorInterno, boolean conexaoWiFi) {
        super(marca, capacidadeMaxima, sensorInterno);
        this.conexaoWiFi = conexaoWiFi;
    }

    @Override
    public double calcularConsumoEnergia() {
        System.out.println("Calculando consumo elevado da Geladeira Smart (Wi-Fi e telas ativas)...");
        return 85.0;
    }

    @Override
    public void realizarDegelo() {
        System.out.println("Geladeira Smart: Sistema Frost Free ativado. Degelo automático e impercetível.");
    }

    // --- Implementação dos métodos da Interface ---
    @Override
    public void conectarRede() {
        System.out.println("Geladeira Smart [" + this.getMarca() + "]: A ligar à rede Wi-Fi doméstica...");
    }

    @Override
    public void desconectarRede() {
        System.out.println("Geladeira Smart [" + this.getMarca() + "]: Wi-Fi desligado.");
    }

    // Getter e Setter
    public boolean isConexaoWiFi() { return conexaoWiFi; }
    public void setConexaoWiFi(boolean conexaoWiFi) { this.conexaoWiFi = conexaoWiFi; }
}