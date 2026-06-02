import model.Baralho;
import model.Carta;

public class GerenciarJogo {
    static void main() {
        Baralho baralho = new Baralho();
        System.out.println(baralho);
        System.out.println("Embaralhar");
        baralho.embaralhar();
        System.out.println(baralho);
        Carta cartaMaromo = baralho.getCartas().get(0);
        baralho.getCartas().remove(cartaMaromo);
        Carta cartaOponente = baralho.getCartas().get(0);
        baralho.getCartas().remove(cartaOponente);
        //Ha formas melhores de se fazer.
        System.out.println("Cartas selecionadas");
        System.out.println(cartaMaromo);
        System.out.println(cartaOponente);
        if(cartaMaromo.getNaipe().ordinal()==cartaOponente.getNaipe().ordinal()){
            if(cartaMaromo.getValor().ordinal() > cartaOponente.getValor().ordinal()){
                System.out.println("Maromo sai jogando");
            }else{
                System.out.println("Oponente sai jogando");
            }
        }else{
            if(cartaMaromo.getValor().ordinal() > cartaOponente.getValor().ordinal()){
                System.out.println("Maromo sai jogando");
            }else{
                System.out.println("oponente sai jogando");
            }
        }
    }
}
