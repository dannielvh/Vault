# Vault
Aluno: Danniel Vieira Holanda

Professor: Eduardo Habib Bechelane Maia

Disciplina: Programação Orientada à Objeto

## ☢️ Introdução

Este trabalho, desenvolvido em Java, tem como implementação um gerenciador de vault. Na simulação o programa será capaz de administrar sobreviventes, recursos e missões no vault. Lidando com mudanças, adições e remoções até mesmo das habilidades que os sobreviventes têm, e imprimindo as informações que já haviam sido cadastradas anteriormente no vault. O programa também conta com várias condições de existência, para que tudo funcione conforme o planejado.

## 📖 Metodologia

No início da simulação são criadas listas dentro da classe Vault, para que seja possível alocar os sobreviventes, os recursos e as missões. Cada classe do programa contando com variadas implementações para que seja possível a maior administração de casos possíveis dentro da simulação.

### Classes

Uma breve explicação da criação de cada classe e suas variáveis, para que assim, futuramente ao explicar as funções implementadas em cada uma, a compreensão seja facilitada.

#### 🧍🏻 Pessoa e Sobrevivente

A classe Pessoa, que foi criada com o propósito de servir como uma superclasse para a classe Sobrevivente, tem um dos construtores mais simples de todos. Contando apenas com as variáveis nome, o identificador e a idade de cada pessoa alocada.

A classe Sobrevivente, como citado anteriormente, é uma herança direta da classe Pessoa, ou seja, já conta com as variáveis definidas anteriormente, mas também apresenta coisas novas, a lista de habilidades e o status. A lista serve para armazenar as habilidades de cada sobrevivente sem problema de alocação ou conflito entre as habilidades de cada um, e o status é usado como forma de comparação para certas interações com o programa do vault, como por exemplo, saber se um determinado sobrevivente está apto para ir em alguma missão proposta, comparando essa string com as possibilidades de registro.

#### Recurso

#### Missão

#### Vault
