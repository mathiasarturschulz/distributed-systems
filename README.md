# distributed-systems

## Criando a network externa

`docker network create shared`

## Persistência

### MongoDB

E mongo-express para visualizar os dados salvos a partir do navegador http://0.0.0.0:8081/

## Backend

### Python 3.8.5

## Frontend

### React

## Replica set

Criar a Network para comunicação dos containers

`docker network create my-mongo-cluster`

Iniciando todos os três containers mongo

`docker-compose up`

Conectar no shell do primeiro container

`docker exec -it mongo01 mongo`

Criando o config dentro do mongo do container conectado

`config = {"_id" : "my-mongo-set", "members" : [{"_id" : 0, "host" : "mongo01:27017"}, {"_id" : 1, "host" : "mongo02:27017"}, {"_id" : 2, "host" : "mongo03:27017"}]}`

Iniciando o replica set

`rs.initiate(config)`
