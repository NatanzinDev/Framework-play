# Programação para internet
## Framework play

### Anotações 
<ol>
<li>Template == Views</li>
<li>Nome das pastas na views tem que ser igual ao nome dos controllers</li>
<li>Nome dos arquivos html na views tem que ser igual a nomemclatura das actions</li>
<li>O arquivo route dentro da pasta conf controla as rotas de caminho e pode criar rotas personalizadas dentro delas</li>
<li>localhost:9000/documentation para ver a documentação do play</li>
<li>Nas views estrutura html padrão(head, dody) é herdada do main.html</li>
<li>Se você for linkar algum arquivo css ou js sempre deve estar em volta de aspas simples('') Ex: src="@{'public/stylesheets/style.css'}"</li>
<li>A anotação @Transient dentro do Model serve para que o atributo anotado com ele não seja criado no banco de dados, ele servira apenas como um valor de passagem.</li>
<li> https://www.playframework.com/documentation/1.5.x/cheatsheet/commandLine link da documentação do play</li>
<li> métodos com getNomedoatributo no Model vão ser considerados como atributo no template, incluse é melhor para fazer operações matemáticas por exemplo do que diretamente na application ou na view </li>
</ol>

### Comandos do play
<ol>
  <li>Criar projeto: play new [nome do projeto]</li>
  <li>Rodar projeto na porta 9000: play run [nome do projeto]</li>
  <li>Para o eclipse reconher como projeto java: (dentro do projeto em terminal) play eclipsify [nome do projeto]</li>
  <li>Para importar javascript: #{script 'nomedoscript' /}</li>
</ol>

### Metodos para dados do form 
<ol>
  <li><strong>.save </strong>| para salvar dado no banco</li>
  <li><strong>.findAll </strong>| para buscar dados do banco e adiconar na lista</li>
  <li><strong>? </strong>| usado na frente da variaveis do view para assumir que elas não vão receber valor sem o id</li>
</ol>

### Montagem de query string
<ol>
  <li>depois do final da url se passa o "?" e em sequência o "name do input" seguido do atribuido de valor "=" mais o determinado valor </li>
  <li>E para passar mais de um valor se usa "&" Exemplo: ?email=valoremail&senha=valorsenha</li>
</ol>

## Assuntos cobrados
<ol>
  <li>Montagem de querry string </li>
  <li>CRUD</li>
  <li>Diferença dos methodos get e post</li>
</ol>
