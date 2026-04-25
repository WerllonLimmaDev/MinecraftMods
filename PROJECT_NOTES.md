# PROJECT_NOTES.md

## Último Estado Conhecido

- Projeto aberto no IntelliJ.
- Linguagem principal: Java.
- Build system: Gradle com wrapper.
- Plugin de modding identificado: ForgeGradle (`net.minecraftforge.gradle`).
- Java version encontrada: 17.
- Terminal padrão definido como Git Bash.
- CMD não deve ser usado como terminal principal.
- O projeto parece ser um mod de Minecraft com Forge.
- Minecraft identificado: `1.20.1`.
- Forge identificado: `47.4.10`.
- Mod ID identificado: `shearupgraded`.
- Nome do mod identificado: `Shear Upgraded`.
- O projeto contém configurações de execução para `runClient`, `runServer`, `runData` e `runGameTestServer`.
- Há artefato gerado em `build/libs/shearupgraded-1.0.0.jar`, o que sugere que pelo menos uma build já foi realizada anteriormente.
- Se o projeto compila atualmente nesta máquina e neste estado: PENDENTE DE CONFIRMAÇÃO.
- Se a tarefa `runClient` funciona atualmente sem erro: PENDENTE DE CONFIRMAÇÃO.

## Estrutura Identificada

- `build.gradle`
- `settings.gradle`
- `gradle.properties`
- `gradlew`
- `gradlew.bat`
- `gradle/wrapper`
- `src/main/java`
- `src/main/resources`
- `src/main/resources/META-INF/mods.toml`
- `src/main/resources/pack.mcmeta`
- `src/main/resources/assets/shearupgraded`
- `src/main/resources/data/shearupgraded`
- `src/generated/resources`
- `.idea/runConfigurations`
- `run`
- `build`
- `docs`

Arquivos Java principais identificados:

- `src/main/java/dev/werllon/shearupgraded/ShearUpgradedMod.java`
- `src/main/java/dev/werllon/shearupgraded/registry/ModItems.java`
- `src/main/java/dev/werllon/shearupgraded/item/BaseVeinShearsItem.java`
- `src/main/java/dev/werllon/shearupgraded/item/DiamondShearsItem.java`
- `src/main/java/dev/werllon/shearupgraded/item/EmeraldShearsItem.java`
- `src/main/java/dev/werllon/shearupgraded/item/GoldenShearsItem.java`
- `src/main/java/dev/werllon/shearupgraded/item/IronShearsItem.java`
- `src/main/java/dev/werllon/shearupgraded/item/NetheriteShearsItem.java`
- `src/main/java/dev/werllon/shearupgraded/client/VeinMiningPreviewRenderer.java`
- `src/main/java/dev/werllon/shearupgraded/util/VeinMiningHelper.java`
- `src/main/java/dev/werllon/shearupgraded/util/EntityVeinMiningHelper.java`
- `src/main/java/dev/werllon/shearupgraded/util/ModBlockTags.java`

Recursos principais identificados:

- `src/main/resources/assets/shearupgraded/lang/en_us.json`
- `src/main/resources/assets/shearupgraded/lang/pt_br.json`
- `src/main/resources/assets/shearupgraded/models/item/*.json`
- `src/main/resources/assets/shearupgraded/textures/item/*.png`
- `src/main/resources/data/shearupgraded/recipes/*.json`
- `src/main/resources/data/shearupgraded/tags/blocks/vein_mineable_with_shears.json`

## Terminal e Comandos

- Terminal padrão: Git Bash.
- Terminal a evitar: CMD / Prompt de Comando do Windows.
- Comandos Gradle devem ser preferencialmente executados no formato:
  - `./gradlew build`
  - `./gradlew runClient`
  - `./gradlew test`
- `gradlew.bat` só deve ser usado se necessário ou autorizado.

Comandos adicionais que fazem sentido para este projeto:

- `./gradlew runServer`
- `./gradlew runData`
- `./gradlew runGameTestServer`
- `./gradlew tasks`

Observações:

- A lista completa de tarefas Gradle está PENDENTE DE CONFIRMAÇÃO por execução direta.
- O uso de `./gradlew` foi definido como padrão conceitual do projeto para Git Bash.

## Decisões Importantes

- O usuário quer aprender o raciocínio, não apenas receber código pronto.
- O Codex deve pedir autorização antes de alterar arquivos.
- O Codex deve explicar de forma simples.
- O Codex deve evitar alterações grandes sem necessidade.
- O Codex deve usar Git Bash como terminal padrão.
- O Codex não deve usar CMD como terminal principal.
- O Codex deve manter este arquivo atualizado quando houver mudança importante.

## Problemas Encontrados

- Uma conversa antiga do Codex apresentou erro de sessão: “Failed to initialize ACP session. Error: Internal error: no rollout found for thread id”.
- Solução usada: iniciar uma nova conversa e usar os arquivos AGENTS.md e PROJECT_NOTES.md como contexto permanente.
- O comando `bash` não estava disponível diretamente no `PATH` da sessão atual da ferramenta, mas o executável do Git Bash foi localizado no caminho padrão do Git para Windows.
- A disponibilidade exata de todas as tarefas Gradle sem execução direta permanece PENDENTE DE CONFIRMAÇÃO.
- O estado atual de compilação e execução do projeto nesta sessão permanece PENDENTE DE CONFIRMAÇÃO.

## Próximas Tarefas

- Confirmar se `./gradlew build` executa sem erro no Git Bash.
- Confirmar se `./gradlew runClient` abre o ambiente de desenvolvimento corretamente.
- Confirmar se há testes automatizados relevantes para `./gradlew test`.
- Revisar a classe principal do mod e o fluxo de registro de itens.
- Revisar recipes, tags, models e texturas para garantir consistência com os itens registrados.
- PENDENTE DE DEFINIÇÃO PELO USUÁRIO.

## Histórico de Atualizações

### 2026-04-25

- Alteração realizada: criação inicial dos arquivos de contexto permanente do projeto.
- Arquivos modificados: `AGENTS.md`, `PROJECT_NOTES.md`
- Terminal usado: Git Bash
- Comandos executados: inspeção da estrutura do projeto e leitura de arquivos de configuração/build
- Motivo: preservar contexto entre conversas futuras do Codex e reduzir perda de contexto por erro de sessão
- Observações: nenhum arquivo de código, build ou recurso do projeto foi alterado

## Prompt de Retomada Para Nova Conversa

“Leia os arquivos AGENTS.md e PROJECT_NOTES.md.

Use esses arquivos como contexto principal desta nova conversa.

Use Git Bash como terminal padrão deste projeto.

Não use CMD como terminal principal.

A partir deles, me diga:

1. O que você entendeu sobre este projeto.
2. Em que ponto estamos.
3. Qual deve ser o próximo passo.
4. Quais arquivos você pretende analisar ou modificar.
5. Quais comandos pretende executar no Git Bash, se necessário.

Não altere nenhum arquivo ainda.”
