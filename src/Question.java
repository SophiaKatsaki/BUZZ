import java.util.ArrayList;
import java.util.Random;

public class Question
{
    ArrayList<String> categories;

    public Question()
    {
        categories=new ArrayList<>();
        categories.add("Music");
        categories.add("Books");
        categories.add("Travelling");
        categories.add("Movies");
    }

    public void ShowCategory()
    {
            Random rand = new Random();
            System.out.println(categories.get(rand.nextInt(categories.size())));
    }

    public void showQuestion()
    {

    }

    public void showAnswers()
    {

    }

    public void showCorrectAnswer()
    {
        //U answered correct as an intellectual or you are useless and you did this wrong as usual
    }


}

