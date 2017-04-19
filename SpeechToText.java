/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STT;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SpeechToText {
    
    public static Configuration configuration;
    
    public SpeechToText(){
        //speechtotext.initialize();
        
            configuration = new Configuration();
            configuration
                    .setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            configuration
                    .setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
            configuration
                    .setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        }
    
    public static String SpeechToTextConverter(String file) 
            throws FileNotFoundException, IOException{
        
        String resultantString = "null";
        
        StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
        InputStream stream = new FileInputStream(new File(file));

        recognizer.startRecognition(stream);
        SpeechResult result;
        while ((result = recognizer.getResult()) != null) {
            System.out.format("Hypothesis: %s\n", result.getHypothesis());
            resultantString = result.getHypothesis();
        }
        
        recognizer.stopRecognition();
        return resultantString;
    }
    
}
