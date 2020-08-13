# # importação do micro framework
# from flask import Flask

# app = Flask(__name__)
# print('aqui')
# # decorator - aplicando a função route em cima da função index
# @app.route('/')
# def index():
#     return 'Hello World!'

# # verificação se o usuário está executando o arquivo principal
# # se for o principal realiza o run
# if __name__ == '__main__':
#     # app.run()
#     print('entrou')
#     app.run(host="0.0.0.0", debug=True)

import time

import redis
from flask import Flask


app = Flask(__name__)
cache = redis.Redis(host='redis', port=6379)


def get_hit_count():
    retries = 5
    while True:
        try:
            return cache.incr('hits')
        except redis.exceptions.ConnectionError as exc:
            if retries == 0:
                raise exc
            retries -= 1
            time.sleep(0.5)


@app.route('/')
def hello():
    count = get_hit_count()
    # return 'Hello World! I have been seen {} times.\n'.format(count)
    return 'teste'

if __name__ == "__main__":
    app.run(host="0.0.0.0", debug=True)