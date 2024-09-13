# Como iniciar a aplicação

## Requisitos
- Java JDK 17
- Maven
- Docker (Opcional)

### Iniciar aplicação utilizando Docker

1. Após instalar o docker em sua maquina

1.  Navegue até o diretório do seu projeto na terminal/comando
2.  Certifique-se de estar no diretório raiz do seu projeto (onde o arquivo pom.xml está localizado)
3.  Execute o seguinte comando:

`docker-compose up`

Isso compilará sua aplicação, baixará dependências e iniciará a aplicação Spring Boot.

4. Abra o endereço `localhost:8080` ou `localhost:8080/jogo/simular` no seu navegador.

### Iniciar aplicação utilizando Maven
### No Windows

1.  Visite a página oficial de download do Oracle Java: [https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
2.  Baixe o instalador apropriado para o seu sistema (Windows x64).
3.  Execute o instalador baixado e siga as instruções.
4.  Defina a variável de ambiente JAVA\_HOME:
    -   Valor da variável: Caminho para sua instalação JDK (por exemplo, C:\\Program Files\\Java\\jdk-17)
    -   Adicione %JAVA\_HOME%\\bin ao caminho de variável de ambiente

### No Linux (distribuições baseadas em Ubuntu)

1.  Abra o Terminal
2.  Atualize a lista de pacotes:

`sudo apt update`

3.  Instale Java 17:

`sudo apt install openjdk-17-jdk`

## Instalando Maven

Maven é uma ferramenta de automação de build para projetos Java. Aqui está como instalá-la:

### No Windows

1.  Visite a página de download do Apache Maven: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
2.  Baixe o arquivo ZIP binário (apache-maven-x.x.x-bin.zip)
3.  Extraia os arquivos para um diretório de sua escolha (por exemplo, C:\\Program Files\\Apache Software Foundation\\apache-maven-x.x.x)
4.  Defina a variável de ambiente MAVEN\_HOME:
    -   Nome da variável: MAVEN\_HOME
    -   Valor da variável: Caminho para sua instalação Maven
    -   Adicione %MAVEN\_HOME%\\bin ao caminho de variável de ambiente

### No Linux (distribuições baseadas em Ubuntu)

1.  Abra o Terminal
2.  Instale Maven:

`sudo apt-get update sudo apt-get install maven`

## Executando a aplicação Spring Boot

1.  Navegue até o diretório do seu projeto na terminal/comando
2.  Certifique-se de estar no diretório raiz do seu projeto (onde o arquivo pom.xml está localizado)
3.  Execute o seguinte comando:

`mvn spring-boot:run`

Isso compilará sua aplicação, baixará dependências e iniciará a aplicação Spring Boot.

4. Abra o endereço `localhost:8080` ou `localhost:8080/jogo/simular` no seu navegador.