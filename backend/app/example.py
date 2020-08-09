# arquivo testando a comunicação com o banco
from pymongo import MongoClient
import datetime

connection = MongoClient('localhost', 27017, username='admin', password='admin',)

databaseEmpresa = connection.empresa
collectionUsuarios = databaseEmpresa.collectionUsuarios

musica = {
    'nome': 'Mathias Artur Schulz',
    'cargo': 'Chefão kkk',
    'email': 'MathiasSchulz34@gmail.com',
    'telefones': ['99 99999-9999', '88 88888-8888'],
    'dataCriacaoRegistro': datetime.datetime.now(),
}

musica_id = collectionUsuarios.insert_one(musica).inserted_id
print(musica_id)
