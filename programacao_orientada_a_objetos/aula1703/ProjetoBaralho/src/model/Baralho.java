package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho(){
        cartas = new ArrayList<>();
        popularBaralho();
    }

    private void popularBaralho() {
        for(Naipe naipe : Naipe.values()){
            for(Valor valor : Valor.values()){
                cartas.add(new Carta(naipe, valor));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for(Carta carta : cartas){
            sb.append(carta).append("\n");
        }
        return sb.toString();
    }

    public void embaralhar(){
        Collections.shuffle(cartas);
    }

    public List<Carta> getCartas() {
        return cartas;
    }
}
