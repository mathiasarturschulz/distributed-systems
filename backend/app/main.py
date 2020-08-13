# importação do micro framework
from flask import Flask

app = Flask(__name__)

# decorator - aplica a função route em cima da função hello
@app.route('/')
def hello():
    return 'Exemplo de rota'

@app.route('/pessoas')
def pessoas():
    return 'Exemplo de rota para visualização'

# verificação se o usuário está executando o arquivo principal
# se for o principal realiza o run
if __name__ == "__main__":
    app.run(host='0.0.0.0', debug=True)
