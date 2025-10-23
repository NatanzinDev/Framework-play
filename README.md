# Programação para internet
## Framework play

### Anotações 
<ol>
<li>Template == Views</li>
<li>Nome das pastas na views tem que ser igual ao nome dos controllers</li>
<li>Nome dos arquivos html na views tem que ser igual a nomemclatura das actions</li>
<li>O arquivo route dentro da pasta conf controla as rotas de caminho e pode criar rotas personalizadas dentro delas</li>
<li>localhost:9000/documentation para ver a documentação do play</li>
<li>No arquivo routes a Home Page define a rota principal, vai direcionar pra página selecionada quando você digitar localhost:9000</li>
<li>Nas views estrutura html padrão(head, dody) é herdada do main.html</li>
<li>Se você for linkar algum arquivo css ou js sempre deve estar em volta de aspas simples('') Ex: src="@{'public/stylesheets/style.css'}"</li>
<li>A anotação @Transient dentro do Model serve para que o atributo anotado com ele não seja criado no banco de dados, ele servira apenas como um valor de passagem.</li>
<li> https://www.playframework.com/documentation/1.5.x/cheatsheet/commandLine link da documentação do play</li>
<li> métodos com getNomedoatributo no Model vão ser considerados como atributo no template, incluse é melhor para fazer operações matemáticas por exemplo do que diretamente na application ou na view </li>
<li> 
  A cardinalidade correponde ao final da notação do model
  <ul>
    <li>@ManyToOne - vai ser atributo único</li>
     <li>@OneToOne - o atributo vai ser em forma de Lista</li>
  </ul>
</li>
<li>A anotação @Transient serve para ignorar atributos do model, o atributo com essa anotação não será salvo no banco.</li>
<li>Preferir o usar Long ao invés de long, pois o long com L minusculo se não receber valor adota zero como valor padrão e não fica uma boa prática comparar com zero algo que não inicializado</li>
<li>Não repetir o nome de variáveis de laços de repetição utilizados na mesma view</li>
<li>Na parte de relacionamento de entidades buscar começar tralhando com o model</li>
<li>@ManyToMany(mappedBy="nomedoatributodorelacionamentonaoutraclasse") o mappedBy serve para definir quem vai ser o atributo fraco da relação, é obrigatório na relação ManyToMany</li>
<li>Sempre que modificar alguma coisa no inicializador reinicie a aplicação para atualizar os valores no banco de dados</li>
<li>Comandos flash duram apenas duas requisições</li>
	
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

## Estruturas de controle e repetição
<ol>
  <li>
    if-else
  </li>
  #{if condicao}
    #{/if}
#{else if outraCondicao}
    #{/else if}
#{else}
    #{/else}

  <li>
    list
  </li>
  #{list items:minhaColecao, as:'item'}
    <p>${item.propriedade}</p>#{/list}

  <li>Verificação do flash</li>
  	   
         #{if flash.error}
					  <div class="alert alert-danger alert-dismissible fade show" role="alert">
					    <strong>Algo deu errado:</strong> ${flash.error}
					    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					  </div>
					#{/if}
		    		
		    	#{if flash.success}
					  <div class="alert alert-success alert-dismissible fade show" role="alert">
					    <strong>Sucesso!</strong> ${flash.success}
					    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					  </div>
					#{/if}
</ol>

## Login 
<ol> 
	<li>A session para salvar no play, a preferência de tipos que se deve salvar nela é string pois é o único que você consegue recuperar</li>
	<li>Para proteger uma classe com sua classe de segurança ele deve conter a @With(nomedaclass.clas)</li>
	<li>session.clear() limpar toda a sessão do usuario logado</li>
	<li>session.put("chave", dadosarmazenados), serve para armazenar os dados desejados do usuario logado</li>
	<li> A palavra-chave @interface (com o @ na frente) é usada para criar sua própria anotação em Java. O nome que você dá a ela, neste caso Administrador, é como você vai usá-la no resto do seu código (ex: @Administrador).</li>
	<li>Target - Define onde a sua anotação pode ser usada no código</li>
	<li>ElementType.METHOD - Permite que você coloque a anotação em cima de um método.</li>
	<li>ElementType.TYPE -  Permite que você coloque a anotação em cima de uma classe ou interface.</li>
</ol>

### Passos da criação do login
<ol>
	<li>Editar model com email e senha</li>
	<li>Deixar pelo menos um usuario já cadastrado pelo inicializador - Usuario root</li>
	<li>Controlador de login - Apresentar form, lógica e deslogar</li>
	<li>Form de login, que aponta para action de logar</li>
	<li>Lógica da action de logar, pequisa por email e senha igual os parametros informados na action - sess</li>
	<li>Criação de interceptador("classe de segurança") - faz a verificação de a sessão está com a chave de sessão</li>
	<li>Anotar classe desejadas com @With, que são classe que vão ser protegidas</li>
	<li>Uso dos dados no session['chave'] nos templates</li>
	<li>Lógica de logout</li>
</ol>

### Validação 
<ol>
	<li>@Required anotação para campos que são obrigatórios</li>
	<li>@Min(valor) e @Max(valor) anotar valores minimo e máximo dos campos</li>
	<li>A importação tem que ser feita do play.data.validation</li>
	<li>@MinSize(valor) e MAxSize(Valor) serva para anotar a quantidade de caracteres que o campo deve ter</li>
	<li>Evitar trabalhar com tipos primitivos na validação.</li>
	<li>@Email anotação para validar campo de email</li>
	<li>@Valid serve para fazer a validação do no controler, é colocado na assinatura da action antes do objeto que lhe refere</li>
</ol>
