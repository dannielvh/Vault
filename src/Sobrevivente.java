import java.util.List;
import java.util.ArrayList;

public class Sobrevivente extends Pessoa
{
    public String status_Pes;
    public List<String> habilidades = new ArrayList<>();

    public Sobrevivente(String nome, String identificador, int idade, String status_Pes, List<String> habilidades)
    {
        super(nome, identificador, idade);
        this.status_Pes = status_Pes;
        this.habilidades = habilidades;
    }

    public String getStatus_Pes()
    {
        return status_Pes;
    }

    public void setStatus_Pes(String status_Pes)
    {
        this.status_Pes = status_Pes;
    }

    // Lista das habilidades
    public List<String> getHabilidades()
    {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades)
    {
        this.habilidades = habilidades;
    }

    public void adicionar_Habilidade(String habilidade)
    {
        habilidades.add(habilidade);
    }

    public void remover_Habilidade(String habilidade)
    {
        habilidades.remove(habilidade);
    }
}