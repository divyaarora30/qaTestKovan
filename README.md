# qaTestKovan
Selenium Project to demonstarte the automation on Ethereum Transaction pages

How to Execute qaTestKovan Project

- Clone the porject in your local workspace
- Build the project
- Right click on testng.xml file present inside the root directory of the project and Run as Testng
- This will excute TestCaseOne() and TestCaseTwo() simultaneously on diffreent brwsers
-  If you dont wnat to run simultaneously on different brwosers, use below command in Testng.xml file to run tests in each browser one by one
     <suite name="Suite" parallel="none">
- Can execute each test case, TestCaseOne() and TestCaseTwo(), individually by righ clicking on each test case and running.


Test Results Report

There are 2 test cases which will be executed by the automation script
1. TestCaseOne() executes the first test case-

Test case: Verify ‘from’ and ‘to’ links are not broken
Steps:
- Visit website: https://kovan.etherscan.io
- Search fro the transaction hash
- Click on Go button
- On search results page, click on from link and To links
Expected Results: From and To Links re not broken and have status code as 200.

2. TestCaseTwo() executes the second test case-

Test case: Verify transaction is confirmed
Steps:
- Visit website: https://kovan.etherscan.io
- Search fro the transaction hash
- Click on Go button
- On search results page, check if blocked confirmed are not less than or equal to 10
Expected Results: Transaction is confirmed


