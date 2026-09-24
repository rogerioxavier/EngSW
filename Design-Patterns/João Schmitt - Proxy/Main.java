// Interface comum: Proxy e objeto real seguem o mesmo contrato
interface Arquivo {
    void abrir();
}


// RealSubject: executa o trabalho de verdade
class ArquivoReal implements Arquivo {
    private String nome;


    public ArquivoReal(String nome) {
        this.nome = nome;
        System.out.println("Carregando " + nome + "...");
    }


    public void abrir() {
        System.out.println("Abrindo " + nome);
    }
}


// Proxy: controla o acesso ao RealSubject
class ArquivoProxy implements Arquivo {
    private ArquivoReal arquivoReal;
    private String nome;
    private String perfil;


    public ArquivoProxy(String nome, String perfil) {
        this.nome = nome;
        this.perfil = perfil;
    }


    public void abrir() {
        if (!perfil.equalsIgnoreCase("admin")) {
            System.out.println("Acesso negado.");
            return;
        }


        if (arquivoReal == null) {
            arquivoReal = new ArquivoReal(nome);
        }
        arquivoReal.abrir();
    }
}


// Cliente
public class Main {
    public static void main(String[] args) {
        Arquivo arquivo = new ArquivoProxy("contrato.pdf", "admin");
        arquivo.abrir();
    }
}





