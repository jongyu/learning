*** Settings ***
Resource          model.robot

*** Test Cases ***
test_case
    range    3
    ${result}    addition    4    5
    log    a + b = ${result}

testing
    [Setup]    start
    log    this test case...
    [Teardown]    end

*** Keywords ***
start
    log    start test case

end
    log    end test case
