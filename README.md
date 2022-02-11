## Desenvolvimento Web - Trabalho 01

A classe **Jogador** possui os atributos: **identificador, nome, email e data de nascimento**.

Já a classe **Pagamento**, responsável pela caracterização da entidade pagamento, possui os atributos: **identificador, ano, mês e valor**.

As duas entidades acima estão relacionadas utilizando a ideia de que um jogador pode possuir diversos pagamentos. Sendo assim, utiliza-se a notação *decorator* **@ManyToOne**
e **@OneToMany** do Spring Data JPA.

O servidor atende na URL **http://localhost:8080/api** por padrão e possui os seguintes *endpoints*:

Relacionados a **Jogador**:
- /jogadores - suporta os métodos **POST**, **GET** e **DELETE**.
  - Método **GET**: busca todos os jogadores ou, através de *query param*, busca jogadores pelo **nome**;
  - Método **POST**: cria um jogadores;
  - Método **DELETE**: deleta todos os jogadores.
- /jogadores/{id} - suporta os métodos **GET**, **PUT** e **DELETE**.
  - Método **GET**: busca um jogador pelo **id**;
  - Método **DELETE**: deleta um jogador pelo **id**;
  - Método **PUT**: atualiza os dados do jogador que possui o **id**.
  
Relacionados a **Pagamento**:
  - /pagamentos - suporta os métodos **GET**, **POST** e *DELETE*.
    - Método **GET**: busca todos os pagamentos ou, através de *query param*, busca pagamento pelo **id** do jogador;
    - Método **DELETE**: deleta todos os pagamentos ou, através de *query param*, delete pagamento pelo **id**;
  - /pagamentos/{id}/jogadores: suporta o método **POST**;
    - Método **POST**: cria um pagamento relacionado com jogador, onde o **id** recebido pela rota é o **id** do jogador;
  - /pagamentos/{id}: suporta método **PUT**:
    - Método **PUT**: atualiza dados do pagamento que o possui o **id**;

**Alunos**: Luiz Gustavo Kobilacz, Luciano Folmer Gasparello e Rafael Hiro Kato Kawakami.

