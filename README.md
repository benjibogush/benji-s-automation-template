![alt text](src/main/resources/assets/images/logo.png)

> > > > **BeehabFrameWorkBase**
> 
# Step 0: <ins>VERY IMPORTANT<ins>

### Switch to your own branch before you follow the rest of the documentation.
> git checkout myBranch
> 
> git checkout yourBranch

### Now you are free to follow the remaining steps.

## Step 1 : Also see Step 6

### Add your feature file and tag the scenarios. For ex: @AddUser

## Step 2

### Add your page object: For example RecruitmentPage and add the following by changing the classnames in your own classes

   ```java
    WebDriver driver;
    PropReader propReader;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        propReader = new PropReader();
        PageFactory.initElements(driver, this);
    }
   ```  
 ## Step 3
 
 ### Go to PageObjectManager class to add a get method for your class, for ex: getRecruitmentPage() {} see below
 ### Add the following in the Manager class: Remember you have to use your own class names and variable names.
 
```java
 private RecruitmentPage recruitmentPage;
 
 public RecruitmentPage getRecruitmentPage(){
		return (recruitmentPage == null) ? recruitmentPage = new RecruitmentPage(driver) : recruitmentPage;
	}
 ``` 
  ### in your own class, you will change the type of method from RecruitmentPage to Xpage of your test case.
  
  
  ## Step 4
  
  ### Go to step_definitions package and add your Steps class, for ex: RecruitmentSteps. 
  ### Do not touch Hooks unless it is done by the teamwork.
  ### In your Steps class, add the following but change the name of the constructor in your own Steps class.
  
  ```java
    TestContext testContext;
    RecruitmentPage recruitmentPage;


    public RecruitmentSteps(TestContext Context) {
        testContext = Context;
        recruitmentPage = testContext.getPageObjectManager().getRecruitmentPage();
    }
  ```
  ## Step 5
  
  ### In step 1, you tagged your scenarios in the feature file. Now you will need open TestRunner class.
  
  ### Remember, you are in your own branch, and you do not need to push TestRunner class to remote.
  
  ### Now change the tag name to whatever you typed at step 1. For ex: See below
  
  > tags = {"@AddUser"}
  
  
  ## Step 6
  
  ### Run the TestRunner class and copy methods that are not implemented in your StepDefinitions class.
  
  ### Then write your codes based on the test steps.
  
  ### In your feature file, use Background in the following lines below Feature at first line.
  ### Background will take care of the login process. Then you just need to navigate to certain page and move on.
  
 > Background: Login to the environment
 > 
 > Given the Admin admin is in login Page
  
 
    
    For more, please provide feedback and let's make this a great environment for the future company of ours.
  
  
  
 
 
