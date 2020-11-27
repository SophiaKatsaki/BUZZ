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

    public void ShowQuestion()
    {

    }

    public void ShowAnswers()
    {

    }

    public void ShowCorrectAnswer()
    {
        //U answered correct as an intellectual or you are useless and you did this wrong as usual
    }

    public int ChangePoints()
    {
        Round r=new Round(int numberOfQuestions, String kind, int points);
        int PointsToChange=r.GetPoints();
        //we add or subtract points
        return PointsToChange;
    }

}

