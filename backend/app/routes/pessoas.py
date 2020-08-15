from . import routes
from controllers.ControllerPessoa import ControllerPessoa
from Connection import Connection

def start():
    connection = Connection()
    collection = connection.getCollectionByName('collectionUsuarios')
    return ControllerPessoa(collection)

@routes.route('/pessoas', methods=['GET'])
def get():
    """Retorna todos os registros"""
    controller = start()
    return controller.get()

@routes.route('/pessoas/<id>', methods=['GET'])
def getOne(id):
    """Retorna o registro de acordo com o id fornecido"""
    controller = start()
    return controller.getOne(id)

@routes.route('/pessoas', methods=['POST'])
def insertOne(jsonData):
    """Realiza a inserção de um registro com as informações fornecidas"""
    controller = start()
    return controller.insertOne(jsonData)

@routes.route('/pessoas/<id>', methods=['POST'])
def updateOne(id, jsonData):
    """Realiza a atualização de um registro pelo id atualizando as informações fornecidas"""
    controller = start()
    return controller.updateOne(id, jsonData)

@routes.route('/pessoas/<id>', methods=['DELETE'])
def deleteOne(id):
    """Deleta um registro de acordo com o id fornecido"""
    controller = start()
    return controller.deleteOne(id)
