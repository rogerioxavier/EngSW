internal class Program
{
    private static void Main(string[] args)
    {
        // Sem Builder: dá pra saber o que é cada parâmetro?
        var cliente = new Cliente("Fulano", 20, "email@x.com", "054", "99999999",
                                   "Farroupilha", "95181000", "RS", 67, "Centro", "Coronel P. de Moraes");


        var clienteBld = new ClienteBuilder()
            .CriarNovo("Fulano", 20)
            .AdicionarContato("fulano@ifrs.aluno.farroupila.edu.br", "054", "99999999")
            .AdicionarEndereco("Farroupilha", "95181000", "RS", 67, "Centro", "Coronel P. de Moraes")
            .Build();

    }
}