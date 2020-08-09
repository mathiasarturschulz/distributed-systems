# arquivo testando a comunicação com o banco
from pymongo import MongoClient
import datetime

connection = MongoClient('localhost', 27017, username='admin', password='admin',)

databaseEmpresa = connection.empresa
collectionUsuarios = databaseEmpresa.collectionUsuarios

usuario = {
    'nome': 'Mathias Artur Schulz',
    'cargo': 'Chefão kkk',
    'email': 'MathiasSchulz34@gmail.com',
    'telefones': ['99 99999-9999', '88 88888-8888'],
    'dataCriacaoRegistro': datetime.datetime.now(),
}

usuario_id = collectionUsuarios.insert_one(usuario).inserted_id
print(usuario_id)
