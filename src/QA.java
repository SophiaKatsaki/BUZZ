import java.util.ArrayList;
import java.util.Random;

/**
 * This abstract class contains all the data that are important for the questions and answers.
 * It has three ArrayLists for questions, possible answers and categories and a variable for the number of a category.
 *
 * It has a constructor, useful for the creation of the collections.
 * It creates the three ArrayLists.
 *
 * It has four methods.
 * Two for handling the categories of the questions/ answers.
 * One for handling the data of the questions.
 * One for handling the data of the answers.
 */

public abstract class QA {
    protected ArrayList<String> questions;
    protected ArrayList<String> possibleAnswers;
    protected ArrayList<String> categories;
    protected int numberOfCategory;

    /**
     * The constructor creates the ArrayList of the categories with the possible categories that the game will have.
     *
     * It also creates two ArrayLists.
     * One for the questions and one for the possible answers without any elements inside neither of them.
     */
    public QA () {
        this.categories = new ArrayList<>();
        this.categories.add("Music");
        this.categories.add("Books");
        this.categories.add("TV Series/ Movies");
        this.categories.add("Travelling");

        this.questions = new ArrayList<>();
        this.possibleAnswers = new ArrayList<>();
    }

    /**
     * @return statement gives back the information of the number of the category that was chosen randomly.
     */
    public int getNumberOfCategory() {
        return this.numberOfCategory;
    }

    /**
     * This method sets randomly a number that will point to a category.
     */
    public void setNumberOFCategory () {
        Random rand = new Random();
        this.numberOfCategory = rand.nextInt(this.categories.size());
    }

