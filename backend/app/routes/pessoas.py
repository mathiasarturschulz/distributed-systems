from . import routes

@routes.route('/pessoas', methods=['GET'])
def get():
    return 'rota com retorno de todos os registros'

@routes.route('/pessoas/<id>', methods=['GET'])
def getOne(id):
    return 'rota com retorno do registro ' + id

@routes.route('/pessoas', methods=['POST'])
def insertOne():
    return 'rota de inserção de um registro'

@routes.route('/pessoas/<id>', methods=['POST'])
def updateOne():
    return 'rota de atualização de um registro'

@routes.route('/pessoas/<id>', methods=['DELETE'])
def deleteOne(id):
    return 'rota de exclução do registro ' + id
