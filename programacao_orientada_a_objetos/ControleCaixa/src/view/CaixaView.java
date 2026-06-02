package view;
import model.Caixa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CaixaView extends JFrame {
    private JLabel labelValor, labelSaldo;
    private JTextField txtValor, txtSaldo;
    private JButton buttonEntrada,  buttonRetirada, buttonConsulta, buttonSair;
    private JTextArea textMensagem;
    private Dimension dLabel, dButton, dTextField, dTextArea, dFrame;
    private Caixa caixa;

    //CONSTRUTOR
    public CaixaView() {
        //0. definir os tamanhos padroes
        dFrame = new Dimension(350, 400);
        dLabel = new Dimension(40,20);
        dTextField = new Dimension(150,20);
        dButton = new Dimension(95,20);
        dTextArea = new Dimension(300,140);
        //1. definir a aparencia da janela
        this.setTitle("Controle de Caixa"); //Titulo da Janela
        this.setSize(dFrame); //tamanho da janela
        this.setResizable(false); //nao redimensionar a janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);// o botao X fecha o programa
        this.setLayout(null); //nao vai usar gerenciador de layout
        this.setLocationRelativeTo(null); //sem posicao relativa = ficar no centro

        //2.Definir cada componente que vai na janela
        labelValor = new JLabel("Valor: ");
        labelValor.setSize(dLabel);
        labelValor.setLocation(25, 50);
        this.add(labelValor);

        labelSaldo = new JLabel("Saldo: ");
        labelSaldo.setSize(dLabel);
        labelSaldo.setLocation(25, 80);
        this.add(labelSaldo);

        txtValor = new JTextField("");
        txtValor.setSize(dTextField);
        txtValor.setLocation(75,50);
        this.add(txtValor);

        txtSaldo = new JTextField("");
        txtSaldo.setSize(dTextField);
        txtSaldo.setLocation(75,80);
        this.add(txtSaldo);

        buttonEntrada = new JButton("Entrada");
        buttonEntrada.setSize(dButton);
        buttonEntrada.setLocation(25,150);
        this.add(buttonEntrada);

        buttonRetirada = new JButton("Retirada");
        buttonRetirada.setSize(dButton);
        buttonRetirada.setLocation(225,150);
        this.add(buttonRetirada);

        buttonConsulta= new JButton("Consulta");
        buttonConsulta.setSize(dButton);
        buttonConsulta.setLocation(25,185);
        this.add(buttonConsulta);

        buttonSair = new JButton("Sair");
        buttonSair.setSize(dButton);
        buttonSair.setLocation(225,185);
        this.add(buttonSair);

        textMensagem = new JTextArea();
        textMensagem.setSize(dTextArea);
        textMensagem.setLocation(25,210);
        this.add(textMensagem);

        //3. adicionar ouvintes para os objetos desejados
        buttonSair.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttonSair)(
            JOptionPane.showMessageDialog(
                    null,
                    "Saindo com Cuidado",
                    "Sair",
                    JOptionPane.INFORMATION_MESSAGE
            )
    }
}