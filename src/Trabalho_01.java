import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Trabalho_01
{
    public static void main(String [] args)
    {
        int count_Sobreviventes = 0, count_Recurso = 0, count_Missoes = 0;

        Scanner scanner = new Scanner(System.in);

        List<Missao> missoes = new ArrayList<>();
        List<Sobrevivente> sobreviventes = new ArrayList<>();
        List<Recurso> recursos = new ArrayList<>();        
        Vault vault = new Vault(sobreviventes, recursos, missoes);

        while(true)
        {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar sobrevivente.");
            System.out.println("2 - Adicionar habilidade a um sobrevivente.");
            System.out.println("3 - Remover habilidade de um sobrevivente.");
            System.out.println("4 - Adicionar recurso ao vault.");
            System.out.println("5 - Consumir recurso.");
            System.out.println("6 - Registrar missão.");
            System.out.println("7 - Adicionar sobrevivente a uma missão.");
            System.out.println("8 - Exibir sobreviventes do vault");
            System.out.println("9 - Exibir recursos do vault.");
            System.out.println("10 - Exibir missões realizadas.");
            System.out.println("11 - Exibir sobreviventes cadastrados em uma missão.");
            System.out.println("12 - Sair.\n");

            System.out.print("Digite qual opção gostaria de realizar: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch(op)
            {
                // Cadastrar sobrevivente
                case 1:
                {
                    // Verifica se já não foi atingido o número máximo de sobreviventes que podem ser cadastrados no vault
                    if(count_Sobreviventes > 100)
                    {
                        System.out.println("Impossível cadastrar mais sobreviventes ao Vault.\n");

                        break;
                    }

                    else
                    {
                        System.out.print("Digite o nome do sobrevivente: ");
                        String nome = scanner.nextLine();

                        System.out.print("Digite o identificador do sobrevivente: ");
                        String identificador = scanner.nextLine();

                        System.out.print("Digite a idade do sobrevivente: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();

                        String status;

                        System.out.println("Opções para status do sobrevivente: (Ativo, Doente, Ferido ou Morto).");
                        System.out.print("Digite em qual dessa opções o sobrevivente cadastrado se encaixa: ");
                        status = scanner.nextLine();

                        // Verifica se o status digitado para o sobrevivente é compatível com as opções
                        if(status.equals("Ativo") || status.equals("Doente") || status.equals("Ferido") || status.equals("Morto"))
                        {
                            // Cadastra o novo sobrevivente no vault
                            Sobrevivente novo_Sobrevivente = new Sobrevivente(nome, identificador, idade, status, new ArrayList<>());
                            vault.adicionar_Sobreviventes_Vault(novo_Sobrevivente);
                            count_Sobreviventes++;

                            System.out.println("Cadastro concluído com sucesso.\n");

                            break;
                        }

                        else
                        {
                            System.out.println("Opção inválida.\n");

                            break;
                        }
                    }
                }

                // Adicionar habilidade a um sobrevivente
                case 2:
                {
                    System.out.print("Digite o identificador do sobrevivente: ");
                    String ident_Sobrevivente = scanner.nextLine();

                    Sobrevivente sobrevivente = vault.buscar_Sobrevivente(ident_Sobrevivente);

                    // Verifica se o sobrevivente existe mesmo
                    if(sobrevivente != null)
                    {
                        // Verifica se ele já não tem o número máximo de habilidades por sobrevivente
                        if(sobrevivente.getHabilidades().size() < 3)
                        {
                            System.out.print("Digite qual opção de habilidade gostaria de atribuir ao sobrevivente: ");
                            String op_Habilidade = scanner.nextLine();

                            sobrevivente.adicionar_Habilidade(op_Habilidade);

                            System.out.println("Habilidade adicionada com sucesso.\n");
                        }

                        else
                        {
                            System.out.println("Número máximo de habilidades por sobrevivente já foi atingido.\n");
                        }
                    }

                    else
                    {
                        System.out.println("Sobrevivente não identificado.\n");
                    }

                    break;
                }

                // Remover habilidade de um sobrevivente
                case 3:
                {
                    System.out.print("Digite o identificador do sobrevivente o qual gostaria de retirar uma habilidade: ");
                    String id_Remover = scanner.nextLine();

                    Sobrevivente sobrevivente = vault.buscar_Sobrevivente(id_Remover);

                    // Verifica se o sobrevivente procurado existe mesmo
                    if(sobrevivente != null)
                    {
                        System.out.println("As habilidades atuais desse sobrevivente: " + sobrevivente.getHabilidades());
                        System.out.print("Digite qual habilidade gostaria de remover: ");
                        String hab_Remover = scanner.nextLine();

                        // Verifica se o sobrevivente tem a habilidade que será removida
                        if(sobrevivente.getHabilidades().contains(hab_Remover))
                        {
                            sobrevivente.remover_Habilidade(hab_Remover);

                            System.out.println("Habilidade removida.\n");
                        }

                        else
                        {
                            System.out.println("Habilidade inválida/não existe no escopo de habilidade do sobrevivente referido.\n");
                        }
                    }

                    else
                    {
                        System.out.println("Sobrevivente não identificado.\n");
                    }

                    break;
                }

                // Adicionar recurso ao vault
                case 4:
                {
                    // Verifica se a quantidade de recurso limite do estoque do vault já não foi atingida
                    if(count_Recurso > 400)
                    {
                        System.out.println("Impossível armazenar mais recursos.\n");
                    }

                    else
                    {
                        System.out.print("Digite qual recurso gostaria de adicionar: ");
                        String nome_Rec_Adicionar = scanner.nextLine();

                        System.out.print("Digite agora a quantidade: ");
                        int qnt_Rec_Adicionar = scanner.nextInt();
                        scanner.nextLine();

                        // Verifica se a quantidade que vai ser adicionada é maior que 0
                        if(qnt_Rec_Adicionar > 0)
                        {
                            Recurso recurso = new Recurso(nome_Rec_Adicionar, qnt_Rec_Adicionar);
                            count_Recurso++;

                            vault.adicionar_Recursos_Vault(recurso);

                            System.out.println("Recurso adicionado.\n");
                        }

                        else
                        {
                            System.out.println("Quantidade inválida.\n");
                        }
                    }

                    break;
                }

                // Consumir recurso
                case 5:
                {
                    // Verifica se existe recurso para ser consumido
                    if(count_Recurso == 0)
                    {
                        System.out.println("Não existe nenhum recurso para ser consumido, o estoque está vazio.\n");
                    }

                    else
                    {
                        System.out.print("Digite qual recurso gostaria de consumir: ");
                        String nome_Rec_Consumido = scanner.nextLine();

                        System.out.print("Digite a quantidade que será consumida: ");
                        int qnt_Rec_Consumido = scanner.nextInt();
                        scanner.nextLine();

                        // Verifica se a quantida que o usuário quer consumir não é 0 u um número negativo
                        if(qnt_Rec_Consumido <= 0)
                        {
                            System.out.println("Quantidade para consumo inválida.\n");
                        }

                        else
                        {
                            // Consome o recurso
                            if(vault.consumir_Recurso(nome_Rec_Consumido, qnt_Rec_Consumido))
                            {
                                System.out.println("Recurso consumido.\n");
                            }

                            else
                            {
                                System.out.println("Recurso não encontrado no vault.\n");
                            }
                        }
                    }

                    break;
                }

                // Registrar missão
                case 6:
                {
                    System.out.print("Digite o nome da missão que gostaria de registrar: ");
                    String nome_Missao = scanner.nextLine();

                    System.out.print("Digite o objetivo da missão: ");
                    String obj_Missao = scanner.nextLine();

                    System.out.print("Digite o local da missão: ");
                    String loc_Missao = scanner.nextLine();

                    System.out.println("Opções de status para a missão: (Em andamento, Sucesso, Fracasso)");
                    System.out.print("Digite o status da missao: ");
                    String sta_Missao = scanner.nextLine();

                    Missao nova_Missao = new Missao(nome_Missao, obj_Missao, loc_Missao, sta_Missao, new ArrayList<>(), new ArrayList<>());

                    System.out.print("Algum recurso foi coletado durante essa missão? Digite SIM ou NÃO como resposta: ");
                    String resposta = scanner.nextLine();

                    // Enquanto a resposta for SIM ele vai adicionar recursos a missão
                    while("SIM".equals(resposta))
                    {
                        System.out.print("Digite qual recurso gostaria de adicionar: ");
                        String nome_Rec_Adicionar = scanner.nextLine();

                        System.out.print("Digite agora a quantidade: ");
                        int qnt_Rec_Adicionar = scanner.nextInt();
                        scanner.nextLine();

                        // Verifica se a quantidade que vai ser adicionada é maior que 0
                        if(qnt_Rec_Adicionar > 0)
                        {
                            Recurso recurso = new Recurso(nome_Rec_Adicionar, qnt_Rec_Adicionar);
                            count_Recurso++;

                            nova_Missao.adicionar_Rec_Coletados(recurso);

                            System.out.println("Recurso adicionado.\n");
                        }

                        else
                        {
                            System.out.println("Quantidade inválida.\n");
                        }

                        System.out.print("Existe mais algum recurso para ser cadastrado, fruto dessa missão? Digite SIM ou NÃO como resposta: ");
                        resposta = scanner.nextLine();
                    }

                    // Verifica se o status da missão é condingente com as opções
                    if(vault.verifica_Missao(sta_Missao))
                    {
                        vault.adicionar_Missoes_Vault(nova_Missao);
                        count_Missoes++;

                        System.out.println("Missão registrada.\n");
                    }

                    else
                    {
                        System.out.println("Status inválido para o registro da missão.\n");
                    }

                    break;
                }

                // Adicionar sobrevivente a uma missão
                case 7:
                {
                    System.out.print("Digite o nome da missão a qual gostaria de adicionar um sobrevivente: ");
                    String nome_Mis_Adicionar = scanner.nextLine();

                    Missao missao_Ad = vault.buscar_Missao(nome_Mis_Adicionar);

                    // Verifica se a missão procurada existe
                    if(missao_Ad != null)
                    {
                        // Verifica se a missão já nao está com cinco sobreviventes
                        if(missao_Ad.getSobreviventes().size() < 5)
                        {
                            System.out.print("Digite o identificador do sobrevivente que gostaria de adicionar a missao: ");
                            String id_Sob_Adicionar = scanner.nextLine();

                            Sobrevivente sobrevivente = vault.buscar_Sobrevivente(id_Sob_Adicionar);

                            // Verifica se o sobrevivente existe
                            if(sobrevivente != null)
                            {
                                String status_Sob = sobrevivente.getStatus_Pes();

                                // Verifica se o sobrevivente está com o status Ativo
                                if(vault.verifica_Status(status_Sob))
                                {
                                    System.out.println("Infelizmente esse sobrevivente não poderá participar da missão por conta do seu estado atual.\n");
                                }

                                else
                                {
                                    missao_Ad.adicionar_Sobreviventes(sobrevivente);

                                    System.out.println("Sobrevivente adicionado a missão.\n");
                                }
                            }

                            else
                            {
                                System.out.println("Sobrevivente não identificado.\n");
                            }
                        }

                        else
                        {
                            System.out.println("O número máximo de sobreviventes nessa missão já foi atingido.\n");
                        }
                    }

                    else
                    {
                        System.out.println("Missão não encontrada.\n");
                    }
                }

                // Exibir sobreviventes do vault
                case 8:
                {
                    if(count_Sobreviventes == 0)
                    {
                        System.out.println("Nenhum sobrevivente foi cadastrado até o momento.\n");
                    }

                    else
                    {
                        vault.exibir_Sobreviventes_Vault();
                    }

                    break;
                }

                // Exibir recursos do vault
                case 9:
                {
                    if(count_Recurso == 0)
                    {
                        System.out.println("Nenhum recursos foi cadastrado até o momento, ou o estoque está vazio.\n");
                    }

                    else
                    {
                        vault.exibir_Recursos_Vault();
                    }

                    break;
                }

                // Exibir missões do vault
                case 10:
                {
                    if(count_Missoes == 0)
                    {
                        System.out.println("Nenhuma missão foi registrada até o momento.\n");
                    }

                    else
                    {
                        vault.exibir_Missoes_Vault();
                    }

                    break;
                }

                // Exibir sobreviventes cadastrados em uma missão
                case 11:
                {
                    System.out.print("Digite o nome da missão: ");
                    String nome_Mis = scanner.nextLine();

                    Missao mis = vault.buscar_Missao(nome_Mis);

                    if(mis != null)
                    {
                        System.out.println("SOBREVIVENTES CADASTRADOS NA MISSÃO " + nome_Mis);

                        for(Sobrevivente sob : mis.getSobreviventes())
                        {
                            System.out.println(" - " + sob.getNome_Pes());
                        }
                    }

                    else
                    {
                        System.out.println("Missão não encontrada.\n");
                    }

                    break;
                }

                case 12:
                {
                    System.out.println("Saindo do programa...\n");
            
                    scanner.close();
        
                    return;
                }

                default:
                {
                    System.out.println("Opção inválida.");

                    break;
                }
            }
        }
    }
}