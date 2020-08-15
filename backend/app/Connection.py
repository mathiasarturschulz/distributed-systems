from pymongo import MongoClient

class Connection:
    USERNAME = 'admin'
    PASSWORD = 'admin'
    DATABASE = 'empresa'

    connection = None

    def __init__(self):
        self.collection = self.startConnection()

    def startConnection(self):
        if not self.connection:
            self.connection = MongoClient('localhost', 27017, username=self.USERNAME, password=self.PASSWORD)
        return self.connection
    
    def getCollectionByName(self, name):
        connection = self.startConnection()
        return connection[self.DATABASE][name]
