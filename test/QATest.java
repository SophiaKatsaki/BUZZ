import org.junit.Test;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QATest {

    public QATest() {}

    @Test
    public void Categories()
    {
        Question question=new Question();
        question.makeCategories();
        ArrayList<String> allCategories=new ArrayList<>();
        allCategories.add("Music");
        allCategories.add("Books");
        allCategories.add("TV Series/ Movies");
        allCategories.add("Travelling");
        allCategories.add("Food & Drinks");
        assertEquals(allCategories.get(0),question.categories.get(0));
        assertEquals(allCategories.get(1),question.categories.get(1));
        assertEquals(allCategories.get(2),question.categories.get(2));
        assertEquals(allCategories.get(3),question.categories.get(3));
        assertEquals(allCategories.get(4),question.categories.get(4));

    }

    @Test
    public void NumberOfCategories()
    {
        Question question=new Question();
        assertEquals(5,question.categories.size());
    }

    @Test
    public void Questions()
    {
        Question question=new Question();
        question.makeQ(question.getNumberOfCategory());
        assertEquals(30,question.questions.size());
    }

    @Test
    public void Answers()
    {
        Question question=new Question();
        question.makeA(question.getNumberOfCategory());
        assertEquals(120,question.possibleAnswers.size());
    }

}
