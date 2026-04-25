# AGENTS.md

## Objetivo do Arquivo

Este arquivo serve como instrução permanente para o Codex sempre que uma nova conversa for iniciada neste projeto. Ele existe para preservar o contexto essencial do projeto, o modo de trabalho esperado e as regras que devem ser seguidas antes de qualquer análise, sugestão ou alteração.

## Contexto Geral do Projeto

- Tipo do projeto: projeto Java com Gradle para mod de Minecraft.
- Linguagem principal: Java.
- IDE usada: IntelliJ IDEA (há pasta `.idea` e configurações de execução do IntelliJ).
- Sistema de build: Gradle com wrapper (`gradlew` e `gradlew.bat`).
- Plugin principal de build identificado: `net.minecraftforge.gradle` versão `[6.0,6.2)`.
- Versão do Java encontrada: Java 17 (`java.toolchain.languageVersion = JavaLanguageVersion.of(17)`).
- Relação com Minecraft/modding: projeto de modding para Minecraft usando Forge.
- Minecraft identificado: `1.20.1`.
- Forge identificado: `47.4.10`.
- Mod loader identificado: Forge / `javafml`.
- Mod identificado: `shearupgraded` / `Shear Upgraded`.
- Estrutura principal de pastas identificada:
  - `src/main/java`
  - `src/main/resources`
  - `src/generated/resources`
  - `gradle/wrapper`
  - `.idea/runConfigurations`
  - `run`
  - `build`
  - `docs`
- Pacote principal identificado: `dev.werllon.shearupgraded`.
- Classe principal identificada: `src/main/java/dev/werllon/shearupgraded/ShearUpgradedMod.java`.
- Pastas de recursos relevantes identificadas:
  - `src/main/resources/META-INF/mods.toml`
  - `src/main/resources/assets/shearupgraded`
  - `src/main/resources/data/shearupgraded`
  - `src/main/resources/pack.mcmeta`

## Perfil do Usuário

O usuário está estudando Java e desenvolvimento de projetos, incluindo projetos relacionados a Minecraft/mods quando aplicável.

O usuário precisa que as explicações sejam claras, simples, progressivas e didáticas.

O Codex deve ajudar o usuário a entender o raciocínio por trás das mudanças, e não apenas entregar código pronto.

## Terminal Padrão do Projeto

- O terminal padrão deste projeto deve ser o Git Bash.
- O Codex deve usar Git Bash sempre que precisar sugerir ou executar comandos.
- O Codex não deve usar CMD como terminal principal.
- O Codex não deve usar Prompt de Comando do Windows, salvo se o usuário autorizar.
- Comandos devem ser escritos preferencialmente no formato compatível com Git Bash.
- Para Gradle, priorizar:
  - `./gradlew build`
  - `./gradlew runClient`
  - `./gradlew test`
- Evitar usar `gradlew.bat`, exceto quando necessário ou autorizado pelo usuário.

## Regras de Trabalho do Codex

- Sempre analisar antes de alterar.
- Sempre explicar o problema de forma simples.
- Sempre apresentar um plano antes de modificar arquivos.
- Sempre informar quais arquivos pretende alterar.
- Nunca alterar arquivos sem autorização explícita do usuário.
- Evitar mudanças grandes sem necessidade.
- Priorizar correções pequenas, seguras e fáceis de entender.
- Não atualizar dependências sem autorização.
- Não alterar versão do Java, Gradle, Minecraft, Forge, Fabric, NeoForge ou bibliotecas sem autorização.
- Não apagar arquivos sem autorização.
- Não reformular o projeto inteiro sem necessidade.
- Quando houver erro, identificar primeiro a causa provável.
- Quando sugerir código, explicar o motivo da solução.
- Se não tiver certeza de algo, dizer claramente que precisa confirmar.
- Sempre considerar o Git Bash como terminal padrão do projeto.

## Padrão de Resposta Esperado

O Codex deve responder preferencialmente neste formato:

1. O que eu entendi.
2. Problema ou objetivo atual.
3. Causa provável, se houver erro.
4. Plano de ação.
5. Arquivos que podem ser alterados.
6. Comandos que podem ser executados no Git Bash, se necessário.
7. Confirmação antes de modificar.

## Comandos do Projeto

Comandos confirmados ou fortemente prováveis com base na estrutura Gradle/Forge encontrada. Todos devem ser pensados para uso no Git Bash.

- `./gradlew build`
- `./gradlew runClient`
- `./gradlew test`
- `./gradlew runServer`
- `./gradlew runData`
- `./gradlew runGameTestServer`
- `./gradlew tasks` para listar tarefas disponíveis e confirmar o conjunto exato

Observações:

- Existem configurações do IntelliJ para `runClient`, `runData`, `runGameTestServer` e `runServer`, o que reforça a existência dessas tarefas no projeto.
- O comando `./gradlew test` faz sentido para Gradle/Java, mas a existência de testes reais no projeto está PENDENTE DE CONFIRMAÇÃO.
- A lista exata de tarefas disponíveis sem execução direta está PENDENTE DE CONFIRMAÇÃO.

## Cuidados Especiais

- Respeitar a estrutura do Gradle.
- Respeitar a versão atual do Java.
- Respeitar a versão atual do Minecraft/mod loader.
- Não mudar mappings, loader, plugins ou dependências sem autorização.
- Antes de mexer em registries, eventos, mixins, assets, resources ou configs, explicar o impacto.
- Não executar comandos destrutivos no terminal.
- Não executar comandos de limpeza pesada sem explicar antes.
- Não usar CMD como primeira opção de terminal.
- Como este projeto é de modding com Forge para Minecraft `1.20.1`, qualquer mudança em `mods.toml`, registries, recipes, tags, modelos, texturas e comportamento de itens pode afetar carregamento do mod, assets e compatibilidade do ambiente.

## Como Usar em Novas Conversas

Prompt sugerido para novas conversas:

“Leia primeiro o arquivo AGENTS.md e siga todas as regras descritas nele. Depois leia PROJECT_NOTES.md para entender o estado atual do projeto. Use Git Bash como terminal padrão. Não use CMD. Antes de alterar qualquer arquivo, explique o que você entendeu e me apresente um plano.”
