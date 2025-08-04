# Nubank Capital Gain Tax Calculator

Este projeto resolve o desafio técnico do Nubank relacionado ao cálculo de imposto sobre ganho de capital em operações de compra e venda de ações.

O projeto foi desenvolvido com:
- **Java 17**
- **Programação Orientada a Objetos**
- **Biblioteca [Gson](https://github.com/google/gson)** para leitura de arquivos JSON
- Arquivo `capital.json` contendo os **9 cenários de teste** (`case1` a `case9`)

A estrutura do projeto segue o padrão Maven:

src/
└── main/
└── java/
└── com/capital/
├── Main.java
└── Operacoes/
├── Operation.java
├── Result.java
└── TaxaCalculator.java


- `Main.java` → Entrada principal do programa, onde o usuário escolhe o case
- `Operation.java` → Representa cada operação (buy/sell)
- `Result.java` → Representa a saída (tax)
- `TaxaCalculator.java` → Responsável por todo o cálculo da média ponderada, imposto e prejuízo acumulado

---

##  Como executar

###  1. Usando `rodarApp.bat` no Windows

1. Abra o **Prompt de Comando** ou **PowerShell**
2. Navegue até a pasta do projeto
3. Execute: rodarApp
para Rodar no Git Bash, MINGW ou WSL
1. Abra o **Git Bash**, **MINGW** ou **WSL**
2. Navegue até a pasta do projeto
3. Execute: cmd.exe /c rodarApp.bat
4. Execute: rodarApp

para Simplificar e rodar quem qualquer prompt 
1. Navegue até a pasta do projeto
2. Execute: mvn compile exec:java
para Rodar no  
Terminal	Funciona com mvn compile exec:java?
**CMD (Prompt de Comando)**	
**PowerShell**	
**Git Bash / MINGW**
**WSL / Linux / macOS**	(desde que Maven esteja instalado)

O terminal pedira para escolher o case case1 ao case9 ou allcases. Digite a opçao e a saida do capital vendio e comprado e a taxa cobrada sera mostrada.

Contado 
Nome: **Daniel Péricles do Nascimento**
Github: https://github.com/Danielpernasc
Linkedin: https://www.linkedin.com/in/danielpericlesnascimento/
Whatsapp e Telefone: **1196711900**


