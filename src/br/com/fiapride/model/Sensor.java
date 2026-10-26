package br.com.fiapride.model;

// Implementando a interface numa classe que não tem herança
public class Sensor implements Conectavel {
    private String modelo;
    private boolean ativo;

    public Sensor(String modelo, boolean ativo) {
        this.setModelo(modelo);
        this.setAtivo(ativo);
    }

    // --- Implementação dos métodos da Interface ---
    @Override
    public void conectarRede() {
        System.out.println("Sensor [" + this.modelo + "]: A estabelecer ligação à central de automação...");
    }

    @Override
    public void desconectarRede() {
        System.out.println("Sensor [" + this.modelo + "]: Ligação encerrada.");
    }

    // Getters e Setters
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}