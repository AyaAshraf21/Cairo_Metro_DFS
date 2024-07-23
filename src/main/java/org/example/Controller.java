package org.example;

import java.util.*;

public class Controller
{
    private static ArrayList<String> transtionStations = new ArrayList<>(Arrays.asList("Sadat","Nasser","Attaba","Al-Shohadaa","Cairo University"));

    private static ArrayList<String> line1 = new ArrayList<>(Arrays.asList("New El-Marg", "El-Marg", "Ezbet El-Nakhl", "Ain Shams", "El-Matareyya", "Helmeyet El-Zaitoun", "Hadayeq El-Zaitoun", "Saray El-Qobba", "Hammamat El-Qobba", "Kobri El-Qobba", "Manshiet El Sadr", "EL-Demerdash", "Ghamra", "Al-Shohadaa", "Orabi", "Nasser", "Sadat", "Saad Zaghloul", "Al-Sayeda Zeinab", "El-Malek El-Saleh", "Mar Girgis", "El-Zahraa", "Dar El-Salam", "Hadayek El-Maadi", "Maadi", "Sakanat El-Maadi", "Tora El-Balad", "Kozzika", "Tora El-Asmant", "El-Maasara", "Hadayek Helwan", "Wadi Hof", "Helwan University", "Ain Helwan", "Helwan"));
    private static ArrayList<String> line2 = new ArrayList<>(Arrays.asList("Shubra El-Kheima", "Kolleyyet El-Zeraa", "Mezallat", "Khalafawy", "St. Teresa", "Rod El-Farag", "Masaraa", "Al-Shohadaa", "Attaba", "Mohamed Naguib", "Sadat", "Opera", "Dokki", "El Bohoth", "Cairo University", "Faisal", "Giza", "Omm El-Masryeen", "Sakiat Mekky", "El-Mounib"));
    private static ArrayList<String> line3 = new ArrayList<>(Arrays.asList("Adly Mansour", "El Haykestep", "Omar Ibn El-Khattab", "Qobaa", "Hesham Barakat", "El-Nozha", "Nadi El-Shams", "Alf Maskan", "Heliopolis", "Haroun", "Al-Ahram", "Koleyet El-Banat", "Stadium", "Fair Zone", "Abbassiya", "Abdou Pasha", "El-Geish", "Bab El Shaaria", "Attaba", "Nasser", "Maspero", "Safaa Hegazy", "Kit Kat","Sudan","Imbaba","El-Bohy","El-Kawmeya Al-Arabiya","Ring Road","Rod El-Farag Axis"));
    //private static ArrayList<String> line3part2 = new ArrayList<>(Arrays.asList("Adly Mansour","Kit Kat","Tawfikeya", "Wadi El-Nile", "Gamaet El-Dowal Al-Arabiya", "Bulaq Al-Dakrour", "Cairo University"));

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


    private static ArrayList<String> getValidLine(String station)
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
//        else if(line3part2.contains(station))
//        {
//            return line3part2;
//        }
        return new ArrayList<>();
    }


    private static ArrayList<String> getSharedLine(String transitionStation1, String transitionStation2)
    {
        if(line1.contains(transitionStation1) && line1.contains(transitionStation2))
        {
            return line1;
        }
        else if(line2.contains(transitionStation1) && line2.contains(transitionStation2))
        {
            return line2;
        }
        else if(line3.contains(transitionStation1) && line3.contains(transitionStation2))
        {
            return line3;
        }
        return  new ArrayList<>();
    }


    private static boolean isTransition(String transitionStation, ArrayList<String> path)
    {
        String stationBefore = path.get(path.indexOf(transitionStation)-1);
        String stationAfter = path.get(path.indexOf(transitionStation)+1);

        if(transtionStations.contains(stationBefore) && transtionStations.contains(stationAfter))
        {
            return !getSharedLine(stationBefore,transitionStation).contains(stationAfter);
        }
        else if(transtionStations.contains(stationBefore))
        {
            return !getValidLine(stationAfter).contains(stationBefore);
        }
        else if(transtionStations.contains(stationAfter) || (!transtionStations.contains(stationBefore) && !transtionStations.contains(stationAfter)))
        {
            return !getValidLine(stationBefore).contains(stationAfter);
        }
        return false;
    }


    public static String getDirection (ArrayList<String> path)
    {
        String direction = "";
        ArrayList<String> firstLine = getValidLine(path.get(0));

        if(firstLine.indexOf(path.get(0)) < firstLine.indexOf(path.get(1)))
        {
            direction += ("["+firstLine.get(firstLine.size()-1) + "] Direction  ");
        }
        else
        {
            direction += ("[" + firstLine.get(0) + "] Direction  ");
        }

        for(String s : transtionStations)
        {
            if(path.contains(s) && path.indexOf(s) != 0 && path.indexOf(s) != path.size()-1)
            {
                if(isTransition(s,path))
                {
                    ArrayList<String> lineShared = getSharedLine(s,path.get(path.indexOf(s)+1));
                    direction += (", Then transtion at ["+ s +"]  ");
                    if(lineShared.indexOf(path.get(path.indexOf(s)+1)) > lineShared.indexOf(s))
                    {
                        direction += ("["+lineShared.get(lineShared.size()-1) + "] Direction  ");
                    }
                    else
                    {
                        direction += ("["+lineShared.get(0) + "] Direction  ");
                    }
                }
            }
        }


        return direction;
    }
}