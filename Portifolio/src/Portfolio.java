import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Projeto> projetos;

    public Portfolio() {
        projetos = new ArrayList<>();
    }

    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    public void mostrarProjetos() {
        for (Projeto projeto : projetos) {
            System.out.println("Nome: " + projeto.getNome());
            System.out.println("Descrição: " + projeto.getDescricao());
            System.out.println("-----------------------------");
        }
    }
}

