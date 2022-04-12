package com.company.utils;

import com.company.panels.VisualizerPanel;

import javax.sound.midi.*;
import java.util.Arrays;

public class Sound {

    private Synthesizer synth;
    private final MidiChannel channel;
    private final VisualizerPanel vis;

    // INSTRUMENTS: 16, 32
    private static final int INSTRUMENT = 32;
    private static final int VELOCITY = 50;
    private static final int NOTE_RANGE_START = 40;
    private static final int NOTE_RANGE_END = 105;

    public Sound(VisualizerPanel vis) {
        this.vis = vis;
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        channel = synth.getChannels()[0];
        channel.programChange(synth.getAvailableInstruments()[INSTRUMENT].getPatch().getProgram());
        channel.controlChange(7, 127);
    }

    private int translateVolume(int volume) {
        int volumeRange = 10;
        int controllerMax = 127;
        return (volume * controllerMax) / volumeRange;
    }

    public void setVolume(int volume) {
        channel.controlChange(7, translateVolume(volume));
    }

    private int translateVal(int arrVal) {
        int arrRange = vis.getArr().length;
        int noteRange = NOTE_RANGE_END - NOTE_RANGE_START;
        return ((arrVal * noteRange) / arrRange) + NOTE_RANGE_START;
    }

    public void startNote(int arrVal) {
        channel.noteOn(translateVal(arrVal), VELOCITY);
    }

    public void stopNote(int arrVal) {
        channel.noteOff(translateVal(arrVal), VELOCITY);
    }

    public void stopAllNotes() {
        channel.allNotesOff();
    }

    private void printDefaultSoundbank() {
        System.out.printf("Default Soundbank%nName: %s%nVendor: %s%nDescription: %s%n",
                synth.getDefaultSoundbank().getName(),
                synth.getDefaultSoundbank().getVendor(),
                synth.getDefaultSoundbank().getDescription());
        for (int i = 0; i < Arrays.stream(synth.getDefaultSoundbank().getInstruments()).count(); i++) {
            System.out.printf("Index: %s %s%n", i, synth.getDefaultSoundbank().getInstruments()[i]);
        }
    }

    private void printAvailableInstruments() {
        for (int i = 0; i < Arrays.stream(synth.getAvailableInstruments()).count(); i++) {
            System.out.printf("Index: %s %s%n", i, synth.getAvailableInstruments()[i]);
        }
    }

}
