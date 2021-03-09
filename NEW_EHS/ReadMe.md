#EHS_TASK

This is a regression test automation task with three user stories. The project is working local host and opening the chrome by using Selenium and searches for a specified search item as an output it prints web links as result in order.

#Features 
All user stories and test steps are defined under features. F

# Running of the code
For running @ regression test follow the next steps.
- Click Src->test->test->CukesRunner->Click run
In order to run specific test steps change tags = „@anyName“ in the CukesRunnerand add over the test Scenario in the features @anyName.

# Receiving Report
For getting reports follow next steps.

-Click Maven (right on top of the page)->clean-> click verify
And than click Target (in the Framework)->cucumber-html-repors -> js ->any of overview-failers (right click)-> open in Browser ->Chrome
