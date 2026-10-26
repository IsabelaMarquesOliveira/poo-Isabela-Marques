package br.com.fiapride.main;

import br.com.fiapride.model.Frigobar;
import br.com.fiapride.model.Geladeira;
import br.com.fiapride.model.GeladeiraInteligente;
import br.com.fiapride.model.Sensor;
import br.com.fiapride.model.Conectavel; // Importar a interface

import java.util.ArrayList;
import java.util.List;

public class SistemaPrincipal2 {
    public static void main(String[] args) {

        Sensor sensorComum = new Sensor("Termostato Simples", true);
        Sensor sensorSmart = new Sensor("Sensor Digital Wi-Fi", true);

        Frigobar meuFrigobar = new Frigobar("Consul", 120, sensorComum, true);
        GeladeiraInteligente minhaSmart = new GeladeiraInteligente("Samsung", 500, sensorSmart, true);

        System.out.println("--- Teste 1: Sistema de Degelo (Classes Abstratas) ---");
        List<Geladeira> listaDeEletrodomesticos = new ArrayList<>();
        listaDeEletrodomesticos.add(meuFrigobar);
        listaDeEletrodomesticos.add(minhaSmart);

        for (Geladeira eletro : listaDeEletrodomesticos) {
            System.out.println("Equipamento: " + eletro.getMarca());
            eletro.realizarDegelo();
        }

        System.out.println("\n--- Teste 2: Interfaces e Polimorfismo Transversal ---");
        // Criando um array tipado com a Interface
        Conectavel[] dispositivosIoT = new Conectavel[2];

        // Adicionando objetos de hierarquias completamente diferentes
        dispositivosIoT[0] = sensorSmart; // É um Sensor
        dispositivosIoT[1] = minhaSmart;  // É uma Geladeira

        // Invocando o comportamento em massa
        for (Conectavel dispositivo : dispositivosIoT) {
            dispositivo.conectarRede();
        }
    }
}