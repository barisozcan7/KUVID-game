package service.save_service;

import UI.components.game_view.statistics_view.StatisticsPanel;
import UI.views.GameView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import domain.enums.SaveMode;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.options.SaveOptions;
import org.bson.Document;
import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class DatabaseSave implements AdvancedSaveLoad {

    public static MongoClient mongoClient;
    public static MongoDatabase mongoDatabase;

    public DatabaseSave() {
    }

    public static void setUpMongo() {
        ServerConnection serverConnection = new ServerConnection();
        mongoClient = serverConnection.getMongoClient();
        if (ServerConnection.isAvailable()) {
            mongoDatabase = serverConnection.getMongoDatabase();
        }
    }

    @Override
    public void saveToDatabase(String username) {
        String folderName = Utils.fileNameGenerator(username);
        try {
            mongoDatabase.createCollection(folderName);
            MongoCollection<Document> collection = mongoDatabase.getCollection(folderName);
            Document gameDoc = Document.parse(objectToJsonConverter(Game.getInstance()));
            Document shooterDoc = Document.parse(objectToJsonConverter(AtomShooter.getInstance()));
            collection.insertMany(Arrays.asList(gameDoc, shooterDoc));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromDatabase(SaveOptions saveOptions) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String collectionName = saveOptions.name + "_" + saveOptions.date;
            MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
            Document gameDoc = new Document();
            Document shooterDoc = new Document();
            FindIterable<Document> iterDoc = collection.find();
            Iterator it = iterDoc.iterator();
            if (it.hasNext()) {
                gameDoc = (Document) it.next();
                it.hasNext();
                shooterDoc = (Document) it.next();
            }
            gameDoc.remove("_id");
            shooterDoc.remove("_id");
            Game.getInstance().loadGame(mapper.readValue(gameDoc.toJson(), Game.class));
            AtomShooter.getInstance().loadAtomShooter(mapper.readValue(shooterDoc.toJson(), AtomShooter.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<SaveOptions> fetchDatabase() {
        ArrayList<SaveOptions> list = new ArrayList<>();
        MongoIterable<String> collectionNames = mongoDatabase.listCollectionNames();
        for (String name : collectionNames) {
            list.add(Utils.fileNameToSaveOptionsConverter(name, SaveMode.DATABASE));
        }
        return list;
    }

    @Override
    public void saveToFile(String username) {
    }

    @Override
    public void loadFromFile(SaveOptions saveOptions) {
    }

    @Override
    public ArrayList<SaveOptions> fetchFiles() {
        return null;
    }

    private String objectToJsonConverter(Object object) throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(object);
        return json;
    }
}
