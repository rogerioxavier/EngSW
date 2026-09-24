public class ClienteBuilder
{
    private Cliente NovoCliente { get; } = new Cliente();

    public ClienteBuilder CriarNovo(string nome, int idade)
    {
        NovoCliente.Nome = nome;
        NovoCliente.Idade = idade;
        return this;
    }

    public ClienteBuilder AdicionarContato(string email, string dddTelefone, string numeroTelefone)
    {
        NovoCliente.Email = email;
        NovoCliente.DddTelefone = dddTelefone;
        NovoCliente.NumeroTelefone = numeroTelefone;
        return this;
    }

    public ClienteBuilder AdicionarEndereco(string cidade, string cep, string estado, int numero, string bairro, string rua)
    {
        NovoCliente.Cidade = cidade;
        NovoCliente.Cep = cep;
        NovoCliente.Estado = estado;
        NovoCliente.Numero = numero;
        NovoCliente.Bairro = bairro;
        NovoCliente.Rua = rua;
        return this;
    }

    public Cliente Build() => NovoCliente;
}