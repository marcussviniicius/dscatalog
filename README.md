# DSCatalog

API REST em Java com Spring Boot para catálogo de produtos — parte do projeto de bootcamp **DevSuperior**.

Este projeto implementa um backend completo para gerenciar produtos, usuários e rotas REST seguindo boas práticas de camadas, DTOs, validações, tratamento de erros, paginação e testes automatizados.

---

## 🧰 Tecnologias

- Java 17/21 (LTS)
- Spring Boot (REST API)
- Spring Data JPA
- Banco H2 (em memória para desenvolvimento/testes)
- JUnit e Mockito para testes
- Paginação e ordenação com `Pageable`

---

## 🚀 Funcionalidades

✔ CRUD completo de produtos  
✔ Paginação de resultados  
✔ Ordenação por campos  
✔ Tratamento de exceções personalizado  
✔ Testes de integração e unidade  
✔ Camadas bem separadas:
- Controller
- Service
- Repository

---

## 📌 Como rodar localmente

### Pré-requisitos

- JDK 17 ou superior
- Maven

### Execução

```sh
git clone https://github.com/marcussviniicius/dscatalog.git
cd dscatalog/backend
mvn spring-boot:run
