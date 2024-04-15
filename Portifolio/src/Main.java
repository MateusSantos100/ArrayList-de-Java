public class Main {
    public static void main(String[] args) {
        Projeto projeto1 = new Projeto("Aplicativo de Lista de Tarefas", "Uma aplicação para gerenciar tarefas do dia a dia.");
        Projeto projeto2 = new Projeto("Jogo da Forca", "Um jogo simples de adivinhação de palavras.");

        Portfolio portfolio = new Portfolio();
        portfolio.adicionarProjeto(projeto1);
        portfolio.adicionarProjeto(projeto2);

        System.out.println("=== Meu Portfólio ===");
        portfolio.mostrarProjetos();
    }
}
