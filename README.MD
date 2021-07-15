# Como Executar
1 - Faça um clone do repositório via SSH
```shell
git@github.com:pablorodrigo52/desafio_quality.git
```

1.1 - ou via HTTPS
```shell
https://github.com/pablorodrigo52/desafio_quality.git
```


2 - Você pode executar a aplicaçao pela sua IDE ou pelo comando abaixo na pasta raiz do projeto
```shell
./mvnw spring-boot:run
```

# Swagger DOCS
Uma documentação usando swagger foi gerada para facilitar o uso. Depois que o projeto estiver rodando em sua máquina basta acessar:
```shell
http://localhost:8080/swagger-ui.html
```


# Rotas

## Calcular total m2 de uma propriedade
    - POST /property/m2 
    {
        "prop_name": "string",
        "district": {
            "prop_district": "string",
            "value_district_m2": 0
        },
        "rooms": [
            {
            "room_name": "string",
            "room_width": 0,
            "room_length": 0,
            "m2": 0
            }
        ]
    }

## Calcular valor de uma propriedade
    - POST /property/value
    {
        "prop_name": "string",
        "district": {
            "prop_district": "string",
            "value_district_m2": 0
        },
        "rooms": [
            {
            "room_name": "string",
            "room_width": 0,
            "room_length": 0,
            "m2": 0
            }
        ]
    }

## Determinar qual é o maior comodo de uma propriedade
    - POST /property/biggestRoom
    {
        "prop_name": "string",
        "district": {
            "prop_district": "string",
            "value_district_m2": 0
        },
        "rooms": [
            {
            "room_name": "string",
            "room_width": 0,
            "room_length": 0,
            "m2": 0
            }
        ]
    }

## Determinar a quantidade de m2 que cada comodo de uma propriedade tem
    - POST /property/rooms/m2
    {
        "prop_name": "string",
        "district": {
            "prop_district": "string",
            "value_district_m2": 0
        },
        "rooms": [
            {
            "room_name": "string",
            "room_width": 0,
            "room_length": 0,
            "m2": 0
            }
        ]
    }

## Listar todos os Bairros cadastrados
    - GET /district/

## Cadastrar um novo Bairro
    - POST /district/
    {
        "prop_district": "string",
        "value_district_m2": 0
    }