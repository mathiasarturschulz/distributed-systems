FROM python:3.8.5
# seta o diretório atual
ADD ./app /usr/src/app
# seta a localização dos arquivos no container
WORKDIR /usr/src/app
RUN pip install -r requirements.txt
CMD python main.py
