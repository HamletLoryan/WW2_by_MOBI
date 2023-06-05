package com.example.ww2inyourhands;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class Utilities {

    @NonNull
    static DocumentReference getDocumentReference() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        return FirebaseFirestore.getInstance().collection("Saves").document(Objects.requireNonNull(user.getEmail())).collection("user_saves").document("Save");
    }

    @NonNull
    static DocumentReference getDocumentReferenceForEndings() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        return FirebaseFirestore.getInstance().collection("Endings").document(Objects.requireNonNull(user.getEmail())).collection("user_endings").document("Endings");
    }


}
