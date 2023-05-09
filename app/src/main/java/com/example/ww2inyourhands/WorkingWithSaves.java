package com.example.ww2inyourhands;


import android.content.Context;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkingWithSaves {
    private static final String SAVE_ONE = "SaveOne.txt";
    private static final String SAVE_TWO = "saveTwo.txt";
    private static final String SAVE_THREE = "saveThree.txt";
    private static final String AUTO_SAVE = "autoSave.txt";

    Story story;


    public void  WorkingWithSaves(Story story){
        this.story = story;
    }


    public void setSaveOne( Context ctx) {
        String currentPosition = story.currentPosition;
        FileOutputStream fos = null;

        try {
            fos = ctx.openFileOutput(SAVE_ONE, Context.MODE_PRIVATE);
            fos.write(currentPosition.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void setSaveTwo(View v, Context ctx) {
        String currentPosition = story.currentPosition;
        FileOutputStream fos = null;

        try {
            fos = ctx.openFileOutput(SAVE_TWO, Context.MODE_PRIVATE);
            fos.write(currentPosition.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setAutoSave(View v, Context ctx) {
        String currentPosition = story.currentPosition;
        FileOutputStream fos = null;

        try {
            fos = ctx.openFileOutput(AUTO_SAVE, Context.MODE_PRIVATE);
            fos.write(currentPosition.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void setSaveThree(View v, Context ctx) {
        String currentPosition = story.currentPosition;
        FileOutputStream fos = null;

        try {
            fos = ctx.openFileOutput(SAVE_THREE, Context.MODE_PRIVATE);
            fos.write(currentPosition.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public StringBuilder getSaveTwo (View v, Context ctx) {
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();

        try {
            fis = ctx.openFileInput(SAVE_TWO);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String position;
            try {
                position = br.readLine();

                sb.append(position);
            } catch (IOException e) {
                e.printStackTrace();
            }finally{

                if ( fis != null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return sb;
    }public String getSaveOne (Context ctx) {
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();

        try {
            fis = ctx.openFileInput(SAVE_ONE);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String position;
            try {
                position = br.readLine();

                sb.append(position);
            } catch (IOException e) {
                e.printStackTrace();
            }finally{

                if ( fis != null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }public StringBuilder getSaveThree (View v, Context ctx) {
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();

        try {
            fis = ctx.openFileInput(SAVE_THREE);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String position;
            try {
                position = br.readLine();

                sb.append(position);
            } catch (IOException e) {
                e.printStackTrace();
            }finally{

                if ( fis != null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return sb;
    }public StringBuilder getAutoSave (View v, Context ctx) {
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();

        try {
            fis = ctx.openFileInput(AUTO_SAVE);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String position;
            try {
                position = br.readLine();

                sb.append(position);
            } catch (IOException e) {
                e.printStackTrace();
            }finally{

                if ( fis != null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return sb;
    }


}
