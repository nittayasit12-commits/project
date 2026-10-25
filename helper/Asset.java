package helper;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Asset {
    public static Image getImage(String path) {
        String pathString = System.getProperty("user.dir") + File.separator+File.separator+ "assets" + File.separator + path;
       System.out.println(pathString);
        return Toolkit.getDefaultToolkit().createImage(pathString);
        
    }
    // sound background
    public static void SoundBackground() {
        String pathSoundBackground = System.getProperty("user.dir") + File.separator+File.separator+ "assets" + File.separator +"sound"+File.separator +"background.wav";
        System.out.println(pathSoundBackground);
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(pathSoundBackground)));
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-10.0f); // Reduce volume by 20 decib
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e) {
                e.printStackTrace();
                
            }
        }).start();
    }
    public static void SoundShoot() {
        String pathSoundShoot = System.getProperty("user.dir") + File.separator+File.separator+ "assets" + File.separator +"sound"+File.separator +"shoot.wav";
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(pathSoundShoot)));
            
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(0.0f); // Reduce volume by 10 decib
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
               
            }
            
        }).start();
        
        
    }   
    public static void SoundLose() {
        String pathSoundLose = System.getProperty("user.dir") + File.separator+File.separator+ "assets" + File.separator +"sound"+File.separator +"lose.wav";
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(pathSoundLose)));
            
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(0.0f); // Reduce volume by 10 decib
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
               
            }
            
        }).start();
        
    }     
      public static void SoundWin() {
        String pathSoundWin = System.getProperty("user.dir") + File.separator+File.separator+ "assets" + File.separator +"sound"+File.separator +"win.wav";
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(pathSoundWin)));
            
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(0.0f); // Reduce volume by 10 decib
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
               
            }
            
        }).start();
        
    }   
      public static void SoundDead() {
        String pathSoundDead = System.getProperty("user.dir") + File.separator+File.separator+ "assets" + File.separator +"sound"+File.separator +"dead.wav";
                new Thread(() -> {
                    try {
                        Clip clip = AudioSystem.getClip();
                        clip.open(AudioSystem.getAudioInputStream(new File(pathSoundDead)));
                    
                        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                        gainControl.setValue(0.0f); // Reduce volume by 10 decib
                        clip.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    
                    }
                    
                }).start();
        
    }   
    public static Image getShip(int id) {
        return getImage("Ship" + id + ".png");
    }
    public static Image getAmmo(int id) {
        Asset.SoundShoot();
        return getImage("Ship" + id + "_ammo.png");
    }
}