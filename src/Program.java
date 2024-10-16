import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Program {

    public static void main(String[] args) {
        // Criação do formatador para duas casas decimais
        DecimalFormat df = new DecimalFormat("#,##0.00");

        // Leitura dos dados do cliente
        String sexo = "";
        while (!sexo.equals("M") && !sexo.equals("F")) {
            sexo = JOptionPane.showInputDialog("Informe o sexo (F ou M):").toUpperCase();
            if (!sexo.equals("M") && !sexo.equals("F")) {
                JOptionPane.showMessageDialog(null, "Erro: sexo inválido. Por favor, digite M ou F.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        String quantidadeCervejasStr = JOptionPane.showInputDialog("Informe a quantidade de cervejas consumidas:");
        int quantidadeCervejas = Integer.parseInt(quantidadeCervejasStr);

        String quantidadeRefrigerantesStr = JOptionPane.showInputDialog("Informe a quantidade de refrigerantes consumidos:");
        int quantidadeRefrigerantes = Integer.parseInt(quantidadeRefrigerantesStr);

        String quantidadeEspetinhosStr = JOptionPane.showInputDialog("Informe a quantidade de espetinhos consumidos:");
        int quantidadeEspetinhos = Integer.parseInt(quantidadeEspetinhosStr);

        // Cálculo dos valores
        double ingresso = (sexo.equals("M")) ? 10.0 : 8.0;
        double precoCerveja = 5.0;
        double precoRefrigerante = 3.0;
        double precoEspetinho = 7.0;
        double couvert = 4.0;

        // Cálculo do total de consumo
        double totalConsumo = (quantidadeCervejas * precoCerveja) +
                (quantidadeRefrigerantes * precoRefrigerante) +
                (quantidadeEspetinhos * precoEspetinho);

        // Verifica se a taxa de couvert artístico deve ser cobrada
        if (totalConsumo > 30) {
            couvert = 0.0; // Não cobra o couvert
        }

        // Cálculo do total a pagar
        double totalAPagar = ingresso + totalConsumo + couvert;

        // Exibição do relatório
        String mensagem = "Relatório da Conta:\n"
                + "Sexo: " + sexo + "\n"
                + "Ingresso: R$ " + df.format(ingresso) + "\n"
                + "Total de Cervejas: R$ " + df.format(quantidadeCervejas * precoCerveja) + "\n"
                + "Total de Refrigerantes: R$ " + df.format(quantidadeRefrigerantes * precoRefrigerante) + "\n"
                + "Total de Espetinhos: R$ " + df.format(quantidadeEspetinhos * precoEspetinho) + "\n"
                + "Couvert Artístico: R$ " + df.format(couvert) + "\n"
                + "Total a Pagar: R$ " + df.format(totalAPagar);

        JOptionPane.showMessageDialog(null, mensagem, "Relatório da Conta", JOptionPane.INFORMATION_MESSAGE);
    }
}