    /**
     * This method will fill the ArrayList of the questions with some elements depending on the parameter.
     *
     * @param numberOfCategory is the number of the category that was chosen randomly.
     */
    public void makeQ (int numberOfCategory) {
        this.numberOfCategory = numberOfCategory;

        switch (this.numberOfCategory) {
            case 0: {
                this.questions.add("What is the mainstream genre of music?");
                this.questions.add("What was one of the most popular subgenres of the 00s?");
                this.questions.add("Who had earned the most #1 singles by the end of the 10s for that decade?");
                this.questions.add("Who was the best artist of this decade?");
                this.questions.add("Who is not folk singer?");
                this.questions.add("Who considered as punk rocker at th early 00s?");
                this.questions.add("What band is pop?");
                this.questions.add("What was the first video/ song on youtube to reach 100 million views?");
                this.questions.add("What song does not have over 1 billion views on youtube?");
                this.questions.add("When was disco emerged as a genre of dance music?");
                this.questions.add("What is the biggest music platform?");
                this.questions.add("Who is the winner of the ESC of 2019?");
                this.questions.add("Which country has won the ESC seven times?");
                this.questions.add("Who is the singer of Norway's entry in ESC,'FairyTale'");
                this.questions.add("Which of the following did Lewis Capaldi sing?");
                this.questions.add("Which band sings \"Here Without You\"?");
                this.questions.add("Which band is \"losing their religion\"?");
                this.questions.add("Whose album is \"Moral Panic\"?");
                this.questions.add("In which Imagine Dragons album does \"Warriors\" belong?");
                this.questions.add("When did Papa Roach release \"Last Resort\"?");
            }
            case 1: {
                this.questions.add("Which was the first book of John Verdon?");
                this.questions.add("Which book is not written by Sophocles?");
                this.questions.add("Which book is not classical literature?");
                this.questions.add("Which book is not of police content?");
                this.questions.add("What is the genre of the book \"Madame Bovary\"?");
                this.questions.add("Which book is written by Oscar Wilde?");
                this.questions.add("Which book made famous the writer \"J.K Rowling\"?");
                this.questions.add("Who was considered as the best writer in the English-speaking world?");
                this.questions.add("What is the content of Agatha Christie's books?");
                this.questions.add("Which is the most widely read book?");
                this.questions.add("Who wrote \"Parrot's Theorem\"?");
                this.questions.add("Who wrote \"Gone With The Wind\"?");
                this.questions.add("What was the second novel that Charles Dickens wrote?");
                this.questions.add("George Orwell: Animal...?");
                this.questions.add("Where was Fyodor Dostoevsky from?");
                this.questions.add("When was William Shakespeare born?");
                this.questions.add("In which language is \"Erotokritos\" composed?");
                this.questions.add("When was \"Life Of Pi\" published?");
                this.questions.add("How many copies did \"The Book Thief\" sell?");
                this.questions.add("In what fictional towns do the characters of \"The Great Gatsby\" book live?");
            }
            case 2: {
                this.questions.add("How many season had the TV series \"LOST\"?");
                this.questions.add("Who was not main character in the TV series \"Supernatural\"?");
                this.questions.add("Who was not appeared in every season of \"Game of Thrones\"?");
                this.questions.add("In which season did Sara Tancredi left the TV series \"Prison Break\"?");
                this.questions.add("What's the nickname of Silene Oliveira in the TV series \"La Casa De papel\"?");
                this.questions.add("Who will continue to be main character in season 4 in the TV series \"Élite\"?");
                this.questions.add("When was the \"Titanic\" filmed?");
                this.questions.add("What is the name of the child in the movie\"Home Alone\"");
                this.questions.add("What is the first film of \"Harry Potter\"?");
                this.questions.add("Who stayed alive in \"Avengers: Endgame\"?");
                this.questions.add("Who is the protagonist \"Annalise Keating\" in \"How To Get Away With Murder\"?");
                this.questions.add("How is \"Walter's White\" wife called in \"Breaking Bad\"?");
                this.questions.add("Who created \"The Good Place\"?");
                this.questions.add("What is the name of Holt's dog in \"Brooklyn Nine-Nine\"?");
                this.questions.add("What is the score of the series \"The Umbrella Academy\" in IMDb?");
                this.questions.add("What is the name of Lucifer's nightclub in \"Lucifer\"?");
                this.questions.add("How many \"Now You See Me\" movies exist?");
                this.questions.add("Who is the protagonist of \"Shutter Island\"?");
                this.questions.add("In which of the following factions did \"Beatrice\" grow up in \"Divergent\"?");
                this.questions.add("Who plays Batman in \"The Dark Night\" (2008)?");
            }
            case 3: {
                this.questions.add("Which country does not belong to europe?");
                this.questions.add("Where the eiffel tower is located?");
                this.questions.add("Which country does not belong to the continent \"Oceania\"?");
                this.questions.add("Which country is known for its food");
                this.questions.add("If you want to go to the Himalayas, which country will you choose to go to?");
                this.questions.add("Where acropolis is located?");
                this.questions.add("Where Glacier National Park is located?");
                this.questions.add("Paris is the city of");
                this.questions.add("Which part of portugal is mountainous?");
                this.questions.add("Spanish is spoken in");
                this.questions.add("What is the richest country of the world?");
                this.questions.add("Which of the following is not a State of USA?");
                this.questions.add("Where is \"La Bodeguita del Medio\"?");
                this.questions.add("Which country is famous for its chocolates?");
                this.questions.add("How many inhabited islands are there in Greece?");
                this.questions.add("Where is the famous \"Burj Khalifa\"?");
                this.questions.add("Which country is not part of the The Balkans?");
                this.questions.add("What is the country of origin of \"Tacos\"?");
                this.questions.add("Where the biggest carnival in the world is held?");
                this.questions.add("What are the colors of the German flag?");
            }
        }
    }

