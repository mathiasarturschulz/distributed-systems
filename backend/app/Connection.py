from pymongo import MongoClient

class Mongo:
    USERNAME = 'admin'
    PASSWORD = 'admin'

    connection = ''

    def startConnection(self):
        if not connection:
            connection = MongoClient('localhost', 27017, username='admin', password='admin',)
    
    def getCollectionByName(self, name):
        teste = ''



# # arquivo testando a comunicação com o banco
# import datetime


# databaseEmpresa = connection.empresa
# collectionUsuarios = databaseEmpresa.collectionUsuarios

# usuario = {
#     'nome': 'Mathias Artur Schulz',
#     'cargo': 'Chefão kkk',
#     'email': 'MathiasSchulz34@gmail.com',
#     'telefones': ['99 99999-9999', '88 88888-8888'],
#     'dataCriacaoRegistro': datetime.datetime.now(),
# }

# usuario_id = collectionUsuarios.insert_one(usuario).inserted_id
# print(usuario_id)
