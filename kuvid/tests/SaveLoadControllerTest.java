import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import domain.controller.game.AtomShooterController;
import domain.controller.save_load.SaveLoadController;
import domain.enums.SaveMode;
import domain.models.building_mode.BuildingMode;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.atom.Atom;
import domain.models.options.SaveOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.save_service.DatabaseSave;
import service.save_service.ServerConnection;
import utils.Utils;
import java.io.File;
import java.util.ArrayList;

import static configs.ObjectConstants.rotateSpeed;
import static configs.ObjectConstants.transformSpeed;
import static org.junit.jupiter.api.Assertions.*;

public class SaveLoadControllerTest {

    private Game game;
    private SaveLoadController saveLoadController;
    private MongoDatabase mongoDatabase;
    private MongoClient mongoClient;

    private AtomShooter shooter;
    private AtomShooterController atomShooterController;
    private Atom selectedAtom;

    @BeforeEach
    void setUp() {
        game = Game.getInstance();
        game.setGame(BuildingMode.getDefaultBuildingMode());
        saveLoadController = new SaveLoadController();
        DatabaseSave.setUpMongo();
        mongoClient = DatabaseSave.mongoClient;
        mongoDatabase = DatabaseSave.mongoDatabase;

        shooter = AtomShooter.getInstance();
        atomShooterController = AtomShooterController.getInstance();
        atomShooterController.pickAtom();
        selectedAtom = shooter.getCurrentSelectedAtom();
    }

    @Test
    void validate_file_after_saving () {
        saveLoadController.save(SaveMode.FILE, "test_save_file");
        File[] files = new File("save/").listFiles();
        ArrayList<SaveOptions> list = new ArrayList<>();

        for (File file : files) {
            list.add(Utils.fileNameToSaveOptionsConverter(file.getName(), SaveMode.FILE));
        }

        boolean flag = false;
        for (SaveOptions s : list) {
            if (s.name.equals("test_save_file")) {
                flag = true;
            }
        }
        assertTrue(flag);
    }

    @Test
    void validate_file_after_saving_to_db () {

        if(!ServerConnection.isAvailable()) {
            System.out.println("NOT CONNECTED TO DB!!");
            assertFalse(ServerConnection.isAvailable());
            return;
        }

        saveLoadController.save(SaveMode.DATABASE, "test_save_db");
        ArrayList<SaveOptions> list = new ArrayList<>();
        MongoIterable<String> collectionNames = mongoDatabase.listCollectionNames();
        for (String name : collectionNames) {
            list.add(Utils.fileNameToSaveOptionsConverter(name, SaveMode.DATABASE));
        }
        boolean flag = false;
        for (SaveOptions s : list) {
            if (s.name.equals("test_save_db")) {
                flag = true;
            }
        }
        assertTrue(flag);
    }

    @Test
    void validate_if_game_file_loaded_correctly () {
        int numberOfAtomsBeforeShooting = numberOfRemainingAtoms();
        int numberOfAtomsAfterLoading;

        for (int i = 0; i < 10; i++) {
            selectedAtom = shooter.getCurrentSelectedAtom();
            atomShooterController.shoot();
            atomShooterController.finishReloading();
        }
        saveLoadController.save(SaveMode.FILE, "test_game_file");
        File[] files = new File("save/").listFiles();
        ArrayList<SaveOptions> list = new ArrayList<>();

        for (File file : files) {
            list.add(Utils.fileNameToSaveOptionsConverter(file.getName(), SaveMode.FILE));
        }

        for (SaveOptions s : list) {
            if (s.name.equals("test_game_file")) {
                saveLoadController.load(SaveMode.FILE, s);
            }
        }

        numberOfAtomsAfterLoading = numberOfRemainingAtoms();
        assertEquals(numberOfAtomsAfterLoading, numberOfAtomsBeforeShooting - 10);
    }

    @Test
    void validate_if_game_file_loaded_correctly_db () {
        int numberOfAtomsBeforeShooting = numberOfRemainingAtoms();
        int numberOfAtomsAfterLoading;

        for (int i = 0; i < 10; i++) {
            selectedAtom = shooter.getCurrentSelectedAtom();
            atomShooterController.shoot();
            atomShooterController.finishReloading();
        }
        if(!ServerConnection.isAvailable()) {
            System.out.println("NOT CONNECTED TO DB!!");
            assertFalse(ServerConnection.isAvailable());
            return;
        }
        saveLoadController.save(SaveMode.DATABASE, "test_game_file_db");
        ArrayList<SaveOptions> list = new ArrayList<>();
        MongoIterable<String> collectionNames = mongoDatabase.listCollectionNames();
        for (String name : collectionNames) {
            list.add(Utils.fileNameToSaveOptionsConverter(name, SaveMode.DATABASE));
        }
        for (SaveOptions s : list) {
            if (s.name.equals("test_game_file_db")) {
                saveLoadController.load(SaveMode.DATABASE, s);
            }
        }
        numberOfAtomsAfterLoading = numberOfRemainingAtoms();
        assertEquals(numberOfAtomsAfterLoading, numberOfAtomsBeforeShooting - 10);
    }

