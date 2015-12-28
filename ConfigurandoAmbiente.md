# Introducao #

Configuracao do Ambiente de Desenvolvimento


# Variaveis de Ambiente #

Incluir no arquivo _/home/pedro/.bashrc_ ou em _/etc/environment_ ou em _/etc/bash.bashrc_ ou ...

```
export JAVA_HOME=/opt/jdk1.5.0_15
export JBOSS_HOME=/opt/jboss-4.0.5.GA
export MAVEN_HOME=/opt/maven-1.0.2
export JAVA_OPTS='-Xms256m -Xmx512m -XX:PermSize=256m -XX:MaxPermSize=512m'

PATH=$JAVA_HOME/bin:$M2_HOME/bin:$MAVEN_HOME/bin:$PATH
export PATH
```

# JBOSS #

## Banco de Dados ##

Para configurar o data source da aplicacao, basta criar o arquivo _/opt/jboss-4.0.5.GA/server/default/deploy/ouvidoria-ds.xml_ com o seguinte conteudo:

```
<?xml version="1.0" encoding="UTF-8"?>
<!-- JBoss Server DataSource -->
<datasources>
    <local-tx-datasource>
        <jndi-name>jdbc/ouvidoria</jndi-name>
        <connection-url>jdbc:postgresql://localhost/ouvidoria</connection-url>
        <driver-class>org.postgresql.Driver</driver-class>
        <user-name>postgres</user-name>
        <password>postgres</password>       
    </local-tx-datasource>
</datasources>
```

## Autenticacao ##

A autenticacao sera feita utilizando um login module do jboss que acessa o banco de dados configurado no datasource (ouvidoria-ds.xml), assumindo que apenas o hash md5 (em base64) esteja gravado no banco de dados. Incluir o seguinte trecho no arquivo _/opt/jboss-4.0.5.GA/server/default/conf/login-config.xml_

```
<!-- Security domain for Sistema de Ouvidoria 
Os grupo dos usuarios devem estar cadastrados com a coluna nome de acordo com a lista abaixo.
1 - administrador
2 - convidado
As permissoes de acesso no web.xml estao cadastradas com essa nomenclatura e caso esteja 
    diferente na base dados ocorrera erro 403 na tentativa de acesso ao sistema.
-->
<application-policy name = "ouvidoria-login">
   <authentication>
      <login-module code = "org.jboss.security.auth.spi.DatabaseServerLoginModule" flag = "required">
         <module-option name = "dsJndiName">java:/jdbc/ouvidoria</module-option>
         <module-option name="hashAlgorithm">MD5</module-option> 
         <module-option name="hashEncoding">base64</module-option>
         <module-option name = "principalsQuery">SELECT senha FROM usuario WHERE login=?</module-option>
         <module-option name = "rolesQuery">SELECT p.nome, 'Roles' FROM perfil p, usuario u WHERE u.login=? AND u.perfil_fk=p.id</module-option>
      </login-module>
   </authentication>
</application-policy>
```


# AndroMDA #

## Instalacao ##

### Configurar repositorios do maven ###

Criar o arquivo _/home/pedro/build.properties_ com o seguinte conteudo:
```
# Definicao dos repositorios externos
maven.repo.remote=http://www.ibiblio.org/maven,http://www.codeczar.com/maven,http://repo1.maven.org/maven-java.net,http://repo1.maven.org/maven/,http://team.andromda.org/maven
maven.repo.local=/opt/maven/repository
maven.home.local=/opt/maven-1.0.2
maven.compile.encoding=ISO-8859-1
```

### Download do androMDA ###

Executar o seguinte comando:
```
maven plugin:download -DgroupId=andromda -DartifactId=maven-andromdapp-plugin -Dversion=3.1
```


## Criando o projeto ##

```
$ maven andromdapp:generate
```

```
 __  __
|  \/  |__ _Apache__ ___
| |\/| / _` \ V / -_) ' \  ~ intelligent projects ~
|_|  |_\__,_|\_/\___|_||_|  v. 1.0.2

Please enter your first and last name (i.e. Chad Brandon):
Pedro Costa
Please enter the name of your J2EE project (i.e. Animal Quiz):
Sistema de Ouvidoria
Please enter the id for your J2EE project (i.e. animalquiz):
ouvidoria
Please enter a version for your project (i.e. 1.0-SNAPSHOT):
1.0-SNAPSHOT
Please enter the base package name for your J2EE project (i.e. org.andromda.samples):
com.googlecode.ouvidoria
Would you like an EAR or standalone WAR (enter 'ear' or 'war')?
ear
Please enter the type of transactional/persistence cartridge to use (enter 'hibernate', 'ejb', or 'spring'):
spring
Would you like to use the jBpm workflow engine, it uses Hibernate3 (enter 'yes' or 'no')?
no
Please enter the hibernate version number  (enter '2' for 2.1.x or '3' for 3.0.x):
3
Would you like a web application? (enter 'yes' or 'no'):
yes
Would you like your web tier to use JSF or Struts? (enter 'jsf' or 'struts'):
struts
Would you like to be able to expose your services as web services? (enter 'yes' or 'no'):
no
build:start:

