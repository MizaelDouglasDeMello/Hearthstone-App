# Hearthstone App

Este é um aplicativo de cartas Hearthstone desenvolvido com Kotlin, usando arquitetura MVVM, Retrofit para comunicação com APIs, Dagger Hilt para injeção de dependência e Picasso para carregamento de imagens e Unit, Mockito, Robolectric para testes que garantem qualidade e robustez.
<br>
<br>

## Projeto

<hr>

https://github.com/user-attachments/assets/c9bab3b7-2112-46a7-82c7-51b373f9132b

<br>
<hr>

## Funcionalidades

- Exibir uma lista de cartas de Hearthstone.
- Ver detalhes de uma carta selecionada.
- Filtrar cartas com base em determinados critérios.

## Arquitetura

O projeto segue o padrão de arquitetura MVVM (Model-View-ViewModel).

## Bibliotecas e Ferramentas

- **Kotlin**: Linguagem de programação.
- **Retrofit**: Para requisições de API.
- **Dagger Hilt**: Para injeção de dependência.
- **Picasso**: Para carregamento de imagens.
- **JUnit**: Para testes unitários.
- **Mockito**: Para criação de mocks em testes.
- **Robolectric**: Para execução de testes Android.

## Estrutura do Projeto

- `data`: Contém modelos de dados, serviço de API e implementações de repositórios.
- `di`: Contém módulos de injeção de dependência.
- `presentation`: Contém classes relacionadas à interface do usuário, incluindo activities, view models e adapters.
- `utils`: Contém classes utilitárias e constantes.

## Começando

### Pré-requisitos

- Android Studio
- Kotlin 1.8 ou superior
- Gradle 7.0 ou superior

### Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/Mizaeldouglas/hearthstone_app.git
    ```
2. Abra o projeto no Android Studio.
3. Construa o projeto para baixar todas as dependências.

### Executando o App

1. Conecte um dispositivo Android ou inicie um emulador.
2. Clique no botão "Run" no Android Studio.

### Executando Testes

Para executar os testes unitários, use o seguinte comando no terminal:
```sh
./gradlew test
