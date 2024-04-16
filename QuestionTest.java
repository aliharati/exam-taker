import java.util.ArrayList;

public class QuestionTest {
	public static ArrayList<MultipleChoiceQuestion> giveQuestionList() {
        ArrayList<MultipleChoiceQuestion> questionList = new ArrayList<>();
        

        // Creating 10 fake question objects
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(1, "What is the capital of France?", 
        													getOptionsList("Paris", "London", "Berlin"), 1);
        MultipleChoiceQuestion question2 = new MultipleChoiceQuestion(2, "What is the largest planet in our solar system?", 
        													getOptionsList("Mars", "Jupiter", "Earth"), 2);
        MultipleChoiceQuestion question3 = new MultipleChoiceQuestion(3, "Who painted the Mona Lisa?", 	
        													getOptionsList("Pablo Picasso", "Leonardo da Vinci", "Vincent van Gogh"), 2);
        MultipleChoiceQuestion question4 = new MultipleChoiceQuestion(4, "What is the chemical symbol for gold?", 
        													getOptionsList("Ag", "Au", "Fe"), 2);
        MultipleChoiceQuestion question5 = new MultipleChoiceQuestion(5, "Which country won the FIFA World Cup in 2018?", 
        													getOptionsList("Germany", "Brazil", "France"), 3);
        MultipleChoiceQuestion question6 = new MultipleChoiceQuestion(6, "Which is the largest ocean on Earth?", 
        													getOptionsList("Indian Ocean", "Atlantic Ocean", "Pacific Ocean"), 3);
        MultipleChoiceQuestion question7 = new MultipleChoiceQuestion(7, "Who wrote the play 'Romeo and Juliet'?", 
        													getOptionsList("William Shakespeare", "George Orwell", "Jane Austen"), 1);
        MultipleChoiceQuestion question8 = new MultipleChoiceQuestion(8, "What is the square root of 64?", 
        													getOptionsList("4", "8", "16"), 2);
        MultipleChoiceQuestion question9 = new MultipleChoiceQuestion(9, "What is the capital of Japan?", 
        													getOptionsList("Tokyo", "Beijing", "Seoul"), 1);
        MultipleChoiceQuestion question10 = new MultipleChoiceQuestion(10, "Who invented the telephone?", 
        													getOptionsList("Thomas Edison", "Alexander Graham Bell", "Nikola Tesla"), 2);

        // Adding the question objects to the ArrayList
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);
        questionList.add(question7);
        questionList.add(question8);
        questionList.add(question9);
        questionList.add(question10);
        
        return questionList;
      
    }

    // Utility method to create an ArrayList of options
    public static ArrayList<String> getOptionsList(String... options) {
        ArrayList<String> optionsList = new ArrayList<>();
        for (String option : options) {
            optionsList.add(option);
        }
        return optionsList;
    }
}
