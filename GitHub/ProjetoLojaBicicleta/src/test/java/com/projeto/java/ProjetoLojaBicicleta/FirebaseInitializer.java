package com.projeto.java.ProjetoLojaBicicleta;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;


public class FirebaseInitializer {

    public static void main(String[] args) throws IOException {
    	FileInputStream serviceAccount =
    			new FileInputStream("path/to/serviceAccountKey.json");

    			@SuppressWarnings("deprecation")
				FirebaseOptions options = new FirebaseOptions.Builder()
    			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    			  .setDatabaseUrl("https://gerenciamento-de-estoque-fcb40-default-rtdb.firebaseio.com")
    			  .build();

    			FirebaseApp.initializeApp(options);

    }
}
