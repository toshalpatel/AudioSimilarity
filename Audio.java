import LCS.*;
import TTS.*;
import STT.*;

import java.beans.PropertyVetoException;
import java.io.IOException;
import javax.speech.AudioException;
import javax.speech.EngineException;
import javax.speech.EngineStateError;


public class Audio {
    public static void main(String[] args) throws EngineException, 
            AudioException, IllegalArgumentException, InterruptedException, 
            EngineStateError, PropertyVetoException, IOException{
        
        SpeechToText speechtotext = new SpeechToText();
        String audio1 = speechtotext.SpeechToTextConverter("C:\\compassionate.wav");
        String audio2 = speechtotext.SpeechToTextConverter("C:\\community.wav");
        
        LCS lcs = new LCS();
	char[] subSeq = lcs.initializeLCS(audio1, audio2);
        System.out.println(subSeq);
        String speak = new String(subSeq);
        
        TextToSpeech result = new TextToSpeech();
        result.init("kevin16");
        result.doSpeak(speak);
        result.terminate();
    }
}
