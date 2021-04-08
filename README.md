# Project-t

Aplicação de demonstração de consumo a API do Github
## Running

```
docker-compose up --build
```

Vá até http://localhost:9000/api/v1/organizations/{name}/contributors para acessar o endpoint principal da api.

Exemplo: http://localhost:9000/api/v1/organizations/facebook/contributors

## Tecnologias

- `Java11`
- `Play Framework`
- `sbt`
- `Docker`
- `docker-compose`
- `nginx`

## OBS!

Ajustar o Dockerfile e inserir seu token da api do Github na variável de ambiente GH_TOKEN.