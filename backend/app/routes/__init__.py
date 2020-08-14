import datetime
from flask import Blueprint
routes = Blueprint('routes', __name__)

# decorator, aplica a função route em cima da função hello
@routes.route('/')
def hello():
    return 'rota principal %s' % str(datetime.datetime.now())

from . pessoas import *
