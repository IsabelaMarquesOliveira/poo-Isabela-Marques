# Projeto FiapRide - Isabela Marques de Oliveira
## Informações do Aluno
- **Nome:** Isabela Marques de Oliveira
- **RM:** 567230
- **Turma:** 2CCPS
- **Curso:** Ciências da Computação
- **GitHub:** IsabelaMarquesOliveira
---
## Descrição do Projeto
Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, 
onde desenvolvemos o sistema base de mobilidade (FiapRide) para compreender os conceitos teóricos, e paralelamente construímos um sistema de Controle de Eletrodomésticos focado em IoT como projeto prático pessoal. 
A jornada cobre desde a criação de classes básicas até a implementação de arquiteturas desacopladas com interfaces.
---
## Checklist de Implementação
- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces
---
## Perguntas de Reflexão
### Aula 1 - Classes e Objetos
**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fá
cil apenas criar variáveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 5
0.0`?
**Pense:** E se o FiapRide tiver 1 milhão de usuários? Como a Classe ajuda a resolver isso?
<br><br>**Sua Resposta:**
Utilizar variáveis soltas violaria o princípio de coesão e tornaria o gerenciamento de estado impossível em larga escala. 
Se tivéssemos 1 milhão de usuários, precisaríamos de milhões de variáveis desestruturadas, dificultando a busca, a passagem de parâmetros e a manutenção. 
A criação da classe Passageiro resolve isso ao atuar como um "molde" que agrupa o estado (atributos) e o comportamento (métodos) de uma entidade lógica em um único bloco de memória (Objeto).
Isso nos permite instanciar infinitos passageiros, alocá-los em estruturas de dados complexas (como Listas ou HashMaps) e escalonar o FiapRide de forma eficiente e estruturada.
---
### Aula 2 - Métodos
**Pergunta:** "Se nós podemos simplesmente fazer `passageiro.saldo = passageiro.saldo \+ 100` di
retamente no código principal, por que dá tanto trabalho criar um método específico chamado `adi
cionarSaldo\(valor\)` para fazer isso? Quais seriam os riscos para a nossa startup de mobilidade
se deixássemos qualquer programador alterar o saldo diretamente?"
<br><br>**Sua Resposta:**
A manipulação direta de atributos destrói o controle sobre o estado interno do objeto. 
Se permitíssemos o acesso direto ao saldo, qualquer programador, por erro ou má intenção, poderia injetar valores negativos (passageiro.saldo = -500) ou burlar regras de negócio, gerando falhas financeiras gravíssimas para a startup. 
O método adicionarSaldo(valor) atua como uma barreira arquitetural de segurança. 
Ao centralizarmos a alteração neste método, podemos implementar lógicas de validação (ex: if (valor > 0)) e registrar logs de transação, garantindo que o objeto só altere seu estado mediante as regras de negócio permitidas.
---
### Aula 3 - Encapsulamento
**Pergunta:** "No nosso código, os atributos são `private`, mas os métodos `getSaldo\(\)` e `get
Nome\(\)` são `public`. Por que é seguro deixar o `get` público, mas perigoso deixar o atributo
original público?
Pense bem: Qual a diferença entre dar a alguém uma CÓPIA de um documento seu, e entregar o docum
ento ORIGINAL para a pessoa rasurar? "
<br><br>**Sua Resposta:**
Deixar o atributo original como público significa expor o ponteiro direto daquela informação na memória, o que permite que outras classes sobrescrevam o dado de forma arbitrária e incontrolável (como rasurar um documento original). 
O encapsulamento com private blinda a memória do objeto. Quando tornamos o getSaldo() público, estamos projetando uma interface segura que retorna apenas o valor atual (a cópia do documento) para fins de leitura. 
Dessa forma, o sistema externo consegue consumir a informação de que necessita, mas fica arquiteturalmente impossibilitado de adulterar a fonte da verdade da nossa classe.
---
### Aula 4 - Construtores
**Pergunta:** "> "Na nossa classe `Veiculo`, nós tomamos duas decisões arquitetônicas muito impo
rtantes:
>
> 1. Nós **não** criamos o método `setModelo\(\)`.
> 2. O `setPlaca\(\)` foi criado como **privado**, e criamos um método público chamado `atualiza
rPlaca\(\)` para acessá-lo.
>
> Pensando no mundo real e no Clean Code: Por que é um erro gravíssimo clicar em 'Gerar Getters
e Setters para tudo' automaticamente na sua IDE? Como as nossas duas decisões acima protegem o s
istema de fraudes e falhas de lógica?"
_Dica: Pense sobre o que pode ou não mudar fisicamente em um carro, e a diferença entre "alterar
um dado no banco" e "executar um processo real no Detran"_"
**Sua Resposta:**
o código deve ser a representação fiel das regras do mundo real. 
> Um veículo não muda de modelo de fábrica ao longo do tempo, portanto, um setModelo simplesmente não deve existir. 
> Já a placa pode ser alterada, mas exige um processo legal (Detran). 
> O método atualizarPlaca() embute essa complexidade (ex: validação do formato Mercosul, histórico de alterações), enquanto um setPlaca privado impede que essa regra seja ignorada. 
> O construtor entra forçando as dependências essenciais no nascimento do objeto, evitando estados inconsistentes.
---
### Aula 5 - Associação
**Pergunta:** ""No construtor da `Viagem`, nós exigimos o objeto inteiro \(`Passageiro solicitan
te`\). Se o nosso resumo só precisa imprimir o nome da pessoa, não seria mais fácil e mais leve
pedir apenas a String do nome no construtor da Viagem \(`String nomeDoPassageiro`\) em vez do ob
jeto todo?"
_Pense nas regras de negócio: O que acontece na hora que a Viagem acaba e o sistema precisa desc
ontar o saldo? Se a Viagem tiver apenas a String "Ana Silva", ela consegue mexer no dinheiro del
a? _"
<br><br>**Sua Resposta:**
Se passássemos apenas uma String, estaríamos fazendo uma mera passagem de valor textual, perdendo completamente a rastreabilidade do domínio. 
Uma viagem é feita por uma entidade sistêmica, não por um rótulo de texto. Se a Viagem tivesse apenas o nome "Ana", ao finalizar o trajeto, seria impossível executar o desconto da tarifa, pois não haveria ponteiro na memória ligando à carteira da Ana. 
Ao injetar o objeto Passageiro (Associação), o objeto Viagem detém a referência em memória da pessoa. 
Isso permite o envio de mensagens entre objetos (passageiro.descontarSaldo()), garantindo a integridade transacional do fluxo.
---
### Aula 6 - Herança
**Pergunta:** ""No nosso código, a mãe `Veiculo` possui os atributos `placa` e `modelo` como `pr
ivate`. Quando o `Carro` herda de `Veiculo`, ele recebe esses atributos, mas o código dentro de
`Carro` NÃO consegue fazer `this.placa = "ABC"`. Ele é obrigado a usar o `super\(\)` ou o `setPl
aca\(\)`.
Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente? Qual o princí
pio das aulas passadas que isso está protegendo?""
<br><br>**Sua Resposta:**
O Java implementa essa restrição para que a Herança não quebre o Encapsulamento da classe mãe. 
Se a classe filha pudesse acessar variáveis private diretamente, um desenvolvedor poderia criar um CarroPirata extends Veiculo, ignorar totalmente as validações de segurança embutidas na classe mãe, e inserir dados corrompidos. 
Obrigando o uso do super() no construtor e de modificadores restritivos, a linguagem assegura que as regras de negócio, a inicialização segura e as validações definidas pela superclasse sejam respeitadas obrigatoriamente por toda a árvore genealógica de herança.
---
### Aula 7 - Polimorfismo
**Pergunta:** "No nosso loop `for \(Veiculo veiculo : frota\)`, a variável `veiculo` é do tipo g
enérico `Veiculo`. Se esquecêssemos de criar o método `calcularAutonomia\(\)` lá na classe mãe `
Veiculo`, nós conseguiríamos chamá-lo dentro do loop, mesmo sabendo que ele existe dentro do `Ca
rro` e da `Moto`? Por que o contrato precisa existir na base da hierarquia?"
<br><br>**Sua Resposta:**
O compilador só garante o acesso aos métodos declarados expressamente nessa superclasse. Se o método não existir na classe base, ocorre um erro de compilação, pois não há um contrato firmado que garanta que qualquer veículo saiba calcular sua autonomia. 
O método na base da hierarquia atua como uma assinatura obrigatória; ele diz ao compilador "confie em mim, todo veículo terá este comportamento", permitindo que o Late Binding em tempo de execução chame o método correto para cada subtipo específico (Carro ou Moto).
---
### Aula 8 - Classes Abstratas
**Pergunta:** "Pense no mundo real: Faz sentido existir um objeto que é APENAS 'Veículo' sem ser
um tipo específico? Você já entrou em uma concessionária e comprou "um veículo" genérico, sem se
r carro, moto, caminhão ou nada disso?
Por que, então, no código, precisamos EXPLICITAMENTE dizer ao Java que `Veiculo` é `abstract`? P
or que ele não deduz isso sozinho?
Pense: Se esquecermos de colocar `abstract`, qual o risco que corremos? Alguém pode criar `new V
eiculo\(\)` e quebrar a lógica do nosso sistema?"
<br><br>**Sua Resposta:**
A linguagem Java não pode deduzir abstrações lógicas sozinha, pois o compilador não entende o contexto humano; ele avalia regras sintáticas. 
Um Veiculo é um conceito abstrato; não é possível fabricar um veículo sem que ele seja de um tipo concreto (Carro, Moto). 
Se não definirmos explicitamente como abstract, um desenvolvedor desatento poderia instanciar new Veiculo(), alocando em memória um objeto "sem forma", incompleto e conceitualmente falho, o que quebraria a lógica do negócio (ex: como calcular autonomia de algo que não sabemos o motor?). O abstract é uma trava arquitetural.
---
### Aula 9 - Interfaces
**Pergunta:** "Por que Java permite herança simples \(apenas uma mãe\), mas múltipla implementaç
ão de interfaces \(vários contratos\)?
Pense: Se `CarroEletrico` pudesse herdar de `Veiculo` E de `Bateria` ao mesmo tempo \(herança mú
ltipla\), o que aconteceria se AMBAS as mães tivessem um método chamado `ligar\(\)`?
Como as interfaces resolvem esse problema? "
<br><br>**Sua Resposta:**
Se existisse herança múltipla e ambas as superclasses tivessem um método ligar(), a Máquina Virtual Java não saberia qual regra de negócio implementar (ambiguidade). 
As Interfaces resolvem isso de forma elegante, pois fornecem apenas o contrato (assinatura do método) e nenhuma implementação (código/estado). 
Uma classe pode assinar múltiplos contratos livremente (implements Veiculo, Bateria), pois a responsabilidade de construir a lógica do bloco ligar() recai 100% sobre a classe filha, garantindo previsibilidade e alto desacoplamento.
---
## Desafios Técnicos Implementados
### Desafio Pessoal (Seu Projeto)
**Qual foi o domínio que você escolheu para seu projeto pessoal?**
<br>Sistema de Controle de Eletrodomésticos, com foco inicial em simular a arquitetura de uma Geladeira IoT conectada.
<br><br>**Quais classes você criou?** <br>
Geladeira (Superclasse Abstrata)

Frigobar (Subclasse de Geladeira)

GeladeiraInteligente (Subclasse de Geladeira)

Sensor (Classe associada para monitoramento térmico)

Conectavel (Interface para dispositivos IoT) <br><br>
**Qual foi o maior desafio técnico que você enfrentou?**<br>
O maior desafio foi refatorar a estrutura do método main para acomodar o Polimorfismo Transversal utilizando a interface Conectavel. 
Foi necessário entender como alocar objetos de hierarquias completamente diferentes (Sensor e GeladeiraInteligente) em um mesmo array tipado via Interface, garantindo que a iteração chamasse o comportamento conectarRede() dinamicamente sem violar as regras de encapsulamento ou causar exceções de conversão (ClassCastException). 
Essa virada de paradigma exigiu forte dedicação à teoria do Late Binding.
---
## Conclusão
**O que você aprendeu nestas 9 aulas?**<br>
Aprendi a projetar software pensando não como scripts procedurais, mas como componentes vivos que interagem entre si. 
Compreendi que a Orientação a Objetos é primariamente sobre proteção de estado (Encapsulamento) e estabelecimento de contratos rigorosos (Abstração e Interfaces). 
A jornada transformou minha visão sobre arquitetura de sistemas corporativos em Java.
<br>**Qual conceito foi mais difícil de entender?**<br>
O Polimorfismo e as regras de sobreposição (@Override) foram complexos no início. 
Compreender que o Java compila olhando para o lado esquerdo (Tipo da Variável), mas executa olhando para o lado direito (Instância na Memória) mudou minha forma de ler código.
<br>**O que você melhoraria no seu projeto se pudesse refazer?**<br>
Eu substituiria o uso massivo de System.out.println() para tratamento de erros dentro dos setters e métodos (como a falta de espaço na geladeira) pela implementação do fluxo nativo de Exceções do Java (throw new IllegalArgumentException(...)). 
Isso tornaria o sistema mais resiliente e os erros tratáveis em camadas superiores, garantindo uma arquitetura muito mais profissional e limpa.
