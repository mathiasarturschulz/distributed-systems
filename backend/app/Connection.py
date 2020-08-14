from pymongo import MongoClient

class Connection:
    USERNAME = 'admin'
    PASSWORD = 'admin'
    DATABASE = 'empresa'

    connection = None

    def startConnection(self):
        if not connection:
            connection = MongoClient('localhost', 27017, username=self.USERNAME, password=self.PASSWORD)
        return connection
    
    def getCollectionByName(self, name):
        connection = self.startConnection()
        return connection[self.DATABASE][name]
