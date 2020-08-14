# importação do micro framework
from flask import Flask

app = Flask(__name__)

from routes import *
app.register_blueprint(routes)

# verificação se o usuário está executando o arquivo principal
# se for o principal realiza o run
if __name__ == '__main__':
    app.run(host='0.0.0.0', debug=True)