    /**
     * This method will fill the ArrayList of the possible answers with some elements depending on the parameter.
     *
     * @param numberOfCategory is the number of the category that was chosen randomly.
     */
    public void makeA (int numberOfCategory) {
        this.numberOfCategory = numberOfCategory;

        switch (this.numberOfCategory) {
            case 0: {
                this.possibleAnswers.add("pop");
                this.possibleAnswers.add("rock");
                this.possibleAnswers.add("r&b");
                this.possibleAnswers.add("soul");
                this.possibleAnswers.add("contemporary r&b");
                this.possibleAnswers.add("new wave");
                this.possibleAnswers.add("thrash metal");
                this.possibleAnswers.add("country rock");
                this.possibleAnswers.add("Rihanna");
                this.possibleAnswers.add("Taylor Swift");
                this.possibleAnswers.add("Justin Bieber");
                this.possibleAnswers.add("Adele");
                this.possibleAnswers.add("Taylor Swift");
                this.possibleAnswers.add("Eminem");
                this.possibleAnswers.add("Beyonce");
                this.possibleAnswers.add("Bruno Mars");
                this.possibleAnswers.add("Lana Del Rey");
                this.possibleAnswers.add("Ed Sheeran");
                this.possibleAnswers.add("Bon Iver");
                this.possibleAnswers.add("George Ezra");
                this.possibleAnswers.add("Avril Lavigne");
                this.possibleAnswers.add("Kelly Clarkson");
                this.possibleAnswers.add("Amy Lee");
                this.possibleAnswers.add("P!nk");
                this.possibleAnswers.add("Maroon 5");
                this.possibleAnswers.add("The Pretty Reckless");
                this.possibleAnswers.add("Evanescence");
                this.possibleAnswers.add("Nickelback");
                this.possibleAnswers.add("Girlfriend");
                this.possibleAnswers.add("Umbrella");
                this.possibleAnswers.add("I gotta felling");
                this.possibleAnswers.add("Hot n Cold");
                this.possibleAnswers.add("Summertime sadness");
                this.possibleAnswers.add("Not afraid");
                this.possibleAnswers.add("Just the way you are");
                this.possibleAnswers.add("Dusk till dawn");
                this.possibleAnswers.add("1970s");
                this.possibleAnswers.add("1960s");
                this.possibleAnswers.add("1980s");
                this.possibleAnswers.add("1950s");
                this.possibleAnswers.add("Spotify");
                this.possibleAnswers.add("Apple Music");
                this.possibleAnswers.add("Soundcloud");
                this.possibleAnswers.add("Youtube");
                this.possibleAnswers.add("Duncan Laurence");
                this.possibleAnswers.add("Netta");
                this.possibleAnswers.add("Mans Zelmerlow");
                this.possibleAnswers.add("Emmelie de Forest");
                this.possibleAnswers.add("Ireland");
                this.possibleAnswers.add("Sweden");
                this.possibleAnswers.add("UK");
                this.possibleAnswers.add("Israel");
                this.possibleAnswers.add("Alexander Rybak");
                this.possibleAnswers.add("Salvador Sobral");
                this.possibleAnswers.add("James Newman");
                this.possibleAnswers.add("Arilena Ara");
                this.possibleAnswers.add("Someone you loved");
                this.possibleAnswers.add("Someone like you");
                this.possibleAnswers.add("Someone new");
                this.possibleAnswers.add("Someone to you");
                this.possibleAnswers.add("3 Doors Down");
                this.possibleAnswers.add("Metallica");
                this.possibleAnswers.add("Nirvana");
                this.possibleAnswers.add("Aerosmith");
                this.possibleAnswers.add("R.E.M.");
                this.possibleAnswers.add("Pink Floyd");
                this.possibleAnswers.add("Paramore");
                this.possibleAnswers.add("Green Day");
                this.possibleAnswers.add("Nothing But Thieves");
                this.possibleAnswers.add("Bring Me The Horizon");
                this.possibleAnswers.add("The Killers");
                this.possibleAnswers.add("You Me At Six");
                this.possibleAnswers.add("Smoke+Mirrors");
                this.possibleAnswers.add("Evolve");
                this.possibleAnswers.add("Night Vision");
                this.possibleAnswers.add("Origins");
                this.possibleAnswers.add("2000");
                this.possibleAnswers.add("1998");
                this.possibleAnswers.add("2001");
                this.possibleAnswers.add("1996");
            }
            case 1: {
                this.possibleAnswers.add("Think of A Number");
                this.possibleAnswers.add("Shut Your Eyes Tight");
                this.possibleAnswers.add("Peter Pan Must Die");
                this.possibleAnswers.add("Wolf Lake");
                this.possibleAnswers.add("Nicomachus Ethics");
                this.possibleAnswers.add("Antigone");
                this.possibleAnswers.add("Ajax");
                this.possibleAnswers.add("Electra");
                this.possibleAnswers.add("Sapiens");
                this.possibleAnswers.add("Animal Farm");
                this.possibleAnswers.add("The Alchemist");
                this.possibleAnswers.add("Great Expectations");
                this.possibleAnswers.add("Pride and Prejudice");
                this.possibleAnswers.add("The Snowman");
                this.possibleAnswers.add("Think of A Number");
                this.possibleAnswers.add("The son");
                this.possibleAnswers.add("Realist novel");
                this.possibleAnswers.add("Romance novel");
                this.possibleAnswers.add("Novel of manners");
                this.possibleAnswers.add("Drama");
                this.possibleAnswers.add("The Picture of Dorian Gray");
                this.possibleAnswers.add("Madame Bovary");
                this.possibleAnswers.add("Pride and Prejudice");
                this.possibleAnswers.add("A portrait of the Artist as a Young Man");
                this.possibleAnswers.add("Harry Potter");
                this.possibleAnswers.add("Troubled Blood");
                this.possibleAnswers.add("Career Of Evil");
                this.possibleAnswers.add("Fantastic Beasts");
                this.possibleAnswers.add("William Shakespeare");
                this.possibleAnswers.add("George Orwell");
                this.possibleAnswers.add("Virginia Woolf");
                this.possibleAnswers.add("Charles Dickens");
                this.possibleAnswers.add("Murder Mystery");
                this.possibleAnswers.add("Drama");
                this.possibleAnswers.add("Religious Novel");
                this.possibleAnswers.add("Political");
                this.possibleAnswers.add("Holy Bible");
                this.possibleAnswers.add("Da Vinci Code");
                this.possibleAnswers.add("Gone With the Wind");
                this.possibleAnswers.add("The Lord of the Rings");
                this.possibleAnswers.add("Denis Guedj");
                this.possibleAnswers.add("Frederic Dard");
                this.possibleAnswers.add("Pierre Daninos");
                this.possibleAnswers.add("Michael Houellebecq");
                this.possibleAnswers.add("Margaret Mitchell");
                this.possibleAnswers.add("Margaret Atwood");
                this.possibleAnswers.add("Margaret Durrell");
                this.possibleAnswers.add("Margaret Thatcher");
                this.possibleAnswers.add("Oliver Twist");
                this.possibleAnswers.add("A Christmas Carol");
                this.possibleAnswers.add("A Tale Of Two Cities");
                this.possibleAnswers.add("Great Expectations");
                this.possibleAnswers.add("Farm");
                this.possibleAnswers.add("Land");
                this.possibleAnswers.add("Planet");
                this.possibleAnswers.add("Life");
                this.possibleAnswers.add("Russia");
                this.possibleAnswers.add("Belarus");
                this.possibleAnswers.add("Ukraine");
                this.possibleAnswers.add("France");
                this.possibleAnswers.add("1564");
                this.possibleAnswers.add("1562");
                this.possibleAnswers.add("1560");
                this.possibleAnswers.add("1566");
                this.possibleAnswers.add("Greek");
                this.possibleAnswers.add("Italian");
                this.possibleAnswers.add("Russian");
                this.possibleAnswers.add("English");
                this.possibleAnswers.add("2001");
                this.possibleAnswers.add("2000");
                this.possibleAnswers.add("2002");
                this.possibleAnswers.add("2003");
                this.possibleAnswers.add("16 Million");
                this.possibleAnswers.add("13 Million");
                this.possibleAnswers.add("22 Million");
                this.possibleAnswers.add("26 Million");
                this.possibleAnswers.add("West Egg and East Egg");
                this.possibleAnswers.add("West Frie and East Frie");
                this.possibleAnswers.add("West Banana and East Banana");
                this.possibleAnswers.add("West Flour and East Flour");
            }
            case 2: {
                this.possibleAnswers.add("6");
                this.possibleAnswers.add("5");
                this.possibleAnswers.add("4");
                this.possibleAnswers.add("7");
                this.possibleAnswers.add("Rowena MacLeod");
                this.possibleAnswers.add("Sam Winchester");
                this.possibleAnswers.add("Dean Winchester");
                this.possibleAnswers.add("Ruby");
                this.possibleAnswers.add("Bran Stark");
                this.possibleAnswers.add("Cersei Lannister");
                this.possibleAnswers.add("Theon Greyjoy");
                this.possibleAnswers.add("Varys");
                this.possibleAnswers.add("3");
                this.possibleAnswers.add("4");
                this.possibleAnswers.add("2");
                this.possibleAnswers.add("5");
                this.possibleAnswers.add("Tokyo");
                this.possibleAnswers.add("Lisbon");
                this.possibleAnswers.add("Nairobi");
                this.possibleAnswers.add("Stockholm");
                this.possibleAnswers.add("Omar");
                this.possibleAnswers.add("Carla");
                this.possibleAnswers.add("Lucrecia");
                this.possibleAnswers.add("Polo");
                this.possibleAnswers.add("1997");
                this.possibleAnswers.add("1995");
                this.possibleAnswers.add("1999");
                this.possibleAnswers.add("2000");
                this.possibleAnswers.add("Kevin");
                this.possibleAnswers.add("Jack");
                this.possibleAnswers.add("Nick");
                this.possibleAnswers.add("James");
                this.possibleAnswers.add("Harry Potter and the Philosopher's Stone");
                this.possibleAnswers.add("Harry Potter and the Chamber of Secrets");
                this.possibleAnswers.add("Harry Potter and the Order of the Phoenix");
                this.possibleAnswers.add("Harry Potter and the Half-Blood Prince");
                this.possibleAnswers.add("Clint Barton");
                this.possibleAnswers.add("Tony Stark");
                this.possibleAnswers.add("Natasha Romanoff");
                this.possibleAnswers.add("Thanos");
                this.possibleAnswers.add("Viola Davis");
                this.possibleAnswers.add("Aja Naomi King");
                this.possibleAnswers.add("Karla Souza");
                this.possibleAnswers.add("Amy Okada");
                this.possibleAnswers.add("Skyler White");
                this.possibleAnswers.add("Karen White");
                this.possibleAnswers.add("Emma White");
                this.possibleAnswers.add("Charlotte White");
                this.possibleAnswers.add("Mike Schur");
                this.possibleAnswers.add("Lorne Michaels");
                this.possibleAnswers.add("Dan Goor");
                this.possibleAnswers.add("Greg Daniels");
                this.possibleAnswers.add("Cheddar");
                this.possibleAnswers.add("Carly");
                this.possibleAnswers.add("Charlie");
                this.possibleAnswers.add("Cooper");
                this.possibleAnswers.add("8/10");
                this.possibleAnswers.add("7.6/10");
                this.possibleAnswers.add("8.2/10");
                this.possibleAnswers.add("6/10");
                this.possibleAnswers.add("Lux");
                this.possibleAnswers.add("Luci's Place");
                this.possibleAnswers.add("Eden");
                this.possibleAnswers.add("Heaven");
                this.possibleAnswers.add("2");
                this.possibleAnswers.add("3");
                this.possibleAnswers.add("1");
                this.possibleAnswers.add("5");
                this.possibleAnswers.add("Leonardo DiCaprio");
                this.possibleAnswers.add("Brad Pitt");
                this.possibleAnswers.add("Tom Hanks");
                this.possibleAnswers.add("Tom Cruise");
                this.possibleAnswers.add("Abnegation");
                this.possibleAnswers.add("Amity");
                this.possibleAnswers.add("Dauntless");
                this.possibleAnswers.add("Erudite");
                this.possibleAnswers.add("Christian Bale");
                this.possibleAnswers.add("Gary Oldman");
                this.possibleAnswers.add("Aaron Eckhart");
                this.possibleAnswers.add("William Fichtner");
            }
            case 3: {
                this.possibleAnswers.add("Australia");
                this.possibleAnswers.add("Greece");
                this.possibleAnswers.add("United Kingdom");
                this.possibleAnswers.add("Sweden");
                this.possibleAnswers.add("Paris");
                this.possibleAnswers.add("London");
                this.possibleAnswers.add("Madrid");
                this.possibleAnswers.add("New York");
                this.possibleAnswers.add("Zambia");
                this.possibleAnswers.add("Australia");
                this.possibleAnswers.add("New Zealand");
                this.possibleAnswers.add("Solomon Islands");
                this.possibleAnswers.add("Italy");
                this.possibleAnswers.add("France");
                this.possibleAnswers.add("Germany");
                this.possibleAnswers.add("Canada");
                this.possibleAnswers.add("Nepal");
                this.possibleAnswers.add("Japan");
                this.possibleAnswers.add("Russia");
                this.possibleAnswers.add("Georgia");
                this.possibleAnswers.add("Greece");
                this.possibleAnswers.add("Canada");
                this.possibleAnswers.add("India");
                this.possibleAnswers.add("Egypt");
                this.possibleAnswers.add("Argentina");
                this.possibleAnswers.add("Antarctic");
                this.possibleAnswers.add("Canada");
                this.possibleAnswers.add("U.S.A.");
                this.possibleAnswers.add("love");
                this.possibleAnswers.add("food");
                this.possibleAnswers.add("ancient monuments");
                this.possibleAnswers.add("beaches");
                this.possibleAnswers.add("The Northern part");
                this.possibleAnswers.add("The Southern part");
                this.possibleAnswers.add("The Eastern part");
                this.possibleAnswers.add("The Western part");
                this.possibleAnswers.add("Colombia");
                this.possibleAnswers.add("German");
                this.possibleAnswers.add("Greenland");
                this.possibleAnswers.add("Algeria");
                this.possibleAnswers.add("Qatar");
                this.possibleAnswers.add("Singapore");
                this.possibleAnswers.add("Luxembourg");
                this.possibleAnswers.add("Norway");
                this.possibleAnswers.add("Oslo");
                this.possibleAnswers.add("Arizona");
                this.possibleAnswers.add("Hawaii");
                this.possibleAnswers.add("Ohio");
                this.possibleAnswers.add("Havana");
                this.possibleAnswers.add("Dubai");
                this.possibleAnswers.add("Italy");
                this.possibleAnswers.add("Portugal");
                this.possibleAnswers.add("Switzerland");
                this.possibleAnswers.add("Germany");
                this.possibleAnswers.add("The Netherlands");
                this.possibleAnswers.add("Austria");
                this.possibleAnswers.add("227");
                this.possibleAnswers.add("332");
                this.possibleAnswers.add("463");
                this.possibleAnswers.add("539");
                this.possibleAnswers.add("Dubai");
                this.possibleAnswers.add("Mexico");
                this.possibleAnswers.add("Maldives");
                this.possibleAnswers.add("Singapore");
                this.possibleAnswers.add("Italy");
                this.possibleAnswers.add("Montenegro");
                this.possibleAnswers.add("Serbia");
                this.possibleAnswers.add("Croatia");
                this.possibleAnswers.add("Mexico");
                this.possibleAnswers.add("Brazil");
                this.possibleAnswers.add("Canada");
                this.possibleAnswers.add("Cuba");
                this.possibleAnswers.add("Rio de Janeiro");
                this.possibleAnswers.add("Italy");
                this.possibleAnswers.add("UK");
                this.possibleAnswers.add("Canada");
                this.possibleAnswers.add("Black-Red-Gold");
                this.possibleAnswers.add("Red-Blue-White");
                this.possibleAnswers.add("Green-Blue-White");
                this.possibleAnswers.add("Yellow-White-Red");
            }
        }
    }
}