# 🔌 Aula 09: Interfaces e Polimorfismo Transversal

Nesta última etapa, explorámos o conceito de **Interfaces**, que funcionam como contratos de comportamento rigorosos. Enquanto a Herança (`extends`) define o que um objeto *é*, a Interface (`implements`) define o que um objeto *faz*, permitindo o agrupamento de classes de hierarquias completamente distintas.

### A Interface `Conectavel`
Foi criada uma interface para padronizar o comportamento de equipamentos IoT (Internet of Things). Ela exige a implementação de dois métodos:
* `conectarRede()`
* `desconectarRede()`

### Implementação em Múltiplas Hierarquias
Para demonstrar o poder das interfaces, o contrato foi assinado por classes de ramos diferentes da arquitetura:
1. **`Sensor`**: Uma classe independente e base.
2. **`GeladeiraInteligente`**: Uma classe que já herda de `Geladeira` e agora também implementa conectividade.

### Execução Polimórfica
No método principal, foi instanciado um *array* do tipo `Conectavel[]`. O sistema conseguiu iterar sobre um `Sensor` e uma `GeladeiraInteligente` simultaneamente, invocando o método `conectarRede()` sem precisar de conhecer os detalhes internos de cada classe, demonstrando o mais alto nível de desacoplamento em Java.

---
[⬅️ Voltar para o Início](README.md)
