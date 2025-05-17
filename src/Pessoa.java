public class Pessoa
{
    protected String nome_Pes;
    protected String identificador;
    protected int idade;

    public Pessoa(String nome_Pes, String identificador, int idade)
    {
        this.nome_Pes = nome_Pes;
        this.identificador = identificador;
        this.idade = idade;
    }

    public String getNome_Pes()
    {
        return nome_Pes;
    }

    public void setNome_Pes(String nome_Pes)
    {
        this.nome_Pes = nome_Pes;
    }

    public String getIdentificador()
    {
        return identificador;
    }

    public void setIdentificador(String identificador)
    {
        this.identificador = identificador;
    }

    public int getIdade()
    {
        return idade;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
    }
}