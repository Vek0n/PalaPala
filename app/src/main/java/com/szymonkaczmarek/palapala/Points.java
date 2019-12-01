package com.szymonkaczmarek.palapala;

public abstract class Points {

    private String word;

    public void setWord (String wordVoid){
        word = wordVoid;
    }

    public String getWord(){
        return word;
    }

    abstract protected int valueOfLetters(char letter);

    public String countPoints(){
        int sumOfPoints = 0;
        char[] wordChar = getWord().toCharArray();
        for(int i=0; i<getWord().length(); i++)
            sumOfPoints+=valueOfLetters(wordChar[i]);
        return String.valueOf(sumOfPoints);
    }
}


class PointsEnglish extends Points{

    protected int valueOfLetters(char letter){
        if (letter == 'e' || letter == 'a' || letter == 'i' || letter == 'o' || letter == 'n' || letter == 'r' || letter == 't' || letter == 'l' || letter == 's' || letter == 'u')
            return 1;
        if (letter == 'd' || letter == 'g')
            return 2;
        if (letter == 'b' || letter == 'c' || letter == 'm' || letter == 'p')
            return 3;
        if (letter == 'f' || letter == 'h' || letter == 'v' || letter == 'w' || letter == 'y')
            return 4;
        if (letter == 'k')
            return 5;
        if (letter == 'j' || letter == 'x')
            return 8;
        if (letter == 'z')
            return 10;
        else
            return 0;
    }
}


class PointsPolish extends Points{

    protected int valueOfLetters(char letter){
        if ((letter == 'e') || (letter == 'a') || (letter == 'i') || (letter == 'o') || (letter == 'z') || (letter == 'r') || (letter == 'w') || (letter == 'n') || (letter == 's'))
            return 1;
        if ((letter == 'd') || (letter == 'y') || (letter == 'c') || (letter == 'k') || (letter == 'l') || (letter == 'm') || (letter == 'p') || (letter == 't'))
            return 2;
        if ((letter == 'b') || (letter == 'g') || (letter == 'h') || (letter == 'j') || (letter == 'ł') || (letter == 'u'))
            return 3;
        if ((letter == 'ą') || (letter == 'ę') || (letter == 'f') || (letter == 'ó') || (letter == 'ś') || (letter == 'ż'))
            return 5;
        if ((letter == 'ć'))
            return 6;
        if ((letter == 'ń'))
            return 7;
        if ((letter == 'ź'))
            return 9;
        else
            return 0;
    }
}


class PointsFrench extends Points{

    protected int valueOfLetters(char letter){
        if (letter == 'e' || letter == 'a' || letter == 'i' || letter == 'o' || letter == 'n' || letter == 'r' || letter == 't' || letter == 'l' || letter == 's' || letter == 'u')
            return 1;
        if (letter == 'd' || letter == 'g' || letter == 'm')
            return 2;
        if (letter == 'b' || letter == 'c' || letter == 'p')
            return 3;
        if (letter == 'f' || letter == 'h' || letter == 'v' )
            return 4;

        if (letter == 'j' || letter == 'q')
            return 8;
        if (letter == 'z' || letter == 'w' || letter == 'y' || letter == 'x' || letter == 'k')
            return 10;
        else
            return 0;
    }
}