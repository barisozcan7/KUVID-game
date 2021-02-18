package service.audio_service;

import jaco.mp3.player.MP3Player;

import java.io.File;
import java.net.URL;

public final class AudioService {
    private final static URL gameMusicPath = AudioService.class.getResource("/audio//game_music.mp3");
    private final static URL shootAtomSoundPath = AudioService.class.getClassLoader().getResource("/audio//game_music.mp3");
    private final static URL shootPowerupSoundPath = AudioService.class.getClassLoader().getResource("/audio//shoot_powerup.mp3");
    private final static URL hitMoleculeSoundPath = AudioService.class.getClassLoader().getResource("/audio//hit_molecule.mp3");
    private final static URL blockerExplosionSoundPath = AudioService.class.getClassLoader().getResource("/audio//blocker_explosion.mp3");
    private final static MP3Player musicPlayer = new MP3Player(new File(gameMusicPath.getPath()));
//    private final static MP3Player shootAtomAudioPlayer = new MP3Player(new File(shootAtomSoundPath.getPath()));
//    private final static MP3Player shootPowerupAudioPlayer = new MP3Player(new File(shootPowerupSoundPath.getPath()));
//    private final static MP3Player hitMoleculeAudioPlayer = new MP3Player(new File(hitMoleculeSoundPath.getPath()));
//    private final static MP3Player blockerExplosionAudioPlayer = new MP3Player(new File(blockerExplosionSoundPath.getPath()));

    private AudioService() {

    }

    public static void playMusic() {
        //musicPlayer.play();
        //musicPlayer.setRepeat(true);
    }

    public static void pauseMusic() {
        //musicPlayer.pause();
    }

    public static void stopMusic() {
        //musicPlayer.stop();
    }

    public static void shootAtomSound() {
        //       shootAtomAudioPlayer.play();
    }

    public static void shootPowerupSound() {
        //       shootPowerupAudioPlayer.play();
    }

    public static void hitMoleculeSound() {
        //       hitMoleculeAudioPlayer.play();
    }

    public static void blockerExplosionSound() {
        //       blockerExplosionAudioPlayer.play();
    }
}
