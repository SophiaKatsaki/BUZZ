import java.util.ArrayList;
import java.util.Random;

public abstract class QA {
    protected ArrayList<String> questions;
    protected ArrayList<String> possibleAnswers;
    protected ArrayList<String> categories;
    protected int numberOfCategory;

    public QA () {
        this.categories = new ArrayList<>();
        this.categories.add("Music");
        this.categories.add("Books");
        this.categories.add("TV Series/ Movies");
        this.categories.add("Travelling");
    }

    public void makeQA () {
        this.questions = new ArrayList<>();
        this.possibleAnswers = new ArrayList<>();

        Random rand = new Random();
        this.numberOfCategory = rand.nextInt(this.categories.size());

        switch (this.numberOfCategory) {
            case 0 -> {
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
            }
            case 1 -> {
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

                this.possibleAnswers.add("Think of A Number");
                this.possibleAnswers.add("Shut Your Eyes Tight");
                this.possibleAnswers.add("Peter Pan Must Die");
                this.possibleAnswers.add("Wolf Lake");
                this.possibleAnswers.add("Nicomachus Ethics");
                this.possibleAnswers.add("Antigone");
                this.possibleAnswers.add("Ajax");
                this.possibleAnswers.add("Electra");
                this.possibleAnswers.add("Nicomachus Ethics");
                this.possibleAnswers.add("Sapiens");
                this.possibleAnswers.add("Animal Farm");
                this.possibleAnswers.add("The Alchemist");
                this.possibleAnswers.add("Great Expectations");
                this.possibleAnswers.add("Pride and Prejudice");
                this.possibleAnswers.add("The Snowman");
                this.possibleAnswers.add("Think of A Number");
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
            }
            case 2 -> {
                this.questions.add("How many season had the TV series \"LOST\"?");
                this.questions.add("Who was not main character in the TV series \"Supernatural\"?");
                this.questions.add("Who was not appeared in every season of \"Game of Thrones\"?");
                this.questions.add("In which season did Sara Tancredi left the TV series \"Prison Break\"?");
                this.questions.add("What's the nickname of Silene Oliveira in the TV series \"La Casa De papel\"?");
                this.questions.add("Who will continue to be main character in season 4 in the TV series \"Élite\"?");
                this.questions.add("When was the \"Titanic\" filmed?");
                this.questions.add("What is the name of the child in the movie\"Home Alone\"");
                this.questions.add("What is the first film of \"Harry Potter\"?");
                this.questions.add("How stayed alive in \"Avengers: Endgame\"?");


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
            }
            case 3 -> {
                this.questions.add("Which country does not belong to europe?");
                this.questions.add("Where the eiffel tower is located?");
                this.questions.add("Which country does not belong to the continent \"Oceania\"?");
                this.questions.add("Which country is known for its food");
                this.questions.add("If you want to go to the Himalayas, which country will you choose to go to?");
                this.questions.add("Where acropolis is located?");
                this.questions.add("Where Glacier National Park is located?");
                this.questions.add("France is the city of");
                this.questions.add("Which part of portugal is mountainous?");
                this.questions.add("Spanish is spoken in");

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
            }
        }
    }
}