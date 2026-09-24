// Interface que define como o iterador deve funcionar
interface Iterador<T> {
    boolean hasNext();
    T next();
}

// Interface da coleção que poderá ser percorrida
interface Colecao<T> {

    // Cria e retorna um iterador para a coleção
    Iterador<T> criarIterador();
}

class EstanteLivros implements Colecao<String> {
    private final String[] livros;
    private int quantidade = 0;

    public EstanteLivros(int tamanho) {
        livros = new String[tamanho];
    }

    // Adiciona um livro à estante
    public void adicionarLivro(String titulo) {
        livros[quantidade++] = titulo;
    }

    public int tamanho() {
        return quantidade;
    }

    public String livroNaPosicao(int indice) {
        return livros[indice];
    }

    // Cria um iterador específico para esta estante
    @Override
    public Iterador<String> criarIterador() {
        return new IteradorEstante(this);
    }
}


// Iterador responsável por percorrer a estante de livros
class IteradorEstante implements Iterador<String> {

    // Referência para a estante que será percorrida
    private final EstanteLivros estante;
    private int atual = 0;

    // Recebe a estante que será percorrida
    public IteradorEstante(EstanteLivros estante) {
        this.estante = estante;
    }

    // Verifica se ainda existem livros para percorrer
    @Override
    public boolean hasNext() {
        return atual < estante.tamanho();
    }

    // Retorna o livro atual e avança para o próximo
    @Override
    public String next() {
        return estante.livroNaPosicao(atual++);
    }
}

// Iterador que percorre a estante do último livro para o primeiro
class IteradorEstanteReverso implements Iterador<String> {

    // Referência para a estante que será percorrida
    private final EstanteLivros estante;

    // Começamos pelo último livro da estante
    private int indice;


    // Recebe a estante e define o índice inicial
    public IteradorEstanteReverso(EstanteLivros estante) {
        this.estante = estante;

        // Começa no último livro
        this.indice = estante.tamanho() - 1;
    }


    // Verifica se ainda existem livros para percorrer
    @Override
    public boolean hasNext() {
        return indice >= 0;
    }


    // Retorna o livro atual e volta uma posição
    @Override
    public String next() {
        return estante.livroNaPosicao(indice--);
    }
}

public class Main {
    public static void main(String[] args) {
        EstanteLivros estante = new EstanteLivros(3);

        estante.adicionarLivro("Clean Code");
        estante.adicionarLivro("Design Patterns");
        estante.adicionarLivro("Refactoring");

        // Cria um iterador para percorrer a estante
        Iterador<String> iterador = estante.criarIterador();

        System.out.println("Percorrendo primeiro -> último");

        while (iterador.hasNext()) {
            // Obtém e exibe o próximo livro
            System.out.println(iterador.next());
        }
        System.out.println(" ");

        Iterador<String> iterador_reverso = new IteradorEstanteReverso(estante);
        System.out.println("Percorrendo último -> primeiro");

        while (iterador_reverso.hasNext()) {
            // Obtém e exibe o próximo livro
            System.out.println(iterador_reverso.next());
        }
    }
}