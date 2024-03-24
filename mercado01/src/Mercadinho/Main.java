package Mercadinho;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Item {
    private String nome;
    private double preco;

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return nome.equals(item.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}

class ListaDeCompras {
    private ArrayList<Item> itens;

    public ListaDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco) {
        Item novoItem = new Item(nome, preco);
        if (itens.contains(novoItem)) {
            System.out.println("Este item já está na lista de compras.");
            return;
        }
        itens.add(novoItem);
        System.out.println(nome + " foi adicionado à lista de compras.");
    }

    public void removerItem(String nome) {
        Item itemParaRemover = new Item(nome, 0);
        if (!itens.contains(itemParaRemover)) {
            System.out.println(nome + " não está na lista de compras.");
            return;
        }
        itens.remove(itemParaRemover);
        System.out.println(nome + " foi removido da lista de compras.");
    }

    public void mostrarLista() {
        if (itens.isEmpty()) {
            System.out.println("A lista de compras está vazia.");
            return;
        }
        System.out.println("Lista de Compras:");
        for (Item item : itens) {
            System.out.println("- " + item.getNome() + " (R$" + item.getPreco() + ")");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ListaDeCompras listaDeCompras = new ListaDeCompras();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Adicionar item à lista");
            System.out.println("2. Remover item da lista");
            System.out.println("3. Mostrar lista de compras");
            System.out.println("4. Sair");

            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    try {
                        System.out.print("Digite o nome do item: ");
                        String nomeItem = scanner.nextLine();
                        System.out.print("Digite o preço do item: ");
                        double precoItem = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer do scanner
                        listaDeCompras.adicionarItem(nomeItem, precoItem);
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: O preço deve ser um número válido.");
                        scanner.nextLine(); // Limpar o buffer do scanner
                    }
                    break;

                case "2":
                    System.out.print("Digite o nome do item que deseja remover: ");
                    String itemRemover = scanner.nextLine();
                    listaDeCompras.removerItem(itemRemover);
                    break;

                case "3":
                    listaDeCompras.mostrarLista();
                    break;

                case "4":
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

