import java.util.List;
import java.util.ArrayList;

public class Vault
{
    public List<Sobrevivente> sobreviventes_Vault;
    public List<Recurso> recursos_Vault;
    public List<Missao> missoes_Vault;

    public Vault(List<Sobrevivente> sobreviventes_Vault, List<Recurso> recursos_Vault, List<Missao> missoes_Vault)
    {
        this.sobreviventes_Vault = new ArrayList<>();
        this.recursos_Vault = new ArrayList<>();
        this.missoes_Vault = new ArrayList<>();
    }

    // Exibir sobreviventes do vault
    public void exibir_Sobreviventes_Vault()
    {
        System.out.println("\n--- SOBREVIVENTES ---\n");

        for(Sobrevivente sobrevivente : sobreviventes_Vault)
        {
            System.out.println("Nome: " + sobrevivente.getNome_Pes());
            System.out.println("Identificador: " + sobrevivente.getIdentificador());
            System.out.println("Idade: " + sobrevivente.getIdade());
            System.out.println("Status: " + sobrevivente.getStatus_Pes());
            System.out.println("Habilidades: " + sobrevivente.getHabilidades() + "\n");
        }
    }

    // Exibir recursos do vault
    public void exibir_Recursos_Vault()
    {
        System.out.println("\n--- RECURSOS ---\n");

        for(Recurso recurso : recursos_Vault)
        {
            System.out.println("Nome: " + recurso.getNome_Rec());
            System.out.println("Quantidade: " + recurso.getQuantidade() + "\n");
        }
    }

    // Exibir missões do vault
    public void exibir_Missoes_Vault()
    {
        System.out.println("\n--- MISSÕES ---\n");

        for(Missao missao : missoes_Vault)
        {
            System.out.println("Nome: " + missao.getNome_Mis());
            System.out.println("Objetivo: " + missao.getObjetivo());
            System.out.println("Local: " + missao.getLocal());
            System.out.println("Status da missão: " + missao.getStatus_Mis());
            System.out.println("Sobreviventes da missão: ");

            for(Sobrevivente sobrevivente : missao.getSobreviventes())
            {
                String nome_Sobreviv = sobrevivente.getNome_Pes();

                System.out.println(" - " + nome_Sobreviv);
            }

            System.out.println("Recursos coletados na missão: ");

            for (Recurso recurso : missao.getRec_Coletados())
            {
                System.out.println(" - Nome: " + recurso.getNome_Rec() + ", Quantidade: " + recurso.getQuantidade());
            }

            System.out.println();
        }
    }

    // Buscar um sobrevivente comparando os identificadores
    public Sobrevivente buscar_Sobrevivente(String identificador)
    {
        for(Sobrevivente sobrevivente : sobreviventes_Vault)
        {
            if(sobrevivente.getIdentificador().equals(identificador))
            {
                return sobrevivente;
            }
        }

        return null;
    }

    // Busca a existência de uma missão comparando com os nomes
    public Missao buscar_Missao(String nome_Mis)
    {
        for(Missao missao : missoes_Vault)
        {
            if(missao.getNome_Mis().equals(nome_Mis))
            {
                return missao;
            }
        }

        return null;
    }

    // Verifica se o sobrevivente está com algum status que impede a participação na missão
    public boolean verifica_Status(String status_Sob)
    {
        List<String> status_Inv = List.of("Morto", "Ferido", "Doente");

        return status_Inv.contains(status_Sob);
    }

    // Verifica se o status da missão é válido
    public boolean verifica_Missao(String status_Missao)
    {
        List<String> status_Validos = List.of("Em andamento", "Sucesso", "Fracasso");

        return status_Validos.contains(status_Missao);
    }

    // Consumir um recurso do vault
    public boolean consumir_Recurso(String nome, int quantidade)
    {
        for(Recurso recurso : recursos_Vault)
        {
            if(recurso.getNome_Rec().equals(nome))
            {
                if(recurso.getQuantidade() >= quantidade)
                {
                    recurso.setQuantidade(recurso.getQuantidade() - quantidade);

                    return true;
                }

                else
                {
                    System.out.println("Quantidade insuficiente para o consumo.\n");

                    return false;
                }
            }
        }

        return false;
    }

    // Lista de sobreviventes vault
    public List<Sobrevivente> getSobreviventes_Vault()
    {
        return sobreviventes_Vault;
    }

    public void setSobreviventes_Vault(List<Sobrevivente> sobreviventes_Vault)
    {
        this.sobreviventes_Vault = sobreviventes_Vault;
    }

    public void adicionar_Sobreviventes_Vault(Sobrevivente sobrevivente)
    {
        this.sobreviventes_Vault.add(sobrevivente);
    }

    public void remover_Sobreviventes_Vault(Sobrevivente sobrevivente)
    {
        this.sobreviventes_Vault.remove(sobrevivente);
    }

    // Lista de recursos vault
    public List<Recurso> getRecursos_Vault()
    {
        return recursos_Vault;
    }

    public void setRecursos_Vault(List<Recurso> recursos_Vault)
    {
        this.recursos_Vault = recursos_Vault;
    }

    public void adicionar_Recursos_Vault(Recurso recurso)
    {
        this.recursos_Vault.add(recurso);
    }

    public void remover_Recursos_Vault(Recurso recurso)
    {
        this.recursos_Vault.remove(recurso);
    }

    // Lista de missões vault
    public List<Missao> getMissoes_Vault()
    {
        return missoes_Vault;
    }

    public void setMissoes_Vault(List<Missao> missoes_Vault)
    {
        this.missoes_Vault = missoes_Vault;
    }

    public void adicionar_Missoes_Vault(Missao missao)
    {
        this.missoes_Vault.add(missao);
    }

    public void remover_Missoes_Vault(Missao missao)
    {
        this.missoes_Vault.remove(missao);
    }
}