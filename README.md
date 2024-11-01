# Conversor de Moedas

Um projeto simples para converter valores entre diferentes moedas, utilizando a API Exchange Rate.

## Índice

- [Descrição do Projeto](#descrição-do-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação e Configuração](#instalação-e-configuração)
- [Como Usar](#como-usar)
- [Estrutura do Código](#estrutura-do-código)
- [Exemplo de Saída](#exemplo-de-saída)
- [Dependências](#dependências)
- [Observações](#observações)
- [Contribuições](#contribuições)
- [Licença](#licença)
- [Autor](#autor)

## Descrição do Projeto

O **Conversor de Moedas** permite que usuários convertam valores em USD para diversas moedas, como BRL, EUR, GBP, entre outras. O projeto utiliza a API Exchange Rate para obter as taxas de câmbio em tempo real.

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação utilizada.
- **Gson**: Biblioteca para manipulação de JSON.
- **Exchange Rate API**: API utilizada para obter taxas de câmbio.

## Instalação e Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/fred-creator-creat/conversor-de-moedas.git
   cd conversor-de-moedas

## Como Usar

1. O programa solicita que o usuário insira o valor em USD que deseja converter.
2. Em seguida, apresenta uma lista de moedas de destino e solicita ao usuário que escolha uma das opções.
3. O valor convertido é então exibido com a taxa de câmbio atual.
4. Ao final, o usuário pode optar por realizar uma nova conversão ou encerrar o programa.

## Estrutura do Código

- **ConversorDeMoedas.java**: Classe principal com a interface em linha de comando, que captura o valor do usuário, a moeda de destino e exibe o valor convertido.
- **ConversorDeMoedasAPI.java**: Classe auxiliar que conecta-se à API ExchangeRate e obtém a taxa de câmbio entre USD e a moeda de destino.
- **pom.xml**: Arquivo de configuração do Maven, que define as dependências e as propriedades do projeto.

## Exemplo de Saída

Digite o valor em USD que deseja converter: 100

Escolha a moeda de destino:

1: BRL

2: EUR

3: GBP

4: CHF

5: JPY

6: AUD

Digite o número correspondente à moeda de destino: 1

Taxa de câmbio USD para BRL: 5.2500

Valor em BRL: 525.00

## Dependências
- Gson (para processamento de JSON): com.google.code.gson:gson:2.10.1

## Observações
- **Chave da API**: A chave da API ExchangeRate está configurada diretamente no código, na constante BASE_URL da classe ConversorDeMoedasAPI. Verifique e substitua esta chave pela sua chave pessoal da API, caso necessário.
- **Limitações**: A aplicação está configurada apenas para a conversão de USD para outras moedas. Para adicionar novas moedas de origem, é necessário modificar a URL de chamada da API.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença
Este projeto está licenciado sob a MIT License.

## Autor

Frederico Cavalheiro