    @Test
    void validate_if_shooter_file_loaded_correctly () {

        double shooterXCoordinateBefore = shooter.getxCoordinate();
        double shooterXCoordinateAfterLoading;
        double shooterDegreeBefore = shooter.getRotation();
        double shooterDegreeAfterLoading;

        for (int i = 0; i < 3; i++) {
            atomShooterController.moveLeft();
            atomShooterController.rotateClockwise();
        }

        saveLoadController.save(SaveMode.FILE, "test_shooter_file");
        File[] files = new File("save/").listFiles();
        ArrayList<SaveOptions> list = new ArrayList<>();

        for (File file : files) {
            list.add(Utils.fileNameToSaveOptionsConverter(file.getName(), SaveMode.FILE));
        }
        for (SaveOptions s : list) {
            if (s.name.equals("test_shooter_file")) {
                saveLoadController.load(SaveMode.FILE, s);
            }
        }

        shooterXCoordinateAfterLoading = shooter.getxCoordinate();
        shooterDegreeAfterLoading = shooter.getRotation();
        assertEquals(shooterXCoordinateAfterLoading, shooterXCoordinateBefore - 3 * transformSpeed);
        assertEquals(shooterDegreeAfterLoading, shooterDegreeBefore + 3 * rotateSpeed);

    }

    @Test
    void validate_if_shooter_file_loaded_correctly_db () {

        double shooterXCoordinateBefore = shooter.getxCoordinate();
        double shooterXCoordinateAfterLoading;
        double shooterDegreeBefore = shooter.getRotation();
        double shooterDegreeAfterLoading;

        for (int i = 0; i < 3; i++) {
            atomShooterController.moveLeft();
            atomShooterController.rotateClockwise();
        }

        if(!ServerConnection.isAvailable()) {
            System.out.println("NOT CONNECTED TO DB!!");
            assertFalse(ServerConnection.isAvailable());
            return;
        }
        saveLoadController.save(SaveMode.DATABASE, "test_shooter_file_db");
        ArrayList<SaveOptions> list = new ArrayList<>();
        MongoIterable<String> collectionNames = mongoDatabase.listCollectionNames();
        for (String name : collectionNames) {
            list.add(Utils.fileNameToSaveOptionsConverter(name, SaveMode.DATABASE));
        }
        for (SaveOptions s : list) {
            if (s.name.equals("test_shooter_file_db")) {
                saveLoadController.load(SaveMode.DATABASE, s);
            }
        }

        shooterXCoordinateAfterLoading = shooter.getxCoordinate();
        shooterDegreeAfterLoading = shooter.getRotation();
        assertEquals(shooterXCoordinateAfterLoading, shooterXCoordinateBefore - 3 * transformSpeed);
        assertEquals(shooterDegreeAfterLoading, shooterDegreeBefore + 3 * rotateSpeed);

    }

    @Test
    void validate_file_after_saving_multiple_files () {
        saveLoadController.save(SaveMode.FILE, "test");
        saveLoadController.save(SaveMode.FILE, "test_1");
        saveLoadController.save(SaveMode.FILE, "test_2");
        saveLoadController.save(SaveMode.FILE, "test_3");
        saveLoadController.save(SaveMode.FILE, "test_4");
        File[] files = new File("save/").listFiles();
        ArrayList<SaveOptions> list = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                list.add(Utils.fileNameToSaveOptionsConverter(file.getName(), SaveMode.FILE));
            }
        }
        boolean flag = false;
        for (SaveOptions s : list) {
            if (s.name.equals("test_1")) {
                flag = true;
            }
        }
        assertTrue(flag);
    }

    private int numberOfRemainingAtoms() {
        game = Game.getInstance();
        return game.getPlayer().getNumberOfAlphaAtoms() + game.getPlayer().getNumberOfBetaAtoms()
                + game.getPlayer().getNumberOfGammaAtoms() + game.getPlayer().getNumberOfSigmaAtoms();
    }
}