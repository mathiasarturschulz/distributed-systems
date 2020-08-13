FROM python:3.8.5
# diretório atual
ADD . /usr/src/app
# localização dos arquivos no container
WORKDIR /usr/src/app
RUN pip install -r requirements.txt
CMD python main.py
