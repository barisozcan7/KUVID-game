package service.save_service;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.event.ServerClosedEvent;
import com.mongodb.event.ServerDescriptionChangedEvent;
import com.mongodb.event.ServerListener;
import com.mongodb.event.ServerOpeningEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

import static configs.DBConstants.*;


public class ServerConnection implements ServerListener {

    private static boolean available = false;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    public static boolean isAvailable() {
        return available;
    }

    public MongoClient getMongoClient() {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        MongoClientOptions.Builder optionsBuilder = new MongoClientOptions.Builder();
        optionsBuilder.addServerListener(this);

        if (mongoClient != null) {
            return mongoClient;
        }
        try {
            mongoClient = new MongoClient(new ServerAddress(MONGO_CLIENT_HOST, MONGO_CLIENT_PORT), optionsBuilder.build());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isAvailable()) {
            mongoDatabase = getMongoDatabase();
        }
        return mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        if (mongoDatabase != null) {
            return mongoDatabase;
        }
        mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);
        return mongoDatabase;
    }

    @Override
    public void serverOpening(ServerOpeningEvent event) {
    }

    @Override
    public void serverClosed(ServerClosedEvent event) {
    }

    @Override
    public void serverDescriptionChanged(ServerDescriptionChangedEvent event) {
        if (event.getNewDescription().isOk()) {
            available = true;
        } else if (event.getNewDescription().getException() != null) {
            available = false;
        }
    }
}
