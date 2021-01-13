import org.junit.Test;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnswerTest {

    public AnswerTest() {}

    @Test
    public void CategoryOfAnswer()
    {
        ArrayList<String> allCategories=new ArrayList<>();
        allCategories.add("Music");
        allCategories.add("Books");
        allCategories.add("TV Series/ Movies");
        allCategories.add("Travelling");
        allCategories.add("Food & Drinks");
        Answer answer= new Answer();
        assertEquals(allCategories.get(0),answer.categories.get(0));
        assertEquals(allCategories.get(1),answer.categories.get(1));
        assertEquals(allCategories.get(2),answer.categories.get(2));
        assertEquals(allCategories.get(3),answer.categories.get(3));
        assertEquals(allCategories.get(4),answer.categories.get(4));

    }

    @Test
    public void fourAnswers()
    {
        Question question=new Question();
        Answer answer=new Answer();
        answer.setFourPossibleAnswers(question.getNumberOfRandomQuestionInArray(),question.getNumberOfCategory());
        answer.makeA(question.getNumberOfCategory());
        System.out.println(answer.getFourPossibleAnswers());
    }



}
