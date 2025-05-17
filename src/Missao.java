import java.util.List;
import java.util.ArrayList;

public class Missao
{
    public String nome_Mis;
    public String objetivo;
    public String local;
    public String status_Mis;
    public List<Sobrevivente> sobreviventes = new ArrayList<>();
    public List<Recurso> rec_Coletados = new ArrayList<>();

    public Missao(String nome_Mis, String objetivo, String local, String status_Mis, List<Sobrevivente> sobreviventes, List<Recurso> rec_Coletados)
    {
        this.nome_Mis = nome_Mis;
        this.objetivo = objetivo;
        this.local = local;
        this.status_Mis = status_Mis;
        this.sobreviventes = new ArrayList<>();
        this.rec_Coletados = new ArrayList<>();
    }

    public String getNome_Mis()
    {
        return nome_Mis;
    }

    public void setNome_Mis(String nome_Mis)
    {
        this.nome_Mis = nome_Mis;
    }

    public String getObjetivo()
    {
        return objetivo;
    }

    public void setObjetivo(String objetivo)
    {
        this.objetivo = objetivo;
    }

    public String getLocal()
    {
        return local;
    }

    public void setLocal(String local)
    {
        this.local = local;
    }

    public String getStatus_Mis()
    {
        return status_Mis;
    }

    public void setStatus_Mis(String status_Mis)
    {
        this.status_Mis = status_Mis;
    }

    // Lista dos sobreviventes
    public List<Sobrevivente> getSobreviventes()
    {
        return sobreviventes;
    }

    public void setSobreviventes(List<Sobrevivente> sobreviventes)
    {
        this.sobreviventes = sobreviventes;
    }

    public void adicionar_Sobreviventes(Sobrevivente sobrevivente)
    {
        this.sobreviventes.add(sobrevivente);
    }

    public void remover_Sobreviventes(Sobrevivente sobrevivente)
    {
        this.sobreviventes.remove(sobrevivente);
    }

    // Lista dos recursos coletados
    public List<Recurso> getRec_Coletados()
    {
        return rec_Coletados;
    }

    public void setRec_Coletados(List<Recurso> rec_Coletados)
    {
        this.rec_Coletados = rec_Coletados;
    }

    public void adicionar_Rec_Coletados(Recurso rec_Coletado)
    {
        this.rec_Coletados.add(rec_Coletado);
    }

    public void remover_Rec_Coletados(Recurso rec_Coletado)
    {
        this.rec_Coletados.remove(rec_Coletado);
    }
}