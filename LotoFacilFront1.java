import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LotoFacilFront1 extends JFrame {

    private List<Integer> selecionados = new ArrayList<>();
    private JButton[] botoesNumeros = new JButton[25];

    private JLabel lblSelecionados;
    private JLabel lblValorAposta;
    private JLabel lblProbabilidades;

    private JButton btnCalcular;
    private JButton btnVerResultados;

    public LotoFacilFront1() {
        setTitle("Simulador Lotofácil - Front");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // PAINEL DOS NÚMEROS (CENTRO)
        
        JPanel painelNumeros = new JPanel(new GridLayout(5, 5, 5, 5));

        for (int i = 0; i < 25; i++) {
            final int numero = i + 1;
            JButton botao = new JButton(String.valueOf(numero));
            botoesNumeros[i] = botao;

            botao.setBackground(new Color(230, 238, 245)); 
            botao.addActionListener(e -> alternarSelecao(numero));
            painelNumeros.add(botao);
        }

        // PAINEL DE INFORMAÇÕES  
        
        JPanel painelInfo = new JPanel(new BorderLayout());

        // Textos no centro do painel inferior
        
        JPanel painelTextos = new JPanel();
        painelTextos.setLayout(new BoxLayout(painelTextos, BoxLayout.Y_AXIS));
        painelTextos.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        lblSelecionados = new JLabel("Selecionados: 0");
        lblValorAposta = new JLabel("Valor da aposta: ---");
        lblProbabilidades = new JLabel("Probabilidades: ---");

        painelTextos.add(lblSelecionados);
        painelTextos.add(lblValorAposta);
        painelTextos.add(lblProbabilidades);

        // Botão esquerdo (Ver Resultados) 
        btnVerResultados = new JButton("Ver Resultados");
        btnVerResultados.setEnabled(false);
        btnVerResultados.addActionListener(e -> mostrarResultados());

        // Botão direito (Calcular) 
        btnCalcular = new JButton("Calcular");
        btnCalcular.setEnabled(false);
        btnCalcular.addActionListener(e -> {
            // integrar o back-end depois
            JOptionPane.showMessageDialog(this,
                    "(back-end).",
                    "Calcular",
                    JOptionPane.INFORMATION_MESSAGE);
            private void alternarSelecao(int numero) {
        if (selecionados.contains(numero)) {
            selecionados.remove(Integer.valueOf(numero));
            botoesNumeros[numero - 1].setBackground(new Color(230, 238, 245));
        } else {
            if (selecionados.size() >= 18) return;
            selecionados.add(numero);
            botoesNumeros[numero - 1].setBackground(Color.GREEN);
        }

        atualizarInfo();
    }

    private void atualizarInfo() {
        lblSelecionados.setText("Selecionados: " + selecionados.size());
        double valor = calcularValorAposta(selecionados.size());

        if (valor == 0) {
            lblValorAposta.setText("Valor da aposta: ---");
            btnCalcular.setEnabled(false);
        } else {
            lblValorAposta.setText("Valor da aposta: R$ " + moneyFormat.format(valor));
            btnCalcular.setEnabled(true);
        }

        atualizarProbabilidades();
    }
           }
          );
         }
  }
