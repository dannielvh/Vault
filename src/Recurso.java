public class Recurso
{
    public String nome_Rec;
    public int quantidade;

    public Recurso(String nome_Rec, int quantidade)
    {
        this.nome_Rec = nome_Rec;
        this.quantidade = quantidade;
    }

    public String getNome_Rec()
    {
        return nome_Rec;
    }

    public void setNome_Rec(String nome)
    {
        this.nome_Rec = nome;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }
}