# OpenLibrary Integration - Sistema de Busca de Livros
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="60" alt="Java logo"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="60" alt="MySQL logo"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="60" alt="Spring logo">

---

# Descrição

Este projeto tem como objetivo integrar uma aplicação Java com a API pública OpenLibrary
 para buscar informações de livros.

O sistema permite:

Consultar livros por título.

Processar os dados retornados pela API.

Armazenar e manipular informações em um banco local.

--- 

# Arquitetura do Projeto

Main.java → Ponto de entrada da aplicação.

Livro.java → Entidade que representa um livro.

OpenLibraryResponse.java → Estrutura para mapear os dados vindos da API.

LivroServico.java → Camada de serviço que consome a API e aplica regras de negócio.

LivroDao.java → Camada de persistência/acesso ao banco de dados.

Fluxo:
Usuário → Main → LivroServico → OpenLibrary API → Resposta → Persistência com LivroDao

---

# Tecnologias Utilizadas

Java 17+

Biblioteca HTTP (HttpClient ou equivalente)

Gson / Jackson para parse de JSON

Banco de Dados Local (ex: MySQL ou H2)
