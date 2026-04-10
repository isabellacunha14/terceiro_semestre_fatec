package model;

import java.util.ArrayList;
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

            }
        }
    }


}
