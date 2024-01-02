package StepDidination;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AddNewUser {

    @And("I click on the log in buttton")
    public void and(){
        System.out.println("click on add button");
    }


    @Given("I navigate to the user module")
    public void iNavigateToTheUserModule() {
        System.out.println("2Given");
    }

    @When("I click on new user firstname {string} lastname {string} emailid {string}")
    public void iClickOnNewUserFirstnameLastnameEmailid(String firstName, String lastName, String emailId) {
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(emailId);
    }

    @And("Click the save button")
    public void clickTheSaveButton() {
        System.out.println("click");
    }

    @When("I click on the search drop down")
    public void iClickOnTheSearchDropDown() {
        System.out.println("Click");
    }

    @Then("Veify add user successfuly")
    public void veifyAddUserSuccessfuly() {
        System.out.println("verify");
    }

    @When("navigate to user module")
    public void navigateToUserModule(Map<String,String> list) {
        System.out.println("pass the value using scenario out line");
       String list11= list.get("first");
       System.out.println(list11);
        String list12= list.get("last");
        System.out.println(list12);
        String list13= list.get("email");
        System.out.println(list13);


       }


    @When("I pass the value in datatablt")
    public void iPassTheValueInDatatablt(DataTable table) {
        List<Map<String,String>> list=table.asMaps();
        for(Map<String,String> list1  :list ){
            for(Map.Entry  map:list1.entrySet()){
                System.out.println("kay"+map.getKey()+"-"+map.getValue());
            }
        }
      Map<String,String> map11= list.get(0);
        System.out.println(map11.get("firstname"));
        System.out.println(map11.get("lastname"));
        System.out.println(map11.get("email"));


    }
}

