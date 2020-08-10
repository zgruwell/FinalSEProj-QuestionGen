package com.example.sasha.finalsoftware.model;

public class Question {
    private String questionText;
    private String rightQuestionAnswer;
    private String wrongQuestionAnswers[];
    private String usedQuestions[];

    public Question() {
        super();
    }

    public Question(int number) {
        this.setParameters(number);
    }

    private void setParameters(int number) {
        questionText = questions[number];
        rightQuestionAnswer = rightAnswers[number];
        wrongQuestionAnswers = wrongAnswers[number];
    }

    public String questions[]= {
            "What year was the name James the most popular?",
            "What year was the name Charlene the most popular?",
            "What year was the name Quincy the most popular?",
            "What year was the name Kiera the most popular?",
            "What year was the name Jamie the most popular?",
            "What year was the name Serenity the most popular?",
            "What year was the name Duncan the most popular?",
            "What year was the name Dennis the most popular?",
            "What year was the name Alana the most popular?",
            "What year was the name Agnes the most popular?",
            "What year was the name Isaac the most popular?",
            "What year was the name Patsy the most popular?",
            "What year was the name Amelia the most popular?",
            "What year was the name Green the most popular?",
            "What year was the name Elisa the most popular?",
            "Of these five names, which was the most popular in 1956?",
            "Of these five names, which was the most popular in 1887?",
            "Of these five names, which was the most popular in 1900?",
            "Of these five names, which was the most popular in 1927?",
            "Of these five names, which was the most popular in 1986?",
            "Of these five names, which was the most popular in 2006?",
            "Of these five names, which was the most popular in 1892?",
            "Of these five names, which was the most popular in 1907?",
            "Of these five names, which was the most popular in 1930?",
            "Of these five names, which was the most popular in 1969?",
            "Of these five names, which was the most popular in 2003?",
            "Of these five names, which was the most popular in 1929?",
            "Of these five names, which was the most popular in 1933?",
            "Of these five names, which was the most popular in 1965?",
            "Of these five names, which was the most popular in 2001?",
    };
    public String rightAnswers[]= {
            "1948",
            "1954",
            "2007",
            "2007",
            "1980",
            "2004",
            "1947",
            "1948",
            "2005",
            "1897",
            "2006",
            "1961",
            "2006",
            "1881",
            "1983",
            "Ann",
            "Edwin",
            "Fred",
            "Calvin",
            "Steven",
            "Max",
            "Elsie",
            "Grace",
            "Irene",
            "Brenda",
            "Paige",
            "Sara",
            "Jacqueline",
            "Jill",
            "Darion"
    };
    public String wrongAnswers[][]= {
            {"1886", "1908", "1975", "1891"},
            {"1917", "1926", "1940", "1985"},
            {"1998", "1895", "1976", "1952"},
            {"1994", "2008", "1988", "1992"},
            {"1993", "1988", "1996", "2003"},
            {"2002", "1999", "1998", "2008"},
            {"1983", "1969", "1965", "1954"},
            {"1934", "1905", "1921", "1888"},
            {"1944", "1999", "1956", "1988"},
            {"1972", "1957", "1887", "1918"},
            {"1883", "1902", "1919", "1976"},
            {"1895", "1917", "1926", "1954"},
            {"1970", "1983", "1990", "1898"},
            {"1888", "1896", "1904", "1911"},
            {"1913", "1946", "1969", "1994"},
            {"Helen", "Sherry", "Melissa", "Gladys"},
            {"Guy", "Leon", "Emil", "Otis"},
            {"Peter", "Bernard", "Ira", "Elijah"},
            {"Eddie", "Luther", "Orville", "Roberto"},
            {"Brent", "Ian", "Jessie", "Clint"},
            {"Damien", "Taylor", "Griffin", "Lance"},
            {"Lydia", "Ora", "Freda", "Velma"},
            {"Laura", "Ann", "Kate", "Elinor"},
            {"Audrey", "Charlotte", "Nadine", "Yolanda"},
            {"Tracey", "Jodi", "Ellen", "Bobbie"},
            {"Diana", "Valerie", "Marlene", "Trisha"},
            {"Imogene", "Adeline", "John", "Lily"},
            {"Pat", "Yvonne", "Robbie", "Maude"},
            {"Vicki", "Sondra", "Roxann", "Bettina"},
            {"Thaddeus", "Samir", "Nick", "Irving"}
    };

    public String getQuestionText()
    {
        return questionText;
    }

    public String getRightAnswer()
    {
        return rightQuestionAnswer;
    }

    public String getWrongAnswer1()
    {
        String wrongAnswer = wrongQuestionAnswers[0];
        return wrongAnswer;
    }

    public String getWrongAnswer2()
    {
        String wrongAnswer = wrongQuestionAnswers[1];
        return wrongAnswer;
    }

    public String getWrongAnswer3()
    {
        String wrongAnswer = wrongQuestionAnswers[2];
        return wrongAnswer;
    }

    public String getWrongAnswer4()
    {
        String wrongAnswer = wrongQuestionAnswers[3];
        return wrongAnswer;
    }
}