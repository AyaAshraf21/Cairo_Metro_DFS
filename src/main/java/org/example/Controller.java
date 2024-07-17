package org.example;

import java.lang.reflect.Array;
import java.util.*;

public class Controller
{
    private static ArrayList<String> transtionStations = new ArrayList<>(Arrays.asList("Sadat","Nasser","Attaba","Al-Shohadaa","Cairo University"));

    private static ArrayList<String> line1 = new ArrayList<>(Arrays.asList("New El-Marg", "El-Marg", "Ezbet El-Nakhl", "Ain Shams", "El-Matareyya", "Helmeyet El-Zaitoun", "Hadayeq El-Zaitoun", "Saray El-Qobba", "Hammamat El-Qobba", "Kobri El-Qobba", "Manshiet El Sadr", "EL-Demerdash", "Ghamra", "Al-Shohadaa", "Orabi", "Nasser", "Sadat", "Saad Zaghloul", "Al-Sayeda Zeinab", "El-Malek El-Saleh", "Mar Girgis", "El-Zahraa", "Dar El-Salam", "Hadayek El-Maadi", "Maadi", "Sakanat El-Maadi", "Tora El-Balad", "Kozzika", "Tora El-Asmant", "El-Maasara", "Hadayek Helwan", "Wadi Hof", "Helwan University", "Ain Helwan", "Helwan"));
    private static ArrayList<String> line2 = new ArrayList<>(Arrays.asList("Shubra El-Kheima", "Kolleyyet El-Zeraa", "Mezallat", "Khalafawy", "St. Teresa", "Rod El-Farag", "Masaraa", "Al-Shohadaa", "Attaba", "Mohamed Naguib", "Opera", "Dokki", "El Bohoth", "Cairo University", "Faisal", "Giza", "Omm El-Masryeen", "Sakiat Mekky", "El-Mounib"));
    private static ArrayList<String> line3 = new ArrayList<>(Arrays.asList("Adly Mansour", "El Haykestep", "Omar Ibn El-Khattab", "Qobaa", "Hesham Barakat", "El-Nozha", "Nadi El-Shams", "Alf Maskan", "Heliopolis", "Haroun", "Al-Ahram", "Koleyet El-Banat", "Stadium", "Fair Zone", "Abbassiya", "Abdou Pasha", "El-Geish", "Bab El Shaaria", "Maspero", "Safaa Hegazy", "Kit Kat", "Sudan", "Imbaba", "El-Bohy", "El-Kawmeya Al-Arabiya", "Ring Road", "Rod El-Farag Axis"));

    private static ArrayList<String> directions = new ArrayList<>();

    public static int totalPrice(int stationsNum)
    {
        if(stationsNum >= 1 && stationsNum <= 9)
        {
            return 6;
        }
        else if (stationsNum >= 10 && stationsNum <= 16)
        {
            return 8;
        }
        else if (stationsNum >= 17 && stationsNum <= 23)
        {
            return 12;
        }
        else if(stationsNum > 23)
        {
            return 15;
        }
        else
        {
            return 0;
        }
    }

    public static String getTime(int stationsNum)
    {
        String time ;
        int count = stationsNum * 2;
        if(count >= 60)
        {
            time = count / 60 + " hours, "+(count % 60) + " minutes";
        }
        else
        {
            time = count + " minutes";
        }

        return time;
    }


    public static ArrayList<String> getValidLine(String station)
    {
        if(line1.contains(station))
        {
            return line1;
        }
        else if(line2.contains(station))
        {
            return line2;
        }
        else if(line3.contains(station))
        {
            return line3;
        }
        return new ArrayList<>();
    }

}

