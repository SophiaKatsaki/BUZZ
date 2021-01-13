import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class  QuestionTest {

    public QuestionTest(){}

    @Test
    public void CategoriesOfQuestion()
    {
        ArrayList<String> allCategories=new ArrayList<>();
        allCategories.add("Music");
        allCategories.add("Books");
        allCategories.add("TV Series/ Movies");
        allCategories.add("Travelling");
        allCategories.add("Food & Drinks");
        Question question= new Question();
        assertEquals(allCategories.get(0),question.categories.get(0));
        assertEquals(allCategories.get(1),question.categories.get(1));
        assertEquals(allCategories.get(2),question.categories.get(2));
        assertEquals(allCategories.get(3),question.categories.get(3));
        assertEquals(allCategories.get(4),question.categories.get(4));

    }
    @Test
    public void NumberOfCategory() {
        List<Integer> howMany = List.of(0,1,2,3,4);
        Question question= new Question();
        question.setRandomQuestion();
        assertTrue(howMany.contains(question.getNumberOfCategory()));
        System.out.println(question.getNumberOfCategory());

    }

    @Test
    public void CategoryOfQuestion() {
        ArrayList<String> allCategories=new ArrayList<>();
        allCategories.add("Music");
        allCategories.add("Books");
        allCategories.add("TV Series/ Movies");
        allCategories.add("Travelling");
        allCategories.add("Food & Drinks");
        Question question= new Question();
        question.setRandomQuestion();
        assertTrue(allCategories.contains(question.getCategory()));
        System.out.println(question.getCategory());
    }

    @Test
    public void sizeOfArrayCreatedWithQuestions()
    {
        Question question=new Question();
        question.setRandomQuestion();
        assertEquals(30,question.questions.size());

    }



}
