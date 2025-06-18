package view;

import controller.EquipamentoController;
import model.Equipamento;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EquipamentoController controller = new EquipamentoController();

        System.out.println("Cadastro de Equipamento");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Fabricante: ");
        String fabricante = sc.nextLine();
        System.out.print("Localização: ");
        String localizacao = sc.nextLine();
        Date dataAquisicao = new Date(); // Use um parser para data real

        Equipamento eq = new Equipamento(0, nome, fabricante, dataAquisicao, localizacao);

        try {
            controller.cadastrarEquipamento(eq);
            System.out.println("Equipamento cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }
}