andromdapp:init:

andromdapp:generate:
    [echo] +---------------------------------------------------------------------+
    [echo] |   G E N E R A T I N G   A n d r o M D A   J 2 E E   P R O J E C T   |
    [echo] +---------------------------------------------------------------------+
    [mkdir] Created dir: /home/pedro/workspace/ouvidoria
    [copy] Copying 1 file to /home/pedro/workspace/ouvidoria
andromdapp:init:

andromdapp:generate-app-subproject:
andromdapp:generate-module:
    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/app
    [copy] Copying 2 files to /home/pedro/workspace/ouvidoria/app

    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/app/src/META-INF

andromdapp:init:

andromdapp:generate-spring-subproject:
    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/core
andromdapp:init:

andromdapp:generate-core-subproject:
andromdapp:generate-module:

    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/core/src/java
    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/core/target/src


andromdapp:init:

andromdapp:generate-common-subproject:
andromdapp:generate-module:
    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/common

    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/common/src/java
    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/common/target/src

andromdapp:init:

andromdapp:generate-mda-subproject:
    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/mda/src/uml
    [copy] Copying 1 file to /home/pedro/workspace/ouvidoria/mda/src/uml
    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/mda/conf
    [copy] Copying 1 file to /home/pedro/workspace/ouvidoria/mda
    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/mda/conf/mappings

andromdapp:init:

andromdapp:generate-web-subproject:
andromdapp:generate-module:
    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/web

    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/web/src/java
    [mkdir] Created dir: /home/pedro/workspace/ouvidoria/web/target/src

    [echo] |  
    [echo] |  New J2EE project generated to: '/home/pedro/workspace/ouvidoria'
    [echo] |  
    [echo] |  For more information on how to proceed from here read '/home/pedro/workspace/ouvidoria/readme.txt'
    [echo] |  
BUILD SUCCESSFUL
Total time: 1 minutes 14 seconds
Finished at: Fri Apr 25 19:08:14 BRT 2008

```

## Customizar o projeto ##

**Alterar o arquivo _/home/pedro/workspace/ouvidoria/mda/project.properties_ para que seja gerada uma sequence para cada tabela e seja usada pelo hibernate:**

```
hibernate.generatorClass=sequence
```

**Alterar o arquivo _/home/pedro/workspace/ouvidoria/mda/conf/andromda.xml_:**

```
<namespace name="spring">
	<properties>
		...
		<property name="enableSpringTransactionsWhenEjbsEnabled">false</property>
		...
	</properties>
</namespace>
...		
<namespace name="bpm4struts">
    <properties>
    	...
    	<!-- Este eh o nome do login-module configurado no arquivo _login-config.xml_ do jboss -->
        <property name="securityRealm">ouvidoria-login</property>
    	...       
    </properties>
</namespace>
```

## Gerar artefatos ##

Executar:
```
maven install
```

## Deploy da aplicacao ##

Copiar o EAR gerado para o diretorio de deploy do jboss:
```
cp ~/workspace/ouvidoria/app/target/ouvidoria-app-1.0-SNAPSHOT.ear $JBOSS_HOME/server/default/deploy
```

### Outros GOALS ###

Outros goals retirados do arquivo _readme.txt_ gerado pelo andromda


> In order to succesfully build your project you will need to know
> how to invoke the build process for the existing modules, here's a
> list of examples:

> %> maven install

> simply builds all modules

> %> maven deploy

> collects all artifacts and builds a deployable .ear which is then
> deployed, you will need to have built the other modules before

> %> maven clean install deploy

> deletes all generated files, rebuilds and deploys; files in /src
> directories are **not** deleted

> %> maven core

> only build the core module

> %> maven web

> only build the web module

> %> maven nuke

> cleans out all /target directories and removes all Java classes with names
> ending with 'Impl' from the source directories (from the common, core and
> web modules); this goal asks for confirmation, but be careful calling it
> anyway as you will lose your manually edited files

> %> maven create-schema

> invokes the generated DDL code and subsequently tells the database
> to create the schema for the entities

> %> maven drop-schema

> invokes the generated DDL code and subsequently tells the database
> to drop the schema for the entities

> %> maven start-andromda-server

> starts the AndroMDA server, with this server running you will be able
> to significantly speedup the generation process although it will require
> you to use another console while it is running

> %> maven stop-andromda-server

> stops the AndroMDA server

> %> maven mda

> runs AndroMDA on your model and thereby generating files in
> the subdirectories of the existing modules

> %> maven mda -Dfilter=java,hibernate

> runs AndroMDA, but this time only using the Java and Hibernate
> cartridges (in that order)

> %> maven mda -Dfilter=~java,hibernate

> runs AndroMDA, but this time using all cartridges **except**
> the Java and Hibernate cartridges

> %> maven mda -Dfilter=java core web deploy

> runs AndroMDA using only the Java cartridge, rebuilds the core
> module and then the web module and deploys afterwards