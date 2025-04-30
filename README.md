# Programação para internet
## Framework play

### Anotações 
<li>Template == Views</li>
<li>Nome das pastas na views tem que ser igual ao nome dos controllers</li>
<li>Nome dos arquivos html na views tem que ser igual a nomemclatura das actions</li>
<li>O arquivo route dentro da pasta conf controla as rotas de caminho e pode criar rotas personalizadas dentro delas</li>

### Comandos do play
<ol>
  <li>Criar projeto: play new [nome do projeto]</li>
  <li>Rodar projeto na porta 9000: play run [nome do projeto]</li>
  <li>Para o eclipse reconher como projeto java: (dentro do projeto em terminal) play eclipsify [nome do projeto]</li>
</ol>

### Metodos para dados do form 
<ol>
  <li><strong>.save </strong>| para salvar dado no banco</li>
  <li><strong>.findAll </strong>| para buscar dados do banco e adiconar na lista</li>
  <li><strong>? </strong>| usado na frente da variaveis do view para assumir que elas não vão receber valor sem o id</li>
</ol>
