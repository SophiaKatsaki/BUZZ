import org.junit.Test;

import java.lang.reflect.AnnotatedArrayType;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnswerTest {

    public AnswerTest() {}

    @Test
    public void getCorrectAnswer() {
       Answer answer=new Answer();
       answer.getCorrectAnswer();
       assertEquals(false,answer.getCorrectAnswer());
       System.out.println("By default: "+answer.getCorrectAnswer());
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
