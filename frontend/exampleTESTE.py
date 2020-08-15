import requests
import datetime

url = 'http://0.0.0.0:5000/pessoas'

usuario = {
    'nome': 'Mathias Artur Schulz',
    'cargo': 'Chefão kkk',
    'email': 'MathiasSchulz34@gmail.com',
    'telefones': ['99 99999-9999', '88 88888-8888'],
    'dataCriacaoRegistro': datetime.datetime.now(),
}

x = requests.get(url)

print(x.text)

